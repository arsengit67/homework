package campus_life_planner;

public class ExamPreparation extends CourseItem{

    int daysUntilEvent;

    ExamPreparation(String title, int estimatedHours, Course course, int daysUntilEvent) {
        super(title, estimatedHours, course);
        this.daysUntilEvent = daysUntilEvent;
    }

    public int getDaysUntilEvent() {
        return daysUntilEvent;
    }

    public void setDaysUntilEvent(int daysUntilEvent) {
        this.daysUntilEvent = daysUntilEvent;
    }
}
