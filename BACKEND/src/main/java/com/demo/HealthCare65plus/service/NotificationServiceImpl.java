package com.demo.HealthCare65plus.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendNotification(String recipient, String message) {
        // SMTP server configuration
        String host = "your-smtp-server.com";
        String port = "587";
        String username = "your-email@example.com";
        String password = "your-email-password";

        // Sender and recipient email addresses
        String from = "your-email@example.com";
        String to = recipient;

        // Email subject and content
        String subject = "Notification";
        String content = message;

        // SMTP server properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Create a session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a new email message
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(from));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            emailMessage.setSubject(subject);
            emailMessage.setText(content);

            // Send the email message
            Transport.send(emailMessage);

            System.out.println("Email notification sent to: " + recipient);
        } catch (MessagingException e) {
            System.out.println("Failed to send email notification to: " + recipient);
            e.printStackTrace();
        }
    }
}
