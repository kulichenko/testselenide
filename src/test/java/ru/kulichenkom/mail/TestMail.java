package ru.kulichenkom.mail;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class TestMail {
    public static void main(String[] args) throws MessagingException, IOException {
        String pop3Host = "pop.rambler.ru";
        String portNum = "995";
//        String smtpHost = "smtp.rambler.ru";
//        int smtpPort = 465;
        String user = "coolich@lenta.ru";
        String password = "Aaabbb15";
        Properties props = System.getProperties();
//        props.put("mail.smtp.host", smtpHost);
//        props.put("mail.smtp.port", smtpPort);
//        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.pop3.host", pop3Host);
        props.put("mail.pop3.port", portNum);
        props.put("mail.pop3.ssl.enable", "true");
//        props.put("mail.transport.protocol", "smtp");
        props.put("mail.store.protocol", "pop3");
        Authenticator auth = new MyAuthenticator(user, password);
        Session session = Session.getDefaultInstance(props, auth);
//        session.setDebug(true);
        Store store = session.getStore();
        store.connect();
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);
        System.out.println("Количество сообщений: " + String.valueOf(inbox.getMessageCount()));
    }
}

class MyAuthenticator extends Authenticator {
    String user, password;

    public MyAuthenticator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        String user = this.user;
        String password = this.password;
        return new PasswordAuthentication(user, password);
    }
}
