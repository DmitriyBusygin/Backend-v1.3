package com.busdmv.testjson.db;

import com.busdmv.testjson.beans.Messages;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static final String URL = "jdbc:postgresql://localhost:5432/dmitry.busugin";
    private static final String USERNAME = "dmitry.busugin";
    private static final String PASSWORD = "password";

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            return connection;
        }
    }

    public static ArrayList<Messages> getAllMessageses() {
        connection = Database.getConnection();
        ArrayList<Messages> messagesesList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from messages");
            while (rs.next()) {
                Messages messages = new Messages();
                messages.setId(rs.getString("id"));
                messages.setClient_id(rs.getString("client_id"));
                messages.setMessage(rs.getString("message"));
                messagesesList.add(messages);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messagesesList;
    }

}
