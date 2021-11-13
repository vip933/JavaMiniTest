package Zappy.java.bse208.hw5;

public class Student {
    private final String firstName;
    private final String lastName;
    private final String groupId;

    public Student(String firstName, String lastName, String groupId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupId = groupId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        final Student otherStudent = (Student) other;
        if (firstName == null) {
            if (otherStudent.firstName != null) {
                return false;
            }
        }
        if (lastName == null) {
            return otherStudent.lastName == null;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int seed = 31;
        int result = 1;
        result = seed * result +
                ((firstName == null) ? 0 : firstName.hashCode()) +
                ((lastName == null) ? 0 : lastName.hashCode()) +
                ((groupId == null) ? 0 : groupId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " из группы: " + groupId;
    }

    public static Student parseStudent(String studentInfo) throws RuntimeException {
        if (studentInfo == null) {
            throw new NullPointerException("line with student info is null!");
        }
        final String[] params = studentInfo.split(";");
        if (params.length != 3) {
            throw new IllegalArgumentException("line is incorrect!");
        }
        final String firstName = params[1];
        final String lastName = params[0];
        final String groupId = params[2];
        return new Student(firstName, lastName, groupId);
    }
}
