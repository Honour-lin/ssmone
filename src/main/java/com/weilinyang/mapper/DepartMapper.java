package com.weilinyang.mapper;

import com.weilinyang.pojo.Depart;
import com.weilinyang.pojo.DepartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartMapper {
    int countByExample(DepartExample example);

    int deleteByExample(DepartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Depart record);

    int insertSelective(Depart record);

    List<Depart> selectByExample(DepartExample example);

    Depart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Depart record, @Param("example") DepartExample example);

    int updateByExample(@Param("record") Depart record, @Param("example") DepartExample example);

    int updateByPrimaryKeySelective(Depart record);

    int updateByPrimaryKey(Depart record);

    /**
     * 批量插入
     */
    void batchInsert(List<Depart> departs);
}