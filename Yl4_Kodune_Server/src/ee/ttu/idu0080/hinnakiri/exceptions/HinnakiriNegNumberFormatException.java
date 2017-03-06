package ee.ttu.idu0080.hinnakiri.exceptions;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.ws.WebFault;

@WebFault(name = "HinnakiriNegNumberFormatFault")
public class HinnakiriNegNumberFormatException extends Exception {
	private HinnakiriNegNumberFormatFault faultInfo;
	
	public HinnakiriNegNumberFormatException(){
		this("Number cannot be negative");
	}
	
	public HinnakiriNegNumberFormatException(String message) {
		super(message);
		
		faultInfo = new HinnakiriNegNumberFormatFault();
		faultInfo.setMessage(message);
	}

	public HinnakiriNegNumberFormatException(String message, HinnakiriNegNumberFormatFault faultInfo){
		super(message);
		
		this.faultInfo = faultInfo;
	}
	
	public HinnakiriNegNumberFormatFault getFaultInfo(){
		return faultInfo;
		
	}
	
	
}
