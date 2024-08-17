import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

public class TesteRegrasDeNegocios {
	
	@Test
	public void regraDeNegocios() {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta =  driver.switchTo().alert();
		
		Assert.assertEquals("Nome eh obrigatorio", alerta.getText());
		alerta.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("nome");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertEquals("Sobrenome eh obrigatorio", alerta.getText());
		alerta.accept();
		
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("teste");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertEquals("Sexo eh obrigatorio", alerta.getText());
		alerta.accept();
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alerta.getText());
		alerta.accept();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alerta.getText());
		alerta.accept();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		
		Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
		
		combo.selectByVisibleText("O que eh esporte?");
		combo.selectByVisibleText("Natacao");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertEquals("Voce faz esporte ou nao?", alerta.getText());
		alerta.accept();
		
		
	}

}
