package com.danieltesting.designpatterns.Singleton;

import com.danieltesting.designpatterns.Main;

import java.util.LinkedList;

public class Singleton_Main extends Main {

    public static void singletonMain() {

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // EXAMPLE OF THE SINGLETON SCRABBLER

        System.out.println("SINGLETON EXAMPLE");

        Singleton_Scrabbler newInstance = Singleton_Scrabbler.getInstance(); //This is how you create the instance of the singleton

        System.out.println("Instance 1 ID: "+System.identityHashCode(newInstance)); // This is a way to check if you're dealing with the same object or a new one
                                                                                    // Remember since this is a Singleton it should be suppose to be only one
        System.out.println("Initial list of tiles"+newInstance.getLetterList()); // These are all the letters available

        LinkedList<String> playerOneTiles = newInstance.getTiles(7);//This is a new player and wants 7 tiles

        System.out.println("Player 1:"+playerOneTiles);//These will be the tiles that Player 1 got

        System.out.println("Tiles minus Player 1's tiles"+newInstance.getLetterList()); // These are the remaining Tiles, it is supposed to don't have the ones from player 7

        Singleton_Scrabbler instanceTwo = Singleton_Scrabbler.getInstance(); //Here we are trying to create a new instance, in other words, new letter, but it should be possible

        System.out.println("Instance 2 ID: "+System.identityHashCode(newInstance)+"If the singleton worked, this ID must be the same as 1"); //This is suppose to have the same ID as the Instance 1, since you can't create new instances
                                                                                    //IF for some reason this has a new ID, it means something is wrong with the SINGLETON
        System.out.println("Tiles check (must be same as after player 1's) "+newInstance.getLetterList()); //If a new instance was created, that it shouldn't happen, this will show again all the letters, if it worked correctly, it'll show the letter minus the ones from Player 1

        LinkedList<String> playerTwoTiles = newInstance.getTiles(7);//This player 2, if everything is correct, they shouldn't get the tiles that Plater 1 has

        System.out.println("Player 2:"+playerTwoTiles); //These ones should be from the remaining tiles, not from, in other words player 1 and 2 must not have the same tile twice (there are tiles with the same letter, but there are not two same tiles)

        System.out.println("Tiles minus Player 1 and 2's tiles"+newInstance.getLetterList());

        //--------------------------------------------------------------------------------------------------------------
        //This is the same Singleton, but here we will consider the players threads.
        // you can test this thread making all the previous part as comments, if you run both, threads will be similar to a 3 and 4 player
        System.out.println("\nSINGLETON EXAMPLE-THREADS\n");

        Runnable getTiles = new Singleton_Threads();

        Runnable getTilesAgain = new Singleton_Threads();

        new Thread(getTiles).start();
        new Thread(getTilesAgain).start();

        // this thread actually created two instances at the same time, that should not be possible because we are using a Singleton.
        // this problem was solved with synchronize, read line 48 to 51 of Singleton Class


    }

}
