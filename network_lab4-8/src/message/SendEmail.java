package message;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static void sendMessage(String error) throws Exception{

        Properties properties = new Properties();

        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.Enable","true");
        properties.put("mail.smtp.user","anastasiia.hileta.kn.2021@lpnu.ua");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("anastasiia.hileta.kn.2021@lpnu.ua", "16.08.2004");
            }
        };

        Session session = Session.getDefaultInstance(properties,auth);
        System.out.println("Session created");

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("anastasiia.hileta.kn.2021@lpnu.ua"));
        message.setReplyTo(InternetAddress.parse("anastasiia.hileta.kn.2021@lpnu.ua", false));
        message.setSubject("The critical error occurred","ANSI");
        message.setText(error,"ANSI");

        message.setRecipient(Message.RecipientType.TO,new InternetAddress("anastasiia.hileta.kn.2021@lpnu.ua"));
        Transport.send(message);
        System.out.println("Message was sent successfully...");

    }
}
