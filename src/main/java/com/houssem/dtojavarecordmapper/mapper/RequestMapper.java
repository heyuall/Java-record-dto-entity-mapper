package com.houssem.dtojavarecordmapper.mapper;

import com.houssem.dtojavarecordmapper.dto.RequestDto;
import com.houssem.dtojavarecordmapper.entity.Request;
import com.houssem.dtojavarecordmapper.mapper.common.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RequestMapper extends GenericMapper<RequestDto, Request>, RequestCommonMapper {
    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);
}
