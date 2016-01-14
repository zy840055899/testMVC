package com.test.test.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 * apache commons发送邮件例子
 */
public class MailTest {
    public static void main(String[] args) {

        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.163.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("zy840055899@163.com", "password"));
            email.setSSLOnConnect(true);
            email.setFrom("zy840055899@163.com");
            email.setSubject("TestMail");
            email.setMsg("^_^");
            email.addTo("zhengying@raiyee.com");
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}