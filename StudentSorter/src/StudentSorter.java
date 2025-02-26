import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentSorter {

    public static void main(String[] args) throws FileNotFoundException {
        // Read the student information from the file once
        List<Student> students = readStudentsFromFile("/Users/macbookpro/IdeaProjects/CISC 3130/StudentSorter/src/students.txt");

        // Create a single Scanner for keyboard input
        Scanner keyboard = new Scanner(System.in);
        String input;

        // Repeatedly ask the user how to sort the students
        do {
            printMenu();
            input = keyboard.nextLine();
            char choice = input.charAt(0);

            // Choose the appropriate sort based on user input
            switch (choice) {
                case 'F':
                    // Sort by first name
                    students.sort(new FirstNameComparator());
                    System.out.println("students sorted by first name:");
                    printStudents(students);
                    break;
                case 'L':
                    // Sort by last name
                    students.sort(new LastNameComparator());
                    System.out.println("students sorted by last name:");
                    printStudents(students);
                    break;
                case 'I':
                    // Sort by id
                    students.sort(new IdComparator());
                    System.out.println("students sorted by id:");
                    printStudents(students);
                    break;
                case 'G':
                    // Sort by grade
                    students.sort(new GradeComparator());
                    System.out.println("students sorted by grade:");
                    printStudents(students);
                    break;
                case 'Q':
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (input.charAt(0) != 'Q');

        keyboard.close();
    }

    /**
     * Reads student data from a given file.
     * Each line of the file should contain:
     * firstName lastName id grade
     */
    private static List<Student> readStudentsFromFile(String filename) throws FileNotFoundException {
        List<Student> studentList = new ArrayList<>();
        Scanner fileScanner = new Scanner(new File(filename));
        // Read through the file
        while (fileScanner.hasNext()) {
            String firstName = fileScanner.next();
            String lastName = fileScanner.next();
            int id = fileScanner.nextInt();
            double grade = fileScanner.nextDouble();
            studentList.add(new Student(firstName, lastName, id, grade));
        }
        fileScanner.close();
        return studentList;
    }

    // Prints the menu of choices
    private static void printMenu() {
        System.out.println("\nChoices:");
        System.out.println("F - sort by first name");
        System.out.println("L - sort by last name");
        System.out.println("I - sort by id");
        System.out.println("G - sort by grade");
        System.out.println("Q - quit");
    }

    // Prints each student in the list
    private static void printStudents(List<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

// class to represent a student
class Student {
    private String firstName;
    private String lastName;
    private int id;
    private double grade;

    public Student(String firstName, String lastName, int id, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.grade = grade;
    }

    // Getter methods
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getId() { return id; }
    public double getGrade() { return grade; }

    /**
     * Returns a formatted string representation of the student in one line.
     * The format is:
     * firstName    lastName    id    grade
     */
    @Override
    public String toString() {
        return String.format("%-8s %-8s %-8d %-4.1f", firstName, lastName, id, grade);
    }
}

// Comparators for sorting the students:

//Compares students by first name
class FirstNameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getFirstName().compareTo(s2.getFirstName());
    }
}

//Compares students by last name

class LastNameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getLastName().compareTo(s2.getLastName());
    }
}

// Compares students by id
class IdComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getId(), s2.getId());
    }
}

// Compares students by grade
class GradeComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getGrade(), s2.getGrade());
    }
}
