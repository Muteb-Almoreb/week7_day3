package com.example.week7_day3.Repository;

import com.example.week7_day3.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User,Integer> {

    User findUserById(Integer id);


    @Query("select u from User u where u.email =?1")
    User giveMeUserByEmail(String email);


    @Query("select u from User u where u.role =?1")
    List<User> giveMeUserByRole(String role);

    @Query("select u from User u where u.age>=?1")
    List<User> giveMeAgeOrAbove(Integer age);

    @Query("select u from User u where u.username=?1 and u.password=?2")
    User checkUsernameAndPassword(String username , String password);



}
