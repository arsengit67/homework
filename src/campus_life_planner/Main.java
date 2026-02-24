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
        ArrayList<AssignmentTask> assignmentTasks = new ArrayList<>();
        AssignmentTask integrals = new AssignmentTask("Definite integrals", calculus, 2, 7);
        assignmentTasks.add(integrals);
        AssignmentTask derivatives = new AssignmentTask("Higher-order derivatives", calculus, 4, 1);
        assignmentTasks.add(derivatives);
        AssignmentTask classesAndObjects = new AssignmentTask("Classes and Objects", programmingLanguages, 3, 2);
        assignmentTasks.add(classesAndObjects);
        AssignmentTask publicSpeech = new AssignmentTask("Public Speech", english, 1, 3);
        assignmentTasks.add(publicSpeech);

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
        for (AssignmentTask task : assignmentTasks){
            if (task.isUrgent())
                System.out.println("URGENT: " + task);
            else
                System.out.println(task);
        }
        System.out.println();

        // Total estimated hours remaining for all incompleted tasks
        int totalEstimatedHours = 0;
        for (AssignmentTask task : assignmentTasks){
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
        System.out.println(integrals);
        totalEstimatedHours = 0;
        for (AssignmentTask task : assignmentTasks){
            if (!task.isCompleted()){
                totalEstimatedHours += task.getEstimatedHours();
            }
        }
        System.out.println("Total estimated hours remaining for all incompleted tasks: " + totalEstimatedHours + "\n");

    }
}