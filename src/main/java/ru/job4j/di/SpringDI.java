package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Теперь воспользуемся модулем Spring DI. Вместо самописного класса Context
 * мы будем использовать класс AnnotationConfigApplicationContext
 * (из Spring DI), который будет выполнять теже функции что и Context
 */

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConsoleInput.class, Store.class, StartUI.class);
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Enter name: ");
        ui.print();
    }
}
