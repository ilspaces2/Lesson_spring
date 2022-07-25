package ru.job4j.di;

public class StartUI {

    private ConsoleInput consoleInput;

    private Store store;

    public StartUI(ConsoleInput consoleInput, Store store) {
        this.consoleInput = consoleInput;
        this.store = store;
    }

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
