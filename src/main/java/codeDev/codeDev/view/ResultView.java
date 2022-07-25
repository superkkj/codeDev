package codeDev.codeDev.view;


import codeDev.codeDev.dev.Home;
import codeDev.codeDev.dev.Pair;
import codeDev.codeDev.dev.Person;
import codeDev.codeDev.dev.PersonHome;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ResultView {

    private List<Person> people;
    private List<Home> homes;


    public ResultView(List<Person> people, List<Home> homes) {
        this.people = people;
        this.homes = homes;

    }

    public void printEnglishName() {

        people.stream()
                .filter(p -> checkOnlyEnglish(p.getName()))
                .collect(Collectors.toList())
                .stream()
                .forEach(p -> System.out.println(p.getName()));
    }

    public void printPersonHome(List<PersonHome> personHomes) {

        personHomes.stream()
                .map(p -> new Pair(getPersonName(p.getPersonId()), getPersonHome(p.getHomeId())))
                .collect(Collectors.toList())
                .stream().forEach(r -> System.out.println(r.toString()));

    }

    private String getPersonName(int pId) {
        return people.stream()
                .filter(p -> p.getId() == pId)
                .findFirst()
                .get().getName();

    }

    private String getPersonHome(int hId) {
        return homes.stream()
                .filter(h -> h.getId() == hId)
                .findFirst()
                .get().getName();
    }

    private boolean checkOnlyEnglish(String word) {
        return Pattern.matches("^[a-zA-Z]*$", word);
    }
}
