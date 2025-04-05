package project.postmantest.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.postmantest.domain.user.dto.UserDto;
import project.postmantest.domain.user.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    private UserController() {
        userService = UserService.getInstance();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserDto.UserReq userReq) {
        Long userId = userService.create(userReq);
        return ResponseEntity.ok(Map.of("userId", userId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        UserDto.UserRes user = userService.readById(userId);
        return ResponseEntity.ok(user != null ? user :Map.of("message", "존재하지 않는 사용자입니다."));
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(userService.readAll());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> update(@PathVariable Long userId, @RequestBody UserDto.UserReq userReq) {
        userService.update(userId, userReq);
        return ResponseEntity.ok(Map.of("message", "성공적으로 수정되었습니다."));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.ok(Map.of("message", "성공적으로 삭제되었습니다."));
    }
}
