

import org.junit.Assert;
import org.testng.annotations.Test;

public class dependsonmethod {
	
	@Test
	public void login()
	{
	System.out.println("in login");
	}
	@Test(dependsOnMethods="login")
	public void Search()
	{
	System.out.println("in Search");
	Assert.assertEquals("abc", "xyz");
	}
	@Test(dependsOnMethods="Search",alwaysRun=true)
	public void logout()
	{
	System.out.println("in logout");
	}
}
