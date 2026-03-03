package campus_life_planner;

public class PlanItem {

    // Fields
    private String title;
    private int estimatedHours;
    private boolean completed;

    // Constructor
    PlanItem(String title, int estimatedHours){
        this.title = title;
        this.estimatedHours = estimatedHours;
    }

    // Methods

    public void display(){
        System.out.println("Title: " + title +
                ", Estimated Hours: " + estimatedHours +
                ", Completed: " + completed);
    }

    public void markCompleted(){
        completed = true;
    }


    @Override
    public String toString(){
        return "PlanItem{" +
                "title='" + title +
                "', estimatedHours=" + estimatedHours +
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


    public int getEstimatedHours(){
        return estimatedHours;
    }
    public void setEstimatedHours(int estimatedHours){
        this.estimatedHours = estimatedHours;
    }


    public boolean isCompleted(){
        return completed;
    }
    public void setCompleted(boolean completed){
        this.completed = completed;
    }

}