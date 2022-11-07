import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNGListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<< TestMethod started >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<< TestMethod passed >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<< TestMethod failed >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<< TestMethod Skipped >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
