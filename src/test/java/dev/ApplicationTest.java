package dev;

import codeDev.codeDev.dev.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SpringBootTest(classes = Application.class)
class ApplicationTest {

    List<Person> people = new ArrayList<>();
    List<Home> homes = new ArrayList<>();
    List<PersonHome> personHomes = new ArrayList<>();

    @BeforeEach
    void setUp() {
        people.add(new Person(1, "이선홍"));
        people.add(new Person(2, "권기준"));
        people.add(new Person(3, "lion"));
        people.add(new Person(4, "tiger"));
        people.add(new Person(5, "bear"));

        homes.add(new Home(1, "A아파트"));
        homes.add(new Home(2, "B아파트"));
        homes.add(new Home(3, "C아파트"));


        personHomes.add(new PersonHome(1, 2));
        personHomes.add(new PersonHome(2, 1));
        personHomes.add(new PersonHome(3, 3));
        personHomes.add(new PersonHome(4, 3));
        personHomes.add(new PersonHome(5, 3));
    }

    @Test
    void 영문이름사람출력() {
        List<Person> englishPeople = people.stream()
                .filter(p -> checkOnlyEnglish(p.getName()))
                .collect(Collectors.toList());

        for (Person p : englishPeople) {
            System.out.println(p.getName());
        }


    }

    @Test
    void 사람거주지출력() {

        personHomes.stream()
                .map(p -> new Pair(getPersonName(p.getPersonId()), getPersonHome(p.getHomeId())))
                .collect(Collectors.toList())
                .stream().forEach(r -> System.out.println(r.toString()));
    }


    String getPersonName(int pId) {
        return people.stream()
                .filter(p -> p.getId() == pId)
                .findFirst()
                .get().getName();

    }

    String getPersonHome(int hId) {
        return homes.stream()
                .filter(h -> h.getId() == hId)
                .findFirst()
                .get().getName();
    }

    boolean checkOnlyEnglish(String word) {
        return Pattern.matches("^[a-zA-Z]*$", word);
    }
}