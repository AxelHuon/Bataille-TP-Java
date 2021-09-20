package jeudecarte;

import java.util.ArrayList;
import java.util.Collections;


public class DeckOfCards {
	    public ArrayList<Card> AllCards;
	    public ArrayList<Card> getAlCards() {
        return AllCards;
        
    }
	
    public DeckOfCards()
    {
        this.AllCards = new ArrayList<Card>();
        //Construction des cartes 2 � 14
            String[] couleurs = {"Trefles", "Coeur", "Picque", "Carreau"};
            int [] valeurs = {2,3,4,5,6,7,8,9,10,11,12,13,14};	
            for (String arrayColor : couleurs) //On lui donne une couleur
            for (int arrayValeurs : valeurs)//On lui donne une valeurs
            {
            	AllCards.add(new Card(arrayColor, arrayValeurs)); //Ajoute une carte au deck 
            }
            Collections.shuffle(AllCards);
        }
    

    public void splitDeck(DeckOfCards deck, Joueur j1, Joueur j2)
    {
        int numberOfCardEachPlayer = deck.AllCards.size() / 2;
        j1.createPlayerDeck(0, numberOfCardEachPlayer, AllCards);
        j2.createPlayerDeck(numberOfCardEachPlayer, deck.AllCards.size(), AllCards);
    }
    
    

}
    
 
	
