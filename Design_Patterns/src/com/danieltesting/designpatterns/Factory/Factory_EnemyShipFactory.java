package com.danieltesting.designpatterns.Factory;

public class Factory_EnemyShipFactory {

    public Factory_EnemyShip makeEnemyShip(String newShipType){

        //This is how we encapsulate ship creation, so if we ever need to modify something there wull be only one place where we have to modify

        Factory_EnemyShip newShip = null;

        if(newShipType.equals("U")){

            return new Factory_UFOEnemyShip();

        }
        else if(newShipType.equals("R")){

            return new Factory_RocketEnemyShip();

        }
        else if(newShipType.equals("B")){

            return new Factory_BigUFOEnemyShip();

        }
        else{
            return null;
        }

    }

}
