package core;

import java.util.ArrayList;

public class FlagStorage {
    
//    private static FlagStorage INSTANCE;
    private ArrayList<Flag> flags;
    
    public FlagStorage() {
        flags = new ArrayList<>();
    }
    
    public FlagStorage(String[] flagNames) {
        this();
        for (String flagName : flagNames) {
            this.add(new Flag(flagName));
        }
    }
    
//    public static FlagStorage getInstance() {
//        if (INSTANCE == null) {
//            INSTANCE = new FlagStorage();
//        }
//        return INSTANCE;   
//    }
    
    public void add(Flag flag){
        for (Flag f : flags) {
            if (f.getName() != flag.getName()) {
                flags.add(flag);
            }
        }
    }
    
    public Flag get(String name) {
        for (Flag f : flags) {
            if (f.getName().equals(name)) {
                return f;
            }
        }
        return null;
    }
    
    public void show() {
        for (Flag flag : flags) {
            System.out.println(flag);
        }
    }
    
}
