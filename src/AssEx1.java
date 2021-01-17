import java.util.Scanner;

//name and SID: Kaori Kurokawa 2351397

public class AssEx1 {
    public static void main(String[] args) {
        String date = "01/01/21";

//        welcome(date);
//
//        int n = 10;
//        divisors(n);
//
//        System.out.println(check(1));
//        System.out.println(check(6));
//        System.out.println(check(11));
//        System.out.println(check(12));
//
//        calculator();

        products(13, 7);
    }

    public static void welcome(String date) {
        System.out.println("Hi, please enter your name."); //prompts the user to enter their name
        Scanner s = new Scanner(System.in);
        String userName = s.nextLine(); //save their name in a string variable
        System.out.println("Hello " + userName + " " + date);
    }

    public static void divisors(int n) {
        for (int i = 1; i <= n; i++) { //create a for loop to calculates if n is dividable by all of the integers between 1 and n)
            if (n % i == 0) { //check if n is dividable by numbers between 1 - n
                System.out.println(i); //if n is dividable by a number, print out that number in a new line
            }
        }
    }

    public static boolean check(int n) {
        if ((n == 12) || ((n > 5) && (n < 10))) { //check if n is 12, or is between 5 and 10
            return true; //if yes, return true
        }
        return false;  // if no, return false
    }

    public static void calculator() {
        System.out.println("Please input an integer, followed by an operator e.g +-*/, followed by another integer.\nYou should enter them on the same line and separated by spaces.");
        Scanner s = new Scanner(System.in); //first scanner
        String input = s.nextLine();
        Scanner t = new Scanner(input); //second scanner with input passed to it
        int firstInt = t.nextInt(); //take out and store the first integer entered by user
        String operator = t.next().trim(); //take out and store the operator entered by user
        int secondInt = t.nextInt(); //take out and store the second integer entered by user
        double result = 0;
//        System.out.println(firstInt);
//        System.out.println(operator);
//        System.out.println(secondInt);
        if (operator.equals("+")) {
            result = firstInt + secondInt;
        } else if (operator.equals("-")) {
            result = firstInt - secondInt;
        } else if (operator.equals("*")) {
            result = firstInt * secondInt;
        } else if (operator.equals("/")) {
            result = ((double) firstInt) / ((double) secondInt); //casting firstInt and secondInt into two double variable, so that we can perform floating point division
        }
        String formula = firstInt + " " + operator + " " + secondInt + " " + "=";
        String answer = String.format("%7.2f", result);
        System.out.print(formula + answer);

    }

    public static void products(int rows, int columns) {
        //set the length of each entry
        int largestValue = (rows*columns);
        int length = 0;
        if((largestValue>=0) && (largestValue<=9)){
            length = 2;
        }else if((largestValue>9) && (largestValue<=99)){
            length = 3;
        }else if((largestValue>99) && (largestValue<=999)){
            length = 4;
        }else if((largestValue>999) && (largestValue<=9999)){
            length = 5;
        }

        String format = ("%" + length+"d"); //set the right syntax for String.format
        String formatForSymbol = ("%" + length+"s"); //set the right syntax for -

        //column heading
        System.out.print(String.format(formatForSymbol, "|"));
        for(int a = 1; a <= columns; a ++){

            System.out.print(String.format(format,a));
        }
        System.out.println();
        for(int b = 0; b <=columns; b++){  //print out the "-" until it reaches the end of column
            for(int c =1; c <= length; c++){ //how many "-" to print out = length of the biggest value + 1
                System.out.print("-");
            }
        }
        System.out.println();

        for (int j = 1; j <= rows; j++) {//for the rows, stops when j = number of rows
            if ((!checkNumberOfRowAndColumn(rows)) || ((!checkNumberOfRowAndColumn(columns)))) {
                System.out.println("error");
                break;
            }
            String rowsHeading = j + "|";
            System.out.print(String.format(formatForSymbol, rowsHeading));
            for (int i = 1; i <= columns; i++) {//for columns, stops when i = number of columns
                System.out.print(String.format(format, i*j)); //prints out every product of row*column (i*j) with the format, until i= j, then it end the loop, restart the loop
            }
            System.out.println(); //create new line after 2nd  loop ends
        }
    }


    public static boolean checkNumberOfRowAndColumn(int n) {
        if ((n < 0) || (n > 20)) {
            return false;
        }
        return true;
    }



}



