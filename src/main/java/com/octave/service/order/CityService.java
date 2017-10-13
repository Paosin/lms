package com.octave.service.order;

import com.octave.vo.CityVo;

import java.util.List;

/**
 * Created by Paosin Von Scarlet on 2017/10/13.
 */
public interface CityService {
    List<CityVo> listByParent(Integer id);
}
