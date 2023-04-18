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
		con.repaint();
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
	}
	public static void scene5(Console con){
		//Spongebob drops sodium metal in water and it explodes 
		//Patrick says it is unsafe, and player does not pass the lab
		
	}
	public static void scene6(Console con){
		//Spongebob mixes copper (II) sulfate and sodium hydroxide, forming a new solid
		//Patrick asks Spongebob what was produced
	}
	public static void scene7(Console con){
		//Patrick tells Spongebob he got the chemical formula wrong
		//Player does not pass the lab
	}
	public static void scene8(Console con){
		//Patrick says the chemical formula is correct, Spongebob measures the mass
		//Patrick asks for the mass measured in grams 
		
	}
	public static void scene9(Console con){
		//Patrick calculates and says the amount produced 
		//Generates a random % yield
	}
	public static void scene10(Console con){
		//Patrick says the % yield is bad
		//Player does not plass lab
		
	}
	public static void scene11(Console con){
		//Patrick says % yield was good 
		//Player gets thirsty and wants to drink sodium hydroxide 
		
	}
	public static void scene12(Console con){
		//Player drinks sodium hydroxide and gets poisoned
		//Patrick says it is unsafe and the player does not pass lab
	}
	public static void scene13(Console con){
		//Patrick congratulates player for not drinking sodium hydroxide 
		//Player passes lab with 100%
	}
	public static void scene14(Console con){
		//Spongebob enters Squidward's physics class and Squidward explains two labs the player can choose from 
		//Lab 1: drop a 100g ball 1m 
		//Lab 2: drop a 100kg ball 1m 
	}
	public static void scene15(Console con){
		//Spongebob drops the 100kg ball 1m and it breaks
		//Squidward says it is unsafe and player does not pass lab
		
	}
	public static void scene16(Console con){
		//Spongebob drops the 100g ball 1m and measures the time for 5 trials 
		//Squidward explains the formula for calculating acceleration 
	}
	public static void scene17(Console con){
		//Squidward calculates the acceleration from the average of 5 trials, and puts it on the board
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
