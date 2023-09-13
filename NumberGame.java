import java.util.Scanner;
import java.lang.Math;

public class NumberGame{
    static Scanner sc = new Scanner(System.in);
    
    // Function to generate a random number
    public static int generateNumber() {
	    int min = 100;
	    int max = 999;
	    int range = max - min - 1 ;
	    return ((int)(Math.random()*range) + min);
	}
	// Generating the number that is to be guessed
 	static int NUM = generateNumber();
	static int count = 0;
	static int count1 = 0;
	static int guess = 0;
	static int code ;
	static int rangeLow100 = NUM/100*100;
	static int rangeHigh100 = (NUM+100)/100*100;
	static int rangeLow10 = NUM/10*10;
	static int rangeHigh10 = (NUM+10)/10*10;
	
	//function to give hints
	public static void hint(){
	    if (guess!=NUM){
    	    if (guess==0 || count==0){
    	        System.out.println("Guess between " + rangeLow100 + " to " + (rangeHigh100-1));
    	    }
    	    else if (guess>=rangeLow10 && guess<=(rangeHigh10-1)){
    	        System.out.println("The number is between " + rangeLow10 + " to " + (rangeHigh10-1));
    	        if (guess<NUM && count1>1){
    	            count1++;
    	            System.out.println("Kitna chota sochta hai??!! Bada bola tha maine!!");
    	        }
    	        else if (guess>NUM && count1>1){
    	            count1++;
    	            System.out.println("Kitna bada sochta hai??!! Chota bola tha maine!!");
    	        }
    	        else if (guess<NUM && count1==1){
    	            count1++;
    	            System.out.println("Thoda aur bada!!!");
    	        }
    	        else if (guess>NUM && count1==1){
    	            count1++;
    	            System.out.println("Thoda aur chota!!!");
    	        }
    	        else if (guess<NUM && count1==0){
    	            count++;
    	            System.out.println("Thooooda bada soch!!!");
    	        }
    	        else if (guess>NUM && count1==0){
    	            count1++;
    	            System.out.println("Thooooda chota soch!!!");
    	        }
    	    }
    	    else if (guess>=rangeLow100 && guess<=(rangeHigh100-1)){
    	        System.out.println("You are close, the number is between " + rangeLow100 + " and " + (rangeHigh100-1));
    	        if (guess<NUM){
    	            System.out.println("Bada number soch kar dekh!!!");
    	        }
    	        else if (guess>NUM){
    	            System.out.println("Chota number soch kar dekh!!!");
    	        }
    	    }
    	    else{
    	        System.out.println("Last condition dekh yaar");
    	    }
    	    count++;
    	    code = 1;
	    }
	}
	
	public static void theGuess() {
	    if (count==0)
	        System.out.println("And your first guess is....");
	    guess = sc.nextInt();
	    if (guess != NUM){
	        code = 2;
	    }
	    else {
	        if (count==0) {
	            System.out.println("I think YOU generated the NUMBER!!!");
	        }
	        else if (count==1) {
	            System.out.println("Are you GOD??!!!");
	        }
	        else if (count>1 && count<=4){
	            System.out.println("You are good at this game!!!");
	        }
	        else if (count>4 && count<8){
	            System.out.println("Well done guessing the number!!!");
	        }
	        else {
	            System.out.println("Good!!! At least you guessed it!!!");
	        }
	    }
	}
	
	public static void main(String[] args) {
	    System.out.println("-----Number pehechano bhai-behen log-----");
	    System.out.println("Number is between 100 and 999");
	    System.out.println("Ready to guess???\nPress '1' to guess the number\nPress '2' to get a hint");
	    code = sc.nextInt();
	    NUM = 777;
	    START:
	    do{
    	    switch(code){
    	        case 1:
    	            theGuess();
    	            break;
    	        case 2:
    	            hint();
    	            break;
    	        default:
    	            System.out.println("!!!!Enter a valid code!!!!");
    	            code = sc.nextInt();
    	            break;
    	    }
	    }while(guess != NUM);
	}
}
