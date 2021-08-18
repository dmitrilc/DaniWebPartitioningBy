package com.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Entry {
    public static void main(String[] args){
        List<Student> students = List.of(
                new Student("John", 22, Gender.MALE),
                new Student("Bob", 21, Gender.MALE),
                new Student("Mary", 23, Gender.FEMALE),
                new Student("Jessica", 21, Gender.FEMALE),
                new Student("Sam", 24, Gender.OTHER),
                new Student("Alex", 20, Gender.OTHER));

        Map<Boolean, List<Student>> result = students.stream().collect(
                Collectors.partitioningBy(student -> student.name().length() < 4));
        System.out.println(result);

        Map<Boolean, Map<Boolean, List<Student>>> result2 = students.stream().collect(
                Collectors.partitioningBy(student -> student.name().length() < 4,
                        Collectors.partitioningBy(student -> student.age() > 22)));
        System.out.println(result2);
    }
}

record Student(String name, int age, Gender gender){}

enum Gender {
    MALE, FEMALE, OTHER
}