package core;

import java.io.Console;
import java.util.Scanner;

public class ConsoleClass {
    public ConsoleClass() {
        Console console = System.console();
        if (console == null) {
            System.out.println("No console found!");
            System.exit(-1);
        }
        System.out.println("Your name:");
        String name = console.readLine();
        System.out.println("Password:");
        char[] password = console.readPassword();
        System.out.println(String.format("Hello, %s", name));
        System.out.println("You password is");
        for (char ch : password) {
            System.out.print(ch);
        }

    }

}
