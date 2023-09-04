package com.intellekta.switchOp;

public class Solution {

    public static void main(String[] args) {
        sayHello(args);
    }

    public static void sayHello(String[] args) {
        //Если длина массива не равна 1, выводим Hello и выходим из метода
        if (args.length != 1) {
            System.out.println("Hello");
            return;
        }
        // Сравнивать будем единственное значение массива со значениями в кейсах. Использовал улучшенный switch case
        switch (args[0]) {
            case "-u" -> System.out.println("Hello, " + System.getProperty("user.name") + "!");
            case "-s" -> System.out.println("Hello, " + System.getProperty("os.name") + "!");
            // Здесь объединил сразу 2 варианта параметров
            case "-us", "-su" ->
                    System.out.printf("Hello, %s of %s!", System.getProperty("user.name"), System.getProperty("os.name"));
            // Если ни один из перечисленных вариантов не подходит-выводится "Hello!"
            default -> System.out.println("Hello");
        }
        //Стандартный Switch Case
//        switch (args[0]) {
//            case "-u":
//                System.out.println("Hello, " + System.getProperty("user.name"));
//                break;
//            case "-s":
//                System.out.println("Hello, " + System.getProperty("os.name"));
//                break;
//            case "-us":
//            case "-su":
//                System.out.printf("Hello, %s of %s!", System.getProperty("user.name"), System.getProperty("os.name"));
//                break;
//            default:
//                System.out.println("Hello!");
//        }
    }
}
