/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.lang.*;

/**
 *
 * @author tmtmt
 */
public class Manager{


    //display menu
    public static void mennu() {
        System.out.println("========== Caculator Program ==========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("\nPlease choose one option: ");
    }

    public static double inputNumber() {
        System.out.print("Enter number: ");
        double number = Checker.checkInputDouble();
        return number;
    }

    //allow user calculator normal
    public static void normalCalculator() {
        double memory;
        System.out.print("Enter number: ");
        memory = Checker.checkInputDouble();
        while (true) {
            System.out.print("Enter operator: ");
            String operator = Checker.checkInputOperator();
            if (operator.equalsIgnoreCase("+")) {
                memory += inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                memory -= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                memory *= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
            double denominator = inputNumber();
            if (denominator == 0) {
                System.err.println("Error: Division by zero is not allowed.");
                continue; // Skip this iteration and ask for operator again
            }
            memory /= denominator;
            System.out.println("Memory: " + memory);
        }
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, inputNumber());
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }

    }

    //display result BMI status
    public static String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    //allow user BMI calculator
    public static void BMICalculator() {
        System.out.print("Enter Weight(kg): ");
        double weight = Checker.checkInputDouble();
        System.out.print("Enter Height(cm): ");
        double height = Checker.checkInputDouble();
        double bmi = weight*10000 / (height*height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}

