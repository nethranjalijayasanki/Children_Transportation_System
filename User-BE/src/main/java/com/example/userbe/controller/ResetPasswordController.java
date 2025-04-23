package com.example.userbe.controller;

import com.example.userbe.service.impl.UserServiceImpl;
import org.apache.logging.log4j.message.Message;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

@RestController
@RequestMapping("/api/v1/password")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResetPasswordController {
   
}
