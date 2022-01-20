package com.danieltesting.designpatterns.Singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList; // All of these import here are for the scrabble example, not for the Singleton itself

public class Singleton_Scrabbler {

    // this is the only a single instance of the class Singleton
    //this part here will be the access point for the one object created from this class
    private static Singleton_Scrabbler firstInstance = null;

    //The constructor here is private because there will be only one instance of the class Singleton
    private Singleton_Scrabbler() {    }


    // !!!!!!!!IMPORTANT!!!!!!!!This part in commens is the normal Singleton, the method with the if is a threat safe
/*
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return  SingletonHolder.INSTANCE;
    }
*/


    // EXAMPLE: this is to hold all the scrabble letters in an array
    String[] scrabbleLetters = {"a", "a", "a", "a", "a", "a", "a", "a", "a",
            "b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e",
            "e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h",
            "h", "i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l",
            "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o",
            "o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r",
            "r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u",
            "u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z",}; // The scrabble have a certain number of letter of each type, so they don't repeat

    //EXAMPLE
    private LinkedList<String> letterList = new LinkedList<String>(Arrays.asList(scrabbleLetters)); // Here the array of letters was converted into a list
                                                                                                    //This type of list each letter (nodes) is connected to
                                                                                                    // the next one and the one after
    //EXAMPLE: this is created to slowdown the first thread (threats are considered when a new object is tried to be created, since this is a Singleton, this is supposed to not happen)
    static boolean firstThread = true;


    // this is the thread safe method.
    //This method is still not completely fool proofed, several request can happen at the same time, creating multiple instances that we don't want
    //in order to solve this we can write "synchronized" between "static" and "Singleton" this means that as long as 1 thread is running the method, no other can enter
    //However Synchronize SLOWS DOWN A LOT, to solve this go to line 75, which makes the class synchronized temporarily until the first object is created
    // What happened in the thread example, is that while one thread entered the firstThread if, the other one did as well, since both entered at the same time
    // it meant that the Instance haven't been created yet, so both were able to create their own instance
    public static synchronized Singleton_Scrabbler getInstance() { // note for noobs like me: the Singleton in this line, means that this method in particular must return a Singleton class


        //this if is to check is the instance exists or not, it won't be null if an object was created for it
        //in other words, the only way to come here is only if a Singleton Object does not exist already
        if (firstInstance == null){

            //EXAMPLE: this is how the firtthread is slowed down
            if (firstThread){//this one here will always come inside, just to slowdown the thread, or in short the creating of a new instance of the object

                firstThread = false;

                Thread.currentThread();
                try {
                    Thread.sleep(1000); //Here the first thread entered, and while it was sleeping, the second one did as well, this is before the synchronize in line 75
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            //EXAMPLE-THREADWhat this do is to force the class to be synchronized method until the first object is created, this avoids the slowing down using Synchronize at the start
            //Here we also create a new IF for isntance ==NULL
            synchronized (Singleton_Scrabbler.class) {

                //EXAMPLE-THREAD, this is to check again if the instance was already created
                if(firstInstance==null) {


                    // this here is known as lazy instantiation, it means that if the instances is not needed, it'll never be created
                    firstInstance = new Singleton_Scrabbler();

                    //EXAMPLE: here we are just shuffling the letter, so everytime you play (create this instance) the letters will be ramdomly organized
                    Collections.shuffle(firstInstance.letterList);
                }

            }

        }
        // If you try to create a new object, it'll return the one that already exist, and if it does not exsit already, it'll
        //return the newly created
        return firstInstance;
    }

    //EXAMPLE: This is how you return the fiels inside a singleton, this is the second method that is shown in the basic Singleton, the one inside /* */
    public LinkedList<String> getLetterList(){ //The <String> means that all the values inside the LinkedList are Strings

        return firstInstance.letterList;

    }

    public LinkedList<String> getTiles(int howManyTiles){ //this is to give the tiles, or letter to the player

        LinkedList<String> tilesToSend = new LinkedList<String>();

        //what we will do here is to give the player the tiles, and remove them from the initial one so they are not repeated
        for (int i = 0; i <= howManyTiles; i++) {

            tilesToSend.add(firstInstance.letterList.remove(0)); //The reason why this 0 is here, is because it'll remove the first letter on the list, then this list will move to the left, mening that it'll remove always the first letter

        }

        return tilesToSend;

    }

}
