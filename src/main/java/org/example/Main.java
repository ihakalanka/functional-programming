package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        System.out.println("===================================");

        Employee employee = employees.stream()
                .filter(emp -> emp.getSalary() > 7000.0)
                .findAny()
                .orElse(null);
        System.out.println(employee);

        System.out.println("===================================");

        List<Employee> shortCircuitEmployees = employees.stream()
                .skip(2)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(shortCircuitEmployees);

        System.out.println("===================================");

        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("===================================");

        List<Employee> sortedEmployees = employees.stream()
                .sorted((emp1, emp2) -> emp1.getSalary().compareTo(emp2.getSalary()))
                .collect(Collectors.toList());
        System.out.println(sortedEmployees);

        System.out.println("===================================");

        Employee max = employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(max);

        System.out.println("===================================");

        Double totalSalary = employees.stream()
                .map(emp -> emp.getSalary())
                .reduce(0.0,Double::sum);
        System.out.println(totalSalary);
    }
}