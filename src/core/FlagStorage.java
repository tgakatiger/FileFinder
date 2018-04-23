package core;

import java.util.ArrayList;

public class FlagStorage {
    
    private ArrayList<Flag> flags;
    
    public FlagStorage() {
        flags = new ArrayList<>();
    }
    
    public FlagStorage(Flag flag) {
        this();
        this.add(flag);
    }
    
    public Flag get(String flagName) {
        for (Flag flag : flags) {
            if (flag.getName().equals(flagName)) {
                flag.change();
                return flag;
            }
        }        
        return new Flag(flagName);
    }
    
    public FlagStorage(String[] flags) {
        this();
        for (String flagName : flags) {
            add(new Flag(flagName));
        }
    }
    
    public void add(Flag flag) {
        if (!flags.contains(flag)) {
            flags.add(flag);
        }
    }
    
    public Boolean contains(Flag flag) {
        return flags.contains(flag);
    }
    
    public void show() {
        for (Flag flag : flags) {
            System.out.println(flag);
        }
        
        System.out.println("FlagStorage.flags  isEmpty: " + flags.isEmpty());
    }
    
}
