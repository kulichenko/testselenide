package ru.kulichenkom.mailtest;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import java.io.IOException;

public class MailTest {

    public static void main(String[] args) throws MessagingException, IOException {
        ConnectToMailBox connectToMailBox = new ConnectToMailBox();
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
}
