package kitchen;

public class Fraction {
	final int NUM, DEN;
	
	public Fraction(int numerator, int denominator) {
		if (denominator == 0)
			throw new IllegalArgumentException("Cannot divide by zero.");
		
		NUM = Integer.signum(denominator) * numerator;
		DEN = Math.abs(denominator);
	}
	
	public Fraction(int number) {
		this(number, 1);
	}
	
//	public Fraction(float number) {
//
//	}
	
	Fraction simplify() {
		var GCF = GCF(NUM, DEN);
		
		if (GCF == 1) {
			return this;
		}
		
		return new Fraction(NUM / GCF, DEN / GCF);
	}
	
	/* performing too much arithmetic on fractions is problematic
	 * fractions can only grow with add, subtract, multiply, and divide
	 * integer overflows will occur unless the fraction is dynamically reduced somehow?
	 */
	
	public Fraction add(Fraction term) {
		return new Fraction((this.NUM * term.DEN) + (term.NUM * this.DEN), this.DEN * term.DEN);
	}
	
	public Fraction subtract(Fraction term) {
		return new Fraction((this.NUM * term.DEN) - (term.NUM * this.DEN), this.DEN * term.DEN);
	}
	
	public Fraction multiply(Fraction term) {
		return new Fraction(this.NUM * term.NUM, this.DEN * term.DEN);
	}
	
	public Fraction divide(Fraction term) {
		return new Fraction(this.NUM * term.DEN, this.DEN * term.NUM);
	}
	
	static int GCF(int a, int b) {
		while (b != 0) {
			int hold = b;
			b = a % b;
			a = hold;
		}
		
		return a;
	}
	
	float evaluate() {
		return (float) NUM / DEN;
	}

}
