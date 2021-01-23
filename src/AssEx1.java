import java.util.Scanner;

//name and SID: Kaori Kurokawa 2351397

public class AssEx1 {
    public static void main(String[] args) {
        String date = "01/01/21";
        comment();
        welcome(date);
        int n = 10;
        divisors(n);
        System.out.println(check(1));
        System.out.println(check(6));
        System.out.println(check(11));
        System.out.println(check(12));
        calculator();
        products(13,7);
        products(-2,7);
        products(3,6);
        products(12,13);
        products(5,25);
    }

    public static void comment() {
        // just a comment!
    }

    public static void welcome(String date) {
        //prompts the user to enter their name
        System.out.println("Hi, please enter your name.");
        Scanner s = new Scanner(System.in);
        //save their name in a string variable
        String userName = s.nextLine();
        System.out.println("Hello " + userName + " " + date);
    }

    public static void divisors(int n) {
        //create a for loop to calculates if n is dividable by all of the integers between 1 and n)
        for (int i = 1; i <= n; i++) {
            //check if n is dividable by numbers between 1 - n
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }

    public static boolean check(int n) {
        //check if n is 12, or is between 5 and 10
        if ((n == 12) || ((n > 5) && (n < 10))) {
            return true;
        }
        return false;
    }

    public static void calculator() {
        System.out.println("Please input an integer, followed by an operator e.g +-*/, followed by another integer.\nYou should enter them on the same line and separated by spaces.");
        //first scanner
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        //second scanner with input passed to it
        Scanner t = new Scanner(input);
        //take out and store the first integer entered by user
        int firstInt = t.nextInt();
        //take out and store the operator entered by user
        String operator = t.next().trim();
        //take out and store the second integer entered by user
        int secondInt = t.nextInt();
        double result = 0;
        if (operator.equals("+")) {
            result = firstInt + secondInt;
        } else if (operator.equals("-")) {
            result = firstInt - secondInt;
        } else if (operator.equals("*")) {
            result = firstInt * secondInt;
        } else if (operator.equals("/")) {
            //casting firstInt and secondInt into two double variable, so that we can perform floating point division
            result = ((double) firstInt) / ((double) secondInt);
        }

        //get the length of first and second int for formatting
        String firstIntInString = String.format("%s", firstInt);
        int firstIntLength = firstIntInString.length() + 1;
        String secondIntInString = String.format("%s", secondInt);
        int secondIntLength = secondIntInString.length() + 1;

        //set the right String format syntax for first int
        String firstIntSyntax = "%-" + firstIntLength + "d";
        //set the right String format syntax for second int
        String secondIntSyntax = "%-" + secondIntLength + "d";
        //set the right String format syntax for the operator
        String operatorSyntax = "%-2s";
        //set the right String format syntax for the whole expression
        String wholeSyntax = firstIntSyntax + operatorSyntax + secondIntSyntax;
        String wholeExpression = String.format(wholeSyntax, firstInt, operator, secondInt);
        String answer = String.format("%7.2f", result);

        System.out.println(wholeExpression + "=" + answer);
    }




    public static void products(int rows, int columns) {
        //check if number of rows and columns is >=0 and <=20
        if ((!isRowsAndColumnValid(rows)) || ((!isRowsAndColumnValid(columns)))) {
            System.out.println("error");
        } else if((rows==0)||(columns==0)){
            System.out.println();
        } else{

            //set the length of each entry
            int largestValue = (rows * columns);
            String largestValueInString = String.format("%s", largestValue);
            int length = largestValueInString.length() + 1;

            //set the right String.format syntax for each entry
            String format = ("%" + length + "d");
            //set the right String.format syntax for "-"
            String formatForSymbol = ("%" + length + "s");


            //column heading
            System.out.print(String.format(formatForSymbol, "|"));
            for (int a = 1; a <= columns; a++) {
                    System.out.print(String.format(format, a));
                }

            System.out.println();

            //print out the "-" line
            for (int b = 0; b <= columns; b++) {
                    //how many "-" to print out = length of the biggest value + 1
                    for (int d = 1; d <= length; d++) {
                        System.out.print("-");
                    }
                }

            System.out.println();

            //for the rows, stops when j = number of rows
            for (int j = 1; j <= rows; j++) {
                    //rows heading
                    String rowsHeading = j + "|";
                    System.out.print(String.format(formatForSymbol, rowsHeading));
                    //for columns, stops when i = number of columns
                    for (int i = 1; i <= columns; i++) {
                        //prints out every product of row*column (i*j) with the format, until i= j,
                        // then restart the loop
                        System.out.print(String.format(format, i * j));
                    }
                    //create new line after 2nd loop ends
                    System.out.println();
                }
            }
        }





    public static boolean isRowsAndColumnValid(int n) {
        if ((n < 0) || (n > 20)) {
            return false;
        }
        return true;
    }



}



