import hsa.*;
public class Enigma {

    public static void main (String[] args) {
	int input;
	// Below is declaration of all 'keys': plug and plug_1 have the same six characters to represent self mapping. Everything else has different characters in the respective 'space' below.
	String keyboard = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	String plug     = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String plug_1   = "ABCDEFHGJILKNMPORQTSVUXWZY";
	
	String r3   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	String r3_1 = "NCLRGKVQJBDPAIHYUEMZXFSOTW";
	
	String r2   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String r2_1 = "LXNCKEQTAMJSPVUWYDIZRHOFBG";
	
	String r1   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String r1_1 = "HQOSUEYVZGWRAKILXDMPJTCBFN";
	
	String reflector    = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	String reflector_1  = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
	
	// Initial settings 
	 
	String ini3 = "Q";
	
	r3 = r3.substring(r3.indexOf(ini3)) + r3.substring(0, r3.indexOf(ini3));
	r3_1 = r3_1.substring(r3.indexOf(ini3)) + r3_1.substring(0, r3.indexOf(ini3));
	
	String ini2 = "B";
	
	r2 = r2.substring(r2.indexOf(ini2)) + r2.substring(0, r2.indexOf(ini2));
	r2_1 = r2_1.substring(r2.indexOf(ini2)) + r2_1.substring(0, r2.indexOf(ini2));
	
	String ini1 = "X";
	
	r1 = r1.substring(r1.indexOf(ini1)) + r1.substring(0, r1.indexOf(ini1));
	r1_1 = r1_1.substring(r1.indexOf(ini1)) + r1_1.substring(0, r1.indexOf(ini1));
	Stdout.println(r1);
      
	// Below, input represents the position of the 'stored character' - no need for extra variables taking up memory. 
	// The counter variable represents the amount of inputs given, and is used in the calculations of wheher the rotors should rotate or not.    
	for (int counter = 0; true; counter++) { 
	    // Takes user input, and converts to upper case (as a QOL improvement)
	    input = keyboard.indexOf(Character.toUpperCase(Stdin.readChar()));
	    
	    // Plugboard
	    input = plug.indexOf(plug_1.charAt(input));
	    
	    // Rotor3
	    input = r3.indexOf(r3_1.charAt(input));
	    
	    // Rotor2
	    input = r2.indexOf(r2_1.charAt(input));

	    // Rotor1
	    input = r1.indexOf(r1_1.charAt(input));
	    
	    // Reflector
	    input = reflector.indexOf(reflector_1.charAt(input));
	    
	    // Returning rotors
	    // Rotor1 backwards
	    input = r1_1.indexOf(r1.charAt(input));
	    
	    // Rotor2 backwards
	    input = r2_1.indexOf(r2.charAt(input));
	    
	    // Rotor3 backwards
	    input = r3_1.indexOf(r3.charAt(input));
	    
	    // Plugboard, again
	    input = plug.indexOf(plug_1.charAt(input));
	    
	    Stdout.println(keyboard.charAt(input));
	    
	    // Shifting of rotors
	    // Rotor3
	    r3 = r3.substring(1) + r3.charAt(0);
	    r3_1 = r3_1.substring(1) + r3_1.charAt(0);
	    
	    // Rotor2
	    if (counter % keyboard.length() == 0 && counter != 0){
		r2 = r2.substring(1) + r2.charAt(0);
		r2_1 = r2_1.substring(1) + r2_1.charAt(0);
	    }
	    // Rotor1
	    if (counter % Math.pow(keyboard.length(),2) == 0 && counter != 0){
		r1 = r1.substring(1) + r1.charAt(0);
		r1_1 = r1_1.substring(1) + r1_1.charAt(0);
	    }
	}
    } 
} 
