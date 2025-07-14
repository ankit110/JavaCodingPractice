package inheritance;

public class InheritanceMain {

    public static void main(String args[]) {
        System.out.println("Hello Inheritance");

        Actor actor = new Actor();
        actor.act();

        Hero hero = new Hero();
        hero.fight();
        hero.act();

        Comedian comedian = new Comedian();
        comedian.act();
        comedian.comedy();

        System.out.println("-------------------------------");

        Actor actor1 = new Hero();
//        actor1.fight(); // It will give Compilation error SuperClass can't access it subClass instance variables and methods.

//        Hero hero1 = new Actor(); // Compilation error you can assign a subclass object to a superclass reference
                                    // But you cannot assign a superclass object to a subclass reference

//        Hero hero1 = (Hero) new Actor(); // Exception in thread "main" java.lang.ClassCastException: class Actor cannot be cast to class Hero
                                        // Even though Hero is a subclass of Actor, the actual object created is of type Actor.
                                        // Java allows the cast at compile time because it could be valid (e.g., if the object was actually a Hero),
                                        // but at runtime, it checks the actual type and throws an exception if the cast is invalid.
//        ----------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                              Overloading
//        ----------------------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("---------------------OverLoading----------------------");
        Overloading overloading = new Overloading();
        overloading.doIt(10);
        overloading.doIt("ankit ", "kumar");

        OverloadingInheritance overloadingInheritance = new OverloadingInheritance();
        overloadingInheritance.doIt("Singh");
        overloadingInheritance.doIt(10, 20);

        overloadingInheritance.doIt("Ankit", "Singh");
        overloadingInheritance.doIt(11);
//        ---------------------------------------------------------------------------------------------------------
//                                                  OverRiding
//        ---------------------------------------------------------------------------------------------------------

        System.out.println("---------------------------------OverRiding----------------------------");

        // Case 1: Superclass reference and object

        AnimalOverriding animal = new AnimalOverriding();
        System.out.println(animal.bark());
        // Output:-  Don't Know => Since the object is of type AnimalOverriding, it calls the method defined in that class.

        // Case 2: Superclass reference, subclass object

        AnimalOverriding animal1 = new Cat(); // created a reference of type AnimalOverriding but instantiate it with a Cat object.
        System.out.println(animal1.bark());
        // Output:- Meow Meow => This is runtime polymorphism. Even though the reference is of the superclass, the actual object is of the subclass (Cat).
        // So, the overridden method in Cat is called.

        // Case 3: Subclass reference and object

        Cat cat = new Cat();
        System.out.println(cat.bark());
        // Output:- Meow Meow=> The object is of type Cat, and it uses its own overridden method.


    }
}
