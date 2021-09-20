package jeudecarte;

public class Card {
	
	    private String couleurs;
	    private int valeurs;

	    public Card(String couleurs, int valeurs)
	    {
	        this.couleurs = couleurs;
	        this.valeurs = valeurs;
	    }

	    private String verifyName(int valeurs)
	    {
	        switch (valeurs)
	        {
	            case 11:
	                return "Valet";
	            case 12:
	                return "Roi";
	            case 13:
	                return "Reine";
	            case 14:
	                return "As";
	            default:
	                return String.valueOf(valeurs);
	        }
	    }
	    
	    public int getValue()
	    {
	        return valeurs;
	    }
	 
	    
	    public String getColor()
	    {
	        return couleurs;
	    }
	 
	   
	    public String toString()
	    {
	        String card = verifyName(valeurs) +" de " +   couleurs ;
	        return card;
	    }
	
	    
	}
