package com.qk.common.function;

public class ExecutionReport {

	private String testcaseid;
	private String ActualResult;
	private String Module;
	//private String Submodule;
	private String ExecutionStatus;
	private int StatusCode;
	private long ExecutionTime;
	
	public String getModule() {
		return Module;
	}
	public void setModule(String Module) {
		this.Module = Module;
	}
	
	/*
	 * public String getSubmodule() { return Submodule; } public void
	 * setSubmodule(String Submodule) { this.Submodule = Submodule; }
	 */
	
	public String getTestcaseid() {
		return testcaseid;
	}
	public void setTestcaseid(String testcaseid) {
		this.testcaseid = testcaseid;
	}
	
	public String getExecutionStatus() {
		return ExecutionStatus;
	}
	public void setExecutionStatus(String ExecutionStatus) {
		this.ExecutionStatus = ExecutionStatus;
	}
	
	public int getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(int StatusCode) {
		this.StatusCode = StatusCode;
	}
	
	public String getActualResult() {
		return ActualResult;
	}
	public void setActualResult(String ActualResult) {
		this.ActualResult = ActualResult;
	}
	
	public long getExecutionTime() {
		return ExecutionTime;
	}
	public void setExecutionTime(long ExecutionTime) {
		this.ExecutionTime = ExecutionTime;
	}
	
}
