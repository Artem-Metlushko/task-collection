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
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public final List<Animal> animals;
    public final List<Person> persons;
    public final List<House> houses;
    public final List<Student> students;

    public final List<Examination> examinations;

    public Main(List<Animal> animals,
                List<Person> persons,
                List<House> houses,
                List<Student> students,
                List<Examination> examinations) {
        this.animals = animals;
        this.persons = persons;
        this.houses = houses;
        this.students = students;
        this.examinations = examinations;
    }

    public static void main(String[] args) {
        Main main = new Main(Util.getAnimals(), Util.getPersons(), Util.getHouses(),
                Util.getStudents(), Util.getExaminations());
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
        System.out.println(main.task13().size());
//        main.task13().forEach(System.out::println);
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
                .filter(person -> numberOfYears(person) >= 18 && numberOfYears(person) <= 27)
                .filter(person -> person.getRecruitmentGroup() >= 1 && person.getRecruitmentGroup() <= 3)
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup))
                .limit(200)
                .toList();
    }

    private int numberOfYears(Person person) {
        return Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
    }

    public List<Person> task13() {
        return houses.stream()
                .flatMap(house -> Stream.concat(
                        house.getPersonList().stream()
                                .filter(person -> house.getBuildingType().equals("Hospital")),
                        house.getPersonList().stream()
                                .filter(person -> !house.getBuildingType().equals("Hospital"))
                                .filter(person -> numberOfYears(person) <= 18 || numberOfYears(person) >= 60)))
                .limit(500)
                .toList();
    }

    public void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public List<Student> task16() {

        return students.stream()
                .filter(student -> student.getAge() < 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .toList();
    }

    public List<String> task17() {
        return students.stream()
                .map(Student::getFaculty)
                .distinct()
                .toList();
    }


    public List<Map.Entry<String, Double>> task18() {
        return students.stream()
                .collect(groupingBy(Student::getFaculty,
                        averagingInt(Student::getAge)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .toList();
    }

    public List<Student> task19() {
        String group = "Chemistry";
        return examinations.stream()
                .filter(e -> e.getExam1() > 4 && e.getExam2() > 4 && e.getExam3() > 4)
                .map(e -> students.stream()
                        .filter(s -> s.getId() == e.getStudentId())
                        .findFirst()
                        .orElse(null)).filter(Objects::nonNull)
                .filter(s -> s.getFaculty().equals(group))
                .toList();
    }

    public Double task20() {
       return   examinations.stream()
                .collect(groupingBy(getExaminationWithFaculty(),
                        Collectors.averagingDouble(Examination::getExam1)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(Map.entry("", 0.0)).getValue();
    }

    private Function<Examination, String> getExaminationWithFaculty() {
        return examination -> students.stream()
                .filter(student -> student.getId() == examination.getStudentId())
                .findFirst()
                .orElse(new Student())
                .getFaculty();
    }

    /*public  void task() {


    }*/

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
