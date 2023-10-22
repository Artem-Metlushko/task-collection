package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import by.clevertec.util.UtilMock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    public final Main mainMock = new Main(UtilMock.getAnimals());

    /*private static List<Animal> listAnimals() {
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
    }*/

    @Test
    void task1() {
        List<Animal> expected = new ArrayList<>();
        expected.add(new Animal(4, "White-throated toucan", 18, "Tswana", "Female"));
        expected.add(new Animal(88, "Long-nosed bandicoot", 18, "Finnish", "Female"));
        expected.add(new Animal(98, "Western bearded dragon", 18, "Catalan", "Female"));
        expected.add(new Animal(26, "African wild cat", 19, "Afrikaans", "Female"));
        expected.add(new Animal(34, "Red-tailed cockatoo", 19, "Dhivehi", "Female"));
        expected.add(new Animal(64, "Peregrine falcon", 19, "Estonian", "Female"));
        expected.add(new Animal(80, "King cormorant", 19, "Albanian", "Female"));

        List<Animal> actual = mainMock.task1();

        assertEquals(expected, actual);
    }

    @Test
    void task2() {
        List<String> expected = new ArrayList<>();
        expected.add("antelope, roan");
        expected.add("TERN, ARCTIC");
        expected.add("huron");
        expected.add("LORIKEET, SCALY-BREASTED");

        List<String> actual = mainMock.task2();

        assertEquals(expected, actual);
    }


    @Test
    void task3() {
        mainMock.task3().forEach(System.out::println);
        List<String> expected = new ArrayList<>();
        expected.add("Azeri");
        expected.add("Aymara");
        expected.add("Afrikaans");
        expected.add("Arabic");

        List<String> actual = mainMock.task3();

        assertEquals(expected, actual);


    }

    @Test
    void task4() {
        List<Animal> listAnimal = new ArrayList<>();
        listAnimal.add(new Animal(4, "White-throated toucan", 18, "Tswana", "Female"));
        listAnimal.add(new Animal(88, "Long-nosed bandicoot", 18, "Finnish", "Male"));
        listAnimal.add(new Animal(98, "Western bearded dragon", 18, "Catalan", "Female"));
        listAnimal.add(new Animal(26, "African wild cat", 19, "Afrikaans", "Male"));
        listAnimal.add(new Animal(34, "Red-tailed cockatoo", 19, "Dhivehi", "Female"));
        listAnimal.add(new Animal(64, "Peregrine falcon", 19, "Estonian", "Male"));

        Main myMainForTest = new Main(listAnimal);

        Long expectedQuantity = myMainForTest.task4();
        Long actual = 3L;

        assertEquals(expectedQuantity, actual);
    }


}