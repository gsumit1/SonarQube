/*
public class ABC {
  
	public int getUniqueElementInPage() {
		return null; // Noncompliant {{Avoid using null return, use return webElementFacade instead}}
	}
    
}*/

public class NullReturn {
    
    public String invalidMethod() { 
        return null; // Noncompliant {{Avoid using null return, use return webElementFacade instead}}
    }
    
    public String validMethod() { 
        return ""; 
    }
}