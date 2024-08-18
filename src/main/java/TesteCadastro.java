import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastro {
	
	
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
	public void Cadastro() {
		
		dsl.escreve("elementosForm:nome", "teste");
		dsl.escreve("elementosForm:sobrenome", "teste");
		dsl.clicarRadio("elementosForm:sexo:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		
		dsl.selecionarCombo("elementosForm:escolaridade","Superior");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		
		dsl.clicarBotao("elementosForm:cadastrar");
		
		
		
	}
	
	

}
