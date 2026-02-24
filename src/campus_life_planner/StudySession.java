package campus_life_planner;

public class StudySession {

    // Fields
    private Course course;
    private int minutes;

    // Constructor
    StudySession(Course course, int minutes){
        this.course = course;
        this.minutes = minutes;
    }

    // Methods
    public float getHours(){
        int hours = minutes / 60;
        return hours;
    }

    @Override
    public String toString(){
        return "StudySession{course='" + course.getName() + "', minutes=" + minutes + "}";
    }

    // Getters and Setters
    public Course getCourse(){
        return course;
    }
    public void setCourse(Course course){
        this.course = course;
    }

    public int getMinutes(){
        return minutes;
    }
    public void setMinutes(int minutes){
        this.minutes = minutes;
    }

}
