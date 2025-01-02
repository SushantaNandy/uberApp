package com.nandysushanta.project.uber.uberApp.services;

import com.nandysushanta.project.uber.uberApp.dto.DriverDto;
import com.nandysushanta.project.uber.uberApp.dto.SignupDto;
import com.nandysushanta.project.uber.uberApp.dto.UserDto;

public interface AuthService {
    String login(String email, String password); // return token
    UserDto signup(SignupDto signupDto);
    DriverDto onboardNewDriver(Long userId);
}
