package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {

        int[] numbers = {4, 2, 6, 8, 10, 12};
        String[] names = {"Yashod", "Shawn", "Dinusha", "Nipunika", "Piyumi"};

        // Example 1


        Student student1 = new Student("Udayanga", 25, Gender.MALE, 3.4);
        Student student2 = new Student("Shawn", 26, Gender.MALE, 3.6);
        Student student3 = new Student("Hasini", 26, Gender.FEMALE, 3.7);
        Student student4 = new Student("Chamindika", 24, Gender.FEMALE, 3.5);
        Student student5 = new Student("Yashod", 25, Gender.MALE, 3.3);

        List<Student> studentList = Arrays.asList(student1, student2, student3, student4, student5);

        studentList.stream().filter(x->x.getGender() == Gender.FEMALE).forEach(x -> System.out.println(x.getName()));

        System.out.println();
        System.out.println("---------------------------");
        System.out.println();

        // Sorting
        System.out.println("Sorting Examples");
        // numbers
        System.out.println("Sorting Example1");
        Arrays.stream(numbers).sorted().forEach(x -> System.out.println(x));
        System.out.println();

        // Strings
        System.out.println("Sorting Example2");
        Arrays.stream(names).sorted().forEach(x -> System.out.println(x));
        System.out.println();

        // Sorting using attribbute
        System.out.println("Sorting Example3");
        studentList.stream().sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
        System.out.println();

        // Sorted using two attributes
        System.out.println("Sorting Example4");
        studentList.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getGpa)).forEach(System.out::println);
        System.out.println();
        System.out.println("---------------------------");

        // Filter
        System.out.println("Filter Examples");
        // numbers
        System.out.println("Filter Example1");
        Arrays.stream(numbers).filter(x -> x > 3).forEach(x -> System.out.println(x));
        System.out.println();

        // Filter using attribbute
        System.out.println("Filter Example2");
        studentList.stream().filter(x -> x.getAge() > 24).forEach(System.out::println);
        System.out.println();


        // Filter using 2 attribbute
        System.out.println("Filter Example3");
        studentList.stream().filter(x -> x.getAge() > 24 && x.getGpa() > 3.5).forEach(System.out::println);
        System.out.println();

        // Filter using 2 attribbute
        System.out.println("Filter Example4");
        studentList.stream().filter(x -> x.getAge() > 24 && x.getName().startsWith("Y")).forEach(System.out::println);
        System.out.println();
        System.out.println("---------------------------");
        System.out.println();


        // Maps
        System.out.println("Maps");
        System.out.println("Maps Example1");
        Arrays.stream(numbers).map(x -> x * x).forEach(x -> System.out.println(x));
        System.out.println();

        System.out.println("Maps Example2");
        studentList.stream().map(x -> { x.setAge(x.getAge()+1); return x; }).forEach(System.out::println);
        System.out.println();

        // Collect
        System.out.println("Collect");
        System.out.println("Collect Example1");
        List<String> filteredNames = Arrays.stream(names).filter(x->x.startsWith("S")).collect(Collectors.toList());
        System.out.println();

        System.out.println("Collect Example2");
        Map<String, Integer> mapped = studentList.stream().filter(x -> x.getAge() > 25).collect(Collectors.toMap(x->x.getName(), x->x.getAge()));
        for (String key: mapped.keySet()) {
            System.out.println("Name :" + key + " and Age:" + mapped.get(key));
        }
        System.out.println();

        System.out.println("Collect Example3");
        Map<Integer, List<Student>> groupMap = studentList.stream().filter(x -> x.getAge() > 25).collect(Collectors.groupingBy(Student::getAge));
        for (Integer key: groupMap.keySet()) {
            System.out.println("For Age :" + key);
            for (Student student: groupMap.get(key)) {
                System.out.println("Name :" + student.getName());
            }
            System.out.println("------------");
        }
        System.out.println();
        System.out.println("------------");

        System.out.println("Reduce");
        int sumOfSquares = Arrays.stream(numbers).reduce(0, (int a, int b) -> a + b * b);
        System.out.println(sumOfSquares);

    }
}
