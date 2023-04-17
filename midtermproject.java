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
			
		
		}
	}
	public static void scene1(Console con){
		BufferedImage imgCountryside = con.loadImage("countryside.jpeg");
		BufferedImage imgSchool = con.loadImage("school.png");
		con.drawImage(imgCountryside, 0,0);
		con.drawImage(imgSchool, 0,0);
		int intSpongebobX;
		int intCount;
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
	
	}
	public static void scene3(Console con){
		
	}
	public static void scene4(Console con){
		
	}
	public static void scene5(Console con){
		
	}
	public static void scene6(Console con){
		
	}
	public static void scene7(Console con){
		
	}
	public static void scene8(Console con){
		
	}
	public static void scene9(Console con){
		
	}
	public static void scene10(Console con){
		
	}
	public static void scene11(Console con){
		
	}
	public static void scene12(Console con){
		
	}
	public static void scene13(Console con){
		
	}
	public static void scene14(Console con){
		
	}
	public static void scene15(Console con){
		
	}
	public static void scene16(Console con){
		
	}
	public static void scene17(Console con){
		
	}
	public static void scene18(Console con){
		
	}
	public static void scene19(Console con){
		
	}
	public static void scene20(Console con){
		
	}
	public static void scene21(Console con){
		
	}
	public static void scene22(Console con){
		
	}
	public static void scene23(Console con){
		
	}
}
