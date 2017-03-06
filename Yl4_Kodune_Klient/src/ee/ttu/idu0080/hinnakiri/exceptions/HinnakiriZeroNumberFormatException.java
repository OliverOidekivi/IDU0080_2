package ee.ttu.idu0080.hinnakiri.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "HinnakiriZeroNumberFormatFault")
public class HinnakiriZeroNumberFormatException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HinnakiriZeroNumberFormatFault faultInfo;
	
	public HinnakiriZeroNumberFormatException(){
		this("Number can not be zero");
		
	}

	public HinnakiriZeroNumberFormatException(String message) {
		super(message);
		
		faultInfo = new HinnakiriZeroNumberFormatFault();
		faultInfo.setMessage(message);
	}
	
	public HinnakiriZeroNumberFormatException(String message,
			HinnakiriZeroNumberFormatFault faultInfo) {
		super(message);
		
		this.faultInfo = faultInfo;
	}
	
	
	public HinnakiriZeroNumberFormatFault getFaultInfo(){
		return faultInfo;
	}
	
	
	
	
}
