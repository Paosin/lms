package com.octave.service.order.impl;

import com.octave.entity.City;
import com.octave.mapper.CityMapper;
import com.octave.service.order.CityService;
import com.octave.vo.CityVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Paosin Von Scarlet on 2017/10/13.
 */
@Service
@Transactional(readOnly = true)
public class CitySErviceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<CityVo> listByParent(Integer id) {
        List<CityVo> cityVos = this.cityMapper.listByParent(id);
        return cityVos;
    }
}
