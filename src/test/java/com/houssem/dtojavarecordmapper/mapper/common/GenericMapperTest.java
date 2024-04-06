package com.houssem.dtojavarecordmapper.mapper.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

class GenericMapperTest {

    @Mapper(componentModel = "spring")
    interface TestMapper extends GenericMapper<Dto, Entity>{
        TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);
    }

    public static class Entity {
        private Long id;
        private boolean enabled;
        private LocalDateTime createdOn;
        private LocalDateTime lastModifiedOn;
        private String description;

        public Entity(Long id, boolean enabled, LocalDateTime createdOn, LocalDateTime lastModifiedOn, String description) {
            this.id = id;
            this.enabled = enabled;
            this.createdOn = createdOn;
            this.lastModifiedOn = lastModifiedOn;
            this.description = description;
        }

        public Entity (){
            this.enabled = true;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public LocalDateTime getCreatedOn() {
            return createdOn;
        }

        public void setCreatedOn(LocalDateTime createdOn) {
            this.createdOn = createdOn;
        }

        public LocalDateTime getLastModifiedOn() {
            return lastModifiedOn;
        }

        public void setLastModifiedOn(LocalDateTime lastModifiedOn) {
            this.lastModifiedOn = lastModifiedOn;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public record Dto(Long id, boolean enabled, LocalDateTime createdOn, LocalDateTime lastModifiedOn, String description){}

    private TestMapper mapper = TestMapper.INSTANCE;

    @Test
    void test_entity_to_dto() {
        //given
        Entity myEntity = new Entity(1L, true, LocalDateTime.now(), LocalDateTime.now(), "Description");

        //when
        Dto expectedDto = mapper.entityToDto(myEntity);

        //then
        Assertions.assertEquals(expectedDto.id, myEntity.getId());
        Assertions.assertEquals(expectedDto.createdOn, myEntity.getCreatedOn());
        Assertions.assertEquals(expectedDto.lastModifiedOn, myEntity.getLastModifiedOn());
        Assertions.assertEquals(expectedDto.description, myEntity.getDescription());
    }

    @Test
    void test_dto_to_entity() {
        //given
        Dto dto = new Dto(1L, true, LocalDateTime.now(), LocalDateTime.now(), "Description");

        //when
        Entity expected = mapper.dtoToEntity(dto);

        //then
        Assertions.assertEquals(expected.getId(), dto.id());
        Assertions.assertEquals(expected.isEnabled(), dto.enabled());
        Assertions.assertEquals(expected.getDescription(), dto.description());
        Assertions.assertNull(expected.getCreatedOn());
        Assertions.assertNull(expected.getLastModifiedOn());
    }

    @Test
    void test_update_entity_from_dto() {
        //given
        Entity entity = new Entity(1L, true, LocalDateTime.now(), LocalDateTime.now(), "Description");
        Dto dto = new Dto(2L,
                true,
                LocalDateTime.of(2024, 1,1, 12, 0),
                LocalDateTime.of(2024, 1, 1, 13, 0),
                "Description update");

        //when
        mapper.updateEntityFromDto(dto, entity);

        //then
        Assertions.assertEquals(entity.getId(), dto.id());
        Assertions.assertEquals(entity.isEnabled(), dto.enabled());
        Assertions.assertEquals(entity.getDescription(), dto.description());
        Assertions.assertNotEquals(entity.getCreatedOn(), dto.createdOn());
        Assertions.assertNotEquals(entity.getLastModifiedOn(), dto.lastModifiedOn());

    }
}