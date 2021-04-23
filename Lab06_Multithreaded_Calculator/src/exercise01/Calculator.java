package exercise01;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Calculator {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome to the Centennial College Multithreaded Calculator");
		System.out.print("Please enter first integer: ");
		int num1 = s.nextInt();
		System.out.print("Please enter second integer: ");
		int num2 = s.nextInt();
		
		s.close();
		
		// Instance of all classes
		Addition add = new Addition (num1, num2);
		Subtraction sub = new Subtraction(num1, num2);
		Multiplication multi = new Multiplication(num1, num2);
		Division div = new Division(num1, num2);
		
		// Multi-threading
		
		
		add.start();
		try{Thread.sleep(100);}
		catch(InterruptedException e)
		{e.printStackTrace();}
		
		sub.start();;
		try{Thread.sleep(100);}
		catch(InterruptedException e)
		{e.printStackTrace();}
		
		multi.start();
		try{Thread.sleep(100);}
		catch(InterruptedException e)
		{e.printStackTrace();}
		
		div.start();
		try{Thread.sleep(100);}
		catch(InterruptedException e)
		{e.printStackTrace();}
		
		System.out.println("Bye! Have a good day.");
		
		
	}

}
class Addition extends Thread
{
	int number1, number2;
	
	Addition(int n1, int n2)
	{
		number1 = n1;
		number2 = n2;
	}
	public void run()
	{
		System.out.println("The result of the addition operation on " + number1 + " and "+ number2+ " is " + (number1+number2));
	}
}
class Subtraction extends Thread
{
	int number1, number2;
	
	Subtraction(int n1, int n2)
	{
		number1 = n1;
		number2 = n2;
	}
	public void run()
	{
		System.out.println("The result of the subtraction operation on " + number1 + " and "+ number2+ " is " + (number1-number2));
	}
}
class Multiplication extends Thread
{
	int number1, number2;
	
	Multiplication(int n1, int n2)
	{
		number1 = n1;
		number2 = n2;
	}
	public void run()
	{
		System.out.println("The result of the multiplication operation on " + number1 + " and "+ number2+ " is " + (number1*number2));
	}
}
class Division extends Thread
{
	double number1, number2;
	
	Division(int n1, int n2)
	{
		number1 = Double.valueOf(n1);
		number2 = Double.valueOf(n2);;
	}
	public void run()
	{
		DecimalFormat f = new DecimalFormat("##.00");
		System.out.println("The result of the division operation on " + number1 + " and "+ number2+ " is " + f.format(number1/number2));
	}
}


