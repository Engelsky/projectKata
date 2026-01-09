package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }
    // Создание таблицы
    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(45), " +
                "lastName VARCHAR(45), " +
                "age TINYINT)";

        // try-with-resources
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql); // Выполняем SQL
            System.out.println("Users table created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Удаление таблицы
    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";

        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
            System.out.println("Users table dropped");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Сохранение пользователя
    @Override
    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";

        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, name); // Вместо первого '?' подставляем name
            preparedStatement.setString(2, lastName); // Аналогично 2 - lastName
            preparedStatement.setByte(3, age); // 3 - age

            // Вывод будет в Main, здесь по условию не надо
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Удаление по ID
    @Override
    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection connection = Util.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Получение всех пользователей
    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery(sql)) {
            // Проходимся циклом по resultSet
            // и Превращаем строки таблицы в объекты User
            while (resultSet.next()) { // Пока есть строки в ответе БД
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                users.add(user);// добавляем созданного юзера в список
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    // Очистка таблицы(удаляем все записи, сохраняя структуру)
    @Override
    public void cleanUsersTable() {
        String sql = "DELETE FROM users";

        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
            System.out.println("Users table cleaned");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}