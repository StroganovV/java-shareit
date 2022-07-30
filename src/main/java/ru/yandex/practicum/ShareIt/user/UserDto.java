package ru.yandex.practicum.ShareIt.user;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;

@Data
public class UserDto {
    private Long id;
    private String name;
    @NonNull
    @Email
    private String email;

    public UserDto(String name, String email, Long id) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
