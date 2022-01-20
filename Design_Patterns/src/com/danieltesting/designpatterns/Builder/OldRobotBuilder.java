package com.danieltesting.designpatterns.Builder;

public class OldRobotBuilder implements RobotBuilder{

    private Robot robot;

    //This is just one type of robot,
    // we can create any number of robots, we just have to make a
    // class similar to this one with the different traits

    public OldRobotBuilder(){

        this.robot = new Robot();

    }

    @Override
    public void buildRobotHead() {

        robot.setRobotHead("Tin Head");

    }

    @Override
    public void buildRobotTorso() {

        robot.setRobotTorso("Tin Torso");

    }

    @Override
    public void buildRobotArms() {

        robot.setRobotArms("Blowtorch Arms");

    }

    @Override
    public void buildRobotLegs() {

        robot.setRobotLegs("Roller Skate Legs");

    }

    public Robot getRobot() {
        return this.robot;
    }

}
