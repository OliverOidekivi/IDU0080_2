package ee.ttu.idu0080.hinnakiri.exceptions;
import javax.xml.ws.WebFault;

@WebFault(name = "HinnakiriPrecisionFormatFault")
public class HinnakiriPrecisionFormatException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HinnakiriPrecisionFormatFault faultInfo;
	
	public HinnakiriPrecisionFormatException(){
		this("Number can have maximum precision of two decimal points");
		
	}

	public HinnakiriPrecisionFormatException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
		
		faultInfo = new HinnakiriPrecisionFormatFault();
		faultInfo.setMessage(message);
	}
	
	public HinnakiriPrecisionFormatException(String message,
			HinnakiriPrecisionFormatFault faultInfo) {
		// TODO Auto-generated constructor stub
		super(message);
		
		this.faultInfo = faultInfo;
	}
	
	
	public HinnakiriPrecisionFormatFault getFaultInfo(){
		return faultInfo;
	}
	
	
	
	
	
	
	
	

}
