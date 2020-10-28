package bg.sofia.uni.fmi.mjt.jira.issues;

import java.time.LocalDateTime;

import bg.sofia.uni.fmi.mjt.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueResolution;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueStatus;
import bg.sofia.uni.fmi.mjt.jira.enums.WorkAction;

public abstract class Issue {
	
	private String issueID;
	private String description;
	private IssuePriority priority;
	private IssueResolution resolution;
	private IssueStatus status;
	private Component component;
	private String[] actionLog;
	private int numberOfActions;
	private LocalDateTime createdOn;
	private LocalDateTime lastModifiedOn;
	private static int numberOfIssues;
	protected boolean hasResearch;
	protected boolean hasDesign;
	protected boolean hasImplementation;
	protected boolean hasTests;
	protected boolean hasFix;
	private static final int MAX_ACTIONS=20;
	public Issue(IssuePriority priority, Component component, String description) {
		this.issueID=component.getShortName() + "-" + numberOfIssues++;
		this.description=description;
		this.priority=priority;
		this.resolution=IssueResolution.UNRESOLVED;
		this.status=IssueStatus.OPEN;
		this.component=component;
		actionLog=new String[MAX_ACTIONS];
		createdOn=LocalDateTime.now();
		lastModifiedOn=LocalDateTime.now();
	}
	public static int getNumberOfIssues() {
		return numberOfIssues;
	}
	public String getIssueID() { 
		return issueID; 
	    }
	public String getDescription() {
		return description;
	    }
	public IssuePriority getPriority() { 
		return priority; 
		}
	public IssueResolution getResolution() { 
		return resolution;
		}
	public IssueStatus getStatus() { 
		return status; 
		}
	public Component getComponent() { 
		return component;
		}
	public LocalDateTime getCreatedOn() { 
		return createdOn; 
		}
	public LocalDateTime getLastModifiedOn() { 
		return lastModifiedOn; 
		}
	public String[] getActionLog() { 
		return actionLog;  
		}
    public void setLastModifiedOn(LocalDateTime lastModifiedOn) {
    	this.lastModifiedOn=lastModifiedOn;
    }
	public void setStatus(IssueStatus status) {
		this.status=status;
		lastModifiedOn=LocalDateTime.now();
	}
	public void setResolution(IssueResolution resoultion) {
		this.resolution=resoultion;
		lastModifiedOn=LocalDateTime.now();
	}
	public void addAction(WorkAction action, String description) {
		if(numberOfActions == MAX_ACTIONS || description == null || action==null) {
			throw new IllegalStateException("Error: Reached capacity");
		}
		else {
		   actionLog[numberOfActions++]=action.toString().toLowerCase() + ": " + description;
		   lastModifiedOn=LocalDateTime.now();
		   switch(action) {
		   case RESEARCH : hasResearch = true; break;
		   case DESIGN : hasDesign = true; break;
		   case IMPLEMENTATION : hasImplementation = true; break;
		   case TESTS : hasTests = true; break;
		   case FIX : hasFix = true; 
		   }
		}
		
	}

	public abstract void resolve(IssueResolution resolution);

}
