package udea;

import java.util.Random;

public class CodeBreaker {
	
	public String secret;
	
	
	public CodeBreaker() {
		String generador="";
		Random random = new Random();
		String ran = "";
		int i=0;
		//String ran = String.format("%04d", random.nextInt(10000));
		//System.out.println(ran);
		while(i<4) {
			ran = String.format("%01d", random.nextInt(10));
			//generador += ran;
			if (!generador.contains(ran)) {
				generador+=ran;
				i++;
			}
		}
		System.out.println(generador);
		this.secret = generador;
	}
	
	public CodeBreaker(String secret) {
		this.secret = secret;
	}

	public boolean longitudeNumber(String number) {
		
		return (number!=null) && (number.length()==4);
	}
	
	public boolean validateNumeric(String number)  {				
		boolean result;
		try {
			Integer.parseInt(number);
			result=true;
		} catch (NumberFormatException c){
			result=false;
		}
		return result;
	}
	
	public String validarCoincidencia(String number){
		
		String result ="";
		String aux_ = "";
		
		for(int i = 0; i < secret.length(); i++) {			
			if(secret.charAt(i) == number.charAt(i)) {
				result += "X";
			}else if(secret.contains(number.substring(i, i+1))) {				
				aux_ += "_";
			}
		}
		result += aux_;
		return result;
	}
}
