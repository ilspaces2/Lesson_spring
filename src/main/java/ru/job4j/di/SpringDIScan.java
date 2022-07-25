package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Чтобы в ручную не добавлять классы в контекст, можно выполнить
 * сканированием.
 * Чтобы классы попали в контекст их нужно пометить
 * аннотацией @Component и воспользоватся методом scan("путь пакета").
 */

public class SpringDIScan {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.di");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Enter name: ");
        ui.print();
    }
}
