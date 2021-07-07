package gestoreRistorante.cameriere;

/**
 * Viene creata la classe Tavolo (back-end), grazie alla quale viene identificato un tavolo.
 *
 */
public class Tavolo {
	
	/**
	 * Ogni tavolo è caratterizzato da 3 valori: un nome, un numero e uno stato.
	 */
	private String nome;
	private int numero;
	private String stato;
	
	/**
	 * Con il costruttore è possibile prendere in input 3 valori, che poi vengono associati alle istanze della classe Piatto.
	 * @param nome: rappresenta il nome del tavolo(tavolo1, tavolo2,ecc).
	 * @param numero: rappresenta il numero del tavolo (1, 2, ecc).
	 * @param stato: rappresenta lo stato dell'ordine di quel tavolo (NI : non inserito, I: inserito, E: evaso).
	 */
	public Tavolo(String name, int num, String status) {
		this.nome = name;
		this.numero = num;
		this.stato = status;
	}
	
	/**
	 * @return il nome del tavolo.
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome: cosi si imposta il nome da associare al tavolo.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return il numero del tavolo.
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero: cosi si imposta il numero del tavolo.
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * @return lo stato dell'ordine.
	 */
	public String getStato() {
		return stato;
	}
	/**
	 * @param stato: cosi si imposta lo stato dell'ordine
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

}
