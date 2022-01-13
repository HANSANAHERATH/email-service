package com.example.email.service;

import com.example.email.dto.EmailDto;
import com.example.email.exception.MessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendPlainTextEmail(EmailDto emailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDto.getTo());
        message.setSubject(emailDto.getSubject());
        message.setText(emailDto.getMessageBody());
        mailSender.send(message);
    }

    @Override
    public void sendHtmlBodyEmail(EmailDto emailDto) throws MessageException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setSubject(emailDto.getSubject());
            helper.setTo(emailDto.getTo());
            helper.setText(emailDto.getMessageBody(), true);
        } catch (MessagingException e) {
           throw new MessageException();
        }
        mailSender.send(message);
    }

    @Override
    public void sendHtmlBodyEmailWithAttachment(EmailDto emailDto, String fileLocation, String fileName) throws MessageException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setSubject(emailDto.getSubject());
            helper.setTo(emailDto.getTo());
            helper.setText(emailDto.getMessageBody(),true);
            FileSystemResource file = new FileSystemResource(new File(fileLocation));
            helper.addAttachment(fileName, file);
        } catch (MessagingException e) {
            throw new MessageException();
        }
        mailSender.send(message);
    }

    @Override
    public void sendHtmlBodyEmailWithInlineImage(EmailDto emailDto, String file) throws MessageException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setSubject(emailDto.getSubject());
            helper.setTo(emailDto.getTo());
            String content = emailDto.getMessageBody() + "<br><img src='cid:image001'/><br>";
            helper.setText(content, true);
            FileSystemResource resource = new FileSystemResource(new File(file));
            helper.addInline("image001", resource);
        } catch (MessagingException e) {
            throw new MessageException();
        }
        mailSender.send(message);
    }

}
