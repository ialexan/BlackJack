/**
 * Ishag Alexanian       CS203        
 * project BlackJack
 * The PlayerPanel is for displaying each player in the GUI
 */


package blackjack;

import javax.swing.*;

import java.awt.*;

public class PlayerPanel extends JPanel{
	 
	  private Player playerHand = new Player();
	  private MessagePanel panMessage = new MessagePanel("");
	  private ImageViewer panImage = new ImageViewer();
	  private ImageViewer panImage2 = new ImageViewer();
	  private MessagePanel panMessageScore = new MessagePanel("");
	  
	  private JPanel panelDealerImage = new JPanel();
	  private JPanel panelDealer = new JPanel();
	  private JPanel panelDealerScore = new JPanel();
	 
	  private Card c = new Card(); // The First card
	  
	  private ImageIcon[] cards= new ImageIcon[53];
	  private JPanel jp = new JPanel();
	  
	  private Boolean boolEnd=false;
	  private String name="";
	  private JLabel panmes = new JLabel("");
	  
	  
	  
	 public PlayerPanel(){
		
			jp.setBackground(Color.green);
			jp.setLayout(new BorderLayout(5,5));
			jp.setPreferredSize(new Dimension(865,200));
		 
		    add(jp,BorderLayout.CENTER);
		 
	 }
	 
	  
	public PlayerPanel(String name, Card c, Card c2){
		jp.setBackground(Color.green);
		jp.setLayout(new BorderLayout(5,5));
		jp.setPreferredSize(new Dimension(865,200));
		this.name=name;
		
		Deal(c,c2);
		
	    add(jp,BorderLayout.CENTER);
	}
	
	
	
	public void Deal(Card c, Card c2){
		
		 for (int i=0; i<=52; i++)
			 cards[i] = new ImageIcon("image/"+(i)+".png");
		
		 this.c = c;
		 
		 playerHand.addCard(c);
		 playerHand.addCard(c2);
		 
		 
		panelDealerImage.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
		//panelDealerImage.setPreferredSize(new Dimension(240, 126));
		panelDealerImage.setBackground(Color.green);
		
        if(this.name=="Dealer") 
		   panImage.setImage(cards[52].getImage());  	
        else 
        	panImage.setImage(cards[c.getVal()].getImage()); 	
		
		panImage.setYCoordinate(20);
		panImage.setXCoordinate(10);
		panImage.setPreferredSize(new Dimension(82, 126));
		panImage.setBackground(Color.green);
		panImage.isStretched();
		panelDealerImage.add(panImage);
	    
		
		panImage2.setImage(cards[c2.getVal()].getImage());  	
		panImage2.setYCoordinate(20);
		panImage2.setXCoordinate(10);
		panImage2.setPreferredSize(new Dimension(82, 126));
		panImage2.setBackground(Color.green);
		panelDealerImage.add(panImage2);
				
		jp.add(panelDealerImage, BorderLayout.NORTH);

		
		panelDealer.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
		panMessage.setMessage(this.name);
		panMessage.setYCoordinate(15);
		panMessage.setXCoordinate(30);
		panMessage.setPreferredSize(new Dimension(100, 120));
		panMessage.setBackground(Color.green);
		//panelDealer.setPreferredSize(new Dimension(200, 120));
		panelDealer.setBackground(Color.green);
		
		panelDealer.add(panMessage);
		jp.add(panelDealer, BorderLayout.CENTER);
		
		
		panelDealerScore.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		panelDealerScore.setBackground(Color.green);
		JLabel jlScore = new JLabel("Score =");
		jlScore.setBackground(Color.green);
		panelDealerScore.add(jlScore);
		panelDealerScore.setBackground(Color.green);
		
		if(this.name=="Dealer") 
	 	  panMessageScore.setMessage((c2.getValue())+"");
		else 
			panMessageScore.setMessage(playerHand.getScore()+"");
		
		
		panMessageScore.setPreferredSize(new Dimension(100, 30));			
		panMessageScore.setBackground(Color.green);
		panelDealerScore.add(panMessageScore); 
	    jp.add(panelDealerScore,BorderLayout.SOUTH); 
    
	
		 
		  panmes.setPreferredSize(new Dimension(82,96));
	    
	    if (playerHand.getScore()==21 && this.name!="Dealer"){
			  panImage.setImage(cards[c.getVal()].getImage());
			  panmes.setText("  BlackJack!");
			  panelDealerImage.add(panmes);
			  panMessageScore.setMessage(playerHand.getScore()+""); 
			  boolEnd = true;
		  }
	    
		
	}
		
	
	
	public Boolean End(){
		return boolEnd;
	}
	
	
	public void SetEnd(Boolean end){
		if(this.name=="Dealer"){
		   panImage.setImage(cards[c.getVal()].getImage()); 
		   if (playerHand.getScore()==21){
				  panImage.setImage(cards[c.getVal()].getImage());
				  panmes.setText("  BlackJack!");
				  panelDealerImage.add(panmes);
		             
		}
		   panMessageScore.setMessage(playerHand.getScore() + "");
		   
		}   
		
		boolEnd = end;
	}
	
	public int getScore(){
		//return Integer.parseInt(panMessageScore.getMessage());
		return playerHand.getScore();
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public void Turn(Boolean bolor){
	  if (bolor){	
		 panMessage.setBackground(Color.yellow);
		 panMessage.setFont(new Font("SanSerif", Font.ITALIC,14)); 
	  }	 
	  else{
		  panMessage.setBackground(Color.green);
		  panMessage.setFont(new Font("Times", Font.ITALIC,12)); 
		      
	  }	  
	}
	
	
	
	public void addingimages(Card cardDeal){

		 ImageViewer panImage1 = new ImageViewer();
		 
			
			playerHand.addCard(cardDeal);
		 
		 
		  panImage1.setLayout(new FlowLayout());
		  panImage1.setImage(cards[cardDeal.getVal()].getImage());
		  panImage1.setVisible(true);
		  panImage1.setYCoordinate(20);
		  panImage1.setXCoordinate(10);
		  panImage1.setPreferredSize(new Dimension(82, 126));
		  panImage1.setBackground(Color.green);
		  
		  panelDealerImage.add(panImage1);
		  //panelDealerImage.doLayout();
		  panelDealerImage.setBackground(Color.green);
		  
	
		  
	
		  
			
			
		  if (playerHand.getScore()==21){
			  panImage.setImage(cards[c.getVal()].getImage());
			  panmes.setText("  BlackJack!");
			  panelDealerImage.add(panmes);

			  boolEnd = true;
		  }
		  
		  else if (playerHand.getScore()>21){
			  panImage.setImage(cards[c.getVal()].getImage());
			  panmes.setFont(new Font("SanSerif", Font.ITALIC,14));
			  panmes.setBackground(Color.red);
			  panmes.setText("  Busted!");
			  panelDealerImage.add(panmes);  	
			  boolEnd = true;
		  }
		  
		  panMessageScore.setMessage(playerHand.getScore() + "");
		  panMessageScore.setBackground(Color.green);		
		
	}
		    
			


}
