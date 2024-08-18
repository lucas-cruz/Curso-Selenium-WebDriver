import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class TesteRegrasDeNegocios {
	
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
	public void regraDeNegocios() {
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
		
		dsl.escreve("elementosForm:nome", "nome");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
		
		dsl.escreve("elementosForm:sobrenome", "teste");
		dsl.clicarBotao("elementosForm:cadastrar");
		
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
		
		dsl.clicarRadio("elementosForm:sexo:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
		
		
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:1");
		dsl.clicarBotao("elementosForm:cadastrar");
		
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
		
		
		dsl.clicarRadio("elementosForm:comidaFavorita:1");
		
		
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");		
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
		
		
		
	}

}
