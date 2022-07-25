package codeDev.codeDev.dev;

public class Home {

    private int id;
    private String name;

    public Home(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
