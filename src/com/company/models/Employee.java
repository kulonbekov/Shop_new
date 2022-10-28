package com.company.models;

public class Employee{
    private Long id;
    private int numberEmployee;
    private String name;
    private int age;

    public Employee(int numberEmployee, String name, int age) {
        this.numberEmployee = numberEmployee;
        this.name = name;
        this.age = age;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberEmployee() {
        return numberEmployee;
    }

    public void setNumberEmployee(int numberEmployee) {
        this.numberEmployee = numberEmployee;
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
        return "Employee{" +
                "id=" + id +
                ", numberEmployee=" + numberEmployee +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
