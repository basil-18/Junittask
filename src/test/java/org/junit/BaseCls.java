package org.junit;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseCls {
	public static WebDriver jun;
	public BaseCls() {
		PageFactory.initElements(jun, this);
	}
	@FindBy(xpath="//select[@name='location']")	private WebElement loc;
	@FindBy(xpath="//select[@id='hotels']")	private WebElement hote;
	@FindBy(xpath="//select[@id='room_type']")	private WebElement roTy;
	@FindBy(xpath="//select[@id='room_nos']") private WebElement roNo;
	@FindBy(xpath="//select[@id='adult_room']") private WebElement adRo;
	@FindBy(xpath="//select[@id='child_room']") private WebElement chRo;
	@FindBy(xpath="//input[@id='Submit']") private WebElement sea;
	@FindBy(id="radiobutton_0") private WebElement rdio;
	@FindBy(name="continue") private WebElement con;
	@FindBy(name="first_name") private WebElement fN;
	@FindBy(name="last_name") private WebElement lN;
	@FindBy(name="address") private WebElement add;
	@FindBy(id="cc_num") private WebElement ccN;
	@FindBy(id="cc_type") private WebElement ccT;
	@FindBy(name="cc_exp_month") private WebElement expM;
	@FindBy(name="cc_exp_year") private WebElement expY;
	@FindBy(id="cc_cvv") private WebElement ccV;
	@FindBy(xpath="//input[@id='book_now']") private WebElement bN;
	@FindBy(xpath="//input[@id='order_no']") private WebElement oN;
	public static void pageUrl() {
		String url = jun.getCurrentUrl();
		System.out.println(url);
	}public static void pageTilte() {
		String title = jun.getTitle();
		System.out.println(title);
	}public static void chromeDriver() {
		WebDriverManager.chromedriver().setup();
		jun=new ChromeDriver();
	}public static void lanuchUrl(String url) {
		jun.get(url);
	}public static void maxWindow() {
		jun.manage().window().maximize();
	}public static void waits() {
		jun.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}public static void textBox(WebElement element,String value ) {
		element.sendKeys(value);
	}public static void btnClk(WebElement ref) {
		ref.click();
	}public static void drop(WebElement jun,int index) {
		Select s=new Select(jun);
		s.selectByIndex(index);
	}
	public static String readExcel(int rowNo,int cellNo) throws IOException {
		File f=new File("C:\\Users\\lenovo\\eclipse-workspace\\Junit\\Excels\\juni.xlsx");
		FileInputStream fin=new FileInputStream(f);
		Workbook bo=new XSSFWorkbook(fin);
		Sheet sh = bo.getSheet("hotel");
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();
		String name="";
		if (type==1) {
			 name = c.getStringCellValue();
		} else if(DateUtil.isCellDateFormatted(c)) {
			Date da = c.getDateCellValue();
			SimpleDateFormat form=new SimpleDateFormat("dd-mm-yyyy");
			 name = form.format(da);
		}else {
			double d = c.getNumericCellValue();
			long l=(long)d;
			name=String.valueOf(l);
		}
		
		return name;
	}
	public static WebDriver getJun() {
		return jun;
	}
	public WebElement getLoc() {
		return loc;
	}
	public WebElement getHote() {
		return hote;
	}
	public WebElement getRoTy() {
		return roTy;
	}
	public WebElement getRoNo() {
		return roNo;
	}
	public WebElement getAdRo() {
		return adRo;
	}
	public WebElement getChRo() {
		return chRo;
	}
	public WebElement getSea() {
		return sea;
	}
	public WebElement getRdio() {
		return rdio;
	}
	public WebElement getCon() {
		return con;
	}
	public WebElement getfN() {
		return fN;
	}
	public WebElement getlN() {
		return lN;
	}
	public WebElement getAdd() {
		return add;
	}
	public WebElement getCcN() {
		return ccN;
	}
	public WebElement getCcT() {
		return ccT;
	}
	public WebElement getExpM() {
		return expM;
	}
	public WebElement getExpY() {
		return expY;
	}
	public WebElement getCcV() {
		return ccV;
	}
	public WebElement getbN() {
		return bN;
	}
	public WebElement getoN() {
		return oN;
	}
	

}
