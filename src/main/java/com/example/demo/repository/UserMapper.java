package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.User;

/**
  * 
  * @author satakemisako
  *
  */

@Mapper
public interface UserMapper {


    public List<User> findByUsers();

    public User findByUserIdAndPassword(@Param("emailAddress") String emailAddress,@Param("password") String password);

    public void updateUser(User user);

    public void deleteUser(Integer id);
    
    public void insertUser(User user);
	
}
