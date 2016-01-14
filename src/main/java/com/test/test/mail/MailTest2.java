package com.test.test.mail;

import org.apache.commons.mail.*;

import java.net.URL;

/**
 * apache commons发送邮件例子(带附件发送邮件)
 */
public class MailTest2 {
    public static void main(String[] args) throws Exception {

        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("/Users/zhengying/Desktop/gou.jpeg");
        //附件也可以为网络图片
//        attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("a picture of dog");
        attachment.setName("dog");

        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.163.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("zy840055899@163.com", "pwd"));
        email.setSSLOnConnect(true);
        email.setFrom("zy840055899@163.com");
        email.setSubject("TestMail");
        email.setMsg("^_^");
        email.addTo("zhengying@raiyee.com");
        email.attach(attachment);

        email.send();
    }
}