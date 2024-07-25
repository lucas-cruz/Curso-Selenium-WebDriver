import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {
	
	@Test
	public void teste() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		
		driver.quit();
	}

}
