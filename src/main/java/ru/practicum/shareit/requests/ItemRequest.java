package ru.practicum.shareit.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemRequest {
    private Long id;
    private String description;
    private Long requestorId;
    private LocalDateTime created;
}
