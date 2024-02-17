package com.hans.batchapp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNameGenerator {

    static String generateRandomName() {
        String vowels = "aeiou";
        String consonants = "bcdfghjklmnpqrstvwxyz";
        Random random = new Random();
        int nameLength = random.nextInt(7) + 4; // Random name length between 4 and 10
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < nameLength; i++) {
            if (i % 2 == 0) {
                name.append(consonants.charAt(random.nextInt(consonants.length())));
            } else {
                name.append(vowels.charAt(random.nextInt(vowels.length())));
            }
        }
        return name.toString().substring(0, 1).toUpperCase() + name.toString().substring(1);
    }

    static String generateRandomID() {
        Random random = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            id.append(random.nextInt(10));
        }
        return id.toString();
    }

    public static void main(String[] args) {
        String csvFile = "random_names.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append("id,firstname,lastname,age\n");
            Random random = new Random();
            for (int i = 0; i < 100000; i++) {
                String id = generateRandomID();
                String firstName = generateRandomName();
                String lastName = generateRandomName();
                int age = random.nextInt(73) + 18; // Random age between 18 and 90
                writer.append(id).append(",").append(firstName).append(",").append(lastName).append(",").append(String.valueOf(age)).append("\n");
            }
            writer.flush();
            System.out.println("CSV file generated successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to CSV: " + e.getMessage());
        }
    }
}

