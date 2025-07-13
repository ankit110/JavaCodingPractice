package objectsAndClasses;

public class ClientClassWithEqualsOverride {
    int id;

    public ClientClassWithEqualsOverride(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj)
            return true;

        if(obj == null)
            return false;

        if(getClass() != obj.getClass())
            return false;

        ClientClassWithEqualsOverride other = (ClientClassWithEqualsOverride) obj;

        return id == other.id;
    }
}
