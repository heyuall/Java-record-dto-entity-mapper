package com.houssem.dtojavarecordmapper.mapper.common;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface GenericMapper<D, E> {

    @Mapping(target = "createdOn", source = "createdOn", ignore = true)
    @Mapping(target = "lastModifiedOn", source = "lastModifiedOn", ignore = true)
    @Mapping(target = "enabled", source = "enabled", ignore = true)
    E dtoToEntity(D dto);

    D entityToDto(E entity);

    @Mapping(target = "createdOn", source = "createdOn", ignore = true)
    @Mapping(target = "lastModifiedOn", source = "lastModifiedOn", ignore = true)
    @Mapping(target = "enabled", source = "enabled", ignore = true)
    List<E> dtoToEntity(Iterable<D> dtos);

    List<D> entityToDto (Iterable<E> entities);

    @Mapping(target = "createdOn", source = "dto.createdOn", ignore = true)
    @Mapping(target = "lastModifiedOn", source = "dto.lastModifiedOn", ignore = true)
    @Mapping(target = "enabled", source = "enabled", ignore = true)
    void updateEntityFromDto(D dto, @MappingTarget E entity);
}

