package com.athena.goals;

import java.util.Calendar;
import java.util.Date;

public class Task {

    private String goalName;
    private String milestoneName;
    private String objectiveName;
    private String taskName;
    private Date projectedTaskCompletionDate;
    private boolean completionStatus;

    public Task(String goalName, String milestoneName, String objectiveName, String taskName, Date projectedTaskCompletionDate) {
        this.goalName = goalName;
        this.milestoneName = milestoneName;
        this.objectiveName = objectiveName;
        this.taskName = taskName;
        this.projectedTaskCompletionDate = projectedTaskCompletionDate;
        this.completionStatus = false;
    }

    public Task(String goalName, String milestoneName, String objectiveName, String taskName) {
        this.goalName = goalName;
        this.milestoneName = milestoneName;
        this.objectiveName = objectiveName;
        this.taskName = taskName;
        this.projectedTaskCompletionDate = new Date(System.currentTimeMillis());
        this.completionStatus = false;
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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getProjectedTaskCompletionDate() {
        return projectedTaskCompletionDate;
    }

    public void setProjectedTaskCompletionDate(Date projectedTaskCompletionDate) {
        this.projectedTaskCompletionDate = projectedTaskCompletionDate;
    }

    public boolean getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }
}
