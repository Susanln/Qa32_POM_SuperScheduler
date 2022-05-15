package configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;

public class ListenerTest implements ITestListener, ISuiteListener, ITestNGListener, IClassListener,IConfigurationListener
,IDataProviderListener,IExecutionListener,IInvokedMethodListener,IReporter{
    Logger logger = LoggerFactory.getLogger(ListenerTest.class);

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
    }

    @Override
    public void onBeforeClass(ITestClass testClass) {
        IClassListener.super.onBeforeClass(testClass);
        logger.info("Start in class---->  "+ testClass.getName());
    }

    @Override
    public void onAfterClass(ITestClass testClass) {
        IClassListener.super.onAfterClass(testClass);
        logger.info("Finish in class--->"+ testClass.getName());
    }
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info("Start--->" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info("Test success--->"+ result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.info("Test 'FAILED'--->"+ result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.info("Test skipped--->"+ result.getName());
    }

}
