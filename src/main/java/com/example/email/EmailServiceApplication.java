package com.example.email;

import com.example.email.dto.EmailDto;
import com.example.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class EmailServiceApplication {

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	void configureMail() throws MessagingException {
		String[] to = {"subodha.develop@gmail.com"};
		EmailDto emailDto = new EmailDto();
		emailDto.setSubject("Example Subject");
		emailDto.setTo(to);

		emailDto.setMessageBody("Sample Body");
		emailService.sendPlainTextEmail(emailDto);

		emailDto.setMessageBody("<b>Sample Body</b>");
		emailService.sendHtmlBodyEmail(emailDto);

		emailService.sendHtmlBodyEmailWithAttachment(emailDto,"Book.pdf","Bookpdf file.pdf");

		emailService.sendHtmlBodyEmailWithInlineImage(emailDto,"picture.png");
	}

}
