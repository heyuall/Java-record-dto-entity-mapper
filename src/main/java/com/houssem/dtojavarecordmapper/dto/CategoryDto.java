package com.houssem.dtojavarecordmapper.dto;

import java.time.LocalDateTime;

public record CategoryDto(Long id,
                          boolean enabled,
                          LocalDateTime createdOn,
                          LocalDateTime lastModifiedOn,
                          String name,
                          String description) {
}
