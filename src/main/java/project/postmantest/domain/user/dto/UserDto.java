package project.postmantest.domain.user.dto;

import project.postmantest.domain.user.entity.User;

public class UserDto {

    public record UserReq(
            String name,
            int age,
            String intro
    ) {
        public User toEntity() {
            return User.builder()
                    .name(name)
                    .age(age)
                    .intro(intro)
                    .build();
        }
    }

    public record UserRes(
            Long id,
            String name,
            int age,
            String intro
    ) {
        public static UserRes fromEntity(User user) {
            return new UserRes(
                    user.getId(),
                    user.getName(),
                    user.getAge(),
                    user.getIntro()
            );
        }
    }
}
