package com.sbt.lesson21;

import java.sql.*;

/**
 * Created by Student on 19.09.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            Statement statement = connection.createStatement();

//            System.out.println("TYPE_SCROLL_SENSITIVE");
//            System.out.println(connection.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
//            System.out.println("TYPE_SCROLL_INSENSITIVE");
//            System.out.println(connection.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
//            System.out.println("TYPE_FORWARD_ONLY");
//            System.out.println(connection.getMetaData().supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));

//            ResultSet resultSet = statement.executeQuery("select * from songs");
//
//            while (resultSet.next()) {
//                System.out.println("Song name: " + resultSet.getString("NAME") + " song time: " + resultSet.getBigDecimal("SONG_TIME"));
//            }

//            PreparedStatement preparedStatement = connection.prepareStatement("select * from songs where id = ?");
//            preparedStatement.setString(1, "25");
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                System.out.println("Song name: " + resultSet.getString("NAME") + " song time: " + resultSet.getBigDecimal("SONG_TIME"));
//            }

            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into song(name) value(?)");

            Savepoint savepointFirst = connection.setSavepoint("FIRST");

            preparedStatement.setString(1, "MySong");

            preparedStatement.execute();

            connection.releaseSavepoint(savepointFirst);

//            Logger logger = new Logger();
//            logger.setStr("MySong");
//            Thread t = new Thread(logger);
//            t.start();
//            t.join();

            connection.rollback();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("\nOk");
    }
}
