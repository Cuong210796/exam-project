package com.cuong.service;

import org.springframework.mail.SimpleMailMessage;

public interface SendEmailService {
    void sendEmail(SimpleMailMessage simpleMailMessage);
}
