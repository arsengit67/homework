package campus_life_planner;
import java.util.Scanner;

public class Course {

    // Fields
    String name;
    String instructor;
    int credits;

    // Constructor
    Course(String name, String instructor, int credits){
        this.name = name;
        this.instructor = instructor;
        this.credits = credits;
    }

    // Methods
    Scanner input = new Scanner(System.in);

    String getName(){
        System.out.println("Enter the name of the course: ");
        String name = input.nextLine();
        return name;
    }

    String getInstructor(){
        System.out.println("Enter the name of your instructor");
        String instructor = input.nextLine();
        return instructor;
    }

    int getCredits(){
        System.out.println("Enter the number of credits for this course: ");
        int credits = input.nextInt();
        input.nextLine();
        return credits;
    }

    @Override
    public String toString(){
        return "Course{" +
                "name='" + name +
                "', instructor='" + instructor +
                "', credits=" + credits +
                "}";
    }

}

/*1) Course
Represents a university course.
Fields:
String name
String instructor
int credits (e.g., 3 or 6)
Constructor:
Course(String name, String instructor, int credits)
Methods (public):
String getName(), String getInstructor(), int getCredits()
String toString() → e.g., "Course{name='OOP', instructor='Dr. Lee', credits=6}"*/
