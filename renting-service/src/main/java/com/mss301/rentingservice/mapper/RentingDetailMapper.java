package com.mss301.rentingservice.mapper;

import com.mss301.rentingservice.dto.RentingDetailDTO;
import com.mss301.rentingservice.entities.RentingDetail;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RentingDetailMapper {
    RentingDetailDTO toDto(RentingDetail entity);
    RentingDetail toEntity(RentingDetailDTO dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(RentingDetailDTO dto, @MappingTarget RentingDetail entity);
}
