package A1_IOC;

/**
 * MakeBean测试类
 */

public class Person {
    private String name;

    public Person() {
        System.out.println("invoke default constructor");
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
