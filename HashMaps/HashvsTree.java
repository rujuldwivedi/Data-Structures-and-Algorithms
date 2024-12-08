import java.util.*;

class Person
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        return true;
        if(obj == null)
        return false;
        if(getClass() != obj.getClass())
        return false;
        Person other = (Person) obj;
        if(age != other.age)
        return false;
        if(name == null)
        {
            if (other.name != null)
            return false;
        }
        else if (!name.equals(other.name))
        return false;
        return true;
    }
}
public class HashvsTree
{
    public static void main(String[] args)
    {
        // HashMap
        Map<Person, Integer> hashMap = new HashMap<>();
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 30);
        hashMap.put(person1, 100);
        hashMap.put(person2, 200);

        System.out.println("HashMap:");
        for(Map.Entry<Person, Integer> entry : hashMap.entrySet())
        System.out.println(entry.getKey().hashCode() + ": " + entry.getKey().getName() + " - " + entry.getValue());

        // TreeMap
        Map<Person, Integer> treeMap = new TreeMap<>();
        Person person3 = new Person("Alice", 25);
        Person person4 = new Person("Bob", 30);
        treeMap.put(person3, 100);
        treeMap.put(person4, 200);

        System.out.println("\nTreeMap:");
        for(Map.Entry<Person, Integer> entry : treeMap.entrySet())
        System.out.println(entry.getKey().hashCode() + ": " + entry.getKey().getName() + " - " + entry.getValue());
    }
}