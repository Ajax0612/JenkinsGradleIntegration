package com.selenium.listeners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.selenium.testCases.Test;
import com.slack.api.methods.SlackApiException;

public class TestListeners implements ITestListener {
	
	public List<ITestNGMethod> passedtests = new ArrayList<ITestNGMethod>();
	public List<ITestNGMethod> failedtests = new ArrayList<ITestNGMethod>();
	public List<ITestNGMethod> skippedtests = new ArrayList<ITestNGMethod>();

	@Override
	public void onTestSuccess(ITestResult result) {
		//add the passed tests to the passed list

        passedtests.add(result.getMethod());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//add the failed tests to the failed list
        failedtests.add(result.getMethod());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

        //add the skipped tests to the skipped list
       skippedtests.add(result.getMethod());
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {

		try {
			Test.publishReportsInSlak(context.getPassedTests().size(), context.getFailedTests().size(),
					context.getSkippedTests().size(), context.getSuite().getName());
		} catch (Throwable e) {
			e.printStackTrace();

		}
	}

}
