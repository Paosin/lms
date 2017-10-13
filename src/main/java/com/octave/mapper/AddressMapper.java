package com.octave.mapper;

import com.octave.entity.Address;

import org.springframework.stereotype.Component;

@Component("addressMapper")
public interface AddressMapper {
    int insert(Address record);
}