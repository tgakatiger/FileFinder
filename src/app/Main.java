package app;

import core.FileFinder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: filefinder startpath");
            System.exit(-1);
        }
        FileFinder fileFinder = new FileFinder(args);
        fileFinder.scanDir(args[0]);
        fileFinder.info();
        // Change for test commit
    }
}