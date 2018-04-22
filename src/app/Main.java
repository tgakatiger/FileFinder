package app;

import core.FileScanner;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: filefinder startpath");
            System.exit(-1);
        }
        FileScanner fileScanner = new FileScanner(args);
        fileScanner.scanDir(args[0]);
        fileScanner.getInfo();
    }
}