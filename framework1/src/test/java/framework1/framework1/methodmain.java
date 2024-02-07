package framework1.framework1;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
public class methodmain {
	public static WebDriver driver ;
	public static void main(String[] args) {
		methods met=new methods();
		met.driverSetup();
		met.extra();
		met.search();
        met.logo(); 
        met.signup();
        met.dataput();
        met.close();
        
        
	}

}
