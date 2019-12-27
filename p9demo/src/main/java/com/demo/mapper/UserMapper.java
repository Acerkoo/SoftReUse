package com.demo.mapper;

import com.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Select("select * from users")
    @Results({
            @Result(property = "username", column = "name"),
            @Result(property = "password", column = "pwd"),
            @Result(property = "email", column = "email")
    })
    List<User> getAll();

    @Select("select * from users where name = #{name}")
    @Results({
            @Result(property = "username", column = "name"),
            @Result(property = "password", column = "pwd")
    })
    List<User> getByName(String name);

    @Insert("insert into users(name,pwd,email) values(#{username},#{password},#{email})")
    void insert(User user);

    @Update("update users set state=#{state} where name=#{username}")
    void update(User user);

    @Delete("delete from users where name=#{username}")
    void delete(User user);
}
