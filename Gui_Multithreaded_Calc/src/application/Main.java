package application;
	
import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	private TextField Number1 = new TextField();
	private TextField Number2 = new TextField();
	private Button CalculateFX = new Button("Calculate");
    private Button ResetFX = new Button("Reset");
    private TextField ResultAdd = new TextField();
    private TextField ResultSub = new TextField();
    private TextField ResultMulti = new TextField();
    private TextField ResultDiv = new TextField();
	@Override
	public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Enter First Number"), 0, 0);
        gridPane.add(Number1, 1, 0);
        gridPane.add(new Label("Enter Second Number"), 0, 1);
        gridPane.add(Number2, 1, 1);
        gridPane.add(CalculateFX, 1, 2);
        gridPane.add(ResetFX, 1, 2);
        gridPane.add(new Label("The result of Addition: "), 0, 3);
        gridPane.add(ResultAdd, 1, 3);
        gridPane.add(new Label("The result of Subtraction: "), 0, 4);
        gridPane.add(ResultSub, 1, 4);
        gridPane.add(new Label("The result of Multiplication: "), 0, 5);
        gridPane.add(ResultMulti, 1, 5);
        gridPane.add(new Label("The result of Division: "), 0, 6);
        gridPane.add(ResultDiv, 1, 6);
        gridPane.setAlignment(Pos.CENTER);
        GridPane.setHalignment(Number1, HPos.RIGHT);
        GridPane.setHalignment(CalculateFX, HPos.LEFT);
        GridPane.setHalignment(ResetFX, HPos.RIGHT);
        

        CalculateFX.setOnAction(e -> {
            calculate();
        });
        ResetFX.setOnAction(e ->{
        	Number1.setText("");
        	Number2.setText("");
        	ResultAdd.setText("");
        	ResultSub.setText("");
        	ResultMulti.setText("");
        	ResultDiv.setText("");
        });

        Scene scene = new Scene(gridPane,400,350);
        primaryStage.setTitle("Centennial College Multithreaded Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
      
      }
	
	public void calculate()
	{
		int number1 = Integer.parseInt(Number1.getText());
		int number2 = Integer.parseInt(Number2.getText());
		
		// Instance of all classes
			Addition add = new Addition(number1, number2);
			Subtraction sub = new Subtraction(number1, number2);
			Multiplication multi = new Multiplication(number1, number2);
			Division div = new Division(number1, number2);
			
			// Multi-threading
			add.start();
			try{Thread.sleep(100);}
			catch(InterruptedException e)
			{e.printStackTrace();}
			sub.start();
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
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
class Addition extends Thread
	{
		int number1, number2, add;
		
		Addition(int n1, int n2)
		{
			number1 = n1;
			number2 = n2;
		}
		public void run()
		{
			add = number1 + number2;
			String addResult = String.valueOf(add);
			ResultAdd.setText(addResult);
		}
	}
class Subtraction extends Thread
	{
		int number1, number2, sub;
		
		Subtraction(int n1, int n2)
		{
			number1 = n1;
			number2 = n2;
		}
		public void run()
		{
			sub = number1 - number2;
			String subResult = String.valueOf(sub);
			ResultSub.setText(subResult);
		}
	}
class Multiplication extends Thread
	{
		int number1, number2, multi;
		
		Multiplication(int n1, int n2)
		{
			number1 = n1;
			number2 = n2;
		}
		public void run()
		{
			multi = number1 * number2;
			String multiResult = String.valueOf(multi);
			ResultMulti.setText(multiResult);
		}
	}
class Division extends Thread
	{
		double number1, number2, div;
		
		Division(int n1, int n2)
		{
			number1 = Double.valueOf(n1);
			number2 = Double.valueOf(n2);;
		}
		public void run()
		{
			DecimalFormat f = new DecimalFormat("##.00");
			div = number1 / number2;
			String result = f.format(div);		
			ResultDiv.setText(result);
		}
	}
}
