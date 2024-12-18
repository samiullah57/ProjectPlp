package com.philips.generic;

public class TestCaseDetails {
	String testSuiteId;
	String testSuiteName;
	String testCaseId;
	String testCasename;
	String testPointId;
	String testResultId;
	public TestCaseDetails(String testSuiteId, String testSuiteName, String testCaseId, String testCasename,
			String testPointId) {
		super();
		this.testSuiteId = testSuiteId;
		this.testSuiteName = testSuiteName;
		this.testCaseId = testCaseId;
		this.testCasename = testCasename;
		this.testPointId = testPointId;
	}

	@Override
	public String toString() {
		return "TestCaseDetails [testSuiteId=" + testSuiteId + ", testSuiteName=" + testSuiteName + ", testCaseId="
				+ testCaseId + ", testCasename=" + testCasename + ", testPointId=" + testPointId + ", testResultId="
				+ testResultId + "]";
	}

	public String getTestSuiteId() {
		return testSuiteId;
	}
	public void setTestSuiteId(String testSuiteId) {
		this.testSuiteId = testSuiteId;
	}
	public String getTestSuiteName() {
		return testSuiteName;
	}
	public void setTestSuiteName(String testSuiteName) {
		this.testSuiteName = testSuiteName;
	}
	public String getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}
	public String getTestCasename() {
		return testCasename;
	}
	public void setTestCasename(String testCasename) {
		this.testCasename = testCasename;
	}
	public String getTestPointId() {
		return testPointId;
	}
	public void setTestPointId(String testPointId) {
		this.testPointId = testPointId;
	}
	public String getTestResultId() {
		return testResultId;
	}
	public void setTestResultId(String testResultId) {
		this.testResultId = testResultId;
	}
}
