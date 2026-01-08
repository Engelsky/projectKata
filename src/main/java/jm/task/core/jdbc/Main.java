package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаём сервис для работы
        UserService userService = new UserServiceImpl();

        // 1. Создаём таблицу
        userService.createUsersTable();

        // 2. Добавляем 4 пользователя
        userService.saveUser("Saliyat", "Mirzabutaevna", (byte) 25);
        System.out.println("User с именем - Saliyat добавлен в базу данных ");

        userService.saveUser("Vasiliy", "Pautov", (byte) 30);
        System.out.println("User с именем - Vasiliy добавлен в базу данных ");

        userService.saveUser("Marat", "Fatahov", (byte) 60);
        System.out.println("User с именем - Marat добавлен в базу данных ");

        userService.saveUser("Anna", "Shapka", (byte) 29);
        System.out.println("User с именем - Anna добавлен в базу данных ");

        // 3. Получаем всех пользователей и выводим в консоль
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        // 4. Очищаем таблицу
        userService.cleanUsersTable();

        // 5. Удаляем таблицу
        userService.dropUsersTable();
    }
}
