package ru.yandex.practicum.ShareIt.item;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {
    ItemServiceImpl itemServiceImpl;

    @PostMapping
    public ItemDto create(@RequestHeader("X-Sharer-User-Id") long userId,
                          @Valid @RequestBody ItemDto itemDto) {
        return ItemMapper.toItemDto(itemServiceImpl.create(userId, ItemMapper.toItem(itemDto)));
    }

    @PatchMapping("/{itemId}")
    public ItemDto update(@RequestHeader("X-Sharer-User-Id") long userId,
                          @RequestBody Item item,
                          @PathVariable long itemId) {
        return ItemMapper.toItemDto(itemServiceImpl.update(userId, itemId, item));
    }

    @GetMapping("/{itemId}")
    public ItemDto get(@PathVariable long itemId) {
        return ItemMapper.toItemDto(itemServiceImpl.get(itemId));
    }

    @DeleteMapping("/{itemId}")
    public void delete(@RequestHeader("X-Sharer-User-Id") long userId,
                       @PathVariable long itemId) {
        itemServiceImpl.delete(userId, itemId);
    }

    @GetMapping
    public List<ItemDto> getAllUsersItems(@RequestHeader("X-Sharer-User-Id") long userId) {
        List<Item> items = itemServiceImpl.getAllUsersItems(userId);
        List<ItemDto> dtoItems = new ArrayList<>();

        for (Item i : items) {
            dtoItems.add(ItemMapper.toItemDto(i));
        }

        return dtoItems;
    }

    @GetMapping("/search")
    public List<ItemDto> search(@RequestParam String text) {
        if (text == null || text.isBlank()) {
            return new ArrayList<>();
        }
        return itemServiceImpl.search(text.toLowerCase(Locale.ROOT)).stream().map(ItemMapper::toItemDto).collect(Collectors.toList());
    }
}
