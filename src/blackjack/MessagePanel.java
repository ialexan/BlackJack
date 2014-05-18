/**
 * Ishag Alexanian       CS203        
 * project BlackJack
 * The messagePanel is for displaying messages 
 */


package blackjack;

import java.awt.FontMetrics;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;



public class MessagePanel extends JPanel{
   private String message;
   
   private int xCoor = 20;
   private int yCoor = 20;
   
   private boolean centered;
   private int interval = 10;
   
   
   public MessagePanel(){}
   public MessagePanel(String message){ this.message = message;}
   
   public String getMessage(){ return this.message;}
   public void setMessage(String message){
	   this.message = message;
	   repaint();   
   }
   
   public void setCentered(boolean centered){
	   this.centered = centered;
	   repaint();
   }
   
   public int getInterval(){
	   return interval;
   }
   public void setInterval(int interval){
	   this.interval = interval;
	   repaint();
   }
   
   public int getXCoordinate(){ return xCoor;}
   public void setXCoordinate(int x){
	   this.xCoor = x;  
       repaint();
   }
   
   public int getYCoordinate(){ return yCoor;}
   public void setYCoordinate(int y){
	   this.yCoor = y;  
	   repaint();
   }
   
   protected void paintComponent(Graphics g){
	   super.paintComponent(g);
	   
	if (centered){   
	   FontMetrics fm = g.getFontMetrics();
	   
	   int stringWidth = fm.stringWidth(message);
	   int stringAscent = fm.getAscent();
	   
	   xCoor = getWidth()/2 - stringWidth/2;
	   yCoor = getHeight()/2 + stringAscent/2; 
	   
	   
	}
	g.drawString(message, xCoor, yCoor);
	
   }
   
   
}
