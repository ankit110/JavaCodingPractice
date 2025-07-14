package inheritance;

public class Cat extends AnimalOverriding {

    // Polymorphism: The ability of a reference to take many forms.
    // At runtime, Java decides which method to call based on the actual object, not the reference type.

    @Override // @Override Annotation: Helps catch errors if the method signature doesn’t match the superclass method.
    public String bark() {
        return "Meow Meow";
    }
}
