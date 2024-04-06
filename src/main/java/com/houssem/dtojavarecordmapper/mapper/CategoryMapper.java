package com.houssem.dtojavarecordmapper.mapper;

import com.houssem.dtojavarecordmapper.dto.CategoryDto;
import com.houssem.dtojavarecordmapper.entity.Category;
import com.houssem.dtojavarecordmapper.mapper.common.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends GenericMapper<CategoryDto, Category> {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
}
