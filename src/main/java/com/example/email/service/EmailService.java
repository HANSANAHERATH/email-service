package com.example.email.service;

import com.example.email.dto.EmailDto;
import com.example.email.exception.MessageException;

public interface EmailService {

    void sendPlainTextEmail(EmailDto emailDto);
    void sendHtmlBodyEmail(EmailDto emailDto) throws MessageException;
    void sendHtmlBodyEmailWithAttachment(EmailDto emailDto, String fileLocation, String fileName) throws MessageException;
    void sendHtmlBodyEmailWithInlineImage(EmailDto emailDto, String file) throws MessageException;
}
