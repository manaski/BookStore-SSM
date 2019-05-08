package com.gangbin.store.dao;

import com.gangbin.store.bean.ShoppingCartItem;
import com.gangbin.store.bean.ShoppingCartItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoppingCartItemMapper {
    long countByExample(ShoppingCartItemExample example);

    int deleteByExample(ShoppingCartItemExample example);

    int deleteByPrimaryKey(Integer itemId);

    int insert(ShoppingCartItem record);

    int insertSelective(ShoppingCartItem record);

    List<ShoppingCartItem> selectByExample(ShoppingCartItemExample example);

    ShoppingCartItem selectByPrimaryKey(Integer itemId);

    int updateByExampleSelective(@Param("record") ShoppingCartItem record, @Param("example") ShoppingCartItemExample example);

    int updateByExample(@Param("record") ShoppingCartItem record, @Param("example") ShoppingCartItemExample example);

    int updateByPrimaryKeySelective(ShoppingCartItem record);

    int updateByPrimaryKey(ShoppingCartItem record);
}