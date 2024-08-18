import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {
	
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
	public void deveInteragirComAlertSimples() {
		dsl.clicarBotao("alert");
		String text = dsl.alertaObterTextoEAceita();	
		Assert.assertEquals("Alert Simples", text);
	
		driver.findElement(By.id("elementosForm:nome")).sendKeys(text);
	}
	
	@Test
	public void deveInteragirComAlertConfirm() {
		dsl.clicarBotao("confirm");
		
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
		
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
	}
	
	
	@Test
	public void deveInteragirComAlertPrompt() {
		dsl.clicarBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("03");
		Assert.assertEquals("Era 03?", dsl.alertaObterTextoEAceita());
		Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
	}

}
