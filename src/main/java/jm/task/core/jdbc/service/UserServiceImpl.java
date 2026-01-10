package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    // Создаём экземпляр нашего DAO(теперь Hibernate), чтобы через него работать с базой
    private UserDao userDao = new UserDaoHibernateImpl();
    // Делегируем работу методам из UserDaoHibernateImpl
    @Override
    public void createUsersTable() {
        userDao.createUsersTable();
    }
    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
        // По заданию вывод в консоль требуется в Main
    }
    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}