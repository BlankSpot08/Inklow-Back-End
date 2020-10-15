package com.example.inklow.implementation;

import com.example.inklow.dao.UserDao;
import com.example.inklow.database.Database;
import com.example.inklow.model.User;
import com.example.inklow.util.DateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


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
                String stringId = database.resultSet.getString(1);
                UUID id =  UUID.fromString(stringId);

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
                User user = new User(id, firstName, lastName, gender, date, username, password, email, phoneNumber);

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
            String query = "INSERT INTO users (firstName, lastName, gender, birthdate, username, password, email, phonenumber) " +
                    "VALUES ('" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getGender() + "', '" + user.getBirthDate() + "', '" +
                    "" + user.getUsername() + "' , '" + user.getPassword() + "', '" + user.getEmail() + "', '" + user.getPhoneNumber() + "')";
            database.statement.executeUpdate(query);

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User removeUser(String username) {
        System.out.println("Username: " + username);
        try {
            database.statement = database.connection.createStatement();
            database.resultSet = database.statement.executeQuery("SELECT * FROM users WHERE username='" + username + "'");

            User user = null;
            while(database.resultSet.next()) {
                String stringId = database.resultSet.getString(1);
                UUID id =  UUID.fromString(stringId);

                String firstName = database.resultSet.getString(2);
                String lastName = database.resultSet.getString(3);
                String gender = database.resultSet.getString(4);

                String databaseDate = database.resultSet.getString(5);
                Date date = DateUtil.toDateFromISODateString(databaseDate);

                String databaseUsername = database.resultSet.getString(6);
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

                user = new User(id, firstName, lastName, gender, date, databaseUsername, password, email, phoneNumber);
            }

            database.statement = database.connection.createStatement();

            String query = "DELETE FROM users WHERE username = '" + username + "';";
            database.statement.executeUpdate(query);

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    public User updateUser(String username, User user) {
//        try {
//            database.statement = database.connection.createStatement();
//
//            String query = "UPDATE test set username = '" + user.getUsername() + "', password = '" + user.getPassword() + "' WHERE username = '" + username + "';";
//            database.statement.executeUpdate(query);
//
//            return user;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    @Override
    public String updateLastName(String id, String lastName) {
        try {
            database.statement = database.connection.createStatement();

            String query = "UPDATE users set lastName = '" + lastName + "' WHERE id = '" + id + "';";
            database.statement.executeUpdate(query);

            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String updateUsername(String id, String username) {
        try {
            database.statement = database.connection.createStatement();

            String query = "UPDATE users set username = '" + username + "' WHERE id = '" + id + "';";
            database.statement.executeUpdate(query);

            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String updatePassword(String id, String password) {
        try {
            database.statement = database.connection.createStatement();

            String query = "UPDATE users set password = '" + password + "' WHERE id = '" + id + "';";
            database.statement.executeUpdate(query);

            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String updateEmail(String id, String email) {
        try {
            database.statement = database.connection.createStatement();

            String query = "UPDATE users set email = '" + email + "' WHERE id = '" + id + "';";
            database.statement.executeUpdate(query);

            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String updatePhoneNumber(String id, String phoneNumber) {
        try {
            database.statement = database.connection.createStatement();

            String query = "UPDATE users set phoneNumber = '" + phoneNumber + "' WHERE id = '" + id + "';";
            database.statement.executeUpdate(query);

            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
