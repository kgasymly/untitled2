package oop.repositories;

import oop.entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UserRepository {

    private Connection connection;

    private static final String SQL_SELECT_FROM_DRIVERS = "select id, first_name, last_name, age from drivers";
    private static final String SQL_INSERT = "insert into drivers(first_name, last_name, age) values ('Cao', 'Nima', 23), ('Artem', 'Pavlov',34), ('Arash', 'Arakelyan',24), ('Kobe', 'Bryant', 40), ('Ivan', 'Urgant', 45), ('Lewis', 'Hamilton', 38)";
    private static final String SQL_CONDITION = "select * from drivers where age % 2 = 0";
    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT_FROM_DRIVERS);
        List<User> result = new ArrayList<>();

        while (resultSet.next()) {
            User user = new User(
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age")
            );
            result.add(user);
        }
        return result;
    }

    @Override
    public int insert() throws SQLException {
        Statement statement = connection.createStatement();
        int resultSet = statement.executeUpdate(SQL_INSERT);
        return resultSet;
    }

    public List<User> findAllWithCondition() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_CONDITION);
        List<User> result = new ArrayList<>();

        while (resultSet.next()) {
            User user = new User(
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age")
            );
            result.add(user);
        }
        return result;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void remove(User entity) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public java.util.List<User> findAllByAge(Integer age) {
        return null;
    }
}