package com.danieltesting.designpatterns.Factory;

import com.danieltesting.designpatterns.Main;

import java.util.Scanner;

public class Factory_Main extends Main {

    public static void factoryMain(){

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //EXAMPLE OF THE SHIP FACTORY

        System.out.println("\nFACTORY EXAMPLE\n");

        //This example also has a method outside the main, that is the one responsible for printing the results after we stablish the type of ship


/*

//All of this is the old way to create the new class, so we are going to encapsulate everything by placing all inside a new class that makes
// the decisions "Factory_EnemyShipFactory"

        Factory_EnemyShip theEnemy = null;

// this is the old way of creating objects
// When we use a "new" we are not being dynamic

		EnemyShip ufoShip = new UFOEnemyShip();

		doStuffEnemy(ufoShip);

		System.out.print("\n");

// -----------------------------------------

// This allows me to make the program more dynamic
// It doesn't close the code from being modified
// and that is bad!

// Defines an input stream to watch: keyboard
        Scanner userInput = new Scanner(System.in);

        String enemyShipOption = "";

        System.out.println("\n\nFACTORY EXAMPLE");

        System.out.println("What type of ship? (U / R)");

        if (userInput.hasNextLine()){

            enemyShipOption = userInput.nextLine();

        }

        if(enemyShipOption.toUpperCase().equals("U")){

            theEnemy = new Factory_UFOEnemyShip();

        }
        else if(enemyShipOption.toUpperCase().equals("R")){

            theEnemy = new Factory_RocketEnemyShip();

        }

        doStuffEnemy(theEnemy);

// -----------------------------------------
 */

        Factory_EnemyShipFactory shipFactory = new Factory_EnemyShipFactory();

        Factory_EnemyShip theEnemy = null;

        Scanner userInput = new Scanner(System.in);

        System.out.println("What type of ship? (U / R / B):");

        if (userInput.hasNextLine()){

            String typeOfShip = userInput.nextLine();

            theEnemy = shipFactory.makeEnemyShip(typeOfShip.toUpperCase());

        }

        if (theEnemy != null){

            doStuffEnemy(theEnemy);

        }

        else{

            System.out.println("Enter U, R, or B next time.");

        }



    }

    //This is a static method that only calls the results of Factory_EnemyShip to be displayed, just like the printer at the end
    public static void  doStuffEnemy(Factory_EnemyShip anEnemyShip){

        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();

    }

}
