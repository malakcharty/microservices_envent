package com.community.events.mapper;

import com.community.events.dto.organizer.OrganizerCreateUpdateDto;
import com.community.events.dto.organizer.OrganizerReadDto;
import com.community.events.entities.Organizer;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface OrganizerMapper {

    OrganizerReadDto toDto(Organizer organizer);

    Organizer toEntity(OrganizerReadDto dto);

    Organizer fromCreateUpdateDto(OrganizerCreateUpdateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrganizerFromDto(OrganizerCreateUpdateDto dto,
                                @MappingTarget Organizer organizer);
}
