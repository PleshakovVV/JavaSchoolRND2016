package com.sbt.lesson21;

import java.sql.*;

/**
 * Created by Student on 19.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            Statement statement = connection.createStatement();

//            ResultSet resultSet = statement.executeQuery("select * from songs");
//
//            while (resultSet.next()) {
//                System.out.println("Song name: " + resultSet.getString("NAME") + " song time: " + resultSet.getBigDecimal("SONG_TIME"));
//            }

            PreparedStatement preparedStatement = connection.prepareStatement("select * from songs where id = ?");
            preparedStatement.setString(1, "25");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Song name: " + resultSet.getString("NAME") + " song time: " + resultSet.getBigDecimal("SONG_TIME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("\nOk");
    }
}
