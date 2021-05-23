package Chef;

/**
 * Viene creata la classe Piatto, grazie alla quale viene identificato un piatto all'interno del menï¿½.
 *
 */
public class Piatto{
	
	/**
	 * Ogni piatto è caratterizzato da 4 valori: una categoria, un nome, un prezzo e un intero che identifica la categoria.
	 */
	private String name;
	private double price;
	private int numcategory;
	
	/**
	 * Con il costruttore ï¿½ possibile prendere in input 4 valori, che poi vengono associati alle istanze della classe Piatto.
	 * @param nome: rappresenta il nome del piatto(Carbonara, lasagna,ecc).
	 * @param prezzo: rappresenta il prezzo del piatto (ï¿½10, ï¿½1.50, ecc).
	 */
	public Piatto(String nome, double prezzo,int numcat){
		
		this.name= nome;
		this.price=prezzo;
		this.numcategory=numcat;
		
	}
	
	/**
	 * @return il prezzo associato ad un piatto.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @param prize: cosï¿½ si imposta il prezzo da associare ad un piatto.
	 */
	public void setPrice(double prize) {
		this.price = prize;
	}
	
	/**
	 * @return il nome del piatto.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name : cosï¿½ si imposta il nome da associare ad un piatto.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return un intero che rappresenta l'identificatore della categoria.
	 */
	public int getNumcategory() {
		return numcategory;
	}
	
	/**
	 * @param numcategory : cosï¿½ si imposta l'intero da associare per una certa categoria.
	 */
	public void setNumcategory(int numcat) {
		this.numcategory = numcat;
	}
}


