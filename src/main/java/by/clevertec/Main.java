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
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
    public final List<Animal> animals;
    public final List<Person> persons;
    public final List<House> houses;
    public final List<Student> students;
    public final List<Examination> examinations;
    public final List<Flower> flowers;
    public final List<Car> cars;

    public Main(List<Animal> animals,
                List<Person> persons,
                List<House> houses,
                List<Student> students,
                List<Examination> examinations, List<Flower> flowers,
                List<Car> cars) {
        this.animals = animals;
        this.persons = persons;
        this.houses = houses;
        this.students = students;
        this.examinations = examinations;
        this.flowers = flowers;
        this.cars = cars;
    }

    public static void main(String[] args) {
        Main main = new Main(Util.getAnimals(), Util.getPersons(), Util.getHouses(), Util.getStudents(), Util.getExaminations(), Util.getFlowers(), Util.getCars());
        main.task1();
        main.task2();
        main.task3();
        main.task4();
        main.task5();
        main.task6();
        main.task7();
        main.task8();
        main.task9();
        main.task10();
        main.task11();
        main.task12();
        main.task13();
        main.task14();
        main.task15();
        main.task16();
        main.task17();
        main.task18();
        main.task19();
        main.task20();
        main.task21();
        main.task22();
        main.task14();
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

        System.out.println(Stream.of(cars.stream()
                                .filter(isFirstPredicate())
                                .collect(groupingBy(car -> "Туркменистан", summingInt(Car::getMass))),
                        cars.stream()
                                .filter(isFirstPredicate().negate())
                                .filter(isSecondPredicate())
                                .collect(groupingBy(car -> "Узбекистан", summingInt(Car::getMass))),
                        cars.stream()
                                .filter(isFirstPredicate().negate())
                                .filter(isSecondPredicate().negate())
                                .filter(isThirdPredicate())
                                .collect(groupingBy(car -> "Казахстан", summingInt(Car::getMass))),
                        cars.stream()
                                .filter(isFirstPredicate().negate())
                                .filter(isSecondPredicate().negate())
                                .filter(isThirdPredicate().negate())
                                .filter(isFourPredicate())
                                .collect(groupingBy(car -> "Кыргызстан", summingInt(Car::getMass))),
                        cars.stream()
                                .filter(isFirstPredicate().negate())
                                .filter(isSecondPredicate().negate())
                                .filter(isThirdPredicate().negate())
                                .filter(isFourPredicate().negate())
                                .filter(isFivePredicate())
                                .collect(groupingBy(car -> "Россия", summingInt(Car::getMass))),
                        cars.stream()
                                .filter(isFirstPredicate().negate())
                                .filter(isSecondPredicate().negate())
                                .filter(isThirdPredicate().negate())
                                .filter(isFourPredicate().negate())
                                .filter(isFivePredicate().negate())
                                .filter(isSixPredicate())
                                .collect(groupingBy(car -> "Монголия", summingInt(Car::getMass)))

                )
                .map(map -> map.entrySet().stream()
                        .collect(toMap(Map.Entry::getKey,
                                e -> e.getValue() / 1000.0 * 7.14)))
                .peek(System.out::println)
                .flatMap(map -> map.values().stream())
                .mapToDouble(Double::doubleValue)
                .sum());
//

    }

    private Predicate<Car> isFirstPredicate() {
        return c -> (c.getCarMake().equals("Jaguar") ||
                c.getColor().equals("White"));
    }


    private Predicate<Car> isSecondPredicate() {
        return car -> car.getMass() <= 1500 && (car.getCarMake().equals("BMW") ||
                car.getCarMake().equals("Lexus") ||
                car.getCarMake().equals("Chrysler") ||
                car.getCarMake().equals("Toyota"));
    }


    private Predicate<Car> isThirdPredicate() {
        return car -> (car.getColor().equals("Black") &&
                car.getMass() > 4000) ||
                car.getCarMake().equals("GMC") ||
                car.getCarMake().equals("Dodge");
    }


    private Predicate<Car> isFourPredicate() {
        return car -> (car.getReleaseYear() <= 1982) ||
                car.getCarModel().equals("Civic") ||
                car.getCarModel().equals("Cherokee");
    }

    private Predicate<Car> isSixPredicate() {
        return car -> car.getVin().contains("59");
    }

    private Predicate<Car> isFivePredicate() {
        return car -> !(car.getColor().equals("Yellow") ||
                car.getColor().equals("Red") ||
                car.getColor().equals("Green") ||
                car.getColor().equals("Blue")) || car.getPrice() > 40000;
    }


    public double task15() {
        return flowers.stream()
                .filter(getStartWith())
                .filter(getMaterial())
                .sorted(getHardSorted())
                .mapToDouble(flower -> flower.getPrice() + flower.getWaterConsumptionPerDay() * 365 * 5 * 1.39)
                .sum();
    }

    private Predicate<Flower> getMaterial() {
        return flower -> flower.getFlowerVaseMaterial().contains("Glass") ||
                flower.getFlowerVaseMaterial().contains("Aluminum") ||
                flower.getFlowerVaseMaterial().contains("Steel");
    }

    private Predicate<Flower> getStartWith() {
        return flower ->
                flower.getCommonName().startsWith("S") ||
                        flower.getCommonName().startsWith("T") ||
                        flower.getCommonName().startsWith("U") ||
                        flower.getCommonName().startsWith("V") ||
                        flower.getCommonName().startsWith("W") ||
                        flower.getCommonName().startsWith("X") ||
                        flower.getCommonName().startsWith("Y") ||
                        flower.getCommonName().startsWith("Z") ||
                        flower.getCommonName().startsWith("A") ||
                        flower.getCommonName().startsWith("B") ||
                        flower.getCommonName().startsWith("C");
    }

    private Comparator<Flower> getHardSorted() {
        return Comparator.comparing(Flower::getOrigin).reversed()
                .thenComparing(Comparator.comparing(Flower::getPrice).reversed()
                        .thenComparing(Comparator.comparing(Flower::getWaterConsumptionPerDay).reversed()));
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
        return examinations.stream()
                .collect(groupingBy(getExaminationWithFaculty(),
                        averagingDouble(Examination::getExam1)))
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

    public List<Map.Entry<String, Long>> task21() {
        return students.stream()
                .collect(groupingBy(Student::getGroup, counting()))
                .entrySet().stream().toList();

    }

    public Map<String, Integer> task22() {
        return students.stream()
                .collect(groupingBy(Student::getFaculty, mapping(Student::getAge, minBy(Comparator.naturalOrder()))))
                .entrySet().stream()
                .collect(toMap(Map.Entry::getKey, e -> e.getValue().orElse(0)));
    }
}
