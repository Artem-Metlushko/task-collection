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


    @Test
    void task1() {
        List<Animal> animals = Util.getAnimals();
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
}