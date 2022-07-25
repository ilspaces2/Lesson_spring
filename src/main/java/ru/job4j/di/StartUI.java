package ru.job4j.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * У нас есть 3 способа внедрения зависимости.
 * 1. Через конструктор. Правильный способ.
 * 2. Через поле и аннотацию @Autowired. Нежелательный способ.
 * 3. Через метод set и аннотацию @Autowired. Нежелательный способ.
 * Выполним второй способ..
 * <p>
 * Spring поддерживает 6 режимов создания объектов.
 * Для установки режима используется аннотация @Scope("режим").
 * <ul>
 * <li> singleton - объект создает один раз на всю виртуальную машину(стоит по умолчанию)
 * <li> prototype - каждый раз создается новый объект.
 * <li> session - объект существует, пока существует сессия пользователя.
 * <li> request - объект существует, пока существует запрос.
 * <li> application - объект существует, пока существует ServletContext.
 * <li> websocket - объект существует, пока есть активная сессия для web-сокета.
 * </ul>
 */

@Component
@Scope("prototype")
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
