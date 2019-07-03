package ru.kulichenkom.mail;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class RamblerMailTest {
    static final String ENCODING = "UTF-8";

    public static void receiveMessage(String user, String password, String pop3Host)
            throws MessagingException, IOException {
        Authenticator authenticator = new Passport(user, password);
        Properties properties = System.getProperties();
        properties.put("mail.user", user);
        properties.put("mail.host", pop3Host);
//        properties.put("mail.port", pop3Port);
        properties.put("mail.debug", "false");
        properties.put("mail.store.protocol", "pop3");
        properties.put("mail.transport.protocol", "smtp");

        Session session = Session.getDefaultInstance(properties, authenticator);
        Store store = session.getStore();
        store.connect();
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);

    }

    public static void main(String[] args)
            throws MessagingException, IOException {
        String smtpHost = "smtp.rambler.ru";
        String smtpPort = "465";
        String pop3Host = "pop.rambler.ru";
        String pop3Port = "995";
        String address = "coolich@lenta.ru";
        String login = "coolich";
        String password = "8kusZE6h8squWjm";
        receiveMessage(login, password, pop3Host);
    }
}

class Passport extends Authenticator {
    String user;
    String password;

    public Passport(String user, String password) {
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