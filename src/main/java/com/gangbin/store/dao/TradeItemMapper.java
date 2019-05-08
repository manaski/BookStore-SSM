package com.gangbin.store.dao;

import com.gangbin.store.bean.TradeItem;
import com.gangbin.store.bean.TradeItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeItemMapper {
    long countByExample(TradeItemExample example);

    int deleteByExample(TradeItemExample example);

    int deleteByPrimaryKey(Integer itemId);

    int insert(TradeItem record);

    int insertSelective(TradeItem record);

    List<TradeItem> selectByExample(TradeItemExample example);

    TradeItem selectByPrimaryKey(Integer itemId);

    int updateByExampleSelective(@Param("record") TradeItem record, @Param("example") TradeItemExample example);

    int updateByExample(@Param("record") TradeItem record, @Param("example") TradeItemExample example);

    int updateByPrimaryKeySelective(TradeItem record);

    int updateByPrimaryKey(TradeItem record);
}