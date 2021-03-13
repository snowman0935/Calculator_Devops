package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class calculator {

    public static final Logger logger = LogManager.getLogger(calculator.class);

    public calculator() {}

    public static void main(String[] args) {
        calculator cal = new calculator();
        Scanner scanner = new Scanner(System.in);
        double num1, num2;

        do{
            System.out.println("Calcuator");
            System.out.println("Available functions\n1 - Square Root of x\n2 - Factorial of x\n3 - Natural Log of x\n4 - x Power b");
            int fun;

            try{
                fun = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            try{
                num1 = scanner.nextDouble();
            } catch (InputMismatchException error) {
                return;
            }

            switch(fun){
                case 1:
                    System.out.println("Square root of x = " + calculator.sqt(num1));
                    break;
                case 2:
                    System.out.println("Factorial of x =" + calculator.factorial(num1));
                    break;
                case 3:
                    System.out.println("Natural log of x =" + calculator.log(num1));
                case 4:
                    try {
                        System.out.print("Enter b");
                        num2 = scanner.nextDouble();
                    } catch (InputMismatchException error){
                        return;
                    }
                    System.out.println("x power b = " + calculator.power(num1, num2));
                    break;
                default:
                    System.out.print("Closing");
                    return;
            }
        }while(true);
    }


    public static double sqt(double i){
        double temp = 0;
        try {
            logger.info("[SQRT] - " + i);
            if (i < 0) {
                temp = Double.NaN;
                throw new ArithmeticException("Cannot find square root of -ve numbers");
            } else {
                temp = Math.sqrt(i);
            }
        } catch (ArithmeticException error){
            logger.error("[EXCEPTION - SQRT] - Cannot find sqrt of -ve numbers");
        } finally {
            logger.info("[RESULT - SQRT] = " + temp);
        }
        return temp;
    }

    public static double factorial(double i){
        logger.info("[FACTORIAL] - " + i );
        double temp = 1.0;
        for (int t = 1; t<= i; t++){
            temp *= t;
        }
        logger.info("[RESULT - FACTORIAL] = " + temp);
        return temp;
    }
    public static double log(double i){
        Double temp = 0.0;
        try {
            logger.info("[LOG] - " + i);
            if (i < 0){
                temp = Double.NaN;
                throw new ArithmeticException("Cannot find log of negative numbers");
            }
            else if (i == 0){
                temp = Double.NEGATIVE_INFINITY;
                throw new ArithmeticException("Log of 0 is negative infinity");
            }
            else {
                temp = Math.log(i);
            }
        } catch (ArithmeticException error){
            logger.error("[EXCEPTION - log] - inout is less than or equal to zero");
        } finally {
            logger.info("[RESULT - LOG] = " + temp);
        }
        return temp;
    }
    public static double power(double i, double j){
        logger.info("[POWER] - " + i + ", " + j );
        double temp = Math.pow(i,j);
        logger.info("[RESULT - POWER] = " + temp);
        return temp;
    }

}