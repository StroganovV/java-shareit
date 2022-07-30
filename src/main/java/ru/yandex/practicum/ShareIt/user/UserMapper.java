package ru.yandex.practicum.ShareIt.user;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        return new UserDto(
                user.getName(),
                user.getEmail(),
                user.getId()
        );
    }
}
