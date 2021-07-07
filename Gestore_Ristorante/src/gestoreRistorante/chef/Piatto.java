package gestoreRistorante.chef;

/**
 * Viene creata la classe Piatto (back-end), grazie alla quale viene identificato un piatto all'interno del menù.
 *
 */
public class Piatto {
	
	/**
	 * Ogni piatto è caratterizzato da 3 valori: un nome, un prezzo e un intero che identifica la categoria.
	 */
	private String name;
	private double price;
	private int numcategory;
	
	/**
	 * Con il costruttore è possibile prendere in input 3 valori, che poi vengono associati alle istanze della classe Piatto.
	 * @param nome: rappresenta il nome del piatto(Carbonara, lasagna,ecc).
	 * @param prezzo: rappresenta il prezzo del piatto (10, 11.50, ecc).
	 * @param numcat: rappresenta il numero della categoria (0: antipasti, 1: primi, 2: secondi,ecc).
	 */
	public Piatto(String nome, double prezzo,int numcat) {
		this.name = nome;
		this.price = prezzo;
		this.numcategory = numcat;
	}
	
	/**
	 * @return il prezzo associato ad un piatto.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @param prize: così si imposta il prezzo da associare ad un piatto.
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
	 * @param name : così si imposta il nome da associare ad un piatto.
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
	 * @param numcategory : così si imposta l'intero da associare per una certa categoria.
	 */
	public void setNumcategory(int numcat) {
		this.numcategory = numcat;
	}
	
	/*
	 * Il metodo equals è caratteristico di tutte le classi, ma bisogna implementarlo, essendo Piatto una nuova classe creata.
	 * Utile al fine di confrontare due oggetti di tipo Piatto.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Piatto)) {
			return false;
		}
		Piatto other = (Piatto) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (numcategory != other.numcategory) {
			return false;
		}
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
			return false;
		}
		return true;
	}
}


