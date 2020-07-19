package com.selenium.testCases;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import com.selenium.listeners.TestListeners;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

public class Test {

	static String token = "xoxb-1187942178775-1201229307766-0s5FUV4OLNVNSkAhND46PkvH";
	TestListeners count;

	
	public static void publishReportsInSlak(int passed, int failed, int skipped, String suiteName) throws IOException, SlackApiException {


		Slack s = new Slack();
		// Initialize an API Methods client with the given token
		MethodsClient methods = s.methods(token);
		// Build a request object
		/*ChatPostMessageRequest request = ChatPostMessageRequest.builder().channel("brokerage")
				.text("*Pipeline Name : " + suiteName + "* \nTotal Passed : " + passed + "\nTotal Failed : " + failed
						+ "\nTotal Skipped : " + skipped + "")
				.build();*/
		ChatPostMessageRequest request = ChatPostMessageRequest.builder().channel("brokerage")
				.attachmentsAsString("C:\\Users\\Ajinkya\\Desktop\\RELIANCE.txt").build();

		// Get a response as a Java object
		//ChatPostMessageResponse response = methods.chatPostMessage(request);
		ChatPostMessageResponse response = methods.chatPostMessage(request);
		System.out.println(response.toString());

	}
}
