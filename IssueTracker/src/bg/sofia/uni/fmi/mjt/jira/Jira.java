package bg.sofia.uni.fmi.mjt.jira;

import bg.sofia.uni.fmi.mjt.jira.enums.IssueResolution;
import bg.sofia.uni.fmi.mjt.jira.enums.WorkAction;
import bg.sofia.uni.fmi.mjt.jira.interfaces.Filter;
import bg.sofia.uni.fmi.mjt.jira.interfaces.Repository;
import bg.sofia.uni.fmi.mjt.jira.issues.Issue;

public class Jira implements Filter, Repository {
	 
	
	 private Issue[] issues;
	 private static final int MAX_ISSUES=100;
	 private int totalNumberOfIssues;
	 public Jira() {
    	 issues=new Issue[MAX_ISSUES];
     }
	 
	 @Override
	 public Issue find(String issueID) {
		 for(int i=0;i<totalNumberOfIssues;i++) {
			 if (issues[i].getIssueID().equals(issueID)) {
				 return issues[i];
			 }
		 }
		 
		 return null;
	 }
	 
	 @Override
	 public void addIssue(Issue issue){
		 if(find(issue.getIssueID()) == null && issue != null) {
		  if(totalNumberOfIssues == MAX_ISSUES) {
			  throw new IllegalStateException("Error: Reached capacity");
		  }
		  else {
			  issues[totalNumberOfIssues++]=issue;
		  }
		 }
		 else {
			 throw new IllegalStateException("Error: Issue already exists");
		 }
	 }
	 public void addActionToIssue(Issue issue, WorkAction action, String actionDescription) {
		 if(issue == null || action == null || actionDescription == null) {
			 throw new IllegalStateException("Error: Issue already exists");
		 }
		 issue.addAction(action, actionDescription);
	 }
	 public void resolveIssue(Issue issue, IssueResolution resolution) {
		 if(issue == null || resolution == null) {
			 throw new IllegalStateException("Error: Issue already exists");
		 }
		 issue.resolve(resolution);
	 }
    
}
