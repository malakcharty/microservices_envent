package com.community.events.mapper;

import com.community.events.dto.staff.StaffReadDto;
import com.community.events.entities.Staff;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StaffMapper {
    Staff toEntity(StaffReadDto staffReadDto);

    StaffReadDto toDto(Staff staff);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Staff partialUpdate(StaffReadDto staffReadDto, @MappingTarget Staff staff);
}