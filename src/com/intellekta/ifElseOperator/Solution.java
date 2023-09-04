package com.intellekta.ifElseOperator;

public class Solution {

    public static void main(String[] args) {
        sayHello(args);
    }

    public static void sayHello(String[] args) {
        /* Создал 2 отдельных переменных, чтобы не вписывать
        каждый раз в метод equals параметры для сравнения
        */
        String param1 = "-u";
        String param2 = "-s";
        //Проверка на количество параметров и содержит ли массив параметры -u или -s
        if (args.length == 1 && (args[0].equals(param1) || args[0].equals(param2))) {
            //Здесь использовал тернарный оператор для сокращения кода. Делаю проверку на первый параметр
            System.out.println(args[0].equals(param1) ? "Hello, " + System.getProperty("user.name") + "!"
                    : "Hello, " + System.getProperty("os.name") + "!");
        }
        // Проверка, если используются оба параметра одновременно
        else if (args.length == 2 && args[0].equals(param1) && args[1].equals(param2)) {
            System.out.printf("Hello, %s of %s!", System.getProperty("user.name"), System.getProperty("os.name"));
        }
        /* Если передается пустой массив, или количество аргументов больше,
         или один из аргументов не соответствует перечисленным в условии-выводится Hello!
         */
        else
            System.out.println("Hello!");
    }
}
