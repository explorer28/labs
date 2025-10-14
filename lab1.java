import java.util.Scanner;
public class lab1
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
		System.out.println(num1 + dividsStatus(num1));
		System.out.println(num2 + dividsStatus(num2));
		System.out.println(num3 + dividsStatus(num3));
	}
	public static String dividsStatus(int number){
		byte status = 0;
		if(number%3==0)status++;
		if(number%9==0)status++;
		switch (status) {
			case 0:
				return " doesn't divides by 3 or 9";
			case 1:
				return " divides by 3";
			case 2:
				return " divides by 3 and 9";
			default:
				return " nothing";
		}
	}
}
