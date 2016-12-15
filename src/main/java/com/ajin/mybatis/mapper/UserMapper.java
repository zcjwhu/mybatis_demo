package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by ajin on 16-12-14.
 */
public interface UserMapper {
    //使用mapper接口的方式，可以看出仅仅定义一个方法即可 接口中默认的时public的方法，所以不用修饰
    //需要注意的是使用这种方式时，需要对应的UserMapper.xml文件的namespace即为这个接口的全限定名称
    //对应的方法名称和映射文件中的statement的id需要一致
    User selectUser(int id);

    void insertUser(User user);

    void deleteUser(int id);

    void updateUser(User user);
}
