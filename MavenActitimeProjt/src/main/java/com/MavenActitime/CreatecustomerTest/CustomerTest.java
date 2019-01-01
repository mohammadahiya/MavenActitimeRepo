package com.MavenActitime.CreatecustomerTest;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.MavenActitime.genericlib.Baseclass;
import com.MavenActitime.objrepository.Activecustomersandprojectpage;
import com.MavenActitime.objrepository.Home;
import com.MavenActitime.objrepository.OpenTask;
import com.MavenActitime.objrepository.Createnewcustomerpage;


public class CustomerTest extends Baseclass{
@Test
public void Createcustomertest() throws Throwable
{
	Home hm=PageFactory.initElements(driver, Home.class);
	hm.navigatetotask();
	
	OpenTask Otpage=PageFactory.initElements(driver, OpenTask.class);
	Otpage.navigatetoprojectscustpage();
	
	Activecustomersandprojectpage acp=PageFactory.initElements(driver, Activecustomersandprojectpage.class);
	acp.navigatetocreatenewcustomerpage();
	
	String customername=flib.getexceldata("readsinglecell", 1, 2);
	//String ecpmsg=flib.getexceldata("readsinglecell", 1, 3);
	
	com.MavenActitime.objrepository.Createnewcustomerpage cnsp=PageFactory.initElements(driver, Createnewcustomerpage.class);
	cnsp.createcustomer(customername);
	//Thread.sleep(2000);
	/*String actmsg=acp.getsucmsg().getText();
	//System.out.println(actmsg);
	boolean status=actmsg.contains(ecpmsg);
	//System.out.println(ecpmsg);
	Assert.assertTrue(status);
*/
}
}
