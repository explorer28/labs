import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter 1st number: \n");
		int num1 = scan.nextInt();
		System.out.print("Enter 2nd number: \n");
		int num2 = scan.nextInt();
		System.out.print("Enter 3rd number: \n");
		int num3 = scan.nextInt();
		
		boolean res13 = false, res19 = false, res23 = false, res29 = false,
res33 = false, res39 = false;
		if(num1 % 9 == 0) res19 = true;
		else if(num1 % 3 == 0) res13 = true;
		
		if(num2 % 9 == 0) res29 = true;
		else if(num2 % 3 == 0) res23 = true;
		
		if(num3 % 9 == 0) res39 = true;
		else if(num3 % 3 == 0) res33 = true;
		
		System.out.println("\nResult:\n");
		if(res19) System.out.println(num1 + " divides by 3 and 9");
		else if(res13) System.out.println(num1 + " divides by 3");
		else System.out.println(num1 + " doesn't divides by 3 nor 9");
		
		if(res29) System.out.println(num2 + " divides by 3 and 9");
		else if(res23) System.out.println(num2 + " divides by 3");
		else System.out.println(num2 + " doesn't divides by 3 nor 9");
		
		if(res39) System.out.println(num3 + " divides by 3 and 9");
		else if(res33) System.out.println(num3 + " divides by 3");
		else System.out.println(num3 + " doesn't divides by 3 nor 9");
	}
}
