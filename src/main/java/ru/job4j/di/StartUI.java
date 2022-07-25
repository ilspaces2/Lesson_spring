package ru.job4j.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * У нас есть 3 способа внедрения зависимости.
 * 1. Через конструктор. Правильный способ.
 * 2. Через поле и аннотацию @Autowired. Нежелательный способ.
 * 3. Через метод set и аннотацию @Autowired. Нежелательный способ.
 * Выполним второй способ..
 */

@Component
public class StartUI {

    @Autowired
    private ConsoleInput consoleInput;

    @Autowired
    private Store store;

    public void add(String value) {
        store.add(askStr(value));
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    private String askStr(String question) {
        return consoleInput.askStr(question);
    }
}
