package com.dao;

import bean.Info;

import java.util.List;

public interface TestDao {

    List<Info> findBeauty();

    Info findById(Integer id);
}
