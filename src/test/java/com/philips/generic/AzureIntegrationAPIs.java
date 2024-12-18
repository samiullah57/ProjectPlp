package com.philips.generic;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

public class AzureIntegrationAPIs {
	public static List<TestCaseDetails> testcasedetails = new ArrayList<TestCaseDetails>();

	/*private static String baseUrl = "https://dev.azure.com/partnerSrinivasGangappa/DemoProject/_apis";
	private static String accesstoken = "OnZtaTV4Mmh2MzRiNXV6eXEzeGJmbHhlaTQydnh0eGx5bWVqbnhuZGI0ajdkaWl5b2tpdmE=";
	 */
	private static String baseUrl = "https://dev.azure.com/PhilipsAgile/7.0%20DC%20M2O-Markets/_apis";
	private static String accesstoken = "OmF6ZTdldWZzNWxoZXFzNGoydHVxemhsbmkyZHN5YjZ1eXg1NXZwZ3h5YjV3aXV5d21vcWE=";

	public static HashMap<String, String> clonedSuiteDetails;
	public static String projectname ="7.0 DC M2O-Markets";
	//public static String RegressionsuiteID = "853584";	// Source Suite ID
	public static String parentSuiteID = "873460"; 		// destination suite ID
	public static String planID = "224193";		  		// destination Plan ID
	public static String suiteID = null;
	public static String SuiteName = null;
	public static String opID = null;
	public static String Runid = null;

	// End Points
	private static String createTestPlan = baseUrl + "/testplan/plans?api-version=5.1-preview.1";
	private static String cloneTestSuites = baseUrl + "/testplan/Suites/CloneOperation?api-version=5.1-preview.2";
	private static String createRun = baseUrl + "/test/runs?api-version=5.1";

	public static void main(String args[]) throws ParseException 
	{
		fetchTestData();
	}

