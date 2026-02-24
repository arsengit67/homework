package campus_life_planner;
import java.util.Scanner;

public class Course {

    // Fields
    private String name;
    private String instructor;
    private int credits;

    // Constructor
    Course(String name, String instructor, int credits){
        this.name = name;
        this.instructor = instructor;
        this.credits = credits;
    }

    // Methods
    Scanner input = new Scanner(System.in);

    String getName(){
        return name;
    }

    String getInstructor(){
        return instructor;
    }

    int getCredits(){;
        return credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name +
                "', instructor='" + instructor +
                "', credits=" + credits +
                "}";
    }

}