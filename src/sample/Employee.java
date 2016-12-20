package sample;

import java.util.Date;


public class Employee {

    private int id;
    private String name;
    private String lastname;
    private String patronymic;
    private String position;
    private int salary;
    private String happybirthday;
    private String email;
    private String phone;

    public Employee(int id, String name, String lastname, String patronymic, String position, int salary, String happybirthday, String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.position = position;
        this.salary = salary;
        this.happybirthday = happybirthday;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public String getHappybirthday() {
        return happybirthday;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
