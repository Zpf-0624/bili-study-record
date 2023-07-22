package com.tuyoo.bi.java8;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author zhangpengfei
 * @Date 2023-03-22 23:07
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class StreamTest01 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 11, 2000, Status.p1),
            new Employee("李四", 22, 3000, Status.p2),
            new Employee("王五", 31, 4000, Status.p2),
            new Employee("赵六", 42, 4000, Status.p1),
            new Employee("赵六", 62, 5000, Status.p1),
            new Employee("t七", 62, 4000, Status.p1)
    );

    @Test
    public void test01() {

        Double a = 1.1;
        Stream<Employee> stream = employees.stream().filter(x -> x.age > 30);
        stream.limit(2).skip(1).forEach(System.out::println);


    }

    @Test
    public void test02() {
        Consumer<String> c1 = (x -> System.out.println(x + x));
        c1.accept("zpf");
    }

    @Test
    public void test03() {
        Map<Status, Set<String>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.mapping(Employee::getName, Collectors.toSet())));
        System.out.println(collect);
    }

    @Test
    public void test04() {
        Map<Status, Map<Integer, Set<String>>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,
                        Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toSet()))));
        System.out.println(collect);
    }



    /*public static void print(Consumer<String> c1 , Consumer<String> c2){
        String str = "Hello World";
        c1.andThen(c2).accept(str);
    }*/

    @Test
    public void test05() {
        Map<Status, Map<String, List<Employee>>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,
                        Collectors.groupingBy(x -> {
                            if (x.getSalary() > 2500) {
                                return "g";
                            } else {
                                return "d";
                            }
                        })));
        System.out.println(collect);
    }



}
