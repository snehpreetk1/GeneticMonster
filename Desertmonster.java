package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Desertmonster{

} class DesertMonster extends Monster {
    private int heatResistance;

    public DesertMonster(String name, String color, int strength, int speed, int heatResistance) {
        super(name, color, strength, speed);
        this.heatResistance = heatResistance;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " is surviving in extreme heat with a resistance of " + heatResistance + "!");
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.write(this.toString() + "," + heatResistance);
        writer.newLine();
        writer.close();
    }

    @Override
    public String toString() {
        return super.toString() + "," + heatResistance;
    }
}

