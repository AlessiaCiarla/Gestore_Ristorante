package gestore_ristorante.cameriere;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class ListaTavoli {
	ArrayList<Tavolo> listatavoli = new ArrayList<Tavolo>();
	File file = new File("file/tavoli.txt");
	
	/**
	 * Con il costruttore leggo l'ArrayList contenente oggetti di tipo Piatto,usando il metodo read() creato pi� avanti, al fine di popolare immediatamente il pannello grafico usato in Menu_Chef.
	 */
	public ListaTavoli () {
		read();
	}
			
	
	public Tavolo getTavolo(int indice) {
		return listatavoli.get(indice);
	}
	
	/**
	 * Metodo grazie al quale si ricava la lunghezza dell'Arraylist listapiatti.
	 * @return la  lunghezza di listapiatti.
	 */
	public int size() {
		return listatavoli.size();
	}
	
	
	public void readArray() {
		for (Tavolo datiTavolo : listatavoli){
			System.out.println(datiTavolo.getNome() 
								+ ","+ datiTavolo.getNumero() 
								+ ","+ datiTavolo.getStato());
		}
	}
	
	/**
	 * Legge dal file in cui � contenuto il men� e lo copia all'interno dell'ArrayList.
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

		    while (currentLine != null){
			    String[] datiPiatto = currentLine.split(",");
			   
			    String Name = datiPiatto[0];
			    String Numero =datiPiatto[1];
			    String Stato = datiPiatto[2];
			    int numint= Integer.parseInt(Numero);
			    /**
			    * Crea un oggetto Piatto e lo aggiunge all'ArrayList.
			    */
			    listatavoli.add(new Tavolo( Name, numint, Stato));
			   
			    currentLine = reader.readLine();
		    }
		    reader.close();
		} catch(Exception ex){
			System.out.println("Exception msg: "+ ex);
		}
	}
		
	/**
	 * Prende il contenuto dell'ArrayList e lo copia all'interno del file txt.
	 */
	public void write(){
		try {
			
	    /**
	     * Crea un oggetto BufferedWriter per scrivere l'output del file.
	     */
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

		/**
		* Scrive ogni piatto all'interno del file di output.
		*/
			for (Tavolo datiPiatto : listatavoli){
				writer.write(datiPiatto.getNome());
				writer.write("," + datiPiatto.getNumero());
			    writer.write(","  + datiPiatto.getStato());
			    writer.newLine(); 
			}
		
	    /**
	     * Chiude il file.
	     */
			writer.close();
	  
		} catch(Exception ex){
			System.out.println("Exception msg: "+ex);
		}
	}

}
