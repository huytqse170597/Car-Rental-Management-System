package com.mss301.rentingservice.service.impl;

import com.mss301.rentingservice.dto.RentingTransactionDTO;
import com.mss301.rentingservice.entities.RentingTransaction;
import com.mss301.rentingservice.mapper.RentingTransactionMapper;
import com.mss301.rentingservice.repositories.RentingTransactionRepository;
import com.mss301.rentingservice.service.RentingTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentingTransactionServiceImpl implements RentingTransactionService {
    private final RentingTransactionRepository repository;
    private final RentingTransactionMapper mapper;

    @Override
    public RentingTransactionDTO create(RentingTransactionDTO dto) {
        RentingTransaction entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public RentingTransactionDTO update(Long id, RentingTransactionDTO dto) {
        RentingTransaction entity = repository.findById(id).orElseThrow();
        mapper.updateEntityFromDto(dto, entity);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public RentingTransactionDTO getById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public List<RentingTransactionDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}

