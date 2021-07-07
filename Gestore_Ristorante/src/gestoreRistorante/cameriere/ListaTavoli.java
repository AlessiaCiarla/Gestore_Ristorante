package gestoreRistorante.cameriere;

import java.io.*;
import java.util.ArrayList;

import gestoreRistorante.Lista;

/**
* Classe back-end che contiene l'ArrayList di tutti i tavoli e gestisce vari metodi che saranno usati nella classe 
* ElencoTavoliCameriere(front-end).
*/
public class ListaTavoli implements Lista {
	
	/**
	 * Viene creato un ArrayList contenente oggetti di tipo Tavolo.
	 * Viene salvato un file preso in input con l'indirizzo, in una variabile, "file".
	 */
	ArrayList<Tavolo> listatavoli = new ArrayList<Tavolo>();
	File file = new File("file/lista_tavoli.txt");
	
	/**
	 * Con il costruttore leggo l'ArrayList contenente oggetti di tipo Tavolo, usando il metodo read() creato più avanti, 
	 * al fine di popolare immediatamente il pannello grafico usato in ElencoTavoliCameriere.
	 */
	public ListaTavoli () {
		read();
	}
			
	/**
	 * Metodo grazie al quale è possibile ricavare un tavolo di tipo Tavolo nell'Arraylist listatavoli.
	 * @param indice: un indice di tipo intero.
	 * @return l'oggetto di tipo Tavolo all'indice passato in input.
	 */
	public Tavolo getTavolo(int indice) {
		return listatavoli.get(indice);
	}
	
	/**
	 * Metodo grazie al quale si ricava la lunghezza dell'Arraylist listatavoli.
	 * @return la  lunghezza di listatavoli.
	 */
	public int size() {
		return listatavoli.size();
	}
	
	/**
	 * Legge dal file in cui è contenuta la lista dei tavoli e lo copia all'interno dell'ArrayList.
	 */
	public void read() {
		try {
			
		    /**
		     * Crea un oggetto BufferedReader per leggere l'input del file.
		     */
			BufferedReader reader = new BufferedReader(new FileReader(file));
		  
		    /**
		     * Legge il contenuto del file riga per riga.
		     */
		    String currentLine = reader.readLine();

		    while (currentLine != null) {
			    String[] datiPiatto = currentLine.split(",");
			   
			    String Name = datiPiatto[0];
			    String Numero = datiPiatto[1];
			    String Stato = datiPiatto[2];
			    int numint = Integer.parseInt(Numero);
			    
			    /**
			    * Crea un oggetto Piatto e lo aggiunge all'ArrayList.
			    */
			    listatavoli.add(new Tavolo( Name, numint, Stato));
			   
			    currentLine = reader.readLine();
		    }
		    reader.close();
		} catch (Exception ex) {
			System.out.println("Exception msg: "+ ex);
		}
	}
	
	@Override
	/**
	 * Prende il contenuto dell'ArrayList e lo scrive all'interno del file txt.
	 */
	public void write() {
		try { 
			/**
		     * Crea un oggetto BufferedWriter per scrivere l'output del file.
		     */
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			/**
			* Scrive ogni piatto all'interno del file di output.
			*/
			for (Tavolo datiPiatto : listatavoli) {
				writer.write(datiPiatto.getNome());
				writer.write("," + datiPiatto.getNumero());
			    writer.write(","  + datiPiatto.getStato());
			    writer.newLine(); 
			}
		
		    /**
		     * Chiude il file.
		     */
			writer.close();
		} catch (Exception ex) {
			System.out.println("Exception msg: "+ex);
		}
	}
}
