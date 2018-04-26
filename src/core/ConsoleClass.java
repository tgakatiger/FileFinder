package core;

import java.io.Console;

public class ConsoleClass {
    public ConsoleClass() {
        Console console = System.console();
        System.out.println("Your name:");
        String name = console.readLine();
//        System.out.println("Password:");
//        String password = console.readPassword().toString();
        System.out.println(String.format("Hello, %s. You pass => $s", name));
    }

}
