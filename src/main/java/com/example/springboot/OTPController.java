package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
public class OTPController {
    
    @Autowired
    OTPService otpService; 

    @GetMapping("/generate")
    public ResponseEntity<String> generateOTP(@RequestParam String email){
        String generateOTP = otpService.generateOTP(email);
        return ResponseEntity.ok("OTP : Generated"+ generateOTP);
    }
}
