package ru.yandex.practicum.ShareIt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    UserInMemoryRepositoryImpl userInMemoryRepositoryImpl;

    @Autowired
    public UserService(UserInMemoryRepositoryImpl userInMemoryRepositoryImpl) {
        this.userInMemoryRepositoryImpl = userInMemoryRepositoryImpl;
    }

    public User get(long userId) {
        return userInMemoryRepositoryImpl.get(userId);
    }

    public User update(User user, long userId) {
        return userInMemoryRepositoryImpl.update(user, userId);
    }

    public Collection<User> getAll() {
        return userInMemoryRepositoryImpl.getAll();
    }

    public User create(User user) {
        return userInMemoryRepositoryImpl.create(user);
    }

    public void delete(long userId) {
        userInMemoryRepositoryImpl.delete(userId);
    }
}
