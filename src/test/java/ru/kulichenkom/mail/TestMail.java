package ru.kulichenkom.mail;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class TestMail {
    public static void main(String[] args) throws MessagingException, IOException {
        String host = "pop.rambler.ru";
        int portNum = 995;
        String user = "coolich@lenta.ru";
        String password = "8kusZE6h8squWjm";
        Properties props = System.getProperties();
        props.put("mail.pop3.host", host);
        props.put("mail.pop3.port", portNum);
        props.put("mail.pop3.ssl.enable", "true");
        Authenticator auth = new MyAuthenticator(user, password);
        Session session = Session.getDefaultInstance(props, auth);
        session.setDebug(true);
        Store store = session.getStore("pop3");
        store.connect();
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
