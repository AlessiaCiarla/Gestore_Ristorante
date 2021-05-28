package gestore_ristorante.cameriere;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


/**
 * Classe che contiene l'ArrayList di tutti i piatti all'interno del men�.
 */
public class ListaTavoli{
	
	
	ArrayList<Tavolo> listatavoli = new ArrayList<Tavolo>();
	File file = new File("file/tavoli.txt");
	
	/**
	 * Costruttore che genera un ArrayList che contiene i vari piatti.
	 * @param piatti sono i piatti da aggiungere all'ArrayList.
	 */
	public ListaTavoli () {
		read();
	}
			
	/**
	 * Aggiunge un piatto all'ArrayList dei piatti.
	 * @param piatto � il piatto da aggiungere.
	 */
	public void add(Tavolo datiTavolo){
		if (!listatavoli.contains(datiTavolo)) {
			listatavoli.add(datiTavolo);
		}
	}
	
	
	public Tavolo getTavolo(int indice) {
		return listatavoli.get(indice);
	}
	
	public int size() {
		return listatavoli.size();
	}
	
	
	
	/**
	 * Mostra il contenuto dell'ArrayList.
	 */
	public void readArray() {
		for (Tavolo datiTavolo : listatavoli){
			System.out.println(datiTavolo.getNome_tavolo() 
								+ ","+ datiTavolo.getNumero_tavolo()
								+ "," + datiTavolo.getStato());
		}
		
		
	}
	
	
	/**
	 * Legge il file in cui � contenuto il men� e lo copia all'interno dell'ArrayList.
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
			    String[] datiTavolo = currentLine.split(",");
			   
			    String Name = datiTavolo[0];
			    int Number = Integer.parseInt(datiTavolo[1]);
			    String Status= datiTavolo[2];
			    /**
			    * Crea un oggetto Piatto e lo aggiunge all'ArrayList.
			    */
			    listatavoli.add(new Tavolo( Name, Number, Status));
			   
			    currentLine = reader.readLine();
		    }
		reader.close();
		}
		catch(Exception ex){
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
		for (Tavolo datiTavolo : listatavoli){
			writer.write(datiTavolo.getNome_tavolo());
			writer.write("," + datiTavolo.getNumero_tavolo());
		    writer.write(","  + datiTavolo.getStato());
		    writer.newLine(); 
		}
		
	    /**
	     * Chiude tutte le risorse
	     */
	    writer.close();
	  
		}
		catch(Exception ex){
			System.out.println("Exception msg: "+ex);
		}
	}
}