package com.octave.service.user.impl;

import com.octave.entity.Client;
import com.octave.mapper.ClientMapper;
import com.octave.service.user.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Paosin Von Scarlet on 2017/10/12.
 */
@Service
@Transactional(readOnly = true)
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;


    @Override
    public Boolean save(Client client) {
        try {
            this.clientMapper.insertSelective(client);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
