package org.junit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JunitPro extends BaseCls {
	@BeforeClass
	public static void befCla() {
		chromeDriver();maxWindow();waits();
		lanuchUrl("http://adactinhotelapp.com/");
	}@Before
	public void bef() {
		pageTilte();pageUrl();
		WebElement use = jun.findElement(By.id("username"));
		textBox(use, "basil123");
		WebElement pasw = jun.findElement(By.id("password"));
		textBox(pasw, "basil142");
		WebElement loin = jun.findElement(By.id("login"));
		btnClk(loin);
	}@Test
	public void ts() throws IOException {
		BaseCls p=new BaseCls(); 
		JavascriptExecutor j=(JavascriptExecutor)jun;
		waits();
		WebElement loc = p.getLoc();drop(loc, 1);
		WebElement hote = p.getHote();drop(hote, 2);
		WebElement roTy = p.getRoTy();drop(roTy, 1);
		WebElement roNo = p.getRoNo();drop(roNo, 1);
		WebElement adRo = p.getAdRo();drop(adRo, 1);
		WebElement chRo = p.getChRo();drop(chRo, 0);
		WebElement sea = p.getSea();btnClk(sea);
		WebElement rdio = p.getRdio();btnClk(rdio);
		WebElement con = p.getCon();btnClk(con);
		WebElement fN = p.getfN();textBox(fN, readExcel(0, 1));
		WebElement ln = p.getlN();textBox(ln, readExcel(1, 1));
		WebElement add = p.getAdd();textBox(add, readExcel(2, 1));
		WebElement ccN = p.getCcN();textBox(ccN, readExcel(3, 1));
		WebElement ccT = p.getCcT();drop(ccT, 2);
		WebElement expM = p.getExpM();drop(expM, 8);
		WebElement expY = p.getExpY();drop(expY, 10);
		WebElement ccV = p.getCcV();textBox(ccV, readExcel(4, 1));
		WebElement bN = p.getbN();btnClk(bN);
		WebElement oN = p.getoN();System.out.println(oN.getAttribute("value"));
		String order = oN.getAttribute("value");
		File f=new File("C:\\Users\\lenovo\\eclipse-workspace\\Junit\\Excels\\juni.xlsx");
		Workbook bo=new XSSFWorkbook();
		Sheet sh = bo.createSheet("hotel");
		Row r = sh.createRow(7);
		Cell c = r.createCell(0);
		c.setCellValue(order);
		FileOutputStream fo=new FileOutputStream(f);
		bo.write(fo);
		
		
	}

}
