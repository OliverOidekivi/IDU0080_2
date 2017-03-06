package ee.ttu.idu0080.hinnakiri;

/**
 * Klient hinnakirja teenusele
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.ws.soap.SOAPFaultException;



import ee.ttu.idu0080.hinnakiri.exceptions.HinnakiriNegNumberFormatException;
import ee.ttu.idu0080.hinnakiri.exceptions.HinnakiriNumberFormatException;
import ee.ttu.idu0080.hinnakiri.exceptions.HinnakiriPrecisionFormatException;
import ee.ttu.idu0080.hinnakiri.exceptions.HinnakiriZeroNumberFormatException;
import ee.ttu.idu0080.hinnakiri.service.HinnakiriService;
import ee.ttu.idu0080.hinnakiri.service.HinnakiriService_Service;
import ee.ttu.idu0080.hinnakiri.types.GetHinnakiriResponse;
import ee.ttu.idu0080.hinnakiri.types.Hinnakiri;
import ee.ttu.idu0080.hinnakiri.types.Hinnakiri.HinnakirjaRida;

/**
 * This class was generated by Apache CXF 2.2.6 Thu Mar 04 16:26:57 EET 2010
 * Generated source version: 2.2.6
 * 
 */

public final class Klient {

	public static void main(String args[]) throws Exception {
		URL wsdlURL = parseArguments(args);

		ArrayList isikukoodid = new ArrayList();		
		
		isikukoodid.add("39608170498");
		isikukoodid.add("39613170494");
		isikukoodid.add("398081704987");
		isikukoodid.add("312081704987");
		isikukoodid.add("396081707");
		isikukoodid.add("39608170498L");
		
		GetHinnakiriResponse response = null;
		
		
		for(int i = 0; i<10; i++){
		
		try {
			HinnakiriService_Service service = new HinnakiriService_Service(
					wsdlURL);
			HinnakiriService port = service.getHinnakiriPort();

			//response = port.getHinnakiri("12.00A");
			//response = port.getHinnakiri("12A");
			response = port.getHinnakiri("12.34");
			//response = port.getHinnakiri("12.340");
			//response = port.getHinnakiri("12.345");
			//response = port.getHinnakiri("12.0");
			//response = port.getHinnakiri("-12.0");
			//response = port.getHinnakiri("0.000");
			
			
			System.out.println(" korras");
			printToConsole(response.getHinnakiri());
			break;
			
		} catch(HinnakiriNumberFormatException e) {
			System.out.println("Hind ei ole numbrilises formaadis");
			break;
		}catch(HinnakiriNegNumberFormatException e){
			System.out.println("Hind ei tohi olla negatiivne "+ e );
			break;
		} catch (HinnakiriZeroNumberFormatException e) {
			System.out.println("Hind ei tohi olla null "+ e );	
			break;
		} catch(HinnakiriPrecisionFormatException e){
			System.out.println("Hind v�ib olla maksimaalselt kahe komakoha t�psusega "+ e );	
			break;
		}
		catch (SOAPFaultException e){
			System.out.println("soapfaultexception"+":"+e);
		} catch (Exception e){
			System.out.println("Yldine viga"+e);
			if(i==9){
			e.printStackTrace();
			}
		}

		Thread.sleep(2000);
		
		}
		
		
		
		if(response == null)
			return;
		
		printToConsole(response.getHinnakiri());
	}

	/**
	 * Prindib konsoolile hinnakirja
	 * 
	 * @param hinnakiri
	 */
	private static void printToConsole(Hinnakiri hinnakiri) {

		System.out.println("Hinnakiri:");

		for (HinnakirjaRida hinnakirjaRida : hinnakiri.getHinnakirjaRida()) {
			StringBuilder outRida = new StringBuilder();
			outRida.append(hinnakirjaRida.getToode().getKood());
			outRida.append("\t");
			outRida.append(hinnakirjaRida.getToode().getNimetus());
			outRida.append("\t");
			outRida.append(hinnakirjaRida.getHind().getSumma());
			outRida.append(" ");
			outRida.append(hinnakirjaRida.getHind().getValuuta());

			System.out.println(outRida);
		}
	}

	/**
	 * Parsib välja programmi argumentide hulgast WSDL-i URL-i
	 * 
	 * @param args
	 *            argumendid
	 * @return URL
	 */
	private static URL parseArguments(String[] args) {

		URL wsdlURL = HinnakiriService_Service.WSDL_LOCATION;

		try {
			if (args.length > 0) {
				String firstArg = args[0];

				if (firstArg.startsWith("http:")) {
					wsdlURL = new URL(firstArg);
				} else {
					File wsdlFile = new File(firstArg);
					if (wsdlFile.exists()) {
						wsdlURL = wsdlFile.toURI().toURL();
					} else {
						wsdlURL = new URL(firstArg);
					}
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return wsdlURL;
	}

}
