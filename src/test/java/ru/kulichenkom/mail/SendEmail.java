package ru.kulichenkom.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.Date;
import java.util.Properties;

public class SendEmail {
    public static void main(String[] args) throws MessagingException, IOException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.required", "true");
//        props.put("mail.debug", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props, null);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom("ivan1524215632145@gmail.com");
            msg.setRecipients(Message.RecipientType.TO,
                    "coolich@lenta.ru");
            msg.setSubject("JavaMail hello world example");
            msg.setSentDate(new Date(1));
            msg.setText("Hello, world!\n");
            Transport.send(msg, "ivan1524215632145@gmail.com", "Aaabbb15");
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }
    }
}
