package codeDev.codeDev.dev;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Country {

    private List<Person> people = new ArrayList<>();
    private List<Home> homes = new ArrayList<>();
    private List<PersonHome> personHomes = new ArrayList<>();
    private final String NAME_SPLIT_REGEX = ",";
    private Random random = new Random();

    private HashSet<Integer> pIds = new HashSet<>();
    private HashSet<Integer> hIds = new HashSet<>();


    public void initPerson(String pName) {

        String[] pNames = pName.split(NAME_SPLIT_REGEX);

        people = IntStream.range(0, pNames.length)
                .mapToObj(i -> new Person(i, pNames[i]))
                .collect(Collectors.toList());
        setPid();
    }




    public void initHome(String hName) {
        String[] hNames = hName.split(NAME_SPLIT_REGEX);

        homes = IntStream.range(0, hNames.length)
                .mapToObj(i -> new Home(i, hNames[i]))
                .collect(Collectors.toList());

        sethid();
    }

    public void initPersonHome() {

        List<Integer> personId = pIds.stream().collect(Collectors.toList());
        List<Integer> homeId = hIds.stream().collect(Collectors.toList());

        personHomes = IntStream.range(0, people.size())
                .mapToObj(i -> new PersonHome(personId.get(i), homeId.get(getRandomHid())))
                .collect(Collectors.toList());

    }

    private int getRandomPid() {
        return random.nextInt(people.size());
    }

    private int getRandomHid() {
        return random.nextInt(homes.size());
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public List<Home> gethomes() {
        return Collections.unmodifiableList(homes);
    }

    public List<PersonHome> getPersonHome() {
        return Collections.unmodifiableList(personHomes);
    }

    private void setPid() {
        while (pIds.size() < people.size()){
            pIds.add(getRandomPid());
        }
    }

    private void sethid() {
        while (hIds.size() < homes.size()){
            hIds.add(getRandomHid());
        }
    }
}
