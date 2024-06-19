public class HW01_1 {
	public static void main(String[] args){
		int myint = 5;
		System.out.println("myint = "+myint);
		float myfloat = 3.5f;
		System.out.println("myfloat = "+myfloat);
		float mult = myint*myfloat;
		System.out.printf("%d x %f = %f\n", myint, myfloat, mult);
		float myint2float = (float)myint;
		System.out.printf("Convert myint to float: %f\n", myint2float);
		int myfloat2int = (int)myfloat;
		System.out.printf("Convert myfloat to int: %d\n", myfloat2int);
		
		char mycharup = 'A';
		char mycharlo = 'A'+32;
		System.out.printf("Convert my upper char (%c) to lower char: %c\n", mycharup,mycharlo);
	}
	
}