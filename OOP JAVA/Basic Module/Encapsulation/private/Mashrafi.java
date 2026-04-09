class Person {

    
    private String name;

    public void setName(String name)  {

        this.name = name; 
    }

    public String getName() { return name; }
}

public class Mashrafi {
    public static void main(String[] args)
    {

        Person p = new Person();
        p.setName("Mashrafi");

        // System.out.println(p.name); // Error: 'name'
        // has private access
        System.out.println(p.getName());
    }
}