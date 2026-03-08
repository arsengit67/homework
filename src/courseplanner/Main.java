package courseplanner;

import java.util.*;

public class Main {

    // course -> set of prerequisites
    static HashMap<String, HashSet<String>> prereqs = new HashMap<>();

    // student -> set of completed courses
    static HashMap<String, HashSet<String>> completed = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        printHelp();

        boolean exit = false;

        // Menu
        while (!exit) {
            System.out.print("> ");

            String line = scanner.nextLine().trim();

            if (line.isEmpty())
                continue;

            String[] parts = line.split("\\s+");
            String cmd = parts[0].toUpperCase();

            switch (cmd) {

                case "HELP":
                    printHelp();
                    break;

                case "ADD_COURSE":
                    addCourse(parts);
                    break;

                case "ADD_PREREQ":
                    addPrereq(parts);
                    break;

                case "PREREQS":
                    showPrereqs(parts);
                    break;

                case "COMPLETE":
                    completeCourse(parts);
                    break;

                case "DONE":
                    showCompleted(parts);
                    break;

                case "CAN_TAKE":
                    canTake(parts);
                    break;

                case "EXIT":
                    System.out.println("Goodbye!");
                    exit = true;

                default:
                    System.out.println("Unknown command. Type HELP.");

            }
        }
    }

    // ---------------- HELP MENU ----------------

    static void printHelp() {
        System.out.println("Course Enrollment Planner — Commands:");
        System.out.println("HELP");
        System.out.println("ADD_COURSE <C>");
        System.out.println("ADD_PREREQ <C> <P>");
        System.out.println("PREREQS <C>");
        System.out.println("COMPLETE <student> <C>");
        System.out.println("DONE <student>");
        System.out.println("CAN_TAKE <student> <C>");
        System.out.println("EXIT");
    }

    // ---------------- ADD COURSE ----------------

    static void addCourse(String[] parts) {

        if (parts.length < 2) {
            System.out.println("Usage: ADD_COURSE <C>");
            return;
        }

        String course = parts[1];

        prereqs.putIfAbsent(course, new HashSet<>());

        System.out.println("Added course: " + course);
    }

    // ---------------- ADD PREREQ ----------------

    static void addPrereq(String[] parts) {

        if (parts.length < 3) {
            System.out.println("Usage: ADD_PREREQ <C> <P>");
            return;
        }

        String course = parts[1];
        String prereq = parts[2];

        if (course.equals(prereq)) {
            System.out.println("A course cannot be its own prerequisite");
            return;
        }

        prereqs.putIfAbsent(course, new HashSet<>());
        prereqs.putIfAbsent(prereq, new HashSet<>());

        prereqs.get(course).add(prereq);

        System.out.println("Added prereq: " + prereq + " -> " + course);
    }

    // ---------------- SHOW PREREQS ----------------

    static void showPrereqs(String[] parts) {

        if (parts.length < 2) {
            System.out.println("Usage: PREREQS <C>");
            return;
        }

        String course = parts[1];

        if (!prereqs.containsKey(course)) {
            System.out.println("Course not found");
            return;
        }

        System.out.println("Prereqs for " + course + ": " + prereqs.get(course));
    }

    // ---------------- COMPLETE COURSE ----------------

    static void completeCourse(String[] parts) {

        if (parts.length < 3) {
            System.out.println("Usage: COMPLETE <student> <C>");
            return;
        }

        String student = parts[1];
        String course = parts[2];

        completed.putIfAbsent(student, new HashSet<>());

        completed.get(student).add(course);

        System.out.println(student + " completed " + course);
    }

    // ---------------- SHOW COMPLETED ----------------

    static void showCompleted(String[] parts) {

        if (parts.length < 2) {
            System.out.println("Usage: DONE <student>");
            return;
        }

        String student = parts[1];

        if (!completed.containsKey(student)) {
            System.out.println("No record");
            return;
        }

        System.out.println(student + " completed: " + completed.get(student));
    }

    // ---------------- CAN_TAKE ----------------

    static void canTake(String[] parts) {

        if (parts.length < 3) {
            System.out.println("Usage: CAN_TAKE <student> <C>");
            return;
        }

        String student = parts[1];
        String course = parts[2];

        HashSet<String> coursePrereqs = prereqs.get(course);

        // if course unknown or no prereqs
        if (coursePrereqs == null || coursePrereqs.isEmpty()) {
            System.out.println("YES");
            return;
        }

        HashSet<String> studentCourses = completed.getOrDefault(student, new HashSet<>());

        for (String p : coursePrereqs) {
            if (!studentCourses.contains(p)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
