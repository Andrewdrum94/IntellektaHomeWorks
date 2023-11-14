package com.intellekta;

import com.intellekta.domain.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageRunApplicationContext {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/message-bean.xml");
        Message message = context.getBean(Message.class);
        System.out.println(message.getMessage());
    }
}
