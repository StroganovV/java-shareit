package ru.yandex.practicum.ShareIt.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.ShareIt.exceptions.IncorrectUserException;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@Slf4j
@AllArgsConstructor
public class UserController {
    UserService userService;

    @GetMapping
    public Collection<UserDto> getAll() {
        return userService.getAll().stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public UserDto get(@PathVariable long userId) {
        return UserMapper.toUserDto(userService.get(userId));
    }

    @PatchMapping("/{userId}")
    public UserDto update(@RequestBody User user,
                          @PathVariable long userId) {
        return UserMapper.toUserDto(userService.update(user, userId));
    }

    @PostMapping
    public UserDto create(@Valid @RequestBody User user) {
        if (user.getEmail() == null || user.getName() == null) {
            throw new IncorrectUserException("Некорректно заполно имя или email");
        }
        return UserMapper.toUserDto(userService.create(user));
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable long userId) {
        userService.delete(userId);
    }
}
