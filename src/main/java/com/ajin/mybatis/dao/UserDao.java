package com.ajin.mybatis.dao;

import com.ajin.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by ajin on 16-12-14.
 */
public class UserDao {
    //使用dao方式，可以看出里面需要写很多代码
    private SqlSessionFactory sqlSessionFactory;

    public UserDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User selectUser(int id){
        SqlSession sqlSession= sqlSessionFactory.openSession();
        User user =sqlSession.selectOne("test.selectUser",id);
        return user;
    }
}
