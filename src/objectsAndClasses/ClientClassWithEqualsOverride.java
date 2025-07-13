package objectsAndClasses;

public class ClientClassWithEqualsOverride {
    int id;

    public ClientClassWithEqualsOverride(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        ClientClassWithEqualsOverride other = (ClientClassWithEqualsOverride) obj;

        return id == other.id;
    }
}
