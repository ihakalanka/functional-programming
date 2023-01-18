package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(
                new Employee("Hashan", "Chathuanga", 5000.0)
        );

        employees.add(
                new Employee("Naveen", "Fernando", 6000.0)
        );

        employees.add(
                new Employee("Nipuna", "Dilshan", 5500.0)
        );
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}