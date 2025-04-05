package project.postmantest.domain.user.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {
    private Long id;
    private String name;
    private int age;
    private String intro;

    @Builder
    public User(String name, int age, String intro) {
        this.name = name;
        this.age = age;
        this.intro = intro;
    }

    public void updateInfo(String name, int age, String intro) {
        this.name = name;
        this.age = age;
        this.intro = intro;
    }

    public void generateId(Long id) {
        this.id = id;
    }
}
