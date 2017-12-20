package com.demo.sample;

public class SwitchCaseExample {

    public static void main(String[] args) {

 

        grading('A');

        grading('C');

        grading('D');

        grading('E');

    }

 

    public static void grading(char grade) {

 

        int success;

        switch (grade) {

        case 'A':

            System.out.println("Excellent grade");

            success = 1;

            break;

        case 'B':

            System.out.println("Very good grade");

            success = 1;

            break;

        case 'C':

            System.out.println("Good grade");

            success = 1;

            break;

        case 'D':

        case 'E':

        case 'F':

            System.out.println("Low grade");

            success = 0;

            break;

        default:

            System.out.println("Invalid grade");

            success = -1;

     

        }



       
    }

}