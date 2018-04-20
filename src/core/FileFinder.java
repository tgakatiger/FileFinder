package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class FileFinder {
    private boolean SHOW_FINDINGS;
    private boolean SHOW_INFO;
    private boolean SHOW_ERRORS;
    private int MAX_LEVEL;

    private int count;
    private int level;
    private int max_level;
    private int errors;
    private long s_time;
    private long e_time;
    private ArrayList<String> errorsList;
    private ArrayList<String> findingList;
    private ArrayList<String> infoList;
    private long byteTotal;
    private ArgParser argParser;


    public FileFinder() {
        count = 0;
        level = 0;
        max_level = 0;
        errors = 0;
        s_time = System.currentTimeMillis();
        byteTotal = 0;
        argParser = new ArgParser();
        s_time = System.currentTimeMillis();
        errorsList = new ArrayList<>();
        findingList = new ArrayList<>();
        infoList = new ArrayList<>();
        byteTotal = 0;
        SHOW_ERRORS = true;
        SHOW_FINDINGS = false;
        SHOW_INFO = argParser.parse("--info");
        MAX_LEVEL = 3;
    }

    public FileFinder(String[] args) {
        this();
        this.argParser.init(args);
    }

    private void printListIf(Boolean condition, ArrayList<String> list) {
        if (condition) {
            for (String unit : list) {
                System.out.println(unit);
            }
        }
    }

    private void createInfoList() {
        infoList.add("==========");
        infoList.add("Total: " + count);
        infoList.add("ML: " + max_level + " E: " + errors + " BT: " + byteTotal);
        infoList.add("S@ " + s_time + " E@ " + e_time + " T: " + (double) (e_time - s_time) / 1000. + " sec.");
    }

    public void info() throws IOException {
        e_time = System.currentTimeMillis();

        printListIf(SHOW_FINDINGS, findingList);
        createInfoList();
        printListIf(SHOW_INFO, infoList);
        save(findingList, e_time + ".files");
        save(infoList, e_time + ".info");

        if (errors > 0) {
            save(errorsList, e_time + ".err");
            printListIf(SHOW_ERRORS, errorsList);
        }
    }

    private void save(ArrayList<String> list, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (String line : list) {
                writer.write(line + System.getProperty("line.separator"));
            }
            System.out.println("Write " + filename + " Done");
        }
    }

    private String whatIs(File name) {
        if (name.isFile()) return "[" + level + "F]";
        if (name.isDirectory()) return "[" + level + "D]";
        else return "[" + level + "]";
    }

    private String levelToSpaces() {
        String tmp = new String();
        for (int i = 0; i < level; ++i) {
            tmp = new String(tmp.concat(" "));
        }
        return tmp;
    }

    public void scanDir(String path) {
        File file = new File(path);
        if (!file.isDirectory()) {
            System.out.println("!D");
            return;
        } else {
            for (File f : file.listFiles()) {
                // System.out.println(" => " + levelToSpaces() + whatIs(f) + " " + f.getName() + " [" + f.length() + "]");
                findingList.add(" => " + levelToSpaces() + whatIs(f) + " " + f.getName() + " [" + f.length() + "]");
                byteTotal += f.length();
                // if (f.isDirectory()) {
                if (f.isDirectory() && (level) < MAX_LEVEL) {
                    level++;
                    // if (max_level < level) max_level = level;

                    try {
                        scanDir(f.getPath());
                    } catch (Exception e) {
                        level--;
                        errors++;
                        errorsList.add(f.getAbsolutePath());
                        System.out.println("!=> " + levelToSpaces() + "[can't open]");
                        continue;
                    }
                }
                count++;
            }
        }
        level--;
    }
}
