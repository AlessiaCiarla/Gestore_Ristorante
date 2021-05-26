package gestore_ristorante.cameriere;

public class Tavolo {
	
	private String nome_tavolo;
	private int numero_tavolo;
	private String stato;
	
	public Tavolo (String nome, int numero, String status) {
			this.nome_tavolo=nome;
			this.numero_tavolo=numero;
			this.stato=status;
	}

	/**
	 * @return the nome_tavolo
	 */
	public String getNome_tavolo() {
		return nome_tavolo;
	}

	/**
	 * @param nome_tavolo the nome_tavolo to set
	 */
	public void setNome_tavolo(String nome_tavolo) {
		this.nome_tavolo = nome_tavolo;
	}

	/**
	 * @return the numero_tavolo
	 */
	public int getNumero_tavolo() {
		return numero_tavolo;
	}

	/**
	 * @param numero_tavolo the numero_tavolo to set
	 */
	public void setNumero_tavolo(int numero_tavolo) {
		this.numero_tavolo = numero_tavolo;
	}

	/**
	 * @return the stato
	 */
	public String getStato() {
		return stato;
	}

	/**
	 * @param stato the stato to set
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

}
