package campus_life_planner;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static void main(){

        // Courses
        ArrayList<Course> courses = new ArrayList<>();
        Course calculus = new Course("Calculus", "Hussain Chebsi", 6);
        courses.add(calculus);
        Course english = new Course("English", "Murray Eldred", 3);
        courses.add(english);
        Course programmingLanguages = new Course("Programming Languages", "Azhar Kazakbaeva", 4);
        courses.add(programmingLanguages);

        // Assignment Tasks
        ArrayList<Assignment> assignments = new ArrayList<>();
        Assignment integrals = new Assignment("Definite integrals", 2, calculus, 7);
        assignments.add(integrals);
        Assignment derivatives = new Assignment("Higher-order derivatives", 4, calculus, 1);
        assignments.add(derivatives);
        Assignment classesAndObjects = new Assignment("Classes and Objects", 3, programmingLanguages, 2);
        assignments.add(classesAndObjects);
        Assignment publicSpeech = new Assignment("Public Speech", 1, english, 3);
        assignments.add(publicSpeech);

        // Study Sessions
        ArrayList<StudySession> studySessions = new ArrayList<>();
        StudySession integralsSession = new StudySession(calculus, 120);
        studySessions.add(integralsSession);
        StudySession derivativeSession = new StudySession(calculus, 120);
        studySessions.add(derivativeSession);
        StudySession classesAndObjectsSession = new StudySession(programmingLanguages, 60);
        studySessions.add(classesAndObjectsSession);
        StudySession publicSpeechSession = new StudySession(english, 60);
        studySessions.add(publicSpeechSession);

        // Print
        // List of all courses
        System.out.println("List of all courses:");
        for (Course course : courses){
            System.out.println(course.getName());
        }
        System.out.println();

        // List of all assignments
        System.out.println("List of all assignments:");
        for (Assignment task : assignments){
            task.display();
        }
        System.out.println();

        // Total estimated hours remaining for all incompleted tasks
        int totalEstimatedHours = 0;
        for (PlanItem task : assignments){
            if (!task.isCompleted()){
                totalEstimatedHours += task.getEstimatedHours();
            }
        }
        System.out.println("Total estimated hours remaining for all incompleted tasks: " + totalEstimatedHours + "\n");

        // Total study time per course
        System.out.println("Total study time per course:");
        HashMap<String, Float> courseStudyHours = new HashMap<>();
        for (StudySession session : studySessions){
            String courseName = session.getCourse().getName();
            float studyHours = session.getHours();

            if (courseStudyHours.containsKey(courseName))
                courseStudyHours.put(courseName, studyHours + courseStudyHours.get(courseName));
            else
                courseStudyHours.put(courseName, studyHours);
        }
        for (var entry : courseStudyHours.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue() + " hours");
        }
        System.out.println();

        // Mark one assignment as completed and reprint it with new remaining estimated hours
        integrals.markCompleted();
        integrals.display();
        totalEstimatedHours = 0;
        for (PlanItem task : assignments){
            if (!task.isCompleted()){
                totalEstimatedHours += task.getEstimatedHours();
            }
        }
        System.out.println("Total estimated hours remaining for all incompleted tasks: " + totalEstimatedHours + "\n");

        // Create a mix of different plan item types
        Training volleyball = new Training("Volleyball practice session", 2, 1);
        Training gym = new Training("Gym session", 2, 2);
        ExamPreparation calculusExamPrep = new ExamPreparation("Calculus Exam Prep", 4, calculus, 0);
        Event competition = new Event("Arm wrestling competition", 2, 5);

        // Store them together in a single collection of the base type
        ArrayList<PlanItem> planItems = new ArrayList<>(assignments);
        planItems.add(volleyball);
        planItems.add(gym);
        planItems.add(calculusExamPrep);
        planItems.add(competition);

        // Print all items
        System.out.println("List of all plan items:");
        for (PlanItem item : planItems){
            item.display();
        }
        System.out.println();

        // Mark completed and reflect updates
        volleyball.markCompleted();
        competition.markCompleted();

        volleyball.display();
        competition.display();
        System.out.println();

        // Perform simple summarizing tasks
        // Total remaining time
        int totalRemainingTime = 0;
        for (PlanItem item : planItems){
            totalRemainingTime += item.getEstimatedHours();
        }
        System.out.println("Total remaining time = " + totalRemainingTime);
        System.out.println();

        // Most urgent activity
        Assignment mostUrgentTask = assignments.getFirst();
        for (Assignment task : assignments){
            if (task.getDaysUntilDue() < mostUrgentTask.getDaysUntilDue()){
                mostUrgentTask = task;
            }
        }
        System.out.println("Most urgent item: " + mostUrgentTask.getTitle());
        System.out.println();

    }
}