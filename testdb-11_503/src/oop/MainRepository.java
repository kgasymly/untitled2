package oop;

import oop.entities.User;
import oop.repositories.UserRepository;
import oop.repositories.UsersRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MainRepository {

    private static final String DB_USERNAME = "postgres";

    private static final String DB_PASSWORD = "kanan123@@";

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb_11_503";


    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        UserRepository userRepository = new UsersRepositoryJdbcImpl(connection);

        List<User> users = userRepository.findAll();
        int users1 = userRepository.insert();
        List<User> users2 = userRepository.findAllWithCondition();


        users.forEach(user -> System.out.println(user.getName()));
        users2.forEach(user -> System.out.println(user.getName()+" "+user.getSurname()+" "+user.getAge()));
        System.out.println(users1);
    }
}