package project.postmantest.database;

import project.postmantest.domain.user.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDatabase {
    private static final Map<Long, User> userData = new HashMap<>();
    private static UserDatabase userDatabase;

    private static Long sequence = 1L;

    private UserDatabase() {}

    public static UserDatabase getInstance() {
        if (userDatabase == null) {
            userDatabase = new UserDatabase();
        }
        return userDatabase;
    }

    public Long create(User user) {
        Long userId = sequence++;
        user.generateId(userId);
        userData.put(userId, user);

        return user.getId();
    }

    public User readById(Long id) {
        return userData.get(id);
    }

    public List<User> readAll() {
        return new ArrayList<>(userData.values());
    }

    public void update(Long id, String name, int age, String intro) {
        User foundUser = userData.get(id);

        foundUser.updateInfo(name, age, intro);
    }

    public void delete(Long id) {
        userData.remove(id);
    }
}
