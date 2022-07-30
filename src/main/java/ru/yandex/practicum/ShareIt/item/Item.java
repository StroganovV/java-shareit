package ru.yandex.practicum.ShareIt.item;

import lombok.*;
import ru.yandex.practicum.ShareIt.request.ItemRequest;

@Data
@RequiredArgsConstructor

public class Item {
    private Long id;
    private String name;
    private String description;
    private Boolean available;
    private Long ownerId;
    private ItemRequest request;

    public Boolean isAvailable() {
        return available;
    }
}
