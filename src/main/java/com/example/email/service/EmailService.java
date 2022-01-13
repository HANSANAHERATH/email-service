package com.example.email.service;

import com.example.email.dto.EmailDto;
import com.example.email.exception.MessageException;
import org.springframework.core.io.FileSystemResource;

import javax.mail.MessagingException;

public interface EmailService {

    public void sendPlainTextEmail(EmailDto emailDto);
    public void sendHtmlBodyEmail(EmailDto emailDto) throws MessageException;
    public void sendHtmlBodyEmailWithAttachment(EmailDto emailDto, String fileLocation, String fileName) throws MessageException;
    public void sendHtmlBodyEmailWithInlineImage(EmailDto emailDto, String file) throws MessageException;
}
