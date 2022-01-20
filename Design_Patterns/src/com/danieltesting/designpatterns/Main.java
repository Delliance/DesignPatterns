package com.danieltesting.designpatterns;

import com.danieltesting.designpatterns.AbstractFactory.AbstractFactory_Main;
import com.danieltesting.designpatterns.Builder.Builder_Main;
import com.danieltesting.designpatterns.Decorator.Decorator_Main;
import com.danieltesting.designpatterns.Factory.Factory_Main;
import com.danieltesting.designpatterns.InitialConcepts.InitialConcepts_Main;
import com.danieltesting.designpatterns.Singleton.Singleton_Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // THIS IS A SUPERCLASS I MADE TO CALL THE OTHER MAIN CLASSES, THIS WAS JUST TO SEPARATE EACH OF THE EXAMPLES
        // THE MAIN FOR EACH EXAMPLE, CAN BE USED TO CREATE A NEW INDIVIDUAL PROJECT

        Scanner exampleOption = new Scanner(System.in);
        String selectedExample = "";

        System.out.println("What example do you want to run?" +
                "\nInitial concepts (I)" +
                "\nSingleton (S)" +
                "\nFactory (F)" +
                "\nAbstract Factory (A)" +
                "\nBuilder (B)" +
                "\nDecorator (D)");

        selectedExample = exampleOption.nextLine();

        switch (selectedExample.toUpperCase()) {

            case "I":
                //INITIAL CONCEPTS
                InitialConcepts_Main.initialConceptsMain();

            case "S":
                //SINGLETON EXAMPLE
                Singleton_Main.singletonMain();
                break;

            case "F":
                // FACTORY EXAMPLE
                Factory_Main.factoryMain();
                break;

            case "A":
                //ABSTRACT FACTORY EXAMPLE
                AbstractFactory_Main.abstractFactoryMain();
                break;

            case "B":
                //BUILDER EXAMPLE
                Builder_Main.factoryMain();
                break;

            case "D":
                    //DECORATOR EXAMPLE
                Decorator_Main.decoratorMain();

            default:
                System.out.println("That was not a valid letter, please try again");


        }

    }

}
