package Zappy.java.bse208.hw5;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StudentDao studentDao;
        String path = Main.class.getResource("/test.txt").getPath();
        try {
            studentDao = new StudentDao(path);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            return;
        }
        // studentDao.printAll();
        // System.out.println();

        String nameRequest = "МаКсиМ";
        var students = studentDao.findAllByName(nameRequest);
        printFound(students, nameRequest);

        String request = "МаксИм ЛейПУнский";
        var student = studentDao.findByNameAndSurname("МаКсИм", "ЛеЙпуНский");
        printFound(new Student[]{student}, request);
    }

    private static void printFound(Student[] students, String request) {
        System.out.println("Я нашел вот эти совпадения по запросу: " + request);
        Arrays.stream(students).forEach(System.out::println);
        System.out.println("-------------------------------\n");
    }
}
