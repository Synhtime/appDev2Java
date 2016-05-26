//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Main {
    static char[] delimeters = new char[]{' ', '\u0000'};
    static char[] line = new char[128];
    static File file1 = new File("/home/thebaldsoprano/IdeaProjects/testFile");

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        System.out.println(fromConsole(line));
        System.out.println(countWords(line));
    }

    public static int fromConsole(char[] inputLine) throws IOException {
        boolean i = false;
        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));

        int var4;
        for(var4 = 0; var4 < 127; ++var4) {
            char inputChar = (char)myReader.read();
            if(inputChar == 10) {
                break;
            }

            inputLine[var4] = inputChar;
        }

        inputLine[var4] = 0;
        return var4;
    }

    public static int countWords(char[] inputLine) {
        int i = 0;
        byte q = 0;
        int words = 0;

        while(inputLine[i] != 0) {
            if(q == 0) {
                if(isDelimeter(inputLine[i])) {
                    q = 1;
                    ++i;
                } else {
                    q = 2;
                    ++i;
                }
            } else if(q == 1) {
                if(isDelimeter(inputLine[i])) {
                    ++i;
                } else {
                    q = 2;
                    ++i;
                }
            } else if(q == 2) {
                if(isDelimeter(inputLine[i])) {
                    q = 1;
                    ++words;
                    ++i;
                } else {
                    ++i;
                }
            }
        }

        if(q == 2) {
            ++words;
        }

        return words;
    }

    public static boolean isDelimeter(char symbolToCompare) {
        for(int i = 0; i < delimeters.length; ++i) {
            if(symbolToCompare == delimeters[i]) {
                return true;
            }
        }

        return false;
    }

    public static int readFromFile(File file1, int lineIndex) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(file1.getPath()));
        int count = 0;

        String s;
        while((s = bfr.readLine()) != null) {
            ++count;
            if(count == lineIndex) {
                break;
            }
        }

        return s != null && !s.equals("") && s.charAt(0) != '\ufeff'?s.length():0;
    }

    public static int countFileWords(File file1) throws IOException {
        StringBuilder sb1 = new StringBuilder(new String(Files.readAllBytes(Paths.get(file1.getPath(), new String[0]))));
        String delimetersRegex = "";

        for(int pt1 = 0; pt1 < delimeters.length; ++pt1) {
            if(pt1 == delimeters.length - 1) {
                delimetersRegex = delimetersRegex + delimeters[pt1] + "+";
            } else {
                delimetersRegex = delimetersRegex + delimeters[pt1] + "+|";
            }
        }

        Pattern var5 = Pattern.compile(delimetersRegex);

        while(sb1.charAt(0) == '\ufeff' || Character.toString(sb1.charAt(0)).matches(delimetersRegex)) {
            sb1.deleteCharAt(0);
        }

        String[] splittedString = var5.split(sb1);
        return splittedString.length;
    }

    public static int toConsole(File file1) throws IOException {
        System.out.println(new String(Files.readAllBytes(Paths.get(file1.getPath(), new String[0]))));
        return countFileWords(file1);
    }
}
