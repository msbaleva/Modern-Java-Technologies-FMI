package bg.sofia.uni.fmi.mjt.jira.issues;

import java.time.LocalDateTime;

import bg.sofia.uni.fmi.mjt.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueResolution;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueStatus;

public class Feature extends Issue {
	
	public Feature(IssuePriority priority, Component component, String description) {
		super(priority,component,description);
	}
	@Override
	public void resolve(IssueResolution resolution) {
		if(hasDesign && hasImplementation && hasTests) {
			setResolution(resolution);
			setStatus(IssueStatus.RESOLVED);
			//setLastModifiedOn(LocalDateTime.now());
			}
			else {
				throw new IllegalStateException("Error: Cannot resolve feature");
			}
	}
	
}
