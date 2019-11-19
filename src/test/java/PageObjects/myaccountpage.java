package PageObjects;

public class myaccountpage extends pageActions {
	
	

	// Xpath For Registration Forms 
//	public  String txtEmail = "xpath://*[@id='txtEmail']"; 
//	public  String txtUserName = "xpath://*[@id='txtUserName']"; 
//	public  String txtPassword = "xpath://*[@id='txtPassword']"; 
//	public  String txtCnfPassword = "xpath://*[@id='txtCnfPassword']"; 
//	public  String txtFirstName = "xpath://*[@id='txtFirstName']"; 
//	public  String txtLastName = "xpath://*[@id='txtLastName']"; 
//	public String txtAddress = "xpath://input[contains(@placeholder,'Address')]"; 
//	public  String check_news = "xpath://input[@name='check_news']"; 
//	public  String btnRegister = "xpath://*[@id='btnRegister']"; 
//
//	
//	
	public  String myccountPageLavel = "xpath://*[@id='item_details']/section/div/h3"; 

	
	
	public boolean validateMyAccountLabelExist(String LabelName) {
		try {
			String expResult =  LabelName;		
			String actualREsult = getElementValue(myccountPageLavel);
			if(expResult.equalsIgnoreCase(actualREsult)) {
				return  true;
			} else {
				return  false;
			}
		}catch(Exception e) {

			return  false;
		}
		
	}
	
	
//	public  void completeRegistration(String email, String userName, String Lname) {
//		
//		typeOn(txtEmail, email);
//		typeOn(txtUserName, userName);
//		typeOn(txtPassword, "Abc123");
//		typeOn(txtCnfPassword, "Abc123");
//		typeOn(txtFirstName, "MR");
//		typeOn(txtLastName, Lname);
//		typeOn(txtAddress, "123 5th Avenue");
//		
//		clickElement(check_news);
//		clickElement(btnRegister);
//		
//	}


}
