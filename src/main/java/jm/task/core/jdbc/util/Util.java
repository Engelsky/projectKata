package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    // настройки подключения к БД
    // com.mysql.jdbc.Driver был предложен средой, но это же устаревшее
    // а у меня версия MySQL 8-ая, посему cj
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/katapp1134";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "мой пароль";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Загружаем драйвер
            Class.forName(DB_DRIVER);
            // Получаем соединение, используя настройки
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // для проверки коннекта наглядно
            System.out.println("Connected to database successfully");
        }  catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed! Check output console");
        }
        return conn;
    }
}
