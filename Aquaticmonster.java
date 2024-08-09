package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Aquaticmonster{

} class AquaticMonster extends Monster {
    private int swimSpeed;

    public AquaticMonster(String name, String color, int strength, int speed, int swimSpeed) {
        super(name, color, strength, speed);
        this.swimSpeed = swimSpeed;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " is swimming at a speed of " + swimSpeed + " meters/second!");
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.write(this.toString() + "," + swimSpeed);
        writer.newLine();
        writer.close();
    }

    @Override
    public String toString() {
        return super.toString() + "," + swimSpeed;
    }
}
