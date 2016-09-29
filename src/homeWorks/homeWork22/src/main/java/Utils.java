import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Master on 28.09.2016.
 */
public class Utils {
    private static String URL = "jdbc:h2:tcp://localhost/~/test;USER=sa;password=";
    private static String CREATE_CLIENTS_QUERY = "create table clients (\n" +
            "id bigint auto_increment,\n" +
            "primary key(id),\n" +
            "name varchar2(500) not null\n" +
            ") ";
    private static String CREATE_ACCOUNT_QUERY = "create table accounts (\n" +
            "id bigint auto_increment,\n" +
            "primary key(id),\n" +
            "saldo number(10,2) default 0,\n" +
            "id_client bigint not null,\n" +
            "foreign key(id_client) references clients(id)\n" +
            ")";
    private static String CREATE_DOCUMENTS_QUERY = "create table documents (\n" +
            "id bigint,\n" +
            "primary key(id),\n" +
            "account_dt bigint not null,\n" +
            "foreign key(account_dt) references accounts(id),\n" +
            "account_ct bigint not null,\n" +
            "foreign key(account_ct) references accounts(id),\n" +
            "saldo number(10,2) not null,\n" +
            "purpose varchar2(210) not null,\n" +
            "doc_date timestamp default current_timestamp\n" +
            ")";

    public static void createTables(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        statement.executeUpdate(CREATE_CLIENTS_QUERY);
        statement.executeUpdate(CREATE_ACCOUNT_QUERY);
        statement.executeUpdate(CREATE_DOCUMENTS_QUERY);

        connection.commit();
    }
}
