package com.delivery.services;

import com.delivery.dto.UserDto;
import com.delivery.dto.UserSignIn;
import com.delivery.dto.UserSignUpRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    UserDto signup(UserSignUpRequest userSignUpRequest);
    UserDto findUserByEmail(String email);
    UserDto updateProfile(UserDto userDto);
    UserDto changePassword(UserDto userDto, String newPassword);
     List<UserDto> usersAll();
    void deleteById(int id);
    UserDto findById(int id);
    // UserDto signIn(UserSignIn userSignIn);

}
