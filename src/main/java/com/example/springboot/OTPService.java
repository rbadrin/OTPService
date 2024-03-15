package com.example.springboot;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


import org.springframework.stereotype.Service;

@Service
public class OTPService {

    private Map<String, String > otpRegistar = new HashMap<>();
    public String generateOTP(String email){
        String otp = String.valueOf(new Random().nextInt(9000) + 1000);
        OTP otpEntity = new OTP();
        otpEntity.setEmail(email);
        otpEntity.setOtpValue(otp);
        otpRegistar.put(email, otp);
        // System.out.println(otpEntity.getEmail()+ " : " +  otpEntity.getOtpValue());
        return otp;
    }

    public String validateOtp(String email, String user_input){
        System.out.println(otpRegistar.get(email));
        if(user_input.equals(otpRegistar.get(email)))
            return "Success";
        else
            return "Wrong OTP";
    }   
}
