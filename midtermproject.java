//Story Name: Krusty Krab University
//Programmer Name: Isaac Lo
//Version: 0.9
import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class midtermproject{
	public static void main(String[]args){
		//Load font, console and move into scene 1 method 
		Console con = new Console("Krusty Krab University", 1280, 720);	
		Font fntOswald = con.loadFont("Oswald-Bold.ttf",36);
		con.setDrawFont(fntOswald);
		scene1(con);

	}
	public static void scene1(Console con){
		//Spongebob (player) goes to Krusty Krab University in the countryside
		String strChoice;
		strChoice = "";
		int intMouseX;
		intMouseX = 0;
		int intMouseY;
		intMouseY = 0;
		int intCurrentMouseClicked;
		con.setTextColor(Color.WHITE);
		con.println("Welcome to Krusty Krab University!");
		con.println("Click yes to enter and no to quit.");
		BufferedImage imgCountryside = con.loadImage("countryside.jpeg");
		BufferedImage imgSchool = con.loadImage("school.png");
		con.drawImage(imgCountryside, 0,0);
		con.drawImage(imgSchool, 0,0);
		int intSpongebobX;
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		//Animation loop: spongebob moves from right to left
		for(intSpongebobX =1300; intSpongebobX >=700; intSpongebobX-=5){
			con.drawImage(imgCountryside, 0,0);
			con.drawImage(imgSchool, 0,0);
			con.drawImage(imgSpongebob,intSpongebobX, 100);
			con.repaint();
			con.sleep(10);
		}
		con.repaint();
		con.setDrawColor(Color.BLACK);
		con.fillRect(10,100,200,100);
		con.fillRect(1010,100,200,100);
		con.setDrawColor(Color.WHITE);
		con.drawString("  yes  ",10,100);
		con.drawString("  no   ",1010,100);
		con.repaint();
		//Mouse choice loop: takes current mouse x and y data as well as mouse button data until "yes" or "no" rectangles have been clicked
		while(!strChoice.equals("true")||!strChoice.equals("false")){
			intMouseX = con.currentMouseX();
			intMouseY = con.currentMouseY();
			intCurrentMouseClicked = con.currentMouseButton();
			if((((intMouseX >= 10) && (intMouseX <= 210)) && ((intMouseY >= 100) && (intMouseY <= 200))) && (intCurrentMouseClicked == 1)){
				//mouse button yes 
				strChoice = "true";
				scene3(con);
			}else if((((intMouseX >= 1010)&&(intMouseX<= 1210)) &&((intMouseY >=100)&&(intMouseY <=200)))&&(intCurrentMouseClicked == 1)){
				//mouse clicks no
				strChoice = "false";
				scene2(con);
			}
		}
		
	}
	public static void scene2(Console con){
		//Spongebob leaves Krusty Krab University
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		int intSpongebobX;
		intSpongebobX = 700;
		con.clear();
		con.println("You have quit Krusty Krab University!");
		//Animation loop: spongebob moves from left to right
		while(intSpongebobX<=1300){
			BufferedImage imgCountryside = con.loadImage("countryside.jpeg");
			BufferedImage imgSchool = con.loadImage("school.png");
			con.drawImage(imgCountryside, 0,0);
			con.drawImage(imgSchool, 0,0);
			con.drawImage(imgSpongebob, intSpongebobX, 100);
			intSpongebobX = intSpongebobX+5;
			con.repaint();
			con.sleep(10);
		}
		con.sleep(10000);
		con.closeConsole();
	}	
	public static void scene3(Console con){
		//Player is standing in a hallway and sees Mr Krab
		//Mr. Krab asks for player name 
		BufferedImage imgHall = con.loadImage("hall.png");
		BufferedImage imgKrab = con.loadImage("mrkrab.png");
		con.drawImage(imgHall, 0,0);
		con.drawImage(imgKrab,640,100);
		con.setDrawColor(new Color(100,240,165));
		con.fillRect(1080,200,200,100);
		con.fillRect(0,200,200,100);
		con.setDrawColor(Color.WHITE);
		con.drawString("Chemistry",0,200);
		con.drawString("Physics",1080,200);
		String strName;
		String strLetter;
		con.clear();
		con.println("What is your name");
		strName = con.readLine();
		strLetter = strName.substring(0,1);
		//If player name is between a and l, player goes to chemistry
		if(strLetter.equalsIgnoreCase("a")||strLetter.equalsIgnoreCase("b")||strLetter.equalsIgnoreCase("c")||strLetter.equalsIgnoreCase("d")||strLetter.equalsIgnoreCase("e")||strLetter.equalsIgnoreCase("f")||strLetter.equalsIgnoreCase("g")||strLetter.equalsIgnoreCase("h")||strLetter.equalsIgnoreCase("i")||strLetter.equalsIgnoreCase("j")||strLetter.equalsIgnoreCase("k")||strLetter.equalsIgnoreCase("l")){
			scene4(con);
		//If player name is anything else, player goes to physics 
		}else{
			scene14(con);
		}
	}
	public static void scene4(Console con){
		//Spongebob is in chemistry, Patrick explains two labs that player can choose from
		//Lab 1: Drop sodium metal in water
		//Lab 2: Mix sodium hydroxide and copper (II) sulfate
		BufferedImage imgBlack = con.loadImage("black.jpg");
		con.drawImage(imgBlack,0,0);
		con.repaint();
		BufferedImage imgPatrick = con.loadImage("patrick.png");
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		con.drawImage (imgPatrick,1100,200);
		con.clear();
		con.setTextColor(Color.WHITE);
		char chrChemLab;
		chrChemLab = 'c';
		con.drawString("Lab 1: drop sodium metal into water",250,80);
		con.drawString("Lab 2: mix sodium hydroxide and copper (II) sulfate",250,140);
		con.println("Enter 'a' for lab 1 and 'b' for lab 2, anything else and you leave Krusty Krab University");
		//While loop to make the player keep pressing characters until "a" or "b" is pressed
		while(chrChemLab!='a'||chrChemLab!='b'){
		chrChemLab = con.currentChar();
		//If "a" key is pressed 
		if(chrChemLab=='a'){
			scene5(con);
		}
		//If "b" key is pressed 
		else if(chrChemLab=='b'){
			scene6(con);
		//If neither "a" or "b" is pressed
		}else{
			chrChemLab = con.currentChar();
		}
	}
			
	}
	public static void scene5(Console con){
		//Spongebob drops sodium metal in water and it explodes 
		//Patrick says it is unsafe, and player does not pass the lab
		BufferedImage imgPatrick = con.loadImage("patrick.png");
		BufferedImage imgClass = con.loadImage("class.png");
		BufferedImage imgSpongebobLook = con.loadImage("spongeboblook.png");
		BufferedImage imgRock = con.loadImage("rock.png");
		BufferedImage imgExplosion = con.loadImage("explosion.png");
		BufferedImage imgBlack = con.loadImage("black.jpg");
		BufferedImage imgWater = con.loadImage("water.png");
		con.drawImage(imgPatrick, 1100,200);
		int intRockY;
		//Animation loop: Rock moves from top to bottom 
		for(intRockY = 0;intRockY<550;intRockY+=5){
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1280,720);
			con.drawImage (imgClass,0,0);
			con.drawImage (imgSpongebobLook, 100,300);
			con.drawImage (imgWater, 640, 520);
			con.drawImage (imgRock, 640,intRockY);
			con.repaint();
			con.sleep(10);
		}
		con.sleep(1000);
		con.setDrawColor(Color.WHITE);
		con.drawImage (imgExplosion, 200,200);
		con.println("It explodes!");
		con.drawString("That is unsafe!",250,80);
		con.println("You did not pass the lab");
		con.sleep(10000);
		con.closeConsole();
		
	}
	public static void scene6(Console con){
		//Spongebob mixes copper (II) sulfate and sodium hydroxide, forming a new solid
		//Patrick asks Spongebob what was produced		
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgSpongebobLook = con.loadImage("spongeboblook.png");
		BufferedImage imgPatrick = con.loadImage("patrick.png");
		BufferedImage imgClass = con.loadImage("class.png");
		BufferedImage imgBeaker = con.loadImage("beaker.png");
		con.drawImage (imgClass,0,0);
		con.setTextColor(Color.WHITE);
		con.drawImage(imgPatrick, 1100,200);
		con.drawImage(imgSpongebobLook, 100, 300);
		con.sleep(1000);
		con.drawImage(imgBeaker, 640, 500);
		String strChemicalFormula;
		con.println("A new solid is generated!");
		con.drawString("What solid was produced?",250,80);
		con.drawString("CuSO4 + 2NaOH = ___ (s) +Na2SO4",250,140);
		con.println("Enter the chemical formula of the solid produced.");
		strChemicalFormula = con.readLine();
		//If player enters the chemical formula "Cu(OH)2"
		if(strChemicalFormula.equals("Cu(OH)2")){
			scene8(con);
		//If player enters anything else
		}else{
			scene7(con);
		}
	}
	public static void scene7(Console con){
		//Patrick tells Spongebob he got the chemical formula wrong
		//Player does not pass the lab
		BufferedImage imgPatrick = con.loadImage("patrick.png");
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		con.setDrawColor(Color.WHITE);
		con.setTextColor(Color.WHITE);
		con.drawImage(imgPatrick, 1100,200);
		con.drawString("Wrong chemical formula!",250,80);
		con.println("You did not pass the lab");
		con.sleep(10000);
		con.closeConsole();
	}
	public static void scene8(Console con){
		//Patrick says the chemical formula is correct, Spongebob measures the mass
		//Patrick asks for the mass measured in grams 
		con.clear();
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		BufferedImage imgScale = con.loadImage("scale.png");
		BufferedImage imgSpongebobLook = con.loadImage("spongeboblook.png");
		BufferedImage imgBeaker = con.loadImage("beaker.png");
		con.drawImage (imgClass,0,0);
		con.setTextColor(Color.WHITE);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgPatrick = con.loadImage("patrick.png");
		con.drawImage(imgPatrick,1100,200);
		con.drawImage(imgSpongebobLook, 100, 300);
		con.drawImage(imgScale, 640, 500);
		con.drawImage(imgBeaker, 700, 350);
		double dblMass;
		double dblAmount;
		con.drawString("Correct!",250,80);
		con.drawString("What is the mass of the precipitate",250,140);
		con.println("Enter the mass");
		dblMass = con.readDouble();
		dblAmount = dblMass/97.57;
		con.println("The amount is "+dblAmount+"mol");
		con.sleep(5000);
		scene9(con);
	}
	public static void scene9(Console con){
		//Patrick calculates and says the amount produced 
		//Generates a random % yield
		con.clear();
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		con.setTextColor(Color.WHITE);
		BufferedImage imgPatrick = con.loadImage("patrick.png");
		con.drawImage(imgPatrick,1100,200);
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		con.drawImage (imgSpongebob, 100,100);
		int intYield;
		con.drawString("What is the % yield",250,80);
		intYield = (int)(Math.random()*100);
		con.println("Your % yield is "+intYield+"%");
		con.sleep(5000);
		//If randomly generated yield is below 50
		if(intYield<50){
			scene10(con);
		//If randomly generated yield is any other number 
		}else{
			scene11(con);
		}
	}
	public static void scene10(Console con){
		//Patrick says the % yield is bad
		//Player does not plass lab
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		con.drawImage (imgSpongebob, 100,100);
		BufferedImage imgPatrick = con.loadImage("patrick.png");
		con.drawImage(imgPatrick,1100,200);
		con.println("You did not pass the lab");
		con.drawString("Your % yield was bad!",250,80);
		con.sleep(10000);
		con.closeConsole();
		
	}
	public static void scene11(Console con){
		//Patrick says % yield was good 
		//Player gets thirsty and wants to drink sodium hydroxide 
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		con.drawImage (imgSpongebob, 100,100);
		con.drawImage (imgClass,0,0);
		BufferedImage imgPatrick = con.loadImage("patrick.png");
		con.drawImage(imgPatrick,1100,200);
		BufferedImage imgSpongebobLook = con.loadImage("spongeboblook.png");
		con.drawImage (imgSpongebobLook,100,300);
		BufferedImage imgBeaker = con.loadImage("beaker.png");
		String strDrink;
		con.clear();
		con.drawImage (imgBeaker, 640,500);
		con.drawString("Your % yield was good!",250,80);
		con.println("You are thirsty and you want to drink sodium hydroxide");
		con.println("Enter 'yes' to drink and 'no' to not drink");
		strDrink = con.readLine();
		//If player enters "yes" 
		if(strDrink.equalsIgnoreCase("yes")){
			scene12(con);
		//If player enters "no"
		}else if(strDrink.equalsIgnoreCase("no")){
			scene13(con);
		//If player enters neither "yes" nor "no"
		}else{
			con.clear();
			con.println("Enter 'yes' to drink and 'no' to not drink");
			strDrink = con.readLine();
		}
			
	}
	public static void scene12(Console con){
		//Player drinks sodium hydroxide and gets poisoned
		//Patrick says it is unsafe and the player does not pass lab
		BufferedImage imgPatrick = con.loadImage("patrick.png");
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		con.drawImage(imgPatrick,1100,200);
		con.setTextColor(Color.WHITE);
		BufferedImage imgSpongebobSuprised = con.loadImage("spongebobsuprised.png");
		con.drawImage(imgSpongebobSuprised, 100,300);
		con.clear();
		con.println("The sodium hydroxide poisoned you!");
		con.drawString("You can't drink that!",250,80);
		con.println("You did not pass the lab!");
		con.sleep(10000);
		con.closeConsole();
		
	}
	public static void scene13(Console con){
		//Patrick congratulates player for not drinking sodium hydroxide 
		//Player passes lab with 100%
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		BufferedImage imgPatrick = con.loadImage("patrick.png");
		con.drawImage(imgPatrick,1100,200);
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		con.drawImage(imgSpongebob, 100,100);
		con.clear();
		con.setTextColor(Color.WHITE);
		con.println("You passed the lab with 100%!");
		con.drawString("You should never drink in labs! Good job!",250,80);
		con.sleep(10000);
		con.closeConsole();
	}
	public static void scene14(Console con){
		//Spongebob enters Squidward's physics class and Squidward explains two labs the player can choose from 
		//Lab 1: drop a 100g ball 1m 
		//Lab 2: drop a 100kg ball 1m 
		BufferedImage imgBlack = con.loadImage("black.jpg");
		con.drawImage(imgBlack, 0,0);
		con.repaint();
		con.clear();
		int intPhyLab;
		intPhyLab = 0;
		con.setDrawColor(Color.WHITE);
		con.setTextColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage(imgClass,0,0);
		BufferedImage imgSquidward = con.loadImage("squidward.png");
		con.drawImage(imgSquidward,1100,200);
		con.drawString("Lab 1: drop 100kg ball 1m",250,80);
		con.drawString("Lab 2: drop 100g ball 1m",250,140);
		con.println("What lab do you want to do");
		//Choice loop: whhile intPhyLab does not equal 1 or 2
		while(intPhyLab!=1||intPhyLab!=2){
			con.println("Enter '1' for lab 1 and '2' for lab 2");
			intPhyLab = con.readInt();
			//If player enters "1"
			if(intPhyLab ==1){
				scene15(con);
			//If player enters "2"
			}else if(intPhyLab ==2){
				scene16(con);
			}
		}
		
	}
	public static void scene15(Console con){
		//Spongebob drops the 100kg ball 1m and it breaks
		//Squidward says it is unsafe and player does not pass lab
		BufferedImage imgClass = con.loadImage("class.png");
		BufferedImage imgSquidward = con.loadImage("squidward.png");
		BufferedImage imgKg = con.loadImage("kg.png");
		BufferedImage imgExplosion = con.loadImage("explosion.png");
		BufferedImage imgSpongebobLook = con.loadImage("spongeboblook.png");
		int intKgY;
		con.drawImage (imgClass,0,0);
		con.clear();
		//Ani,ation loop: Kg mass goes from top to bottom 
		for(intKgY = 0;intKgY<550;intKgY+=5){
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1280,720);
			con.drawImage (imgClass,0,0);
			con.drawImage (imgSpongebobLook, 100,300);
			con.drawImage (imgSquidward, 1100,200);
			con.drawImage (imgKg, 640,intKgY);
			con.repaint();
			con.sleep(10);
		}
		con.drawImage(imgExplosion, 200,200);
		con.sleep(1000);
		con.setDrawColor(Color.WHITE);
		con.println("The 100kg ball is very heavy and you drop it on your foot!");
		con.drawString("That is unsafe!",250,80);
		con.println("You did not pass the lab.");
		con.sleep(10000);
		con.closeConsole();
	}
	public static void scene16(Console con){
		//Spongebob drops the 100g ball 1m and measures the time for 5 trials 
		//Squidward explains the formula for calculating acceleration 
		con.clear();
		BufferedImage imgSpongebobLook = con.loadImage("spongeboblook.png");
		BufferedImage imgClass = con.loadImage("class.png");
		BufferedImage imgSquidward = con.loadImage("squidward.png");
		BufferedImage imgTimer = con.loadImage("clock.png");
		BufferedImage imgMass = con.loadImage("mass.png");
		con.drawImage (imgClass,0,0);
		int intCount;
		int intMassY;
		intCount = 1;
		double dblTime;
		double dblTimeAvg;
		dblTimeAvg = 0;
		double dblAcceleration;
		double dblAccelerationRounded;
		con.println("You measure the time it takes for the ball to fall 1m for 5 trials.");
		con.drawString("d = vit + 1/2at^2, solve for a",250,800);
		//Animation Loop: mass goes from top to bottom
		for(intMassY = 0;intMassY<550;intMassY+=5){
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1280,720);
			con.setDrawColor(Color.WHITE);
			con.drawImage (imgClass,0,0);
			con.drawImage (imgSquidward, 1100,200);
			con.drawImage (imgSpongebobLook, 100,300);
			con.drawImage (imgTimer, 640, 520);
			con.drawImage (imgMass, 640,intMassY);
			con.repaint();
			con.sleep(10);
		}
		//Player keeps entering time values until they have entered 5 time values
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
		scene17(con, dblAccelerationRounded);
	}
	public static void scene17(Console con, double dblAccelerationRounded){
		//Squidward asks Spongebob for % error
		double dblError;
		double dblErrorRounded;
		double dblErrorInput;
		dblError = (Math.abs(dblAccelerationRounded-9.8))/9.8*100;
		dblErrorRounded=Math.round(dblError);
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(Color.WHITE);
		con.setTextColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		con.drawImage (imgSpongebob, 100,100);
		BufferedImage imgSquidward = con.loadImage("squidward.png");
		con.drawImage (imgSquidward, 1100, 200);
		con.println("Enter the % error if the actual acceleration is 9.8");
		con.drawString("% error is (|exp-act|)/act * 100%",250,80);
		con.println("Round to nearest whole number");
		dblErrorInput = con.readDouble();
		//If the % error the player enters is correct 
		if(dblErrorInput == dblErrorRounded){
			scene19(con);
		//If the % error the player enters is incorrect
		}else{
			scene18(con);
		}
		
	}
	public static void scene18(Console con){
		//Squidward says Spongebob's % error was wrong 
		//Player does not pass lab 
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		con.drawImage (imgSpongebob, 100,100);
		BufferedImage imgSquidward = con.loadImage("squidward.png");
		con.drawImage (imgSquidward, 1100, 200);
		con.println("You did not pass the lab");
		con.drawString("% error incorrect!",250,80);
		con.sleep(10000);
		con.closeConsole();
	}
	public static void scene19(Console con){
		//Squidward says Spongebob's % error was correct 
		//Squidward asks for the number of sig figs in a number
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		con.drawImage (imgSpongebob, 100,100);
		BufferedImage imgSquidward = con.loadImage("squidward.png");
		con.drawImage (imgSquidward, 1100, 100);
		int intSigFigs;
		con.clear();
		con.drawString("The % error is correct!",250,80);
		con.println("Enter # of sig figs in 100g");
		con.drawString("How many sig figs?",250,140);
		intSigFigs = con.readInt();
		//If the player enters "1" for number of sig figs, they pass and move on, if not they fail 
		if(intSigFigs == 1){
			scene21(con);
		//If the player enters any other number
		}else{
			scene20(con);
		}		
	}
	public static void scene20(Console con){
		//Squidward says the player counted sig figs wrong 
		//Player does not pass lab
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280, 720);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		con.drawImage (imgSpongebob, 100,100);
		BufferedImage imgSquidward = con.loadImage("squidward.png");
		con.drawImage (imgSquidward, 1100, 200);
		con.drawString("Sig fig wrong",250,80);
		con.println("You did not pass the lab.");
		con.sleep(10000);
		con.closeConsole();
	}
	public static void scene21(Console con){
		//Squidward says the player counted correct # of sig figs 
		//Squidward asks which factor is ignored for objects in free fall
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280, 720);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		con.drawImage (imgSpongebob, 100,100);
		BufferedImage imgSquidward = con.loadImage("squidward.png");
		con.drawImage (imgSquidward, 1100, 200);
		String strFactor;
		con.clear();
		con.drawString("Sig fig correct!",250,80);
		con.drawString("When objects are in free fall something is ignored",250,140);
		con.println("___ __________ is ignored for objects in free fall.");
		strFactor = con.readLine();
		//If the player enters "air resistance"
		if(strFactor.equalsIgnoreCase("air resistance")){
			scene23(con);
		//If the player enters anything else
		}else{
			scene22(con);
		}
	}
	public static void scene22(Console con){
		//Squidward says the player gave a factor that was wrong
		//Player does not pass lab
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280, 720);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		con.drawImage (imgSpongebob, 100,100);
		BufferedImage imgSquidward = con.loadImage("squidward.png");
		con.drawImage (imgSquidward, 1100, 200);
		con.drawString("That isn't a factor!",250,80);
		con.println("You did not pass the lab");
		con.sleep(10000);
		con.closeConsole();
	}
	public static void scene23(Console con){
		//Squidward says the factor of air resistance is correct
		//Player passes lab
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280, 720);
		con.setDrawColor(Color.WHITE);
		BufferedImage imgClass = con.loadImage("class.png");
		con.drawImage (imgClass,0,0);
		BufferedImage imgSpongebob = con.loadImage("spongebob.png");
		con.drawImage (imgSpongebob, 100,100);
		BufferedImage imgSquidward = con.loadImage("squidward.png");
		con.drawImage (imgSquidward, 1100, 200);
		con.drawString("Good job!",250,80);
		con.println("You passed the lab with 100%!");
		con.sleep(10000);
		con.closeConsole();
	}
}
