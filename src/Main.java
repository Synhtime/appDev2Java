import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static char[] delimeters = {' ', '\0'};

    static char[] line = new char[128];


    public static void main(String[] args) throws IOException {

        char symbol= '\0';
        System.out.println(isDelimeter(symbol));
        System.out.println(fromConsole(line));

    }

    public static int fromConsole(char [] inputLine)throws IOException{
        int i = 0;
        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
        char inputChar;
        for(i=0; i<127;i++){
            inputChar = (char)(myReader.read());
            if(inputChar=='\n'){
                break;
            }
            inputLine[i]=inputChar;
        }
        inputLine[i]='\0';
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
}


