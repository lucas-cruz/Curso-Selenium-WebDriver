import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}

	/*** TextField e TextArea***/
	public void escreve(By by, String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}

	public void escreve(String id_campo, String texto) {
		escreve(By.id(id_campo),texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	
	/*** radio e check***/
	public void clicarRadio(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public boolean isRadioSelected(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}
	
	public boolean isCheckboxSelected(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}
	
	/*** combo ***/
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	public String obterValorCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public int obterQuantidadeOpcoesCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		
		List<WebElement> options = combo.getOptions();
		return options.size();		
	}
	
	public boolean verificarOpcaoCombo(String id, String opcao) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		
		List<WebElement> options = combo.getOptions();
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals(opcao)) {
				encontrou = true;
				break;
			}
		}
		return encontrou;
	}
	
	
	/*** Botao ***/
	public void clicarBotao(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	/*** Link ***/
	public void clicarLink(String id) {
		driver.findElement(By.linkText(id)).click();
	}
	
	/*** texto ***/
	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}
	
	public String obterTexto(String by) {
		return driver.findElement(By.id(by)).getText();
	}


	/*** Alerts ***/

	public String alertaObterTextoEAceita() {
		Alert alerta = driver.switchTo().alert();
		String texto = alerta.getText();
		alerta.accept();
		return texto;
	}

	public Object alertaObterTextoENega() {
		Alert alerta = driver.switchTo().alert();
		String texto = alerta.getText();
		alerta.dismiss();
		return texto;
	}

	public String alertaObterTexto() {
		Alert alerta = driver.switchTo().alert();
		String texto = alerta.getText();
		return texto;
	}

	public void alertaEscrever(String valor) {
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys(valor);
		alerta.accept();
	}


	/*** Frames e Janelas***/

	public void entrarNoFrame(String id) {
		driver.switchTo().frame(id);
	}

	public void sairFrame() {
		driver.switchTo().defaultContent();		
	}

	public void trocarJanela(String id) {
		driver.switchTo().window(id);
	}
		
}
