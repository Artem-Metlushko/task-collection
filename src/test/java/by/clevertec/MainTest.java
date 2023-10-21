package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    public static final List<Animal> animals = Util.getAnimals();

    @Test
    void task1() {
        List<Animal> filteredAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getAge() >= 10 && animal.getAge() <= 20) {
                filteredAnimals.add(animal);
            }
        }
        for (int i = 0; i < filteredAnimals.size(); i++) {
            for (int j = i + 1; j < filteredAnimals.size(); j++) {
                if (filteredAnimals.get(i).getAge() > filteredAnimals.get(j).getAge()) {
                    Animal temp = filteredAnimals.get(i);
                    filteredAnimals.set(i, filteredAnimals.get(j));
                    filteredAnimals.set(j, temp);
                }
            }
        }
        List<Animal> expected = new ArrayList<>();
        for (int i = 14; i < 21; i++) {
            expected.add(filteredAnimals.get(i));
        }

        List<Animal> actual = Main.task1();

        assertEquals(expected, actual);

    }

    @Test
    void task2() {
        List<String> expected = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getOrigin().equals("Japanese")) {
                String bread = animal.getBread();
                if (animal.getGender().equals("Female")) {
                    bread = bread.toLowerCase();
                } else {
                    bread = bread.toUpperCase();
                }
                expected.add(bread);
            }
        }
        List<String> actual = Main.task2();
        assertEquals(expected, actual);
    }

    @Test
    void task3() {
        List<String> expected = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getAge() > 30 && animal.getOrigin().startsWith("A")
                    && !expected.contains(animal.getOrigin())
            ) {
                expected.add(animal.getOrigin());
            }
        }
        List<String> actual = Main.task3();
        assertEquals(expected, actual);
    }

    @Test
    void task4() {
        int expected = 0;
        for (Animal animal : animals) {
            if (animal.getGender().equals("Female")) {
                expected++;
            }
        }
        Long actual = Main.task4();
        assertEquals(expected, actual);
    }
}