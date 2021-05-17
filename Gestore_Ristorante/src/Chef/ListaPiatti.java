package Chef;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Classe che contiene l'ArrayList di tutti i piatti all'interno del menù.
 */
public class ListaPiatti{
	
	private ArrayList<Piatto> listapiatti = new ArrayList<Piatto>();
	File file = new File("file/menu.txt");
	
	/**
	 * Costruttore che genera un ArrayList che contiene i vari piatti.
	 * @param piatti sono i piatti da aggiungere all'ArrayList.
	 */
	public ListaPiatti (ArrayList<Piatto> piatti) 
	{
		this.listapiatti=piatti;
	}
			
	/**
	 * Aggiunge un piatto all'ArrayList dei piatti.
	 * @param piatto è il piatto da aggiungere.
	 */
	public void add(Piatto datiPiatto) 
	{
		listapiatti.add(datiPiatto);
	}
	
	/**
	 * Ordina la lista dei piatti tramite una Collections.sort.
	 * Questo avviene tramite la creazione di un nuovo oggetto di tipo OrdinaPiatti.
	 */
	public void sort() 
	{
		Collections.sort(listapiatti, new OrdinaPiatti());
	}
	
	/**
	 * Rimuove tutto il contenuto dell'ArrayList.
	 */
	public void clear()
	{
		listapiatti.clear();
	}
	
	/**
	 * Rimuove un piatto specifico all'interno dell'ArrayList.
	 * @param piatto è il piatto da rimuovere.
	 */
	public void remove(Piatto datiPiatto) {
		listapiatti.remove(datiPiatto);
	}
	
	
	/**
	 * Permette di sostituire o modificare i dati di un piatto.
	 * @param dasostituire è il piatto da modificare.
	 * @param sostituto è il piatto che va inserito al posto del precedente.
	 */
	public void modify(Piatto dasostituire, Piatto sostituto) 
	{
		for (Piatto datiPiatto : listapiatti)
		{
		   if (datiPiatto.equals(dasostituire))
		   {
			   listapiatti.set(listapiatti.indexOf(datiPiatto), sostituto);
		   }
		}
	}
	
	
	
	/**
	 * Mostra il contenuto dell'ArrayList.
	 */
	public void readArray() {
		for (Piatto datiPiatto : listapiatti)
		  {
			System.out.println(datiPiatto.getCategory() + 
					","+ datiPiatto.getName() 
					+ ","+ datiPiatto.getPrice() 
					+ ","+ datiPiatto.getNumcategory());
		  }
		
		
	}
	
	
	/**
	 * Legge il file in cui è contenuto il menù e lo copia all'interno dell'ArrayList.
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

		  while (currentLine != null)
		  {
		   String[] datiPiatto = currentLine.split(",");
		   
		   String Category = datiPiatto[0];
		   String Name = datiPiatto[1];
		   String Price =datiPiatto[2];
		   
		   int Numcategory = Integer.valueOf(datiPiatto[3]);
		   
		   /**
		    * Crea un oggetto Piatto e lo aggiunge all'ArrayList.
		    */
		   
		   listapiatti.add(new Piatto(Category, Name, Price, Numcategory));
		   
		   currentLine = reader.readLine();
		  }
		reader.close();
		}
		catch(Exception ex)
		{
		   System.out.println("Exception msg: "+ex);
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
	  for (Piatto datiPiatto : listapiatti)
	  {
	   writer.write(datiPiatto.getCategory());
	   writer.write(","+ datiPiatto.getName());
	   writer.write(",€"+ datiPiatto.getPrice());
	   writer.write(","+ datiPiatto.getNumcategory());
	   writer.newLine(); 
	  }
	  /**
	   * Chiude tutte le risorse
	   */
	  writer.close();
	  
	  }
	  catch(Exception ex)
	  {
	   System.out.println("Exception msg: "+ex);
	  }
	 
	 }
}