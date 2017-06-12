package com.si;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Startup {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring/si-components.xml");
    }
}
