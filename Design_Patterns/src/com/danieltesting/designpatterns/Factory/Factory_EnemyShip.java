package com.danieltesting.designpatterns.Factory;

public abstract class Factory_EnemyShip { //An abstract class is one that does not return values at all. it is only used to unify other classes

    private String name;
    private double amtDamage; // amount of damage

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmtDamage() {
        return amtDamage;
    }

    public void setAmtDamage(double amtDamage) {
        this.amtDamage = amtDamage;
    }

    public void followHeroShip(){ //This is just to show that the EnemyShip is Following the hero

        System.out.println(getName()+" is following the hero");

    }

    public void displayEnemyShip(){

        System.out.println(getName()+" is on the screen");

    }

    public void enemyShipShoots(){

        System.out.println(getName()+" attacks and does "+getAmtDamage());

    }




}
