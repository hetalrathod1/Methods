package NopcommerceWebsite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class category
{
    // intializing webdriver
    protected WebDriver driver;
    static String currentdatetime()
    {
        //create date format object
        DateFormat dateFormat=new SimpleDateFormat("MM/dd/yy/HH/ss");
        // current date time with date
        Date date=new Date();
        //date formation
        String date1=dateFormat.format(date);
        return date1;
    }
    @Before
    public void setUp()
    {
        // giving chrome webdriver path
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //implicity wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // giving url
        driver.get("https://demo.nopcommerce.com/");
        // maximise window
        driver.manage().window().maximize();

    }
    @Test
    public void userShouldBeRegisterSuccessfully() {
        // click on register to register new user
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        // click on gender male
        driver.findElement(By.id("gender-male")).click();

        //click on gender female
        driver.findElement(By.id("gender-female")).click();

        // enter first name
        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("hetal");

        //enter last name
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Rathod");

        // enter email id
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("hetal1234" + currentdatetime() + "@gmail.com");

        //enter password
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("1234567");

        //enter confirm password
        driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("1234567");

        // click on register button
        driver.findElement(By.xpath("//input[@name='register-button']")).click();

        //actual result
        String actualRegistrationSuccessMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("Your registration completed", actualRegistrationSuccessMessage);
    }
    @Test
    public void login()
    {
        // click on login
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        // enter email id
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("chirag@gmail.com");
        //enter password
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("123456");
        // click on log in button
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        //actual result
         String actresult=driver.findElement(By.linkText("Log out")).getText();
         Assert.assertEquals("Log out",actresult);
        System.out.println("user should be able to register successfully ");

    }

    @Test
    public void computer()
    {
        //click on computer link
        driver.findElement(By.linkText("Computers")).click();
        // click on notebook
        driver.findElement(By.partialLinkText("Notebooks")).click();
        // actual result
        String actresult=driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals("Notebooks",actresult);
        System.out.println(" User should be able to navigate to Nootebook catetory page");

    }
    @Test
    public void electronics()
    {
        // click on electronics catogary link

        driver.findElement(By.linkText("Electronics")).click();
        //click on cellphones link
        driver.findElement(By.partialLinkText("Cell phones")).click();
        //actual
        String actresult=driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals("Cell phones",actresult);
        System.out.println("User should be able to navigate cell phone page via Electronics");
    }

    @Test
    public void add_to_cart()
    {
        // clik on jewelery catogory
        driver.findElement(By.linkText("Jewelry")).click();

        // click on product name flower girl bracelet
        driver.findElement(By.partialLinkText("Flower Girl Bracelet")).click();

        // click on add to cart
       driver.findElement(By.xpath("//input[@id='add-to-cart-button-41']")).click();

       // actual result
       String actresult = driver.findElement(By.xpath("//p[@class='content']")).getText();
       Assert.assertEquals("The product has been added to your shopping cart",actresult);
//        // Create object of WebDriverWait class
//        WebDriverWait wait=new WebDriverWait(driver,20);
//        // Wait till the element is not visible
//        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));

       // printing msg in consol
        System.out.println("User should be able to add product to shopping cart");
    }
    @After

    public void tearDown()
    {
        driver.quit();
    }



}
