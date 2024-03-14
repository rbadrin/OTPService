package com.example.springboot;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPService {

    @Autowired
    OTPRepository otpRepository;

    public String generateOTP(String email){
        String otp = String.valueOf(new Random().nextInt(9000) + 1000);
        OTP otpEntity = new OTP();

        otpEntity.setEmail(email);
        otpEntity.setOtpValue(otp);
        otpRepository.saveAndFlush(otpEntity);
        System.out.println(otpEntity.getEmail()+ " : " +  otpEntity.getOtpValue());
        return otp;
    }

    public String validateOtp(String email, String user_input){
        
        return "Success";
    }   
}
