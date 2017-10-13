package com.octave.mapper;

import com.octave.entity.Client;
import com.octave.entity.ClientKey;

import org.springframework.stereotype.Component;

@Component("clientMapper")
public interface ClientMapper {
    int deleteByPrimaryKey(ClientKey key);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(ClientKey key);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
}