package com.test.test.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

import java.net.URL;

/**
 * apache commons发送邮件例子
 */
public class MailTest3 {
    public static void main(String[] args) throws Exception {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.163.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("zy840055899@163.com", "pwd"));
        email.setSSLOnConnect(true);

        email.setFrom("zy840055899@163.com");
        email.addTo("zhengying@raiyee.com");
        email.setSubject("TestMail");

        URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
        String cid = email.embed(url, "Apache logo");
        email.setHtmlMsg("<html><head></head><body><h1 style=\"color:red\">title</h1><img src=\"cid:\"+cid+\"\"></body></html>");

        // set the alternative message
        email.setTextMsg("Your email client does not support HTML messages");

        email.send();
    }
}