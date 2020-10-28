package bg.sofia.uni.fmi.mjt.jira.issues;

import java.time.LocalDateTime;

import bg.sofia.uni.fmi.mjt.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueResolution;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueStatus;
import bg.sofia.uni.fmi.mjt.jira.enums.WorkAction;

public class Task extends Issue {
	public Task(IssuePriority priority, Component component, String description) {
		super(priority,component,description);
	}
	@Override
	public void resolve(IssueResolution resolution) {
		setResolution(resolution);
		setStatus(IssueStatus.RESOLVED);
		//setLastModifiedOn(LocalDateTime.now());
		
	}
	
	@Override
	public void addAction(WorkAction action, String description) {
		if(!action.equals(WorkAction.FIX) && !action.equals(WorkAction.IMPLEMENTATION) && !action.equals(WorkAction.TESTS)) {
			super.addAction(action, description);
		}
		else {
			throw new IllegalStateException("Error: Cannot add action");
		}

	}
}
