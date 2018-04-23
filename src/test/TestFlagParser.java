package test;

import core.FlagStorage;
import core.FlagParser;
import core.Flag;

public class TestFlagParser {
    public static void main(String[] args) {
//        FlagStorage flagStorage = new FlagStorage();
//        FlagParser flagParser = new FlagParser();
        FlagStorage flagStorage = new FlagStorage(args);
        flagStorage.show();
        Flag test = new Flag("--test");
//        flagParser.add(test);
//        Boolean test = flagParser.parse("--test");
        System.out.println("Before init:");
        System.out.println(test);
//        flagParser.addFlag(args[0]);
//        Проблема в том что ссылка не меняется
        System.out.println("After init:");
        System.out.println(test);
    }
}
