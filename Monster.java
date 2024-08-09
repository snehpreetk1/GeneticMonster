package org.example;

import java.io.*;

public abstract class Monster {
    protected String name;
    protected String color;
    protected int strength;
    protected int speed;

    public Monster(String name, String color, int strength, int speed) {
        this.name = name;
        this.color = color;
        this.strength = strength;
        this.speed = speed;
    }

    public Monster() {

    }

    public abstract void performSpecialAbility();

    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.write(this.toString());
        writer.newLine();
        writer.close();
    }

    public static Monster loadFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        reader.close();

        String[] details = line.split(",");
        return new Monster(details[0], details[1], Integer.parseInt(details[2]), Integer.parseInt(details[3])) {
            @Override
            public void performSpecialAbility() {
                // Default ability, can be overridden
            }
        };
    }

    @Override
    public String toString() {
        return name + "," + color + "," + strength + "," + speed;
    }
}
