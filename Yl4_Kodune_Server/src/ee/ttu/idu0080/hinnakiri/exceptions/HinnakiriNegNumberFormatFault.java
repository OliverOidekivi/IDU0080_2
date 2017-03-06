package ee.ttu.idu0080.hinnakiri.exceptions;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.ws.WebFault;

@XmlRootElement(name = "HinnakiriNegNumberFormatFault")
public class HinnakiriNegNumberFormatFault {
	
	private String message;
	
	public HinnakiriNegNumberFormatFault(){}
	
	public String getMessage(){
		
		return message;
		
	};
	
	public void setMessage(String message){
		this.message = message;
		
	};
	
	

}
