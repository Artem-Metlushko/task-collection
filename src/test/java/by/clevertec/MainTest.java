package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Person;
import by.clevertec.util.Util;
import by.clevertec.util.UtilMock;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    public final Main mainMock = new Main(UtilMock.getAnimals(), UtilMock.getPersons());
    public final Main mainMockForLittleTest = new Main(getAnimalsForTest(), UtilMock.getPersons());

    @Test
    void task1() {
        List<Animal> expected = new ArrayList<>();
        expected.add(new Animal(8, "Starling, red-shouldered glossy", 17, "Pashto", "Male"));
        expected.add(new Animal(52, "Laughing dove", 17, "Haitian Creole", "Male"));
        expected.add(new Animal(67, "Pademelon, red-legged", 17, "Ndebele", "Female"));
        expected.add(new Animal(4, "White-throated toucan", 18, "Tswana", "Female"));
        expected.add(new Animal(88, "Long-nosed bandicoot", 18, "Finnish", "Female"));
        expected.add(new Animal(98, "Western bearded dragon", 18, "Catalan", "Female"));
        expected.add(new Animal(26, "African wild cat", 19, "Afrikaans", "Female"));

        List<Animal> actual = mainMock.task1();

        assertEquals(expected, actual);
    }

    @Test
    void task2() {

        List<String> expectedJapanese = new ArrayList<>();
        expectedJapanese.add("antelope, roan");
        expectedJapanese.add("TERN, ARCTIC");
        expectedJapanese.add("huron");
        expectedJapanese.add("LORIKEET, SCALY-BREASTED");

        List<String> actual = mainMock.task2();

        assertEquals(expectedJapanese, actual);
    }


    @Test
    void task3() {

        List<String> expectedStartWithA = new ArrayList<>();
        expectedStartWithA.add("Azeri");
        expectedStartWithA.add("Aymara");
        expectedStartWithA.add("Afrikaans");
        expectedStartWithA.add("Arabic");

        List<String> actual = mainMock.task3();

        assertEquals(expectedStartWithA, actual);

    }

    @Test
    void task4() {
        Long expectedQuantityForFemaleGender = mainMockForLittleTest.task4();
        Long actual = 3L;

        assertEquals(expectedQuantityForFemaleGender, actual);
    }

    private List<Animal> getAnimalsForTest() {
        List<Animal> listAnimal = new ArrayList<>();
        listAnimal.add(new Animal(4, "White-throated toucan", 18, "Tswana", "Female"));
        listAnimal.add(new Animal(88, "Long-nosed bandicoot", 18, "Finnish", "Male"));
        listAnimal.add(new Animal(98, "Western bearded dragon", 18, "Catalan", "Female"));
        listAnimal.add(new Animal(26, "African wild cat", 19, "Afrikaans", "Male"));
        listAnimal.add(new Animal(34, "Red-tailed cockatoo", 19, "Hungarian", "Female"));
        listAnimal.add(new Animal(64, "Peregrine falcon", 20, "Estonian", "Male"));
        return listAnimal;
    }

    @Test
    void task5(){
        boolean expectedHungarian = mainMockForLittleTest.task5();

        assertFalse(expectedHungarian);
    }
    @Test
    void task6(){
        boolean expectedMaleAndFemaleAllAnimals = mainMockForLittleTest.task6();

        assertTrue(expectedMaleAndFemaleAllAnimals);
    }

    @Test
    void task7(){
        boolean expectedFromOceaniaIsNotExist = mainMock.task7();

        assertTrue(expectedFromOceaniaIsNotExist);
    }

    @Test
    void task8(){
        int expectedOldestOfHundredFirst=49;
        int actual = mainMock.task8();

        assertEquals(expectedOldestOfHundredFirst, actual);
    }

    @Test
    void task9(){
        int expectedSmallestArraySize = mainMock.task9();
        int actual = 4;

       assertEquals(expectedSmallestArraySize, actual);
    }

    @Test
    void task10(){
        int expectedSumOfAgeAllAnimals = mainMock.task10();
        int actual = 3072;

        assertEquals(expectedSumOfAgeAllAnimals, actual);
    }

    @Test
    void task11(){
        double expectedAverageAgeAnimalsFromIndonesian= mainMock.task11();
        double actual = 17.666666666666668;

        assertEquals(expectedAverageAgeAnimalsFromIndonesian, actual);
    }

    @Test
    void task12(){
        List<Person> expectedCandidates = new ArrayList<>();

        expectedCandidates.add(new Person(14, "Harland", "Batchelour", LocalDate.of(1997, 6, 27), "hbatchelourd@wikispaces.com", "Male", 1, "Banga", "Chief Design Engineer"));
        expectedCandidates.add(new Person(44, "Cointon", "Lethbridge", LocalDate.of(1998, 4, 6), "clethbridge17@craigslist.org", "Male", 1, "Ban Ko Lan", "Teacher"));
        expectedCandidates.add(new Person(137, "Beauregard", "Robet", LocalDate.of(1999, 7, 27), "brobet3s@devhub.com", "Male", 1, "Guohuan", "Actuary"));
        expectedCandidates.add(new Person(31, "Enrico", "Seydlitz", LocalDate.of(2001, 12, 26), "eseydlitzu@seesaa.net", "Male", 2, "Magangu", "Design Engineer"));
        expectedCandidates.add(new Person(130, "Jamill", "Petticrow", LocalDate.of(1997, 9, 11), "jpetticrow3l@answers.com", "Male", 2, "Nassau", "Programmer Analyst II"));
        expectedCandidates.add(new Person(141, "Bourke", "Mote", LocalDate.of(1999, 6, 24), "bmote3w@nature.com", "Male", 2, "Zara", "Staff Scientist"));
        expectedCandidates.add(new Person(50, "Free", "Killgus", LocalDate.of(2004, 12, 23), "fkillgus1d@macromedia.com", "Male", 3, "Polevskoy", "Developer II"));
        expectedCandidates.add(new Person(77, "Fairleigh", "Roberti", LocalDate.of(2004, 12, 31), "froberti24@globo.com", "Male", 3, "Loma Bonita", "Accounting Assistant II"));
        expectedCandidates.add(new Person(120, "Giovanni", "Handling", LocalDate.of(2002, 12, 26), "ghandling3b@mediafire.com","Male" ,3 ,"Stoczek Lukowski","Geological Engineer"));

        List<Person> actual = mainMock.task12();

        assertEquals(expectedCandidates, actual);

    }




}