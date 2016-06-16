/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

    public static final String username = "testsattvaq@gmail.com";
    public static final String password = "www.sattvaq.com";

    public static void sendMail(String email, String subj, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session1 = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });



        try {

            Message message = new MimeMessage(session1);
            message.setFrom(new InternetAddress("sattvaq.info@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject(subj);
            message.setContent(content, "text/html");
            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
    
    
    public static void sendsms(String msg, String phno) {
        try {
            Date mydate = new Date(System.currentTimeMillis());

            URL url = new URL("http://control.msg91.com/sendhttp.php?user=sattvaq&password=195845&mobiles=" + phno + "&message=" + msg + "&sender=SatvaQ");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.connect();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder buffer = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                buffer.append(line).append("\n");
            }
            System.out.println("ok");
            rd.close();
            conn.disconnect();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
