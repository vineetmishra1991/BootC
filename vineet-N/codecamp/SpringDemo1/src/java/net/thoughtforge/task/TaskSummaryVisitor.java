package net.thoughtforge.task;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskSummaryVisitor implements TaskVisitor {

	private Map<String, TaskSummary> taskSummaries = new HashMap<String, TaskSummary>();
	
	private long totalDuration;
	
	public TaskSummaryVisitor(Long totalDuration) {
		this.totalDuration = totalDuration;
	}
	
	public void visit(Task task) {
		TaskSummary taskSummary = taskSummaries.get(task.getName());
		if (taskSummary == null) {
			taskSummary = new TaskSummary(task.getName());
			taskSummaries.put(task.getName(), taskSummary);
		}
		
		taskSummary.addExecutionTime(task.getDuration());
	}
	
	public String printTaskSummaries() {
		StringBuffer taskSummaries = new StringBuffer();
		taskSummaries.append('\n');

		taskSummaries.append("-------------------------------------------------------------------------------------------------\n");
		taskSummaries.append("Invocations\tTotal Time(%)\tTotal Time(ms)\tMin Time\tMax Time\tAverage Time(ms)\tTask Name\n");
		taskSummaries.append("-------------------------------------------------------------------------------------------------\n");
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMinimumIntegerDigits(5);
		nf.setGroupingUsed(false);
		
		NumberFormat pf = NumberFormat.getPercentInstance();
		pf.setMinimumIntegerDigits(3);
		pf.setGroupingUsed(false);
		
		List<TaskSummary> taskSummaryList = new ArrayList<TaskSummary>(this.taskSummaries.values());
		for (TaskSummary taskSummary: taskSummaryList) {
			taskSummaries.append(nf.format(taskSummary.getNumberOfExecutions()) + "\t\t");
			taskSummaries.append(pf.format((taskSummary.getTotalDuration() / 1000.0) / (this.totalDuration / 1000.0)) + "\t\t");
			taskSummaries.append(nf.format(taskSummary.getTotalDuration()) + "\t\t");
			taskSummaries.append(nf.format(taskSummary.getMinDuration()) + "\t\t");
			taskSummaries.append(nf.format(taskSummary.getMaxDuration()) + "\t\t");
			taskSummaries.append(nf.format(taskSummary.getAverageDuration()) + "\t\t\t");
			taskSummaries.append(taskSummary.getName() + "\n");
		}

		return taskSummaries.toString();
	}
	
	private class TaskSummary {
		private List<Long> executionTimes = new ArrayList<Long>();

		private String name;
		
		public TaskSummary(String name) {
			this.name = name;
		}
		
		public void addExecutionTime(Long executionTime) {
			executionTimes.add(executionTime);
		}
		
		public long getAverageDuration() {
			return getTotalDuration()/executionTimes.size();
		}
		
		public List<Long> getExecutionTimes() {
			return executionTimes;
		}
		
		public long getMinDuration() {
			long minDuration = executionTimes.get(0);
			
			for (Long duration : executionTimes) {
				minDuration = Math.min(minDuration, duration);
			}
			
			return minDuration;
		}

		public long getMaxDuration() {
			long maxDuration = executionTimes.get(0);
			
			for (Long duration : executionTimes) {
				maxDuration = Math.max(maxDuration, duration);
			}
		  
			return maxDuration;
		}
		
		public long getNumberOfExecutions() {
			return executionTimes.size();
		}
		
		public long getTotalDuration() {
			long totalExecutionTime = 0;
			
			for (Long executionTime: executionTimes) {
				totalExecutionTime += executionTime;
			}
			
			return totalExecutionTime;
		}
		
		public String getName() {
			return name;
		}
	}
}
