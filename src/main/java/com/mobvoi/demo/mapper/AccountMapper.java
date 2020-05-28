package com.mobvoi.demo.mapper;

import com.mobvoi.demo.entiry.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper
public interface AccountMapper {

  public  Account selectByPrimaryKey(Integer id);
}