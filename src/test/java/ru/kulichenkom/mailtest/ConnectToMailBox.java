package ru.kulichenkom.mailtest;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class ConnectToMailBox {

    private String host = "pop.rambler.ru";
    private String port = "995";
    private String user = "coolich@lenta.ru";
    private String password = "Aaabbb15";

    public Store getConnection() throws MessagingException, IOException {
        Properties properties = System.getProperties();
        properties.put("mail.pop3.host", host);
        properties.put("mail.pop3.port", port);
        properties.put("mail.pop3.ssl.enable", "true");
        properties.put("mail.store.protocol", "pop3");
        Authenticator auth = new MyAuthenticator(user, password);
        Session session = Session.getInstance(properties, auth);
        Store store = session.getStore();
        store.connect();
        return store;
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
}
