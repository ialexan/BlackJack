/**
 * Ishag Alexanian       CS203        
 * project BlackJack
 * The ImageViewer class is for displaying the card pictures 
 */

package blackjack;

import java.awt.*;

import javax.swing.*;

public class ImageViewer extends JPanel{
   private java.awt.Image image;
   
   private int xCoor=0;
   private int yCoor=0;
   
   private boolean stretched = false;
   public ImageViewer(){}
   public ImageViewer(Image image){this.image = image;}
   
   protected void paintComponent(Graphics g){
	   super.paintComponent(g);
	   
	   if (image!=null)
		  if (isStretched())  
	        g.drawImage(image, xCoor, yCoor,getSize().width,getSize().height, this);    
	     else
		   g.drawImage(image, xCoor, yCoor,this); 
   }
   
   public boolean isStretched(){ return stretched;} 
   
   public java.awt.Image getImage(){return image;}
   public void setImage(java.awt.Image image){this.image = image; repaint();}
   
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

}
