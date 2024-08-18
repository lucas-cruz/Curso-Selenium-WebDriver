import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
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
	public void teste() {
	}
	
	@Test
	public void testeTextField() {
		dsl.escreve("elementosForm:nome", "teste");
		Assert.assertEquals("teste", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void deveInteragirComTextArea() {
		dsl.escreve("elementosForm:sugestoes", "teste selenium");
		Assert.assertEquals("teste selenium", dsl.obterValorCampo("elementosForm:sugestoes"));
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioSelected("elementosForm:sexo:0"));
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		Assert.assertTrue(dsl.isCheckboxSelected("elementosForm:comidaFavorita:0"));
	}
	
	@Test
	public void deveInteragirComCombo() {
		dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
		//assertiva
		Assert.assertEquals("Mestrado", dsl.obterValorCombo("elementosForm:escolaridade"));		
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));	
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		
	
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
	}
	
	@Test
	public void deveInteragirComBotao() {	
		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("Value"));
	}
	
	@Test
	public void deveInteragirComLink() {
		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}
	
	@Test
	public void deveBuscarTexto() {
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
	}

}
