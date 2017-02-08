public class MathTools{
 public static double absoluteValue(double n) {
 	return n < 0 ? -n : n;
 }
 
 public static double power(double base, int exponent) {
 	double res = 1;
    if(exponent >= 0) {
      for(int i = 0; i < exponent; ++i) {
          res *= base;
      }
    }else {
      for(int i = 0; i < -exponent; ++i) {
          res /= base;
      }
    }	
      return res;
 }
 
 public static double nthRoot(double value, int root) {
    if(value == 0) {
      return 0.0;
    }else if(value < 0 && root % 2 == 0) {
      throw new IllegalArgumentException();
    }
 	double epsilo = 0.000000001;
  	double initialGuess = root > 0 ? value : 1/value;
  	double newGuess = ((root - 1) * initialGuess + value / power(initialGuess, root - 1)) / root;
    while(absoluteValue(initialGuess - newGuess) > epsilo) {
      initialGuess = newGuess;
      newGuess = ((root - 1) * initialGuess + value / power(initialGuess, root - 1)) / root;
   	}
  	return newGuess;
 }
 
 public static String scientificNotation(double n) {
  	if(n == 0) {return "" + 0.0;}
 	
  	int sign = n < 0 ? -1 : 1;
  	n = ((long)(n * 1000000)) / 1000000.0;
  	n = absoluteValue(n);
  	int exponent = 0;
  	
  	
  	while(n < 1) {
     	n *= 10.0;
  		exponent -= 1;
  	}
    while(n >= 10) {
      n /= 10.0;
      exponent += 1;
    }
  	return n * sign + " * 10^" + exponent;
 }
}