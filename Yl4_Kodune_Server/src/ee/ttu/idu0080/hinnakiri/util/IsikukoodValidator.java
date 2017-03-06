package ee.ttu.idu0080.hinnakiri.util;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


public class IsikukoodValidator {
	
	private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d{11}$");
	
	
	public static boolean isValid(final String number){
		
		System.out.println("Saabunud vaartus " + number);
		
		return StringUtils.isNotBlank(number)&& NUMBER_PATTERN.matcher(number).matches()
				&& calculateChecksum(number) == NumberUtils.toInt(number.substring(10));
				
		
	}


	private static int calculateChecksum(String number) {
		// TODO Auto-generated method stub
		int remainder = calculateWeightRemainder(number, new int[]{1,2,3,4,5,6,7,8,9,1});
		if(remainder < 10){
			return remainder;
		}
		if(remainder == 10){
			remainder = calculateWeightRemainder(number, new int[]{3,4,5,6,7,8,9,1,2,3});
			
		}
		
		return remainder < 10 ? remainder:0;
	}


	private static int calculateWeightRemainder(String number, final int[] weights) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		for(int i = 0; i<weights.length; i++){
			sum += NumberUtils.toInt(number.substring(i, i + 1))*weights[i];
			
		}
		
		
		return sum % 11;
	}	

}
