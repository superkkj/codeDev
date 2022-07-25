package codeDev.codeDev.dev;

public class Pair<P1, P2> {

    private P1 pName;
    private P2 hName;

    public Pair(P1 pName, P2 hName) {
        this.pName = pName;
        this.hName = hName;
    }

    @Override
    public String toString() {
        return
                pName + "-" +
                        hName;
    }
}
