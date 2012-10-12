package net.thoughtforge.task;

public class Task {
	
	private Long endTime;
	
	private String name;
	
	private Long startTime;
	
	public Task(String name, Long startTime) {
		this.name = name;
		this.startTime = startTime;
	}
	
	public long getDuration() {
		return endTime - startTime;
	}

	public Long getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	
	public String getName() {
		return name;
	}
	
	public Long getStartTime() {
		return startTime;
	}
}