import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Test;

public class TestConcatenation {
    @Test
    public void test_concatenation() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0, document.body.scrollHeight)", "");

        Select selectFirstElement = new Select(driver.findElement(By.id("selectBuild")));
        selectFirstElement.selectByVisibleText("Prototype");

        WebElement firstInput = driver.findElement(By.id("number1Field"));
        firstInput.sendKeys("gs");

        WebElement secondInput = driver.findElement(By.id("number2Field"));
        secondInput.sendKeys("bu");

        Select selectSecondElement = new Select(driver.findElement(By.id("selectOperationDropdown")));
        selectSecondElement.selectByVisibleText("Concatenate");

        WebElement buttonResult = driver.findElement(By.id("calculateButton"));
        buttonResult.click();

        WebElement answerInput = driver.findElement(By.id("numberAnswerField"));
        String result = answerInput.getAttribute("value");
        System.out.println("В поле Answer значение равно: "+result);
        Assert.assertEquals(result, "gsbu");
        if (result.equals("gsbu")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}
