package com.bluckham;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    static void main() {
        List<String> list = List.of();
        try (var reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("Day2.txt"))))) {
            var line = reader.readLine();
            list = new ArrayList<>(List.of(line.split(",")));
        } catch (IOException e) {
            System.err.println("Unable to parse file");
        }

        for (var set : list) {
            var combo = set.split("-");
            var start = Integer.parseInt(combo[0]);
            var end = Integer.parseInt(combo[1]);

        }
    }
}
