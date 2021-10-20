package br.ce.anderson;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CadastroClientes.CampoTreinamentoPage;
import CadastrodeFuncionario03.DSL;

public class treino10 {

	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;


	@Before
	public void inicializa(){
		System.setProperty("webdriver.gecko.driver", ".exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		//Clica no "link"
		driver.get("https://sgconline-306117.uc.r.appspot.com/index.jsp");
		//Incerir dados no Email "@gmail.com"
		driver.findElement(By.id("inputEmail")).sendKeys("@gmail.com");
		Assert.assertEquals("@gmail.com", driver.findElement(By.id("inputEmail")).getAttribute("value"));
		//Incerir dados no elemento senha "12345678"
	    driver.findElement(By.id("inputPassword")).sendKeys("12345678");
	    Assert.assertEquals("4802142", driver.findElement(By.id("inputPassword")).getAttribute("value"));
	    //Clicar no elemento "continuar"
	    driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);


	}
	@After
	public void finaliza() throws InterruptedException{
		Thread.sleep(3000);
		driver.close();
	}

	@Test
	public void deveInteragirComRelatorio() throws InterruptedException {
	    Thread.sleep(5000);
	    //Clica em Relatorio
	    page.setClicaEMRelatorio();
	    
	    //Clica em Grafico Financeiro
	    page.setClicaEMGraficoFinanceiro();
	    
	    //Clica em Seleciona Ano
	    page.setClicaEMSelecionaAno();
	    
	    //Clica Selecionar o Nome Jorge Dos Santos
	    page.setClicaEMSelecionaNomeJorje();
	    
	    //Incerir Ano 
		page.setClicaEmAno("2021");
	    Assert.assertEquals("2021", dsl.ClicaemAnoCampo("filtroAno"));

		//Clica em Pesquisar
		page.setClicaEMPesquisa();
	}
}

}
