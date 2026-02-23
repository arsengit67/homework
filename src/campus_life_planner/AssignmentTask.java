package campus_life_planner;

public class AssignmentTask {

    // Fields
    private String title;
    private Course course;
    private int estimatedHours;
    private int daysUntilDue;
    boolean completed;

    // Constructor
    AssignmentTask(String title, Course course, int estimatedHours, int daysUntilDue){
        this.title = title;
        this.course = course;
        this.estimatedHours = estimatedHours;
        this.daysUntilDue = daysUntilDue;
    }

    // Methods
    void markCompleted(){
        completed = true;
    }

    boolean isCompleted(){
        return daysUntilDue <= 2 & !completed;
    }

    @Override
    public String toString(){
        return "AssignmentTask{" +
                "title='" + title +
                "', course='" + course +
                "', estimatedHours=" + estimatedHours +
                "'dueIn=" + daysUntilDue +
                "completed=" + completed +
                "}";
    }

    // Getters and setters

}

/*
2) AssignmentTask
Represents a piece of coursework for a course.
Fields (private):
String title
Course course (the course it belongs to)
int estimatedHours (how long you think it will take)
int daysUntilDue (0 means due today, 1 means due tomorrow, etc.)
boolean completed
Constructor:
AssignmentTask(String title, Course course, int estimatedHours, int daysUntilDue)
Methods (public):
Getters for each field (no setter for course is fine).
void markCompleted() sets completed = true.
boolean isUrgent() returns true if daysUntilDue <= 2 and !completed.
String toString() with a friendly format, e.g.:"AssignmentTask{title='Lab 2', course='OOP', estHours=3, dueIn=1, completed=false}"
*/