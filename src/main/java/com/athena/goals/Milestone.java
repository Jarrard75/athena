package com.athena.goals;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Milestone {

    private String goalName;
    private String milestoneName;
    private Date completionDate;
    private List<Objective> objectives;

    public Milestone(String goalName, String milestoneName, Date completionDate) {
        this.goalName = goalName;
        this.milestoneName = milestoneName;
        this.completionDate = completionDate;
        this.objectives = new ArrayList<Objective>();
    }

    public Milestone(String goalName, String milestoneName, Date completionDate, List<Objective> objectives) {
        this.goalName = goalName;
        this.milestoneName = milestoneName;
        this.completionDate = completionDate;
        this.objectives = objectives;
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

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public double getMilestoneCompletion(){
        return objectives.stream()
                .filter(objective -> objective.getObjectiveCompletion() == 1.0)
                .count()/objectives.size();
    }
}
