import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static char[] delimeters = {' ', '\0'};
    static char[] line = new char[128];
    static File file1 = new File("D:\\a\\2.txt"); //создай, плз, у себя файл с аналогичным путем, чтобы тестить

    public static void main(String[] args) throws IOException
    {
        


        //System.out.println(readFromFile(file1.getPath(), 2)); //тестинг метода возвращения длины определенной строки из файла
        //char symbol= '\0';
        //System.out.print(isDelimeter(symbol));

    }

    public static int fromConsole(char[] inputLine) throws IOException {
        int i = 0;
        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
        char inputChar;
        for (i = 0; i < 127; i++) {
            inputChar = (char) (myReader.read());
            if (inputChar == '\n') {
                break;
            }
            inputLine[i] = inputChar;
        }
        inputLine[i] = '\0';
        return i;
    }

    public static int isDelimeter(char symbolToCompare) {
        for (int i = 0; i < delimeters.length; i++) {
            if (symbolToCompare == delimeters[i]) {
                return 1;
            }
        }
        return 0;
    }

    public static int readFromFile(String filepath, int lineIndex) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(filepath));
        String s;

        int count = 0;

        while ((s = bfr.readLine()) != null) {
            count++;
            if (count == lineIndex) break;
        }

        return s.length();
    }
}


