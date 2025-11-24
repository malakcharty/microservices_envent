package com.community.events.mapper;

import com.community.events.dto.participant.ParticipantCreateUpdateDto;
import com.community.events.dto.participant.ParticipantReadDto;
import com.community.events.entities.Participant;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ParticipantMapper {

    ParticipantReadDto toDto(Participant participant);

    List<ParticipantReadDto> toDtoList(List<Participant> participants);

    Participant toEntity(ParticipantReadDto dto);

    Participant fromCreateUpdateDto(ParticipantCreateUpdateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateParticipantFromDto(ParticipantCreateUpdateDto dto,
                                  @MappingTarget Participant participant);
}
