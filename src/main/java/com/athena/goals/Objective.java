package com.athena.goals;

import java.util.Date;
import java.util.List;

public class Objective {

    private String goalName;
    private String milestoneName;
    private String objectiveName;
    private Date objectiveCompletionDate;
    private List<Task> tasks;

    public Objective(String goalName, String milestoneName, String objectiveName, Date objectiveCompletionDate, List<Task> tasks, double objectiveCompletionStatus) {
        this.goalName = goalName;
        this.milestoneName = milestoneName;
        this.objectiveName = objectiveName;
        this.objectiveCompletionDate = objectiveCompletionDate;
        this.tasks = tasks;
    }

    public Objective(String goalName, String milestoneName, String objectiveName, Date objectiveCompletionDate, List<Task> tasks) {
        this.goalName = goalName;
        this.milestoneName = milestoneName;
        this.objectiveName = objectiveName;
        this.objectiveCompletionDate = objectiveCompletionDate;
        this.tasks = tasks;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public String getObjectiveName() {
        return objectiveName;
    }

    public void setObjectiveName(String objectiveName) {
        this.objectiveName = objectiveName;
    }

    public Date getObjectiveCompletionDate() {
        return objectiveCompletionDate;
    }

    public void setObjectiveCompletionDate(Date objectiveCompletionDate) {
        this.objectiveCompletionDate = objectiveCompletionDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public double getObjectiveCompletion(){
        return tasks.stream()
                .filter(task -> task.getCompletionStatus() == true)
                .count()/tasks.size();
    }

}
