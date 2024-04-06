package com.houssem.dtojavarecordmapper.mapper.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mapping.MappingException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public interface EntityIdMapper {
    Logger logger = LoggerFactory.getLogger(EntityIdMapper.class);
    static <T> Long mapEntityToId(T entity) {
        if (entity == null) {
            return null;
        }
        try {
            Method getIdMethod = entity.getClass().getMethod("getId");
            return (Long) getIdMethod.invoke(entity);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            logger.debug(e.getMessage());
            return null;
        }
    }

    static <T> T mapIdToEntity(Long id, Class<T> entityClass) {
        if (id == null) {
            return null;
        }
        try {
            T entity = entityClass.getDeclaredConstructor().newInstance();
            entityClass.getMethod("setId", Long.class).invoke(entity, id);
            return entity;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new MappingException("Error mapping ID to entity", e);
        }
    }

    static <T> List<Long> mapEntitiesToIds(List<T> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }
        try {
            Method getIdMethod = entities.get(0).getClass().getMethod("getId");
            return entities.stream().map(entity -> {
                try {
                    return (Long) getIdMethod.invoke(entity);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    logger.debug(e.getMessage());
                    return null;
                }
            }).toList();
        } catch (NoSuchMethodException e) {
            throw new MappingException("Entity does not have a getId() method", e);
        }
    }

    static <T> List<T> mapIdsToEntities(List<Long> ids, Class<T> entityClass) {
        if (ids == null) {
            return Collections.emptyList();
        }
        return ids.stream().map(id -> mapIdToEntity(id, entityClass)).toList();
    }
}

