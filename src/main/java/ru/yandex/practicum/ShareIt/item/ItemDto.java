package ru.yandex.practicum.ShareIt.item;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private Boolean available;
    private Long request;

}
