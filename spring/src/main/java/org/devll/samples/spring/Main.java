package org.devll.samples.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

//        applicationContext.register(Config.class);

        applicationContext.scan("org.devll.samples.spring");
        applicationContext.refresh();

        Book book = (Book) applicationContext.getBean("book");

        System.out.println(book);
    }
}
