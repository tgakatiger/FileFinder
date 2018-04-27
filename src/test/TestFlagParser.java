package test;

import core.FlagStorage;
import core.Flag;

public class TestFlagParser {
    public static void main(String[] args) {
//        FlagStorage flagStorage = new FlagStorage();
//        FlagParser flagParser = new FlagParser();
//        FlagStorage flagStorage = new FlagStorage(args);
//        flagStorяage.show();
//        Flag test = new Flag("--test");
//        flagParser.add(test);
//        Boolean test = flagParser.parse("--test");
//        System.out.println("Before init:");
//        System.out.println(test);
//        flagParser.addFlag(args[0]);
//        Проблема в том что ссылка не меняется
//        System.out.println("After init:");
//        System.out.println(test);
        
        System.out.println("Init storage before flag\n");
        
        FlagStorage flagStorage = new FlagStorage(args);
        flagStorage.show();
        Flag flag = flagStorage.get("--test");
        System.out.println("Flag in Storage: " + flag);
        flagStorage.show();

        
        System.out.println("\n\nInit storage after flag\n");
        
        FlagStorage flagStorage2 = new FlagStorage();
        flagStorage2.show();
        Flag flag2 = flagStorage2.get("--run");
        flagStorage2.add(new Flag("--run"));
        System.out.println("Flag in Storage: " + flag2);
        flagStorage2.show();

    }
}
