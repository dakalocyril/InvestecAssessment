package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.InvestecPages;
import testbase.TestBase;

public class InvestecSignUpTest extends TestBase {
	
	@Test
	public void investecSignUpTest() throws InterruptedException
	{
		InvestecPages investec = new InvestecPages(driver);
		
		investec.clickInsight();
		investec.clickOnMyMoney();
		investec.searchInput();
		investec.searchBtn();
		investec.searchResults(0);
		investec.btnSignUp();
		investec.signupTexBoxName();
		investec.relevantInsight();
		investec.btnSubmit();
		verifyEquals(investec.thankYouTxt(), investec.thankYouTxt());
	}

}
