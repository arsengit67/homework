package campus_life_planner;

/* This class is a subclass of PlanItem and superclass of Assignment and ExamPreparation classes
   because they have a course instance variable in common */

public class CourseItem extends PlanItem{

    Course course;

    CourseItem(String title, int estimatedHours, Course course){
        super(title, estimatedHours);
        this.course = course;
    }

    public Course getCourse(){
        return course;
    }
    public void setCourse(Course course){
        this.course = course;
    }

    @Override
    public void display(){
        System.out.println("Title: " + getTitle() +
                ", Estimated Hours: " + getEstimatedHours() +
                ", Course: " + getCourse().getName() +
                ", Completed: " + isCompleted());
    }

}
