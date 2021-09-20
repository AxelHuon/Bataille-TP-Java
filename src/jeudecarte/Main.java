package jeudecarte;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String [] args ) {
		
			

        			
        
        
		//INITIALISATION JOUEUR1
		Scanner user_input = new Scanner( System.in );
		System.out.print("Entrez le nom du premier joueur : ");
		String name_joueur1;
		name_joueur1 = user_input.next( );
		Joueur j1 = new Joueur(name_joueur1);
		
		
		//INITIALISATION JOUEUR2
		Scanner user_input2 = new Scanner( System.in );
		System.out.print("Entrez le nom du deuxi�me joueur : ");
		String name_joueur2;
		name_joueur2 = user_input2.next( );
		Joueur j2 = new Joueur(name_joueur2);
	
		//PHRASE DE DEBUT DE JEU 
		System.out.println("La partie opesera donc : " + j1.getNom() + " VS " + j2.getNom() );
		user_input.close();
		user_input2.close();
		     
		
        DeckOfCards deck = new DeckOfCards();
        //Distribution des cartes
        deck.splitDeck(deck, j1, j2);

        while (j1.getAlPlayerDeck().size() > 0 && j2.getAlPlayerDeck().size()> 0) {
        	Card j1Card = j1.getPlayerFirstCard();
        	Card j2Card = j2.getPlayerFirstCard();
        	j1.removeTopCard();
        	j2.removeTopCard();
        	System.out.println(j1.getNom()+" joue la carte: " + j1Card.getValue()+ " de " + j1Card.getColor()+ "    VS    " + j2.getNom()+" joue la carte: " + j2Card.getValue()+ " de " + j2Card.getColor() );

            //Si le joueur1 à une meilleur carte
        	if (j1Card.getValue() > j2Card.getValue()) {
        		j1.addCard(j1Card);
        		j1.addCard(j2Card);
        		System.out.println(j1.getNom() + " Gagne la manche ");
        		
            //Si le joueur2 à une meilleur carte
        	} else if (j1Card.getValue() < j2Card.getValue()) {
        		j2.addCard(j1Card);
        		j2.addCard(j2Card);
        		System.out.println(j2.getNom() + " Gagne la manche ");
        	} 
            //Si les joueurs sont à égalités
        	else if (j1Card.getValue() == j2Card.getValue()) {
                //Si le joueur1 ne peut pas poser deux cartes sur le plateau
        		if (j1.getAlPlayerDeck().size()<2) {
            		System.out.println(j2.getNom() + " Gagne la Partie ");
        		}
                //Si le joueur2 ne peut pas poser deux cartes sur le plateau
        		else if (j2.getAlPlayerDeck().size()<2) {
            		System.out.println(j1.getNom() + " Gagne la Partie ");	
        		}
                //Si le joueur1 et 2 peuvent poser deux cartes sur le plateau
        		else if((j1.getAlPlayerDeck().size()>2) && (j2.getAlPlayerDeck().size()>2)   ){
        			System.out.println("Egalité, on rejoue une carte pour déterminer le gagnant");
                	Card j1Card2 = j1.getPlayerCardEgalite();
                	Card j2Card2 = j2.getPlayerCardEgalite();
                 	Card j1CardHide = j1.getPlayerCardHide();
                	Card j2CardHide = j2.getPlayerCardHide();
                  	j1.removeSecondCard();
                	j2.removeSecondCard();
                  	j1.removeCardHide();
                  	j2.removeCardHide();
                	System.out.println(j1.getNom()+" joue la carte: " + j1Card2.getValue()+ " de " + j1Card2.getColor()+ "    VS    " + j2.getNom()+" joue la carte: " + j2Card2.getValue()+ " de " + j2Card2.getColor() );
    	            	if (j1Card2.getValue() > j2Card2.getValue()) {	
    	            		j1.addCard(j1Card);
    	            		j1.addCard(j2Card);
    	            		j1.addCard(j1Card2);
    	            		j1.addCard(j2Card2);
    	            		j1.addCard(j1CardHide);
    	            		j1.addCard(j2CardHide);
    	            		System.out.println(j1.getNom() + " Gagne la manche ");
    	            	}	else if (j1Card2.getValue() < j2Card2.getValue()) {
    	            		j2.addCard(j1Card);
    	            		j2.addCard(j2Card);
    	            		j2.addCard(j1Card2);
    	            		j2.addCard(j2Card2);
    	             		j2.addCard(j1CardHide);
    	            		j2.addCard(j2CardHide);
    	                	System.out.println(j2.getNom() + " Gagne la manche ");
    	            	} else if (j1Card2.getValue() == j2Card2.getValue()) {
    		            		System.out.println("Egalité une nouvelle fois, on montre donc les cartes qui étaient cachées");
    		            		if (j1CardHide.getValue() > j2CardHide.getValue()) {	
    		                   		j1.addCard(j1Card);
    			            		j1.addCard(j2Card);
    			            		j1.addCard(j1Card2);
    			            		j1.addCard(j2Card2);
    			            		j1.addCard(j1CardHide);
    			            		j1.addCard(j2CardHide);
    			            		System.out.println(j1.getNom() + " Gagne la manche ");
    			            	}	else if (j1CardHide.getValue() < j2CardHide.getValue()) {
    			            		j2.addCard(j1Card);
    			            		j2.addCard(j2Card);
    			            		j2.addCard(j1Card2);
    			            		j2.addCard(j2Card2);
    			             		j2.addCard(j1CardHide);
    			            		j2.addCard(j2CardHide);
    			                	System.out.println(j2.getNom() + " Gagne la manche ");
    			            	}else if (j1CardHide.getValue() == j2CardHide.getValue()) {
    			            		j1.addCard(j1Card);
    			            		j1.addCard(j1Card2);
    			            		j1.addCard(j1CardHide);
    			            		j2.addCard(j2Card);
    			            		j2.addCard(j2Card2);
    			            		j2.addCard(j2CardHide);
    			                	System.out.println(j2.getNom() + "Triple égalité, le jeu des joueurs leurs ai re distriubuer ");
    	
    			            	}
    	            	}
    	            	
    	            	else if((j1.getAlPlayerDeck().size() >= 0)) {
    	            		System.out.println(j2.getNom() + " Gagne la Partie ");

    	            	}	else if((j2.getAlPlayerDeck().size() >= 0)) {
    	            		System.out.println(j1.getNom() + " Gagne la Partie ");
    	            	}
        		}
        		
            	if((j1.getAlPlayerDeck().size() >= 0)) {
            		System.out.println(j2.getNom() + " Gagne la Partie ");

            	}	else if((j2.getAlPlayerDeck().size() >= 0)) {
            		System.out.println(j1.getNom() + " Gagne la Partie ");
            	}
        		
        		
        		
        	
        		
	           
        	}
        	
        	//System.out.println(j1.getNom() + " " + j1.getScore() + "  vs  " + j2.getScore() + " " + j2.getNom());
        	
        	System.out.println("Taille du deck de "+j1.getNom()+" : "+j1.getAlPlayerDeck().size() +"   taille du deck de : " + j2.getNom()+" : "+j2.getAlPlayerDeck().size() + "\n");
        	
        	try{
    		  Thread.sleep(0);
    		} catch(InterruptedException ex){
    		  break;
    		}
        }

        
    }
}
	
        

	
	
	
	