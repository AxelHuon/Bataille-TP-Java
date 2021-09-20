package jeudecarte;
import java.util.ArrayList;

public class Joueur {
	
	private String nom; 
    public ArrayList<Card> alPlayerDeck = new ArrayList<Card>();

    

	public Joueur (String nom) {
		this.nom= nom;
		
	}

	
	public void addCard(Card card) {
		this.alPlayerDeck.add(card);
	}
	
	
	public void removeTopCard() {
		this.alPlayerDeck.remove(0);
	}
	
	
	public void removeSecondCard() {
		this.alPlayerDeck.remove(2);
	}
	
	public void removeCardHide() {
		this.alPlayerDeck.remove(1);
	}
	
	//GET
	public String getNom() {
		return nom;
	}

	
    public Card getPlayerFirstCard() {
    	return alPlayerDeck.get(0);
    }
	
	
    public Card getPlayerCardEgalite() {
    	return alPlayerDeck.get(2);
    }
	
    public Card getPlayerCardHide() {
    	return alPlayerDeck.get(1);
    }
	
    
    
    
    
    
    
    
    public void createPlayerDeck(int start, int end, ArrayList<Card> alCards)
    {
        for (int i = start; i < end; i++)
            this.alPlayerDeck.add(alCards.get(i));
    }
   
    
    public ArrayList<Card> getAlPlayerDeck()
    {
        return alPlayerDeck;
    }

	
}