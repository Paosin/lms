package com.octave.mapper;

import com.octave.entity.City;
import com.octave.vo.CityVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component("cityMapper")
public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    List<CityVo> listByParent(Integer id);

    List<CityVo> selectVoByPrimaryKey(Integer id);
}