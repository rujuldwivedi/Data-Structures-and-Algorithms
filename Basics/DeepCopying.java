import java.util.*;
class Person
    {
        String name;
        List<String> hobbies;
        public Person(String name, List<String> hobbies)
        {
            this.name = name;
            this.hobbies = hobbies;
        }
        // Shallow copy constructor
        public Person(Person person)
        {
            this.name = person.name;
            this.hobbies = person.hobbies;
        }
        // Deep copy constructor
        public Person deepCopy()
        {
            List<String> hobbiesCopy = new ArrayList<>(this.hobbies); // Creating a new ArrayList
            return new Person(this.name, hobbiesCopy);
        }
    }
    public class DeepCopying
    {
        public static void main(String[] args)
        {
            List<String> originalHobbies = new ArrayList<>();
            originalHobbies.add("Reading");
            originalHobbies.add("Painting");
            Person originalPerson = new Person("Alice", originalHobbies);
            // Shallow copy
            Person shallowCopyPerson = new Person(originalPerson);
            shallowCopyPerson.name = "Bob"; // Modifying shallowCopyPerson's name
            shallowCopyPerson.hobbies.add("Gardening"); // Modifying shallowCopyPerson's hobbies
            System.out.println("Original person: " + originalPerson.name + ", Hobbies: " + originalPerson.hobbies);
            System.out.println("Shallow copy person: " + shallowCopyPerson.name + ", Hobbies: " + shallowCopyPerson.hobbies);
            // Deep copy
            Person deepCopyPerson = originalPerson.deepCopy();
            deepCopyPerson.name = "Carol"; // Modifying deepCopyPerson's name
            deepCopyPerson.hobbies.add("Cooking"); // Modifying deepCopyPerson's hobbies
            System.out.println("Original person: " + originalPerson.name + ", Hobbies: " + originalPerson.hobbies);
            System.out.println("Deep copy person: " + deepCopyPerson.name + ", Hobbies: " + deepCopyPerson.hobbies);
        }
    }