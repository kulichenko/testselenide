package ru.kulichenkom.mailtest;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import java.io.IOException;

public class MailTest {

    public static void connectingAndReadContent(ConnectToMailBox connectToMailBox) throws MessagingException, IOException {
        Folder inbox = connectToMailBox.getConnection().getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);
        System.out.println("Количество сообщений: " + String.valueOf(inbox.getMessageCount()));
        Message message[] = inbox.getMessages();
        for (int i = 0; i < message.length; i++) {
            System.out.println(i + ": " + message[i].getFrom()[0] + "\t" + message[i].getSubject());
            String content = message[i].getContent().toString();
            System.out.println(content);
        }
    }

    public static void main(String[] args) throws MessagingException, IOException {

        if (args.length != 0) {
            System.out.println("Подключение с параметрами из командной строки");
            ConnectToMailBox connectToMailBox = new ConnectToMailBox(args[0], args[1], args[2], args[3]);
            connectingAndReadContent(connectToMailBox);
        } else {
            System.out.println("Подключение без параметров из командной строки");
            ConnectToMailBox connectToMailBox = new ConnectToMailBox();
            connectingAndReadContent(connectToMailBox);
        }
    }
}

