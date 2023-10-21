package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static final List<Animal> animals = Util.getAnimals();

    public static void main(String[] args) {
/*        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();*/
        task9();
    }

    public static List<Animal> task1() {
        return animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .skip(14)
                .limit(7)
                .toList();
    }

    public static List<String> task2() {
        return animals.stream()
                .filter(animal -> (animal.getOrigin()).equals("Japanese"))
                .map(animal -> animal.getGender().equals("Female") ?
                        animal.getBread().toLowerCase() :
                        animal.getBread().toUpperCase())
                .toList();

    }

    public static List<String> task3() {
        return animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .toList();
    }

    public static Long task4() {
        return animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
    }

    public static boolean task5() {
        return animals.stream()
                .filter(animal -> animal.getAge()>=20 && animal.getAge() <=30)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"));
    }

    public static boolean task6() {
        return animals.stream()
                .allMatch(animal -> animal.getGender().equals("Female") || animal.getGender().equals("Male"));
    }
    public static boolean task7() {
        return animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));
    }

    public static int task8() {
        return animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .mapToInt(Animal::getAge)
                .max()
                .orElse(-1);
    }

    public static int task9() {
        return animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(charArray -> charArray.length)
                .min()
                .orElse(-1);
    }


    public static void task10() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
//        persons.stream() Продолжить ...
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
//        houses.stream() Продолжить ...
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
//        students.stream() Продолжить ...
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
