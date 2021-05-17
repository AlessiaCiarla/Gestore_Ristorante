
public class Piatto {
	private String category;
	private String name;
	private double price;
	private int numcategory;
	
	public Piatto(String categoria, String nome,double prezzo, int numcategoria) 
	 
	 {
		this.category=categoria;
		this.name= nome;
		this.price=prezzo;
		this.numcategory=numcategoria;
	 }
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the prize
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param prize the prize to set
	 */
	public void setPrice(double prize) {
		this.price = prize;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the numcategory
	 */
	public int getNumcategory() {
		return numcategory;
	}
	/**
	 * @param numcategory the numcategory to set
	 */
	public void setNumcategory(int numcategory) {
		this.numcategory = numcategory;
	}
	
	
	
}


