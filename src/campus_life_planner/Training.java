package campus_life_planner;

public class Training extends PlanItem{

    private int daysUntilEvent;

    Training(String title, int estimatedHours, int daysUntilEvent) {
        super(title, estimatedHours);
        this.daysUntilEvent = daysUntilEvent;
    }

    public int getDaysUntilEvent() {
        return daysUntilEvent;
    }

    public void setDaysUntilEvent(int daysUntilEvent) {
        this.daysUntilEvent = daysUntilEvent;
    }
}
