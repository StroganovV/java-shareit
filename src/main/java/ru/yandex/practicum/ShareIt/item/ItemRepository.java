package ru.yandex.practicum.ShareIt.item;

import java.util.Collection;
import java.util.List;

public interface ItemRepository {
    Item create(long userId, Item item);

    Item update(long userId, long itemId, Item item);

    Item get(long itemId);

    void delete(long userId, long itemId);

    List<Item> getAllUsersItems(long userId);

    Collection<Item> getAll();
}