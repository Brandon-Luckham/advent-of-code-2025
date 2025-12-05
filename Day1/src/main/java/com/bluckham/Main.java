package com.bluckham;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static void main() {
        final var INITIAL_POS = 50;
        final var START = 0;
        final var END = 100;
        var filePath = "C:/Users/bluck/IdeaProjects/advent-of-code-2025/Day1/src/main/resources/Day1.txt";
        var list = new ArrayList<String>();
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.err.println("Unable to parse file");
        }

        var count = 0;
        var currentPosition = INITIAL_POS;
        for (var line : list) {
            var loops = Integer.parseInt(line.substring(1)) / END;
            var amount = Integer.parseInt(line.substring(1)) % END;
            var direction = line.toCharArray()[0];
            if (direction == 'L') {
                if (currentPosition - amount < START) {
                    if (currentPosition != START)
                        count++;
                    currentPosition = (END - Math.abs(currentPosition - amount));
                } else if (currentPosition - amount == START)
                    currentPosition = START;
                else
                    currentPosition -= amount;
            } else if (direction == 'R') {
                if (currentPosition + amount > END) {
                    currentPosition = (currentPosition + amount) % END;
                    count++;
                } else if (currentPosition + amount == END)
                    currentPosition =(currentPosition + amount) % END;
                else
                    currentPosition += amount;
            }
            if (currentPosition == 0)
                count++;
            count += loops;
        }
        System.out.println(count);
    }
}
