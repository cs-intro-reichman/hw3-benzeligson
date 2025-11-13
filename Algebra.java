// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 < 0){
			return minus(x1, -x2);
		} else {
			for (int counter = 0 ; counter < x2 ; counter++) {
				x1++;
			}
			return x1;
		}	
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 < 0){
			return plus(x1, -x2);
		} else {
			for (int counter = 0 ; counter < x2 ; counter++) {
				x1--;
			}
			return x1;
		}
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int firstValueOfX1 = x1;
		boolean shouldBeNegetivized = false;
		if (x2 < 0) {
			x2 = minus(0, x2);
			shouldBeNegetivized = true;
		}
		for (int counter = 1 ; counter < x2 ; counter++) {
			x1 = plus(x1, firstValueOfX1);
		} 
		if (shouldBeNegetivized) {
			x1 = minus(0, x1);
		}
		if (x2 ==0) {
			x1 = 0;
		}
		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int firstValueOfX = x;
		for (int counter = 1 ; counter < n ; counter++) {
			x = times(x, firstValueOfX);
		}
		if (n==0) {
			x = 1;
		}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int times = 0;
		boolean shouldBeNegetivized = false;
		if (x2< 0 && x1<0){
			x1 = minus(0, x1);
			x2 = minus(0, x2);
		}
		if (x2 < 0) {
			x2 = minus(0, x2);
			shouldBeNegetivized = true;
		}
		if (x1 < 0) {
			x1 = minus(0, x1);
			shouldBeNegetivized = true;
		}
		while (x1 >= x2)
		{
			x1 = minus(x1, x2);
			times++;
		}
		if (shouldBeNegetivized){
			times = minus(0, times);
		}
		return times;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		while (x1 >= x2)
		{
			x1 = minus(x1, x2);
		}
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int tester = 0;
		while (pow(tester, 2) <= x){
			tester++;
		}
		return tester - 1;
	}	  	  
}