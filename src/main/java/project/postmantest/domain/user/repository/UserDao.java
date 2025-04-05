package project.postmantest.domain.user.repository;

import project.postmantest.database.ConnectionMaker;
import project.postmantest.database.UserDatabase;
import project.postmantest.domain.user.entity.User;

import java.util.List;

public class UserDao {
    private static UserDao userDao;
    private final UserDatabase userDatabase;

    private UserDao() {
        this.userDatabase = ConnectionMaker.getUserDateBase();
    }

    public static UserDao getInstance() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public Long create(User user) {
        return userDatabase.create(user);
    }

    public User readById(Long id) {
        return userDatabase.readById(id);
    }

    public List<User> readAll() {
        return userDatabase.readAll();
    }

    public void update(Long id, String name, int age, String intro) {
        userDatabase.update(id, name, age, intro);
    }

    public void delete(Long id) {
        userDatabase.delete(id);
    }
}
