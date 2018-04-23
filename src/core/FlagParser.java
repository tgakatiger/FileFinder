package core;

import java.util.*;

public class FlagParser {

    private ArrayList<Flag> flags;

    public FlagParser() {
        flags = new ArrayList<>();
    }

    public boolean parse(String flag) {
        for (Flag f : flags) {
            if (f.getName().equals(flag)) {
                return true;
            }
        }
        return false;
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

    public void add(Flag f) {
        flags.add(new Flag(arg));
    }
}
