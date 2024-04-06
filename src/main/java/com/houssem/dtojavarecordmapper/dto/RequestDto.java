package com.houssem.dtojavarecordmapper.dto;

import java.time.LocalDateTime;
import java.util.List;

public record RequestDto(Long id,
                         boolean enabled,
                         LocalDateTime createdOn,
                         LocalDateTime lastModifiedOn,
                         String title,
                         String description,
                         List<Long> categories) {
}
