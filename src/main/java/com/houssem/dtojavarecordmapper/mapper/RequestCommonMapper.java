package com.houssem.dtojavarecordmapper.mapper;

import com.houssem.dtojavarecordmapper.entity.Category;

import java.util.List;

import static com.houssem.dtojavarecordmapper.mapper.common.EntityIdMapper.mapEntitiesToIds;
import static com.houssem.dtojavarecordmapper.mapper.common.EntityIdMapper.mapIdsToEntities;

public interface RequestCommonMapper {
    default List<Long> mapCategoriesToDto(List<Category> categories) {
        return mapEntitiesToIds(categories);
    }

    default List<Category> mapCategoryIdsToEntity(List<Long> categories) {
        return mapIdsToEntities(categories, Category.class);
    }
}
