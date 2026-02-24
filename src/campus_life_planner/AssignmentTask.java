package campus_life_planner;

public class AssignmentTask {

    // Fields
    private String title;
    private Course course;
    private int estimatedHours;
    private int daysUntilDue;
    private boolean completed;

    // Constructor
    AssignmentTask(String title, Course course, int estimatedHours, int daysUntilDue){
        this.title = title;
        this.course = course;
        this.estimatedHours = estimatedHours;
        this.daysUntilDue = daysUntilDue;
    }

    // Methods
    public void markCompleted(){
        completed = true;
    }

    public boolean isUrgent(){
        return daysUntilDue <= 2 & !completed;
    }

    @Override
    public String toString(){
        return "AssignmentTask{" +
                "title='" + title +
                "', course='" + course.getName() +
                "', estimatedHours=" + estimatedHours +
                ", dueIn=" + daysUntilDue +
                ", completed=" + completed +
                "}";
    }

    // Getters and setters
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public Course getCourse(){
        return course;
    }
    public void setCourse(Course course){
        this.course = course;
    }

    public int getEstimatedHours(){
        return estimatedHours;
    }
    public void setEstimatedHours(int estimatedHours){
        this.estimatedHours = estimatedHours;
    }

    public int getDaysUntilDue(){
        return daysUntilDue;
    }
    public void setDaysUntilDue(int daysUntilDue){
        this.daysUntilDue = daysUntilDue;
    }

    public boolean isCompleted(){
        return completed;
    }
    public void setCompleted(boolean completed){
        this.completed = completed;
    }

}