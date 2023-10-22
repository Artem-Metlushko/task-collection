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

    public static final Main main = new Main(listAnimals());

    private static List<Animal> listAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(1, "Baboon, chacma", 43, "Japanese", "Male"));
        animals.add(new Animal(2, "Stork, woolly-necked", 37, "Japanese", "Male"));
        animals.add(new Animal(3, "Little cormorant", 32, "Japanese", "Female"));
        animals.add(new Animal(4, "Ovenbird", 25, "Japanese", "Female"));
        animals.add(new Animal(5, "Cook's tree boa", 9, "Bengali", "Male"));
        animals.add(new Animal(6, "Heron, little", 10, "Gujarati", "Male"));
        animals.add(new Animal(7, "Black-tailed tree creeper", 4, "Burmese", "Female"));
        animals.add(new Animal(8, "Siskin, yellow-rumped", 1, "Marathi", "Male"));
        animals.add(new Animal(9, "Red-tailed cockatoo", 10, "Afrikaans", "Female"));
        animals.add(new Animal(9, "White-browed owl", 10, "Korean", "Female"));
        return animals;
    }

    @Test
    void task1() {
        /*List<Animal> animals = Util.getAnimals();
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

        assertEquals(expected, actual);*/

    }

    @Test
    void task2() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("BABOON, CHACMA");
        expectedList.add("STORK, WOOLLY-NECKED");
        expectedList.add("little cormorant");
        expectedList.add("ovenbird");

        assertEquals(expectedList, main.task2());
    }

    

    @Test
    void task3() {
     /*   List<String> expected = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getAge() > 30 && animal.getOrigin().startsWith("A")
                    && !expected.contains(animal.getOrigin())
            ) {
                expected.add(animal.getOrigin());
            }
        }
        List<String> actual = Main.task3();
        assertEquals(expected, actual);*/
    }

    @Test
    void task4() {
    /*    int expected = 0;
        for (Animal animal : animals) {
            if (animal.getGender().equals("Female")) {
                expected++;
            }
        }
        Long actual = Main.task4();
        assertEquals(expected, actual);*/
    }
}