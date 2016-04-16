public class Main {

    static char[] delimeters = {' ', '\0'};


    public static void main(String[] args) {

        char symbol= '\0';
        System.out.print(isDelimeter(symbol));

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


