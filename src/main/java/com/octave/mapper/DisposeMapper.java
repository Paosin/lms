package com.octave.mapper;

import com.octave.entity.Dispose;

public interface DisposeMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Dispose record);

    int insertSelective(Dispose record);

    Dispose selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Dispose record);

    int updateByPrimaryKey(Dispose record);
}