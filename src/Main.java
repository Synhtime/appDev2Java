import java.io.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    static char[] delimeters = {' ', '\0'};
    static char[] line = new char[128];
    static File file1 = new File("D:\\a\\2.txt"); /*создай, плз, у себя файл с аналогичным путем,
    чтобы тестить. в нем напиши какой-нибудь текст с разными словами и строками. Файл
    обязательно должен быть в кодировке UTF-8 (в блокноте: "Файл"-"Сохранить как", там будут парметры кодировки),
    иначе могут быть траблы с кириллицей*/

    public static void main(String[] args) throws IOException {

        //char symbol= '\0'; //твой код
        //System.out.print(isDelimeter(symbol)); //твой код

        //System.out.println(readFromFile(file1, 3)); //тестинг метода возвращения длины определенной строки из файла
        //System.out.println(countFileWords(file1));  //тестинг пересчета слов в файле
        //toConsole(file1); //тестинг вывода содержимого файла на консоль


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

    public static int readFromFile(File file1, int lineIndex) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(file1.getPath()));
        String s;

        int count = 0;

        while ((s = bfr.readLine()) != null) {
            count++;
            if (count == lineIndex) break;
        }
        //System.out.println(s);
        return (s == null || s.equals("") || s.charAt(0) == 65279) ? 0 : s.length();// это проверка на говносимволы, которые приводят к ошибкам
    }

    public static int countFileWords(File file1) throws IOException   //счет количества слов в файле с использованием delimeters как разделителей
    {
        StringBuilder sb1 = new StringBuilder(new String(Files.readAllBytes(Paths.get(file1.getPath())))); //создаем строку из всего файла, затем закидываем ее в StringBuilder для удобства обращения

        String delimetersRegex = "";  //создаем заготовку для шаблона Regex (замысловатая штука для поиска совпадений в строках)

        for (int i = 0; i < delimeters.length; i++) {                               //записываем заготовку из кусков твоего массива
            if (i == delimeters.length - 1) delimetersRegex += delimeters[i] + "+";
            else delimetersRegex += delimeters[i] + "+|";
        }

        Pattern pt1 = Pattern.compile(delimetersRegex); // создаем правило regex на основе заготовки

        while (sb1.charAt(0) == 65279 || (Character.toString(sb1.charAt(0))).matches(delimetersRegex)) //это для "Предусмотреть ситуацию, когда файл не содержит символов, отличных от разделителей. "
        {
            sb1.deleteCharAt(0);
        }

        String[] splittedString = pt1.split(sb1); //разделяем файл по шаблону Regex, полученные слова пихаем в массив
        //for (String c : splittedString) System.out.println(c); //тестинг посредством вывода слов полученных после сплита

        return splittedString.length;
    }

    public static int toConsole(File file1) throws IOException {
        System.out.println(new String(Files.readAllBytes(Paths.get(file1.getPath()))));
        return countFileWords(file1);
    }
}


