package ru.kulichenkom.mail;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class RamblerMailTest {
    static final String ENCODING = "UTF-8";

    public static void receiveMessage(String host, int portNum, String user, String password)
            throws MessagingException, IOException {
        Authenticator authenticator = new OurAuthenticator(user, password);
        Properties properties = System.getProperties();
        properties.put("mail.user", user);
        properties.put("mail.host", host);
        properties.put("mail.pop3.port", portNum);
        Session session = Session.getDefaultInstance(properties, authenticator);
        Store store = session.getStore("pop3");
        store.connect();
//        Folder inbox = store.getFolder("INBOX");
//        inbox.open(Folder.READ_WRITE);

    }

    public static void main(String[] args)
            throws MessagingException, IOException {

        String host = "pop.rambler.ru";
        String user = "coolich";
        String password = "8kusZE6h8squWjm";
        int portNum = 995;
        receiveMessage(host, portNum, user, password);
    }
}

class OurAuthenticator extends Authenticator {
    String user, password;

    public OurAuthenticator(String user, String password) {
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