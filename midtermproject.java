import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class midtermproject{
	public static void main(String[]args){
		Console con = new Console("Krusty Krab University", 1280, 720);	
		String strChoice;
		strChoice = "";
		Font fntOswald = con.loadFont("Oswald-Bold.ttf",40);
		con.setDrawFont(fntOswald);
		int intMouseX;
		intMouseX = 0;
		int intMouseY;
		intMouseY = 0;
		int intCurrentMouseClicked;
		
		//scene 1
		scene1(con);
		while(!strChoice.equals("true")||!strChoice.equals("false")){
			intMouseX = con.currentMouseX();
			intMouseY = con.currentMouseY();
			intCurrentMouseClicked = con.currentMouseButton();
			
			if((((intMouseX >= 10) && (intMouseX <= 210)) && ((intMouseY >= 10) && (intMouseY <= 110))) && (intCurrentMouseClicked == 1)){
				//mouse button yes 
				strChoice = "true";
				
			}else if((((intMouseX >= 1010)&&(intMouseX<= 1210)) &&((intMouseY >=10)&&(intMouseY <=110)))&&(intCurrentMouseClicked == 1)){
				//mouse clicks no
				strChoice = "false";
			}
			if(strChoice.equals("true")){
				scene3(con);
				String strName;
				String strLetter;
				con.println("What is your name");
				strName = con.readLine();
				strLetter = strName.substring(0,1);
				if(strLetter.equalsIgnoreCase("a")||strLetter.equalsIgnoreCase("b")||strLetter.equalsIgnoreCase("c")||strLetter.equalsIgnoreCase("d")||strLetter.equalsIgnoreCase("e")||strLetter.equalsIgnoreCase("f")||strLetter.equalsIgnoreCase("g")||strLetter.equalsIgnoreCase("h")||strLetter.equalsIgnoreCase("i")||strLetter.equalsIgnoreCase("j")||strLetter.equalsIgnoreCase("k")||strLetter.equalsIgnoreCase("l")){
					scene4(con);
					
				}else{
					scene14(con);
				}
			}else if(strChoice.equals("false")){
				scene2(con);
				con.println("You leave Krusty Krab University.");
			}
		
		}
	}
	public static void scene1(Console con){
		//Spongebob (player) goes to Krusty Krab University
		con.println("Welcome to Krusty Krab University!");
		con.println("Click yes to enter and no to quit.");
		BufferedImage imgCountryside = con.loadImage("countryside.jpeg");
		BufferedImage imgSchool = con.loadImage("school.png");
		con.drawImage(imgCountryside, 0,0);
		con.drawImage(imgSchool, 0,0);
		int intSpongebobX;
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		for(intSpongebobX =1500; intSpongebobX >=700; intSpongebobX--){
			con.drawImage(imgSpongebob,intSpongebobX, 100);
			con.repaint();
			con.sleep(10);
		}
		con.repaint();
		con.setDrawColor(Color.BLACK);
		con.fillRect(10,10,200,100);
		con.fillRect(1010,10,200,100);
		
	}
	public static void scene2(Console con){
		//Spongebob leaves Krusty Krab University
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		BufferedImage imgCountryside = con.loadImage("countryside.jpeg");
		BufferedImage imgSchool = con.loadImage("school.png");
		int intSpongebobX;
		intSpongebobX = 700;
		con.clear();
		con.drawImage(imgCountryside, 0,0);
		con.drawImage(imgSchool, 0,0);
		while(intSpongebobX<=1500){
			con.drawImage(imgSpongebob, intSpongebobX, 100);
			intSpongebobX = intSpongebobX+1;
			con.repaint();
			con.sleep(10);
		}
	}	
	public static void scene3(Console con){
		//Mr. Krab asks for player name 
		
	}
	public static void scene4(Console con){
		//Spongebob is in chemistry, Patrick explains two labs that player can choose from
		//Lab 1: Drop sodium metal in water
		//Lab 2: Mix sodium hydroxide and copper (II) sulfate
		con.clear();
		char chrChemLab;
		con.drawString("Lab 1: drop sodium metal into water",1300,600);
		con.drawString("Lab 2: mix sodium hydroxide and copper (II) sulfate",1300,580);
		con.println("What lab do you want to do");
		con.println("Enter 'a' for lab 1 and 'b' for lab 2");
		chrChemLab= con.getChar();
		if(chrChemLab=='a'){
			scene5(con);
		}
		else if(chrChemLab=='b'){
			scene6(con);
		}
			

		
	}
	public static void scene5(Console con){
		//Spongebob drops sodium metal in water and it explodes 
		//Patrick says it is unsafe, and player does not pass the lab
		con.drawString("That is unsafe!",1300,600);
		con.println("You did not pass the lab");
		
	}
	public static void scene6(Console con){
		//Spongebob mixes copper (II) sulfate and sodium hydroxide, forming a new solid
		//Patrick asks Spongebob what was produced
		String strChemicalFormula;
		con.println("A new solid is generated!");
		con.drawString("What solid was produced?",1300,600);
		con.println("Enter the chemical formula of the solid produced.");
		strChemicalFormula = con.readLine();
		if(strChemicalFormula.equals("Cu(OH)2")){
			scene8(con);
		}else{
			scene7(con);
		}
	}
	public static void scene7(Console con){
		//Patrick tells Spongebob he got the chemical formula wrong
		//Player does not pass the lab
		con.drawString("Wrong chemical formula!",1300,600);
		con.println("You did not pass the lab");
	}
	public static void scene8(Console con){
		//Patrick says the chemical formula is correct, Spongebob measures the mass
		//Patrick asks for the mass measured in grams 
		con.clear();
		double dblMass;
		double dblAmount;
		con.drawString("Correct!",1300,600);
		con.drawString("What is the mass of the precipitate",1300,580);
		con.println("Enter the mass");
		dblMass = con.readDouble();
		dblAmount = dblMass/97.57;
		con.println("The amount is "+dblAmount+"mol");
		
	}
	public static void scene9(Console con){
		//Patrick calculates and says the amount produced 
		//Generates a random % yield
		con.clear();
		int intYield;
	
		con.drawString("What is the % yield",1300,600);
		intYield = (int)(Math.random()*100);
		con.println("You % yield is "+intYield+"%");
		if(intYield<50){
			scene10(con);
		}else{
			scene11(con);
		}
	}
	public static void scene10(Console con){
		//Patrick says the % yield is bad
		//Player does not plass lab
		con.clear();
		con.println("You did not pass the lab");
		con.drawString("Your % yield was bad!",1300,600);
		
	}
	public static void scene11(Console con){
		//Patrick says % yield was good 
		//Player gets thirsty and wants to drink sodium hydroxide 
		String strDrink;
		con.clear();
		con.drawString("Your % yield was good!",1300,600);
		con.println("You are thirsty and you want to drink sodium hydroxide");
		con.println("Enter 'yes' to drink and 'no' to not drink");
		strDrink = con.readLine();
		if(strDrink.equalsIgnoreCase("yes")){
			scene12(con);
		}else if(strDrink.equalsIgnoreCase("no")){
			scene13(con);
		}else{
			con.println("Enter 'yes' to drink and 'no' to not drink");
			strDrink = con.readLine();
		}
			
	}
	public static void scene12(Console con){
		//Player drinks sodium hydroxide and gets poisoned
		//Patrick says it is unsafe and the player does not pass lab
		con.clear();
		con.println("The sodium hydroxide poisoned you!");
		con.println("You did not pass the lab!");
		
	}
	public static void scene13(Console con){
		//Patrick congratulates player for not drinking sodium hydroxide 
		//Player passes lab with 100%
		con.clear();
		con.println("You passed the lab with 100%!");
		con.drawString("You should never drink in labs!",1300,600);
	}
	public static void scene14(Console con){
		//Spongebob enters Squidward's physics class and Squidward explains two labs the player can choose from 
		//Lab 1: drop a 100g ball 1m 
		//Lab 2: drop a 100kg ball 1m 
		int intPhyLab;
		con.drawString("Lab 1: drop 100kg ball 1m",1300,600);
		con.drawString("Lab 2: drop",1300,580);
		con.println("What lab do you want to do");
		con.println("Enter '1' for lab 1 and '2' for lab 2");
		intPhyLab = con.readInt();
	}
	public static void scene15(Console con){
		//Spongebob drops the 100kg ball 1m and it breaks
		//Squidward says it is unsafe and player does not pass lab
		
		con.println("The 100kg ball is very heavy and you drop it on your foot!");
		con.drawString("That is unsafe!",1300,600);
		con.println("You did not pass the lab.");
	}
	public static void scene16(Console con){
		//Spongebob drops the 100g ball 1m and measures the time for 5 trials 
		//Squidward explains the formula for calculating acceleration 
		con.clear();
		int intCount;
		intCount = 1;
		double dblTime;
		double dblTimeAvg;
		dblTimeAvg = 0;
		double dblAcceleration;
		double dblAccelerationRounded;
		con.println("You measure the time it takes for the ball to fall 1m for 5 trials.");
		con.drawString("d = vit + 1/2at^2, and we want acceleration",1300,600);
		while(intCount<=5){
			con.println("Enter the time (s)");
			dblTime = con.readDouble();
			dblTimeAvg = dblTimeAvg + dblTime;
			intCount = intCount+1;
		}
		dblAcceleration = 2/Math.pow((dblTimeAvg/5),2);
		dblAccelerationRounded = Math.round(dblAcceleration);
		con.clear();
		con.println("The acceleration is "+dblAccelerationRounded+"m/s^2");
	}
	public static void scene17(Console con){
		//Squidward asks Spongebob for % error
		
	}
	public static void scene18(Console con){
		//Squidward says Spongebob's % error was wrong 
		//Player does not pass lab 
		
	}
	public static void scene19(Console con){
		//Squidward says Spongebob's % error was correct 
		//Squidward asks for the number of sig figs in a number
		
	}
	public static void scene20(Console con){
		//Squidward says the player counted sig figs wrong 
		//Player does not pass lab
	}
	public static void scene21(Console con){
		//Squidward says the player counted correct # of sig figs 
		//Squidward asks which factor is ignored for objects in free fall
	}
	public static void scene22(Console con){
		//Squidward says the player gave a factor that was wrong
		//Player does not pass lab
		
	}
	public static void scene23(Console con){
		//Squidward says the factor of air resistance is correct
		//Player passes lab
		
	}
}
