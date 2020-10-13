package com.example.inklow.implementation;

import com.example.inklow.dao.UserDao;
import com.example.inklow.database.Database;
import com.example.inklow.model.User;
import com.example.inklow.util.DateUtil;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserDaoImp implements UserDao {
    private final Database database;

    private List<User> listOfUsers;

    public UserDaoImp(Database database) {
        this.database = database;
    }

    // Read
    @Override
    public List<User> getUsers() {
        listOfUsers = new ArrayList<>();

        try {
            database.statement = database.connection.createStatement();
            database.resultSet = database.statement.executeQuery("SELECT * FROM users");

            while(database.resultSet.next()) {
                String UUID = database.resultSet.getString(1);
                String firstName = database.resultSet.getString(2);
                String lastName = database.resultSet.getString(3);
                String gender = database.resultSet.getString(4);

                String databaseDate = database.resultSet.getString(5);
                Date date = DateUtil.toDateFromISODateString(databaseDate);

                String username = database.resultSet.getString(6);
                String password = database.resultSet.getString(7);

                String email = null;
                String databaseEmail = database.resultSet.getString(8);
                if (databaseEmail != null) {
                    email = database.resultSet.getString(8);
                }

                String phoneNumber = null;
                String databasePhoneNumber = database.resultSet.getString(9);
                if (database.resultSet.getString(9) != null) {
                    phoneNumber = databasePhoneNumber;
                }
                User user = new User(UUID, firstName, lastName, gender, date, username, password, email, phoneNumber);

                listOfUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfUsers;
    }

    // Create
    @Override
    public User addUser(User user) {
        try {
            database.statement = database.connection.createStatement();

            String query = "INSERT INTO test(username, password) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "')";
            database.statement.executeUpdate(query);

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User removeUser(User user) {
        try {
            database.statement = database.connection.createStatement();

            String query = "DELETE FROM test WHERE username = '" + user.getUsername() + "';";
            database.statement.executeUpdate(query);

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User updateUser(String username, User user) {
        try {
            database.statement = database.connection.createStatement();

            String query = "UPDATE test set username = '" + user.getUsername() + "', password = '" + user.getPassword() + "' WHERE username = '" + username + "';";
            database.statement.executeUpdate(query);

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User updateUsername(String username, User user) {
        return null;
    }

    @Override
    public User updatePassword(String username, User user) {
        return null;
    }
}
