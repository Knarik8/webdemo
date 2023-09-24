package com.epam.webdemoapp.manager;

import com.epam.webdemoapp.entity.User;
import com.epam.webdemoapp.exception.ResourceNotFoundException;
import com.epam.webdemoapp.jdbc.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager implements Manager<User, String> {

    private Connection connection;

    @Override
    public void create(User user) {
        connection = ConnectionProvider.getInstance();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement("INSERT INTO users(username, password, age) VALUES(?,?,?)");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getAge());
            int execute =preparedStatement.executeUpdate();
            System.out.println(execute);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public User getByUsernamePassword(String username, String password) {
        connection = ConnectionProvider.getInstance();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users where username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            throw new ResourceNotFoundException(String.format("Given user with login: %s and password %s not found", username, password));
        }
        return null;
    }

}
