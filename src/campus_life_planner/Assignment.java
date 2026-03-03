package campus_life_planner;

public class Assignment extends CourseItem{

    int daysUntilDue;

    Assignment(String title, int estimatedHours, Course course, int daysUntilDue){
        super(title, estimatedHours, course);
        this.daysUntilDue = daysUntilDue;
    }

    public boolean isUrgent(){
        return getDaysUntilDue() <= 2 & !isCompleted();
    }

    public int getDaysUntilDue(){
        return daysUntilDue;
    }
    public void setDaysUntilDue(int daysUntilDue){
        this.daysUntilDue = daysUntilDue;
    }

    @Override
    public void display(){
        if (isUrgent()){
            System.out.println("URGENT: Title: " + getTitle() +
                    ", Estimated Hours: " + getEstimatedHours() +
                    ", Course: " + getCourse().getName() +
                    ", Days Until Due: " + getDaysUntilDue() +
                    ", Completed: " + isCompleted());
        } else {
            System.out.println("Title: " + getTitle() +
                    ", Estimated Hours: " + getEstimatedHours() +
                    ", Course: " + getCourse() +
                    ", Days Until Due: " + getDaysUntilDue() +
                    ", Completed: " + isCompleted());
        }
    }

}
