package campus_life_planner;

public class Event extends PlanItem{

    private int daysUntilEvent;

    Event(String title, int estimatedHours, int daysUntilEvent) {
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
