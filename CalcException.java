package otherclass;
import java.util.Scanner;

class NotValidInputException extends Exception {
    @Override
    public String toString() {
        return "Error : Not a Numeric input !" + " " + " Please Enter Valid Input!";
    }
}

class NumberDividedByZero extends Exception {
    @Override
    public String toString() {
        return "Error : Number cannot Divided By the zero.";
    }
}

class InputNotGreater extends Exception {
    @Override
    public String toString() {
        return "Error : Input cannot Greater than 1,00,000";
    }
}

class InputNotGreaterForMultiplication extends Exception {
    @Override
    public String toString() {
        return "Error : Input cannot Greater than 7000 if you want to perform multiplication.";
    }
}

public class CalcException {

    static int i = 1;
    static long getInput() throws NotValidInputException, InputNotGreater {
        Scanner sc = new Scanner(System.in);
        String s = " ";
        Long a = 0l;

        try {
            System.out.print("Enter operand  " + i + ":");
            a = sc.nextLong();
            i++;
        } catch (Exception e) {
            s = e.toString();
        }

        if (s == "java.util.InputMismatchException") {
            throw new NotValidInputException();
        }

        else {
            return a;
        }
    }

    static void check(long a , long b) throws InputNotGreater{
        if (a >= 100000 || b >= 100000) {
            throw new InputNotGreater();
        }
    }


    static long add(long a, long b) {
        return a + b;
    }

    static long subtract(long a, long b) {
        return a - b;
    }

    static long multiplication(long a, long b) throws InputNotGreaterForMultiplication {
        if (a >= 7000 || b >= 7000) {
            throw new InputNotGreaterForMultiplication();
        } else {
            return a * b;
        }
    }

    static long divide(long a, long b) throws NumberDividedByZero {

        if (b == 0) {
            throw new NumberDividedByZero();
        }

        else {
            return a / b;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            Long a = getInput();
            Long b = getInput();

            check(a, b);

            System.out.print("Enter Operation :");
            char c = sc.next().charAt(0);

            switch (c) {
                case '+':
                    System.out.println(add(a, b));
                    break;

                case '-':
                    System.out.println(subtract(a, b));
                    break;

                case '*':
                    System.out.println(multiplication(a, b));
                    break;

                case '/':
                    System.out.println(divide(a, b));
                    break;

                default:
                    System.out.println("Invalid Input! Please Enter Operation from + , - , * , / ...");
                    break;
            }

        }

        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
