package gestoreRistorante.cameriere;

import java.io.*;
import java.util.*;

import gestoreRistorante.Lista;
import gestoreRistorante.chef.OrdinaPiatti;
import gestoreRistorante.chef.Piatto;

/**
* Classe back-end che contiene l'ArrayList di tutti i piatti ordinati, e gestisce vari metodi che saranno usati nella classe 
* TavoloSingolo e RiepilogoCameriere(front-end).
*/
public class Ordinazione implements Lista {
	
	/**
	 * Viene creato un ArrayList contenente oggetti di tipo Tavolo.
	 * Viene salvato un file preso in input con l'indirizzo, in una variabile "file".
	 */
	ArrayList<Piatto> listapiatti = new ArrayList<Piatto>();
	File file = new File("file/appoggio.txt");
	
	/**
	 * Con il costruttore leggo l'ArrayList contenente oggetti di tipo Piatto, usando il metodo read() creato più avanti.
	 */
	public Ordinazione () {
		read();
	}

	/**
	 * Aggiunge un piatto all'ArrayList dei piatti.
	 * @param piatto è il piatto da aggiungere.
	 */
	public void add(Piatto datiPiatto) {
		if (!listapiatti.contains(datiPiatto)) {
			listapiatti.add(datiPiatto);
		}
	}
	
	/**
	 * Ordina la lista dei piatti tramite una Collections.sort.
	 * Questo avviene tramite la creazione di un nuovo oggetto di tipo OrdinaPiatti.
	 */
	public void sort() {
		Collections.sort(listapiatti, new OrdinaPiatti());
	}
	
	/**
	 * Rimuove tutto il contenuto dell'ArrayList.
	 */
	public void clear() {
		listapiatti.clear();
	}
	
	/**
	 * Metodo grazie al quale è possibile ricavare un piatto di tipo Piatto nell'Arraylist listapiatti.
	 * @param indice: un indice di tipo intero.
	 * @return l'oggetto di tipo Piatto all'indice passato in input.
	 */
	public Piatto getPiatto(int indice) {
		return listapiatti.get(indice);
	}
	
	/**
	 * Metodo grazie al quale si ricava la lunghezza dell'Arraylist listapiatti.
	 * @return la  lunghezza di listapiatti.
	 */
	public int size() {
		return listapiatti.size();
	}

	/**
	 * Legge dal file in cui è contenuta l'ordinazione e lo copia all'interno dell'ArrayList.
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
			    String Price = datiPiatto[1];
			    String NumCat = datiPiatto[2];
			    int numint = Integer.parseInt(NumCat);
			    double prezzo = Double.parseDouble(Price);
			    /**
			    * Crea un oggetto Piatto e lo aggiunge all'ArrayList.
			    */
			    listapiatti.add(new Piatto( Name, prezzo, numint));
			   
			    currentLine = reader.readLine();
		    }
		    reader.close();
		} catch (Exception ex) {
			System.out.println("Exception msg: "+ ex);
		}
	}
	
	@Override
	/**
	 * Prende il contenuto dell'ArrayList e lo copia all'interno del file txt.
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
			for (Piatto datiPiatto : listapiatti) {
				writer.write(datiPiatto.getName());
				writer.write("," + datiPiatto.getPrice());
			    writer.write(","  + datiPiatto.getNumcategory());
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
