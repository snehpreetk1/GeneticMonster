package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Mountainmonster{

} class MountainMonster extends Monster {
    private final int climbingSkill;

    public MountainMonster(String name, String color, int strength, int speed, int climbingSkill) {
        super(name, color, strength, speed);
        this.climbingSkill = climbingSkill;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " is climbing with a skill level of " + climbingSkill + "!");
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.write(this.toString() + "," + climbingSkill);
        writer.newLine();
        writer.close();
    }

    @Override
    public String toString() {
        return super.toString() + "," + climbingSkill;
    }
}
