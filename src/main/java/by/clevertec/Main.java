package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public final List<Animal> animals;
    public final List<Person> persons;
    public final List<House> houses;

    public Main(List<Animal> animals, List<Person> persons, List<House> houses) {
        this.animals = animals;
        this.persons = persons;
        this.houses = houses;
    }

    public static void main(String[] args) {
        Main main = new Main(Util.getAnimals(), Util.getPersons(), Util.getHouses());
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
        main.task13();
    }

    public List<Animal> task1() {
        return animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .skip(14)
                .limit(7)
                .toList();
    }

    public List<String> task2() {
        return animals.stream()
                .filter(animal -> (animal.getOrigin()).equals("Japanese"))
                .map(animal -> animal.getGender().equals("Female") ?
                        animal.getBread().toLowerCase() :
                        animal.getBread().toUpperCase())
                .toList();

    }

    public List<String> task3() {
        return animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .toList();
    }

    public Long task4() {
        return animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
    }

    public boolean task5() {
        return animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"));
    }

    public boolean task6() {
        return animals.stream()
                .allMatch(animal -> animal.getGender().equals("Female") || animal.getGender().equals("Male"));
    }

    public boolean task7() {
        return animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));
    }

    public int task8() {
        return animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .mapToInt(Animal::getAge)
                .max()
                .orElse(-1);
    }

    public int task9() {
        return animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(charArray -> charArray.length)
                .min()
                .orElse(-1);
    }


    public int task10() {
        return animals.stream()
                .mapToInt(Animal::getAge)
                .sum();
    }

    public double task11() {
        return animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average()
                .orElse(-1);

    }

    public List<Person> task12() {

        return persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person ->
                        Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() >= 18
                                && Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() <= 27
                )
                .filter(person -> person.getRecruitmentGroup() >= 1 && person.getRecruitmentGroup() <= 3)
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup))
                .limit(200)
                .toList();
    }

    public List<Person> task13() {
        return houses.stream()
                .flatMap(house -> Stream.concat(
                        house.getPersonList().stream()
                                .filter(person -> house.getBuildingType().equals("Hospital")),
                        house.getPersonList().stream()
                                .filter(person -> !house.getBuildingType().equals("Hospital"))
                                .filter(person -> checkOfYears(person) <= 18 || checkOfYears(person) >= 60)))
                .limit(500)
                .toList();
    }

    private int checkOfYears(Person person) {
        return LocalDate.now().getYear() - person.getDateOfBirth().getYear();
    }

    public void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public void task15() {
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
