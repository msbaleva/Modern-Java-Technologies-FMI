package bg.sofia.uni.fmi.mjt.jira.issues;

import java.time.LocalDateTime;

import bg.sofia.uni.fmi.mjt.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueResolution;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueStatus;

public class Bug extends Issue{
	
	public Bug(IssuePriority priority, Component component, String description) {
		super(priority,component,description);
	}
	@Override
	public void resolve(IssueResolution resolution) {
		if(hasFix && hasTests) {
		setResolution(resolution);
		setStatus(IssueStatus.RESOLVED);
		//setLastModifiedOn(LocalDateTime.now());
		}
		else {
			throw new IllegalStateException("Error: Cannot resolve bug");
		}
	}

}
