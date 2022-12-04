package module1;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	ExtentReports extent = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("extentreport.html");
  @Test
  public void f1() 
  {
	  ExtentTest test=extent.createTest("launch browser");
	  test.log(Status.PASS, "user lauch browser");
	  test.pass("user open browser verified");
     
  }
  @Test
  public void f2() 
  {
	  ExtentTest test=extent.createTest("open app");
	  test.fail("open url");
  }
  @Test
  public void f3() 
  {
	  ExtentTest test=extent.createTest("login");
	  test.pass("user enter password");
  }
  @Test
  public void f4() 
  {
	  ExtentTest test=extent.createTest("username");
	  test.pass("username entered");
  }
  @Test
  public void f5() 
  {
	  ExtentTest test=extent.createTest("verify password");
	  test.pass("pasword verified");
  }
  @Test
  public void f6() 
  {
	  ExtentTest test=extent.createTest("click login btn");
	  test.fail("could not login");
  }
  @BeforeTest
  public void beforeTest() {
	  
	  extent.attachReporter(spark);
  }

  @AfterTest
  public void afterTest()
  {
	  extent.flush();
  }

}