	public static void fetchTestData() 
	{
		try
		{
			cloneTestSutites(parentSuiteID, AutomationConstants.AzureSuiteID);
			Runid = CreateTestRun();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public static void cloneTestSutites(String destinationSuiteid, String sourceSuiteId)
			throws ClientProtocolException, IOException {
		JSONObject requestbody = new JSONObject();
		JSONObject cloneoption = new JSONObject();
		JSONObject destinationSuite = new JSONObject();
		JSONObject source = new JSONObject();
		source.put("id", sourceSuiteId);
		destinationSuite.put("id", destinationSuiteid);
		//destinationSuite.put("project", "7.0 DC M2O-Markets");
		destinationSuite.put("project", projectname);
		cloneoption.put("copyAllSuites", true);
		requestbody.put("cloneOptions", cloneoption);
		requestbody.put("destinationTestSuite", destinationSuite);
		requestbody.put("sourceTestSuite", source);
		StringEntity params = new StringEntity(requestbody.toString());
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postrequest = new HttpPost(cloneTestSuites);
		postrequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		postrequest.setHeader("Authorization", "Basic " + accesstoken);
		postrequest.setEntity(params);
		HttpResponse response = httpClient.execute(postrequest);
		JSONObject jsonresponse = new JSONObject(new BasicResponseHandler().handleResponse(response));
		//suiteID = jsonresponse.getJSONObject
		opID = jsonresponse.getJSONObject("cloneOperationResponse").get("opId").toString();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("OpID is "+opID);
		getCloneOptionID();
		updateSuiteName(SuiteName, suiteID);
	}

	public static String CreateTestRun() throws ClientProtocolException, IOException {
		getAllTestcaseDetails();
		int[] pointId = new int[testcasedetails.size()];
		for (int i = 0; i < testcasedetails.size(); i++) {
			pointId[i] = Integer.parseInt(testcasedetails.get(i).testPointId);
		}
		JSONObject requestbody = new JSONObject();
		requestbody.put("automated", true);
		requestbody.put("name", "TestRunAutomation");
		requestbody.put("state", "InProgress");
		JSONObject plan = new JSONObject();
		plan.put("id", planID);
		requestbody.put("plan", plan);
		requestbody.put("type", "Web");
		requestbody.put("pointIds", pointId);
		StringEntity params = new StringEntity(requestbody.toString());
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postrequest = new HttpPost(createRun);
		postrequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		postrequest.setHeader("Authorization", "Basic " + accesstoken);
		postrequest.setEntity(params);
		try
		{
			HttpResponse response = httpClient.execute(postrequest);
			JSONObject jsonresponse = new JSONObject(new BasicResponseHandler().handleResponse(response));
			Runid = jsonresponse.get("id").toString();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		}
		return Runid;
	}
	public static void getCloneOptionID() throws ClientProtocolException, IOException
	{
		HashMap<String, String> newQuoteDetails = new HashMap<String, String>();
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getrequest = new HttpGet(baseUrl + "/testplan/Suites/CloneOperation/"+opID+"?api-version=5.1-preview.2");
		getrequest.setHeader(HttpHeaders.ACCEPT, "application/json");
		getrequest.setHeader("Authorization", "Basic " + accesstoken);
		try
		{
			HttpResponse response = httpClient.execute(getrequest);
			JSONObject jsonresponse = new JSONObject(new BasicResponseHandler().handleResponse(response));
			suiteID = jsonresponse.getJSONObject("clonedTestSuite").get("id").toString();
			SuiteName = jsonresponse.getJSONObject("clonedTestSuite").get("name").toString();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		}
	}

	public static void updateSuiteName(String suiteName, String suiteID) throws ClientProtocolException, IOException
	{
		JSONObject requestbody = new JSONObject();
		JSONObject defaultConfigurations = new JSONObject();
		defaultConfigurations.put("id", suiteID);
		defaultConfigurations.put("name", suiteName);
		requestbody.put("name", suiteName+"_"+Utility.getFormatedDateTime());
		requestbody.put("defaultConfigurations",defaultConfigurations);
		StringEntity params = new StringEntity(requestbody.toString());
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPatch postrequest = new HttpPatch(baseUrl + "/testplan/Plans/"+planID+"/suites/"+suiteID+"?api-version=5.1-preview.1");
		postrequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		postrequest.setHeader("Authorization", "Basic " + accesstoken);
		postrequest.setEntity(params);
		HttpResponse response = httpClient.execute(postrequest);
		JSONObject jsonresponse = new JSONObject(new BasicResponseHandler().handleResponse(response));

	}

	public static void getAllTestcaseDetails() throws ClientProtocolException, IOException
	{
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getrequest = new HttpGet(baseUrl + "/testplan/Plans/"+planID+"/Suites/"+suiteID+"/TestCase");
		getrequest.setHeader(HttpHeaders.ACCEPT, "application/json");
		getrequest.setHeader("Authorization", "Basic " + accesstoken);
		HttpResponse response = httpClient.execute(getrequest);
		JSONObject jsonresponse = new JSONObject(new BasicResponseHandler().handleResponse(response));
		JSONArray array = jsonresponse.getJSONArray("value");
		for (int i = 0; i < array.length(); i++) {
			String testSuitId = array.getJSONObject(i).getJSONObject("testSuite").get("id").toString();
			String testsuitename = array.getJSONObject(i).getJSONObject("testSuite").get("name").toString();
			String testcasename = array.getJSONObject(i).getJSONObject("workItem").get("name").toString();
			String testcaseId = array.getJSONObject(i).getJSONObject("workItem").get("id").toString();
			String testPointId = array.getJSONObject(i).getJSONArray("pointAssignments").getJSONObject(0).get("id")
					.toString();
			TestCaseDetails test = new TestCaseDetails(testSuitId, testsuitename, testcaseId, testcasename,
					testPointId);
			testcasedetails.add(test);

		}
	}

	public static void UpdateResults(String testCaseID, String status) throws ClientProtocolException, IOException
	{
		UpdateTestCase(getTestresults(Runid, testCaseID), Runid, status);	
	}

	public static void UpdateTestCase(String testresultId, String runid, String outcome)
			throws ClientProtocolException, IOException {
		JSONObject requestbody = new JSONObject();
		JSONArray ja = new JSONArray();
		requestbody.put("id", testresultId);
		requestbody.put("state", "Completed");
		requestbody.put("outcome", outcome);
		ja.put(requestbody);
		StringEntity params = new StringEntity(ja.toString());
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPatch patchrequest = new HttpPatch(baseUrl +"/test/Runs/"+ runid +"/results?api-version=5.1");
		patchrequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		patchrequest.setHeader("Authorization", "Basic " + accesstoken);
		patchrequest.setEntity(params);
		try {
			HttpResponse response = httpClient.execute(patchrequest);
			JSONObject jsonresponse = new JSONObject(new BasicResponseHandler().handleResponse(response));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		}
	}

	public static String getTestresults(String runid,String testCaseid) throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getrequest = new HttpGet(baseUrl + "/test/Runs/"+runid+"/results?api-version=5.1");
		getrequest.setHeader(HttpHeaders.ACCEPT, "application/json");
		getrequest.setHeader("Authorization", "Basic " + accesstoken);
		HttpResponse response = httpClient.execute(getrequest);
		JSONObject jsonresponse = new JSONObject(new BasicResponseHandler().handleResponse(response));
		JSONArray testresultArray = jsonresponse.getJSONArray("value");
		String testResultId = null;
		String testId = null;
		int count = 0;
		for (int i = 0; i < testresultArray.length(); i++) 
		{
			testId = testresultArray.getJSONObject(i).getJSONObject("testCase").getString("id").toString();
			if(testId.equalsIgnoreCase(testCaseid))
			{
				testResultId = testresultArray.getJSONObject(i).get("id").toString();
				break;				
			}
			else if(count<testresultArray.length())
			{
				count++;
			}
			else
			{
				System.out.println("unable to locate the test case ID");
			}
		}
		return testResultId;


	}
	public static void updateTestRun() throws ClientProtocolException, IOException {
		JSONObject requestbody = new JSONObject();
		requestbody.put("state", "Completed");
		StringEntity params = new StringEntity(requestbody.toString());
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPatch postrequest = new HttpPatch(baseUrl+"/test/runs/" + Runid	+ "?api-version=5.1");
		postrequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		postrequest.setHeader("Authorization", "Basic " + accesstoken);
		postrequest.setEntity(params);
		HttpResponse response = httpClient.execute(postrequest);
		JSONObject jsonresponse = new JSONObject(new BasicResponseHandler().handleResponse(response));

	}
}
