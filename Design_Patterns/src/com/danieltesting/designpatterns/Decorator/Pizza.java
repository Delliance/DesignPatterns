package com.danieltesting.designpatterns.Decorator;

//This is the old way, creating a new class for each of the possible
//combinations of pizza
/*
public abstract class Pizza {

    public abstract void setDescription(String newDescription);

    public  abstract String getDescription();

    public abstract  double getCost();

}
*/


public interface Pizza {

    public String getDescription();

    public double getCost();

}
