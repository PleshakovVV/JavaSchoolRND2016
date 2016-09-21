package homeWorks.homeWork21;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Master on 21.09.2016.
 */
public class CachedFibonachiableProxy implements Fibonachiable {

    private static String TABLE_METHODS_NAME = "METHODS";
    private static String TABLE_METHODS_DATA_NAME = "METHODS_DATA";

    private static String CREATION_TABLE_METHODS_QUERY = "CREATE TABLE METHODS(\n" +
            "ID NUMBER auto_increment, \n" +
            "primary key(ID) ,\n" +
            "NAME VARCHAR2(200),\n" +
            "UNIQUE(NAME)\n" +
            ")";
    private static String CREATION_TABLE_METHODS_DATA_QUERY = "CREATE TABLE METHODS_DATA(\n" +
            "ID NUMBER auto_increment, \n" +
            "primary key(ID),\n" +
            "METHOD VARCHAR2(500),\n" +
            "foreign key(METHOD) references METHODS(ID),\n" +
            "IN_PARAMETER NUMBER,\n" +
            "OUT_PARAMETER NUMBER\n" +
            ")";
    private static String FILL_CACHE_QUERY = "select m.name, md.IN_PARAMETER, md.OUT_PARAMETER \n" +
            "from methods m, METHODS_DATA md\n" +
            "where m.id = md.method\n" +
            "and m.name = ?";

    private static String SELECT_TABLE_METHODS_QUERY = "SELECT * FROM METHODS WHERE NAME = ?";
    private static String INSERT_TABLE_METHODS_QUERY = "INSERT INTO METHODS(NAME) VALUES(?)";

    private static String INSERT_TABLE_DATA_VALUES = "INSERT INTO METHODS_DATA(METHOD,IN_PARAMETER,OUT_PARAMETER)\n" +
            "VALUES(SELECT ID FROM METHODS WHERE NAME = ?,?,?)";

    private Fibonachiable fibonachiable;
    private String URL;
    private Map<String, Map<Integer, Integer>> cache = null;

    public CachedFibonachiableProxy(Fibonachiable fibonachiable, String URL) {
        this.fibonachiable = fibonachiable;
        this.URL = URL;
        try (Connection connection = DriverManager.getConnection(URL)) {
            checkTablesExistence(connection);
            fillCache(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int count(int number) {
        try (Connection connection = DriverManager.getConnection(URL)){

            if (cache == null) {
                return fibonachiable.count(number);
            }

            try {
                Map<Integer, Integer> parameterMap = cache.get(fibonachiable.getClass().getMethod("count", int.class).toString());
                if (parameterMap.containsKey(number)) {
                    System.out.println("From cache:");
                    return parameterMap.get(number);
                } else {
                    int result = fibonachiable.count(number);
                    parameterMap.put(number, result);

                    connection.setAutoCommit(false);
                    PreparedStatement checkMethodPreparedStatement = connection.prepareStatement(SELECT_TABLE_METHODS_QUERY);
                    checkMethodPreparedStatement.setString(1, fibonachiable.getClass().getMethod("count", int.class).toString());
                    ResultSet resultSet = checkMethodPreparedStatement.executeQuery();
                    if (!resultSet.next()) {
                        PreparedStatement insertMethodsPrepareStatement = connection.prepareStatement(INSERT_TABLE_METHODS_QUERY);
                        insertMethodsPrepareStatement.setString(1, fibonachiable.getClass().getMethod("count", int.class).toString());
                        insertMethodsPrepareStatement.executeUpdate();
                        insertMethodsPrepareStatement.close();
                    }
                    checkMethodPreparedStatement.close();

                    PreparedStatement insertMethodDataPreparedStatement = connection.prepareStatement(INSERT_TABLE_DATA_VALUES);
                    insertMethodDataPreparedStatement.setString(1, fibonachiable.getClass().getMethod("count", int.class).toString());
                    insertMethodDataPreparedStatement.setInt(2, number);
                    insertMethodDataPreparedStatement.setInt(3, result);
                    insertMethodDataPreparedStatement.executeUpdate();

                    connection.commit();
                    System.out.println("New evaluate:");
                    return result;
                }
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void checkTablesExistence(Connection connection) throws SQLException {
        if (!isTableForMethodsExists(connection, TABLE_METHODS_NAME)) {
            createTable(connection, CREATION_TABLE_METHODS_QUERY);
        }
        if (!isTableForMethodsExists(connection, TABLE_METHODS_DATA_NAME)) {
            createTable(connection, CREATION_TABLE_METHODS_DATA_QUERY);
        }
    }

    private void fillCache(Connection connection) throws SQLException {

        PreparedStatement preparedStatement = null;
        Method[] methods = this.fibonachiable.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PersistentCached.class)) {
                if (preparedStatement == null) {
                    preparedStatement = connection.prepareStatement(FILL_CACHE_QUERY);
                }
                preparedStatement.setString(1, method.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                cache = new HashMap<>();
                cache.put(method.toString(), new HashMap<Integer, Integer>());
                Map<Integer, Integer> parametersMap = cache.get(method.toString());
                while (resultSet.next()) {
                    parametersMap.put(resultSet.getInt("IN_PARAMETER"), resultSet.getInt("OUT_PARAMETER"));
                }
            }
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    private void createTable(Connection connection, String creationQuery) throws SQLException {
        Statement creationMethodsTableStatement = connection.createStatement();
        creationMethodsTableStatement.execute(creationQuery);
        creationMethodsTableStatement.close();
    }

    private boolean isTableForMethodsExists(Connection connection, String table) throws SQLException {
        String CHECK_TABLE_QUERY = "SELECT COUNT(1) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(CHECK_TABLE_QUERY);
        preparedStatement.setString(1, table);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int tableNumber = resultSet.getInt(1);
        preparedStatement.close();
        return tableNumber == 1;
    }

}
