package com.octave.service.user.impl;

import com.octave.entity.Address;
import com.octave.mapper.AddressMapper;
import com.octave.service.user.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Paosin Von Scarlet on 2017/10/13.
 */
@Service
@Transactional(readOnly = true)
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean save(Address address) {
        return this.addressMapper.insert(address) > 0;
    }
}
