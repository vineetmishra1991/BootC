package net.thoughtforge.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TaskTimer {

	private List<Task> completedTasks = new ArrayList<Task>();
	
	private Long endTime;
	
	private String id;
	
	private Long startTime;
	
	private Stack<Task> taskStack = new Stack<Task>();
	
	public TaskTimer(String id) {
		this.id = id;
	}
	
	public long getTaskCount() {
		return taskStack.size();
	}
	
	public long getTotalDuration() {
		return endTime - startTime;
	}
	
	public String printSummary() {
		StringBuffer summary = new StringBuffer(shortSummary());
		summary.append('\n');

		TaskSummaryVisitor taskSummaryVisitor = new TaskSummaryVisitor(getTotalDuration());
		for (Task task: completedTasks) {
			taskSummaryVisitor.visit(task);
		}
		
		summary.append(taskSummaryVisitor.printTaskSummaries());
		
		return summary.toString();
	}
	
	public String shortSummary() {
		return "TaskTimer '" + this.id + "': running time (millis) = " + getTotalDuration();
	}
	
	public void start(String name) {
		Long startTime = System.currentTimeMillis();
		
		if (taskStack.isEmpty()) {
			this.startTime = startTime;
		}
		
		taskStack.push(new Task(name, startTime));
	}
	
	public void stop() {
		Long endTime = System.currentTimeMillis();
		
		Task currentTask = taskStack.pop();
		currentTask.setEndTime(endTime);
		
		if (taskStack.isEmpty()) {
			this.endTime = endTime;
		}
		
		completedTasks.add(currentTask);
	}
}
