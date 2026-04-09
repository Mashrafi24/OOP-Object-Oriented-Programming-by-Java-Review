public class Employee implements Cloneable {
    private String name;
    private int age;
    private double salary;
    
    
    public Employee() {
        this.name = "Unknown";
        this.age = 18;
        this.salary = 0.0;
    }
    
    public Employee(String name, int age, double salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public double getSalary() {
        return this.salary;
    }
    
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Name cannot be null or empty. Setting to 'Unknown'");
            this.name = "Unknown";
        }
    }
    
    public void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
        } else {
            System.out.println("Error: Age must be between 18 and 65. Setting to default (18)");
            this.age = 18;
        }
    }
    
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Error: Salary cannot be negative. Setting to 0");
            this.salary = 0;
        }
    }
    
    public double calculateAnnualSalary() {
        return this.salary * 12;
    }
    
    public void giveRaise(double percentage) {
        if (percentage > 0) {
            double raiseAmount = this.salary * (percentage / 100);
            this.salary += raiseAmount;
            System.out.println(this.name + " received a raise of " + percentage + "%");
        } else {
            System.out.println("Raise percentage must be positive");
        }
    }
    
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Monthly Salary: $" + String.format("%.2f", this.salary));
        System.out.println("Annual Salary: $" + String.format("%.2f", calculateAnnualSalary()));
        System.out.println("---------------------------");
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}