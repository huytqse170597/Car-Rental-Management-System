package com.mss301.authservice.mapper;

import com.mss301.authservice.entities.Customer;
import com.mss301.authservice.enums.Role;
import com.mss301.authservice.payload.CustomerPayload;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toEntity(CustomerPayload payload) {
        Customer entity = new Customer();
        entity.setCustomerID(payload.getCustomerID());
        entity.setCustomerName(payload.getCustomerName());
        entity.setTelephone(payload.getTelephone());
        entity.setEmail(payload.getEmail());
        entity.setCustomerBirthday(payload.getCustomerBirthday());
        entity.setCustomerStatus(payload.getCustomerStatus());
        entity.setPassword(payload.getPassword());
        entity.setRole(payload.getRole());
        return entity;
    }

    public CustomerPayload toPayload(Customer entity) {
        CustomerPayload payload = new CustomerPayload();
        payload.setCustomerID(entity.getCustomerID());
        payload.setCustomerName(entity.getCustomerName());
        payload.setTelephone(entity.getTelephone());
        payload.setEmail(entity.getEmail());
        payload.setCustomerBirthday(entity.getCustomerBirthday());
        payload.setCustomerStatus(entity.getCustomerStatus());
        payload.setPassword(entity.getPassword());
        payload.setRole(entity.getRole());
        return payload;
    }
}
