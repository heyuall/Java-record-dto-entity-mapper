package com.houssem.dtojavarecordmapper.mapper.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EntityIdMapperTest {

    private EntityForTestPurposes entity;

    @BeforeEach
    void setUp() {
        entity = new EntityForTestPurposes(123L);
    }

    @Test
    void map_entity_to_id_valid_entity_returns_id() {
        //when
        Long id = EntityIdMapper.mapEntityToId(entity);

        //then
        assertEquals(123L, id);
    }

    @Test
    void map_entity_to_id_null_entity_returns_null() {
        //when
        Long id = EntityIdMapper.mapEntityToId(null);

        //then
        assertNull(id);
    }

    @Test
    void map_id_to_entity_valid_id_and_class_returns_entity_with_id_set() {
        //given
        Long id = 123L;

        //when
        EntityForTestPurposes entity = EntityIdMapper.mapIdToEntity(id, EntityForTestPurposes.class);

        //then
        assertNotNull(entity);
        assertEquals(id, entity.getId());
    }

    @Test
    void map_id_to_entity_null_id_returns_null() {
        //when
        EntityForTestPurposes entity = EntityIdMapper.mapIdToEntity(null, EntityForTestPurposes.class);

        //then
        assertNull(entity);
    }

    @Test
    void map_entities_to_ids_valid_entities_returns_ids() {
        //given
        List<EntityForTestPurposes> entities = new ArrayList<>();
        entities.add(new EntityForTestPurposes(123L));
        entities.add(new EntityForTestPurposes(456L));

        //when
        List<Long> ids = EntityIdMapper.mapEntitiesToIds(entities);

        //then
        assertEquals(2, ids.size());
        assertEquals(123L, ids.get(0));
        assertEquals(456L, ids.get(1));
    }

    @Test
    void map_entities_to_ids_null_entities_returns_empty_list() {
        //when
        List<Long> ids = EntityIdMapper.mapEntitiesToIds(null);

        //then
        assertTrue(ids.isEmpty());
    }

    @Test
    void map_ids_to_entities_valid_ids_and_class_returns_entities() {
        //given
        List<Long> ids = List.of(123L, 456L);

        //when
        List<EntityForTestPurposes> entities = EntityIdMapper.mapIdsToEntities(ids, EntityForTestPurposes.class);

        //then
        assertEquals(2, entities.size());
        assertEquals(123L, entities.get(0).getId());
        assertEquals(456L, entities.get(1).getId());
    }

    @Test
    void map_ids_to_entities_null_ids_returns_empty_list() {
        //when
        List<EntityForTestPurposes> entities = EntityIdMapper.mapIdsToEntities(null, EntityForTestPurposes.class);

        //then
        assertTrue(entities.isEmpty());
    }
}

class EntityForTestPurposes {
    private Long id;

    EntityForTestPurposes(Long id) {
        this.id = id;
    }

    EntityForTestPurposes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
