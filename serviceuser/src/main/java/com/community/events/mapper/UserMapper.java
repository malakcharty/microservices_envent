package com.community.events.mapper;

import com.community.events.dto.user.UserReadDto;
import com.community.events.entities.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserReadDto userReadDto);

    UserReadDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserReadDto userReadDto, @MappingTarget User user);
}