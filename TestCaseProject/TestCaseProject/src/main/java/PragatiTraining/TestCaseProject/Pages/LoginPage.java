package PragatiTraining.TestCaseProject.Pages;

import PragatiTraining.AutomationFrameworkAPI.WebTest;
import PragatiTraining.AutomationFrameworkAPI.Utilities.Utils;
import java.util.HashMap;


public class LoginPage {
	
	WebTest T;
	//public HashMap<String,String>ObjectRepo=new HashMap<String,String>();
	public LoginPage(String BrowserName) {
		T=new WebTest();
		Utils.InitialisEnvWars();
		T.StartTest(BrowserName);
		//T.CreateObjectRepository("LoginPage");
	}
	
	public void DoLogin(String UserName,String Password) {
		EnterUserName(UserName);
		EnterPassword(Password);
		ClickSignInButton();
		
		//T.EnterText(T.ObjectRepo.get("UserNameField"),UserName);
		//T.EnterText(T.ObjectRepo.get("PasswordField"),Password);
		//T.ClickElement(T.ObjectRepo.get("SignInButton"));
	}


	public void EnterUserName(String UserName) {
		
		T.EnterText(T.ObjectRepo.get("UserNameField"),UserName);
	}
	
	public void EnterPassword(String Password) {
	
		T.EnterText(T.ObjectRepo.get("PasswordField"),Password);
	}
	
	
	public void ClickSignInButton() {
		T.ClickElement(T.ObjectRepo.get("SigninButton"));
		
	}
	
}
