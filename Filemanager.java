package org.example;

import java.io.*;
import java.util.ArrayList;


class FileManager {

    public static void saveMonsters(ArrayList<Monster> monsters, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Monster monster : monsters) {
            writer.write(monster.toString());
            writer.newLine();
        }
        writer.close();
    }

    public static ArrayList<Monster> loadMonsters(String filename) throws IOException {
        ArrayList<Monster> monsters = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split(",");
            String name = details[0];
            String color = details[1];
            int strength = Integer.parseInt(details[2]);
            int speed = Integer.parseInt(details[3]);

            Monster monster = new Monster(name, color, strength, speed) {
                @Override
                public void performSpecialAbility() {
                    // Default ability
                }
            };
            monsters.add(monster);
        }
        reader.close();
        return monsters;
    }
}

