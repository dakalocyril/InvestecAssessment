package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.TestBase;


public class InvestecPages extends TestBase {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[text()='Focus insights']")
	WebElement btnFocusInsights;
	
	@FindBy(xpath = "//*[@class='js-search-hitArea search-toggler__hitArea']")	
	WebElement search;
	
	@FindBy(xpath = "//*[@class='tabs-horizontal__tab '][@data-id='tab3']")
	WebElement btnMyMoney;
	
	@FindBy(xpath = "//*[@id='searchBoxInput']")
	WebElement searchInput;
	
	@FindBy(xpath = "//*[@id='searchBoxButton']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//*[@class='content-hub-search-results__title ng-binding']")
	public List<WebElement> searchResults;
	//it has to be a list
	
	@FindBy(xpath="//*[@class='button-primary content-hub-form-container__button js-content-hub-form-container-button']")
	WebElement btnSignUp;
	
	@FindBy(xpath="//*[@name='name']")
	WebElement signUpTextBoxName;
	//public List<WebElement> signupTexBox;

	@FindBy(xpath="//*[@name='surname']")
	WebElement signUpTextBoxSurname;

	@FindBy(xpath="//*[@name='email']")
	WebElement signUpTextBoxEmail;

	@FindBy(xpath = "//*[@data-di-id='di-id-26b11945-99badbd1']")
	WebElement relevants;
	
	@FindBy(xpath = "//*[@class='forms__submit cta-primary']")
	WebElement btnSubmit;

	public InvestecPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickInsight()
	{
		waitForClickable(btnFocusInsights);
		btnFocusInsights.click();
	}
	
	public void clickOnSearch()
	{
		waitForClickable(search);
		search.click();
	}
	
	public void clickOnMyMoney()
	{
		waitForClickable(btnMyMoney);
		btnMyMoney.click();
	}
	
	public void searchInput()
	{
		searchInput.sendKeys("cash investment rates");
	}
	
	public void searchBtn()
	{
		searchBtn.click();
	}
	
	public void searchResults(int index)
	{
		waitForClickable(searchResults.get(index));
		searchResults.get(index).click();
	}
	
	public void btnSignUp()
	{
		waitForClickable(btnSignUp);
		javaScriptClick(btnSignUp);
		//btnSignUp.click();
	}
	
	public void signupTexBoxName()
	{
		signUpTextBoxName.sendKeys("Dakalo");
		signUpTextBoxSurname.sendKeys("Dakalo");
		signUpTextBoxEmail.sendKeys("test@investec.co.za");
		//signupTexBox.get(1).sendKeys("Dakalo");
		//signupTexBox.get(2).sendKeys("Dakalo");
	}

	public void relevantInsight()
	{
		waitForClickable(relevants);
		relevants.click();
	}

	public void btnSubmit()
	{
		waitForClickable(btnSubmit);
		javaScriptClick(btnSubmit);
	}

	public String thankYouTxt()
	{
		WebElement text = driver.findElement(By.xpath("//*[text()='Thank you']"));
		return text.getText().toString();
	}

}
