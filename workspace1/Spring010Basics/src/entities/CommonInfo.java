package entities;

public class CommonInfo {
	private String companyName;
	
	CommonInfo()
	{
		System.out.println("Object Created");
	}
	
	
	public String getCompanyName() {//companyName
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	
}
