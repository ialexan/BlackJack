/**
 * Ishag Alexanian       CS203        
 * project BlackJack
 * The Game class is the main class that runs the GUI
 */


package blackjack;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Game extends JFrame {
	  private ImageIcon[] cards= new ImageIcon[53];    

	  // The Buttons
	  private JButton jbtDeal = new JButton("Deal");
	  private JButton jbtHitMe = new JButton("Hit Me");
	  private JButton jbtPass = new JButton("Pass");
	  
	  private String[] numberOfPlayers = {" 0 "," 1 "," 2 "," 3 "," 4 "," 5 "," 6 "};
	  private int numOfPlayers;
	  private JComboBox jcbo = new JComboBox(numberOfPlayers);
	
	  private Deck deck = new Deck();
	  
	  private JPanel p1 = new JPanel(); // Use the p1 panel to set up the Dealer 
	  private JPanel p2 = new JPanel(); // Use the p1 panel to set up the Players 
	  private JPanel p3 = new JPanel(); // Use the panel to group buttons
	  private JPanel jpMain = new JPanel();   
	  private PlayerPanel dealer = new PlayerPanel("Dealer",deck.getCard(), deck.getCard());
	  private ArrayList<PlayerPanel> players = new ArrayList<PlayerPanel>();
	  private Boolean Bool=true;
	  private Timer timer;
	  
	  
	  
	  public Game(){
    
	    jpMain.setLayout(new BorderLayout(5,5));
		
	    
		p1.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		
		p1.setPreferredSize(new Dimension(400,200));			 
		    p1.add(dealer);
		
		jpMain.add(p1, BorderLayout.NORTH);  // Add the Dealer to the frame
		    
		    
						
	    //  p2 where the players goes 
		//p2.setLayout(new GridLayout(2,3,5,5));  //   new GridLayout(1,6,5,5)   Here is my problem  
		p2.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
        
		jpMain.add(p2,BorderLayout.CENTER); // Add the players to the frame
			
			
		
		p3.setBackground(Color.cyan);
		p3.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		    JLabel jlPlayer = new JLabel("               Choose The Number Of Players:");
		    p3.add(jlPlayer);
		    p3.add(jcbo);
		    JLabel jlSpace = new JLabel("                   ");
		    p3.add(jlSpace);
		    p3.add(jbtDeal);
		    
		    jbtDeal.setEnabled(false);
		    jbtHitMe.setEnabled(false);
		    jbtPass.setEnabled(false);
		    p3.add(jbtHitMe);
		    p3.add(jbtPass); 
		    
		    
		    
		jpMain.add(p3, BorderLayout.SOUTH); // Add buttons to the frame
		    
		    
		jpMain.doLayout();
		add(jpMain, BorderLayout.CENTER);   
		
		    //***************************************************************************************


		    jbtDeal.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		         Deal();
		      }
		    });

		    jbtHitMe.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  HitMe();
		      }
		    });
		    
		    jbtPass.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent e) {

			      Pass();  	  
			    	  
			      }
			    });

		    jcbo.addItemListener(new ItemListener() {
			      public void itemStateChanged(ItemEvent e) {
			    	  setDisplay(jcbo.getSelectedIndex());  
						      }
						    });
		    

		  }
	  
	  public void setDisplay(int index){
		  
		  
		  if (Bool){
			  jbtDeal.setEnabled(true);
			  jcbo.setEnabled(false);
			  numOfPlayers = index;
			  
			  for (int i=0; i<numOfPlayers;i++){
			      players.add(new PlayerPanel());
			      players.get(i).setName("Player "+(i+1));
			      p2.add(players.get(players.size()-1));
			      p2.doLayout();
			     
		      }
			  
			  numOfPlayers = 0;
			  
			  Bool=false;
		  }
		  
		  jpMain.validate();
		  
		  
	  }
	  
	  
	  
	  public void Deal() { 
		  jbtDeal.setEnabled(false);
		  jbtHitMe.setEnabled(true);
		  jbtPass.setEnabled(true);
		  
		  for (int i=0; i<players.size(); i++){
			  players.get(i).Deal(deck.getCard(), deck.getCard());
	      }
		  players.get(numOfPlayers).Turn(true);
		  
		  if (players.get(numOfPlayers).End()){
			     players.get(numOfPlayers).SetEnd(true);
		    	 players.get(numOfPlayers).Turn(false);
		    	 numOfPlayers++;
		     }
		  
		  jpMain.validate();
			
		  
	  }
	  
		public void HitMe(){
			
			if (numOfPlayers == players.size()){
			      	   
				  jbtHitMe.setEnabled(false);
				  jbtPass.setEnabled(false); 
				  timer = new Timer(1000, new TimerListener());
		          timer.start();  
            }  
		      
			else {
			     players.get(numOfPlayers).addingimages(deck.getCard());
			     if (players.get(numOfPlayers).End()){
			    	 players.get(numOfPlayers).Turn(false);
			    	 numOfPlayers++;
			     }
			     
			}
		
			
			if (numOfPlayers == players.size()){
				  jbtHitMe.setEnabled(false);
				  jbtPass.setEnabled(false); 
				  timer = new Timer(1000, new TimerListener());
		          timer.start();
           } 
			else 
			   players.get(numOfPlayers).Turn(true);
			jpMain.validate();
		}
		
		
		
		public void Pass(){ 
			
			players.get(numOfPlayers).SetEnd(true);
			players.get(numOfPlayers).Turn(false);
			
			jpMain.validate();
			numOfPlayers++;
	
			
			
			if (numOfPlayers == players.size()){
				  jbtHitMe.setEnabled(false);
				  jbtPass.setEnabled(false);
				  timer = new Timer(1000, new TimerListener());
		          timer.start(); 
            }
			else 
			   players.get(numOfPlayers).Turn(true);
			
			jpMain.validate();
		}
		
		
		
	    class TimerListener implements ActionListener {
	        //Handle The Timer ActionEvent
	           public void actionPerformed(ActionEvent e) {
	        	   dealer.Turn(true);
	        	   jpMain.validate();
	        	   
	        	   if (dealer.getScore()>=17){
	        		   dealer.SetEnd(true); 
	        		   jpMain.validate();
	        	   }  
	        	   
	        	   if (!dealer.End()){
	        		   dealer.addingimages(deck.getCard());
	        		   jpMain.validate();
	 			   }
	        	   else {
	        		   timer.stop();
	        		   jpMain.validate();
	        		   
	        		   JLabel jlWinner = new JLabel("      Winners: ");
	        		   JLabel jlResult = new JLabel("");	
	        		   
	        		   p3.add(jlWinner);
	        		   p3.add(jlResult);
	        		   
	        		   String str="";
	        		   Boolean bool=false;
	        		  
	        		   
	        		   if (dealer.getScore()>21){
	        			   for (int i=0; i<players.size();i++){
	        				   if (players.get(i).getScore()<=21)   
	        				      str +=   players.get(i).getName() + " ";
	        			   }
	        			   str += " Wins!!";
	        			   
	        		   }
	        		   
	        		   else {
	        			   for (int i=0; i<players.size();i++){
	        				   if (players.get(i).getScore()<=21){   
	        				        if (players.get(i).getScore()>dealer.getScore()){
	        			                str +=   players.get(i).getName() + " Wins! ";
	        			                bool =true;   
	        				        }   
	        				        else if (players.get(i).getScore()==dealer.getScore()){
	        				    	    str +=   players.get(i).getName() + " PUSH! ";
	        				            bool = true;
	        				        }   
	        		           }
	        				   
	        				   
	        			   }
	        			   if (bool==false)
	        				   str += "Dealer Wins!";
	        			   
	        			   
	        		   }
	        		   
	
        					  
        					  
        					  jlResult.setText(str);
	        		   
	        		   
	        		   
	        		   
	        	   }
	        	   
	        	   jpMain.validate();
	             
	            }
	        }
	  
	  
	

	public static void main(String[] args) {
		  Game frame = new Game();
		  frame.setTitle("BlackJack");
		  frame.setSize(900, 750);
		  frame.setLocationRelativeTo(null); // Center the frame
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);
	}
	
}
