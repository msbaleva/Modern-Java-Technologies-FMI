package bg.sofia.uni.fmi.mjt.jira;

import bg.sofia.uni.fmi.mjt.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueResolution;
import bg.sofia.uni.fmi.mjt.jira.enums.WorkAction;
import bg.sofia.uni.fmi.mjt.jira.issues.Bug;
import bg.sofia.uni.fmi.mjt.jira.issues.Component;
import bg.sofia.uni.fmi.mjt.jira.issues.Feature;
import bg.sofia.uni.fmi.mjt.jira.issues.Task;
public class Tests {
	public static void main(String[] args) {
		Jira jira=new Jira();
		Task t  = new Task(IssuePriority.TRIVIAL,new Component("ala","FMI"),"alabala");
		jira.addIssue(t);
		System.out.println(t.getIssueID());
		t.addAction(WorkAction.RESEARCH,"аза");
		System.out.println(t.getStatus());
		t.resolve(IssueResolution.FIXED);
		System.out.println(t.getIssueID());
		System.out.println(t.getStatus());
		Bug b=new Bug(IssuePriority.CRITICAL,new Component("bala","portokala"),"dfg");
		jira.addIssue(b);
		Component c = new Component("c1","comp");
		Feature f2 = new Feature(IssuePriority.MAJOR,c,"der");
		f2.addAction(WorkAction.DESIGN, "v ev");
		f2.addAction(WorkAction.IMPLEMENTATION, "v ev");
		f2.addAction(WorkAction.TESTS, "v ev");
		f2.resolve(IssueResolution.FIXED);
		System.out.println(f2.getIssueID());
		jira.addIssue(f2);
		System.out.println(f2.getIssueID());
		jira.addActionToIssue(f2, WorkAction.RESEARCH, "dsvvr");
		Feature f = new Feature(IssuePriority.CRITICAL,new Component("bala","portokala"),"dfg");
		f.addAction(WorkAction.IMPLEMENTATION,"asa");
		f.addAction(WorkAction.TESTS,"ajja");
		f.addAction(WorkAction.FIX,"asa");
		f.addAction(WorkAction.DESIGN,"ajja");
		f.resolve(IssueResolution.FIXED);
		b.addAction(WorkAction.FIX,"asa");
		b.addAction(WorkAction.TESTS,"ajja");
		b.resolve(IssueResolution.FIXED);
		System.out.println(b.getStatus());
		System.out.println(f.getStatus());
		System.out.println(f.getIssueID());
		System.out.println(b.getIssueID());
	}

}
