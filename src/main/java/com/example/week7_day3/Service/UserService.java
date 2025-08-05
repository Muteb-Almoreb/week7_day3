package com.example.week7_day3.Service;

import com.example.week7_day3.API.ApiException;
import com.example.week7_day3.Model.User;
import com.example.week7_day3.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Get all the Users
    //• Add new User
    //• Update User
    //• Delete User
    //• Check if username and password are correct
    //• Get user by email
    //• Get All users with specific role
    //• Get All users with specific age or above


    public List<User> getAllUser(){

        return userRepository.findAll();

    }

    public void addUser(User user){

        userRepository.save(user);

    }

    public void updateUser(Integer Id , User user){

        User oldeUser = userRepository.findUserById(Id);
        if(oldeUser==null){
            throw new ApiException("The User Not found");
        }

        oldeUser.setAge(user.getAge());
        oldeUser.setEmail(user.getEmail());
        oldeUser.setRole(user.getRole());
        oldeUser.setPassword(user.getPassword());
        oldeUser.setUsername(user.getUsername());
        oldeUser.setName(user.getName());

        userRepository.save(oldeUser);

    }

    public void deleteUser(Integer id){
        User user = userRepository.findUserById(id);
        if(user==null){
            throw new ApiException("The User Not found");
        }

        userRepository.delete(user);

    }

    public User getUserByEmail(String email){
        User user = userRepository.giveMeUserByEmail(email);
        if(user==null){
            throw new ApiException("The User Not found");
        }

        return user;

    }


    public List<User> getUserByRole(String role){
         List<User> users = userRepository.giveMeUserByRole(role);
        if(users.isEmpty()){
            throw new ApiException("The User Not found");
        }

        return users;

    }

    public List<User> specificAge(Integer age){
        List<User> users = userRepository.giveMeAgeOrAbove(age);

        if(users.isEmpty()){
            throw new ApiException("The User Not found");

        }

        return users;

    }

    public User checkUsernameAndPassword(String username , String password){

      User userCheck=  userRepository.checkUsernameAndPassword( username , password);
      if(userCheck==null){
              throw new ApiException("Username or password is incorrect");
          }


      return userCheck;


    }



}
