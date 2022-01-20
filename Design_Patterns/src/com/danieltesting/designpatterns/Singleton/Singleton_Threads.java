package com.danieltesting.designpatterns.Singleton;

import java.util.LinkedList;

public class Singleton_Threads implements Runnable{ //This class is created as part of Singleton examples, this is to test the threads

    public void run() {

        Singleton_Scrabbler newInstance = Singleton_Scrabbler.getInstance();

        System.out.println("Instance ID: "+System.identityHashCode(newInstance));

        System.out.println("Initial list of tiles"+newInstance.getLetterList());

        LinkedList<String> playerOneTiles = newInstance.getTiles(7);

        System.out.println("Player:"+playerOneTiles);

        System.out.println("Got Tiles");

    }

}
