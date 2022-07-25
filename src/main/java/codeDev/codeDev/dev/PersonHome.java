package codeDev.codeDev.dev;

public class PersonHome {

    private int personId;
    private int homeId;

    public PersonHome(int personId, int homeId) {
        this.personId = personId;
        this.homeId = homeId;
    }

    public int getPersonId() {
        return personId;
    }

    public int getHomeId() {
        return homeId;
    }

    @Override
    public String toString() {
        return "PersonHome{" +
                "personId=" + personId +
                ", homeId=" + homeId +
                '}';
    }
}
