package Chef;
/**
 * Viene creata la classe Piatto, grazie alla quale viene identificato un piatto all'interno del menù.
 *
 */
public class Piatto {
	
	/**
	 * Ogni piatto è caratterizzato da 4 valori: una categoria, un nome, un prezzo e un intero che identifica la categoria.
	 */
	private String category;
	private String name;
	private String price;
	private int numcategory;
	
	/**
	 * Con il costruttore è possibile prendere in input 4 valori, che poi vengono associati alle istanze della classe Piatto.
	 * @param categoria: rappresenta la portata(Antipasti, Primi, Secondi, ecc).
	 * @param nome: rappresenta il nome del piatto(Carbonara, lasagna,ecc).
	 * @param prezzo: rappresenta il prezzo del piatto (€10, €1.50, ecc).
	 * @param numcategoria: rappresenta l'identificatore della categoria (Antipasti=0, Primi=1,ecc).
	 */
	public Piatto(String categoria, String nome,String prezzo, int numcategoria) 
	 
	 {
		this.category=categoria;
		this.name= nome;
		this.price=prezzo;
		this.numcategory=numcategoria;
	 }
	
	/**
	 * Con questo secondo costruttore è possibile inserire il nome e l'ID della categoria.
	 * @param categoria:rappresenta la portata(Antipasti, Primi, Secondi, ecc).
	 * @param numcategoria: rappresenta l'identificatore della categoria (Antipasti=0, Primi=1,ecc).
	 */
	public Piatto(String categoria, int numcategoria) {
		this.category=categoria;
		this.numcategory=numcategoria;
	}
	
	/**
	 * @return la categoria in cui è inserito un piatto.
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category : così si imposta la categoria da inizializzare.
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return il prezzo associato ad un piatto.
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param prize: così si imposta il prezzo da associare ad un piatto.
	 */
	public void setPrice(String prize) {
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
	public void setNumcategory(int numcategory) {
		this.numcategory = numcategory;
	}
}


