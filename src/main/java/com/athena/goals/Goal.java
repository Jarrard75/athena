package com.athena.goals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Goal {

    private String goalName;
    private Date completionDate;
    private List<Milestone> milestones;

    public Goal(String goalName, Date completionDate) {
        this.goalName = goalName;
        this.completionDate = completionDate;
        this.milestones = new ArrayList<Milestone>();
    }

    public Goal(String goalName, Date completionDate, List<Milestone> milestones) {
        this.goalName = goalName;
        this.completionDate = completionDate;
        this.milestones = milestones;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public Date getGoalCompletionDate() {
        return completionDate;
    }

    public void setGoalCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public List<Milestone> getMilestones() {
        return milestones;
    }

    public void setMilestones(List<Milestone> milestones) {
        this.milestones = milestones;
    }

    public double getGoalCompletion(){
        if(milestones.size() != 0){
            return milestones.stream()
                    .filter(milestone -> milestone.getMilestoneCompletion() == 1.0)
                    .count()/milestones.size();
        }
        else{
            return 0.00;
        }
    }
}
