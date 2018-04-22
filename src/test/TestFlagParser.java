package test;

import core.FlagParser;

public class TestFlagParser {
    public static void main(String[] args) {
        FlagParser flagParser = new FlagParser();
        Boolean test = flagParser.parse("--test");
        System.out.println("Before init:");
        System.out.println(test);
        flagParser.addFlag(args[0]);
        System.out.println("After init:");
        System.out.println(test);
    }
}
