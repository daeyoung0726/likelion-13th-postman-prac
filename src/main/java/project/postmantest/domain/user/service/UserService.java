package project.postmantest.domain.user.service;

import project.postmantest.domain.user.dto.UserDto;
import project.postmantest.domain.user.entity.User;
import project.postmantest.domain.user.repository.UserDao;

import java.util.List;

public class UserService {
    private static UserService userService;
    private final UserDao userDao;

    private UserService() {
        userDao = UserDao.getInstance();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public Long create(UserDto.UserReq userReq) {
        User user = userReq.toEntity();
        return userDao.create(user);
    }

    public UserDto.UserRes readById(Long id) {
        User user = userDao.readById(id);
        return user != null ? UserDto.UserRes.fromEntity(user) : null;
    }

    public List<UserDto.UserRes> readAll() {
        return userDao.readAll().stream()
                .map(UserDto.UserRes::fromEntity)
                .toList();
    }

    public void update(Long id, UserDto.UserReq userReq) {
        userDao.update(id, userReq.name(), userReq.age(), userReq.intro());
    }

    public void delete(Long id) {
        userDao.delete(id);
    }
}
