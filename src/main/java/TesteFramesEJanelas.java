import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFramesEJanelas {
	
	private WebDriver driver;
	private DSL dsl;
		
	
	@Before
	public void inicializa() {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.close();		
	}
	
	@Test
	public void deveInteragirComFrame() {
		dsl.entrarNoFrame("frame1");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		dsl.sairFrame();
		dsl.escreve("elementosForm:nome", msg);
	}
	
	@Test
	public void deveInteragirComJanejas() {
		dsl.clicarBotao("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escreve(By.tagName("textarea"), "deu certo?");
		driver.close();
		dsl.trocarJanela("");
		dsl.escreve("elementosForm:sugestoes", "deu certo");
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() {
		dsl.clicarBotao("buttonPopUpHard");
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		dsl.trocarJanela((String)driver.getWindowHandles().toArray()[1]);
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		dsl.escreve(By.tagName("textarea"),"deu certo?");
		driver.close();
		dsl.trocarJanela((String)driver.getWindowHandles().toArray()[0]);
		dsl.escreve(By.tagName("textarea"),"deu certo");
	}

}
