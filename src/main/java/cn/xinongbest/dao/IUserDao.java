package cn.xinongbest.dao;

import cn.xinongbest.domain.User;

import java.util.List;

/**
 * 用户数据持久层接口
 * @author wzj
 */
public interface IUserDao {
    /**
     * 查询所有用户数据
     * @return List
     */
    List<User> findAll();
}
