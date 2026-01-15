package Assignments;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    // Constructor
    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeDatasetAnalysis {

    public static void main(String[] args) {
        // Step 1: Create dataset, here using Array 
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 28, "HR", 50000),
            new Employee("Bob", 35, "Engineering", 80000),
            new Employee("Charlie", 32, "Sales", 60000),
            new Employee("Diana", 26, "Marketing", 45000),
            new Employee("Ethan", 40, "Engineering", 90000)
        );

        // Step 2: Define a Function to get name and department
        Function<Employee, String> nameAndDepartment = emp ->
            emp.getName() + " - " + emp.getDepartment();

        // Step 3: Generate a new collection of name and department strings
        List<String> nameDeptList = employees.stream()
            .map(nameAndDepartment)
            .collect(Collectors.toList());

        System.out.println("Name and Department List:");
        nameDeptList.forEach(System.out::println);

        // Step 4: Calculate average salary
        double averageSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);

        System.out.println("\n Average Salary: $" + averageSalary);

        // Step 5: Filter employees older than a certain age (e.g., 30)
        int age = 30;
        List<Employee> EmployeesFilter = employees.stream()
            .filter(emp -> emp.getAge() > age)
            .collect(Collectors.toList());

        System.out.println("\nEmployees older than " + age + ":");
        EmployeesFilter.forEach(emp ->
            System.out.println(emp.getName() + " (" + emp.getAge() + " years old)")
        );
    }
}
