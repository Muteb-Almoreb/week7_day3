package com.example.week7_day3.Controller;

import com.example.week7_day3.API.ApiResponse;
import com.example.week7_day3.Model.User;
import com.example.week7_day3.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser(){

        return ResponseEntity.status(200).body(userService.getAllUser());

    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user , Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("The User Add successfully"));


    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id , @RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }

        userService.updateUser(id , user);
        return ResponseEntity.status(200).body(new ApiResponse("The User Update successfully"));

    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){

        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("The User Delete successfully"));

    }




    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){


        return ResponseEntity.status(200).body( userService.getUserByEmail(email));

    }




    @GetMapping("/getUserByRole/{role}")
    public ResponseEntity<?> getUserByRole(@PathVariable String role){


        return ResponseEntity.status(200).body( userService.getUserByRole(role));

    }




    @GetMapping("/specificAge/{age}")
    public ResponseEntity<?> getUserByRole(@PathVariable Integer age){

        return ResponseEntity.status(200).body( userService.specificAge(age));

    }




    @GetMapping("/checkUsernameAndPassword/{username}/{password}")
    public ResponseEntity<?> checkUsernameAndPassword(@PathVariable String username , @PathVariable String password){

        return ResponseEntity.status(200).body( userService.checkUsernameAndPassword(username , password));

    }



}
