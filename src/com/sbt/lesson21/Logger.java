package com.sbt.lesson21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Student on 26.09.2016.
 */
public class Logger implements Runnable {

    String str;

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into log(str) values(?)");
            preparedStatement.setString(1, str);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
