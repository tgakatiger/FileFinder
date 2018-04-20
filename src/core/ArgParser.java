package core;

import java.util.*;

class ArgParser {

    private String[] args;
    private ArrayList<String> flags;
    private boolean isReady;


    public ArgParser() {
        flags = new ArrayList<String>();
        isReady = false;
    }

    public ArgParser(String[] args) {
        this();
        this.args = args;
        isReady = true;
    }

    public boolean parse(String name) {
        if (!name.equals("")) {
            flags.add(name);
            if (args != null && args.length > 0) {
                for (String token : args) {
                    if (token.equals(name)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //public boolean parseParam(String name){
    //	return false;
    //}

    public void init(String[] args) {
        this.args = args;
        isReady = true;
    }

    public boolean isDone() {
        return isReady;
    }

    public void info() {
        System.out.print("Arguments:\n\tFlags: ");
        for (String arg : flags) {
            System.out.print(arg + " ");
        }
        // System.out.print("\n\tParams: ");
        // for (String arg : params){
        // System.out.print(arg + " ");
        // }
        System.out.println();
    }
}
