package Employer;

import java.io.Serializable;
import java.util.Objects;

public class Employer implements Serializable {
    private String name;
    private int age;

    public Employer(String name, int age) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(age);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age + " éves";
    }
}
