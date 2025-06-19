package com.mss301.rentingservice.mapper;

import com.mss301.rentingservice.dto.RentingTransactionDTO;
import com.mss301.rentingservice.entities.RentingTransaction;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = RentingDetailMapper.class)
public interface RentingTransactionMapper {
    RentingTransactionDTO toDto(RentingTransaction entity);
    RentingTransaction toEntity(RentingTransactionDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(RentingTransactionDTO dto, @MappingTarget RentingTransaction entity);
}
