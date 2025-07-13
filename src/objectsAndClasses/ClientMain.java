package objectsAndClasses;

public class ClientMain {

    public static void main(String []args) {
        ClientClassWithoutEqualsOverride clientWithoutEquals = new ClientClassWithoutEqualsOverride(25);

        ClientClassWithoutEqualsOverride clientWithoutEquals1 = new ClientClassWithoutEqualsOverride(25);

        ClientClassWithoutEqualsOverride clientWithoutEquals2 = clientWithoutEquals;

        System.out.println(clientWithoutEquals == clientWithoutEquals1); // false(It is comparing objects references)

        System.out.println(clientWithoutEquals.equals(clientWithoutEquals1)); // false Here equals compare the objects references not the values.

        System.out.println(clientWithoutEquals.equals(clientWithoutEquals2)); // true(pointing to the same object)

        // If we want equals method of the Superclass(Object Class) compare the values of the instances
        // then Override the equals method the way you want to behave the method.

        ClientClassWithEqualsOverride clientWithEquals = new ClientClassWithEqualsOverride(25);

        ClientClassWithEqualsOverride clientWithEquals1 = new ClientClassWithEqualsOverride(25);

        ClientClassWithEqualsOverride clientWithEquals2 = clientWithEquals;

        System.out.println(clientWithEquals == clientWithEquals1); // false

        System.out.println(clientWithEquals.equals(clientWithEquals1)); // true (instead of comparing object references, it is comparing values.)

        System.out.println(clientWithEquals.equals(clientWithEquals2)); // true

    }
}
