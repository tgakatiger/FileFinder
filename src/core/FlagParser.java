package core;

import java.util.*;

public class FlagParser {

    private ArrayList<Flag> flags;

    public FlagParser() {
        flags = new ArrayList<>();
    }

    public boolean parse(String flag) {
        return flags.contains(flag);
    }

//    public void init(String[] args) {
//        this.args = args;
//    }

    public void info() {
        System.out.print("Arguments:\n\tFlags: ");
        for (Flag arg : flags) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

    public void addFlag(String arg) {
        flags.add(new Flag(arg));
    }
}
