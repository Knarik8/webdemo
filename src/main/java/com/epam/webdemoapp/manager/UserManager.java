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
            PreparedStatement preparedStatement =connection.prepareStatement("INSERT INTO users(name, email, password, confirmPassword) VALUES(?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getConfirmPassword());
            int execute =preparedStatement.executeUpdate();
            System.out.println(execute);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public User getByUsernamePassword(String name, String password) {
        connection = ConnectionProvider.getInstance();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users where name=? and password=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            throw new ResourceNotFoundException(String.format("Given user with login: %s and password %s not found", name, password));
        }
        return null;
    }

}
