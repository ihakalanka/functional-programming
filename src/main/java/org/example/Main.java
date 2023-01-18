package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        employees.stream().forEach(employee -> System.out.println(employee));

        System.out.println("===================================");

        List<Employee> increasedSalaryEmployees = employees.stream()
                .map(employee -> {
                    employee.setSalary(employee.getSalary() + 1000.0);
                    return employee;
                })
                .collect(Collectors.toList());
        System.out.println(increasedSalaryEmployees);

        System.out.println("===================================");

        List<Employee> filteredEmployees = employees
                .stream()
                .filter(employee -> employee.getSalary() > 6000.0)
                .collect(Collectors.toList());
        System.out.println(filteredEmployees);


    }
}