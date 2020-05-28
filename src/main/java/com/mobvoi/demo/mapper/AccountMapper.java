package com.mobvoi.demo.mapper;

import com.mobvoi.demo.entiry.Account;

public interface AccountMapper {

  Account selectByPrimaryKey(Integer id);
}