package Zappy.java.bse208.hw5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StudentDao {

    private final List<Student> students;

    public StudentDao(String pathToFile) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader(pathToFile))) {
            students = new ArrayList<>(30);
            while (scanner.hasNextLine()) {
                try {
                    students.add(Student.parseStudent(scanner.nextLine()));
                } catch (NullPointerException | IllegalArgumentException ex) {
                    System.err.println(ex);
                }
            }
        }
    }

    public Student findByNameAndSurname(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            return null;
        }
        for (Student student: students) {
            if (firstName.equalsIgnoreCase(student.getFirstName())) {
                if (lastName.equalsIgnoreCase(student.getLastName())) {
                    return student;
                }
            }
        }
        return null;
    }

    public Student[] findAllByName(String firstName) {
        if (firstName == null) {
            return new Student[0];
        }
        final List<Student> found = new ArrayList<>();
        for (Student student : students) {
            if (firstName.equalsIgnoreCase(student.getFirstName())) {
                found.add(student);
            }
        }
        return found.toArray(Student[]::new);
    }

    public void printAll() {
        students.forEach(System.out::println);
    }
}
