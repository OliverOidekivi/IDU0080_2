package ee.ttu.idu0080.hinnakiri.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HinnakiriZeroNumberFormatFault")
public class HinnakiriZeroNumberFormatFault {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HinnakiriZeroNumberFormatFault(){}
	

}
