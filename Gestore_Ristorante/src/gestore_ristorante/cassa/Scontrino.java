package gestore_ristorante.cassa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import gestore_ristorante.chef.Piatto;

/**
* Classe back-end che contiene l'ArrayList di tutti i piatti ordinati, e gestisce vari metodi che saranno usati nella classe RiepilogoCassa(front-end).
*/
public class Scontrino {
	
	ArrayList<Piatto> listapiatti = new ArrayList<Piatto>();
	File file1 = new File("file/scontrino_tavolo1.txt");
	File file2 = new File("file/scontrino_tavolo2.txt");
	File file3 = new File("file/scontrino_tavolo3.txt");
	File file4 = new File("file/scontrino_tavolo4.txt");
	File file5 = new File("file/scontrino_tavolo5.txt");
	
	/**
	 * è il numero del tavolo su cui sto prendendo l'ordinazione.
	 */
	int numerotavolo=0;
	
	
	/**
	 * Il costruttore chiama la funzione read per leggere il contenuto del file.
	 * @param int num è il numero del tavolo su cui devo pagare l'ordine.
	 */

	public Scontrino (int numero) {
		this.numerotavolo=numero;
		read();
	}


	/**
	 * Metodo grazie al quale � possibile ricavare un piatto di tipo Piatto nell'Arraylist listapiatti.
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
	 * Legge dal file in cui � contenuto il men� e lo copia all'interno dell'ArrayList.
	 */
	public void read() {
		try {
			
		    /**
		     * Crea un oggetto BufferedReader per leggere l'input del file.
		     */
			
			if (numerotavolo==0) {
				BufferedReader reader = new BufferedReader(new FileReader(file1));
				String currentLine = reader.readLine();
				while (currentLine != null){
				    String[] datiPiatto = currentLine.split(",");
				   
				    String Name = datiPiatto[0];
				    String Price =datiPiatto[1];
				    String NumCat= datiPiatto[2];
				    int numint= Integer.parseInt(NumCat);
				    double prezzo = Double.parseDouble(Price);
				    /**
				    * Crea un oggetto Piatto e lo aggiunge all'ArrayList.
				    */
				    listapiatti.add(new Piatto( Name, prezzo, numint));
				   
				    currentLine = reader.readLine();
			    }
			    reader.close();
    	    }
    	    else if (numerotavolo==1) {
    	    	BufferedReader reader = new BufferedReader(new FileReader(file2));
    	    	String currentLine = reader.readLine();
    	    	while (currentLine != null){
    			    String[] datiPiatto = currentLine.split(",");
    			   
    			    String Name = datiPiatto[0];
    			    String Price =datiPiatto[1];
    			    String NumCat= datiPiatto[2];
    			    int numint= Integer.parseInt(NumCat);
    			    double prezzo = Double.parseDouble(Price);
    			    /**
    			    * Crea un oggetto Piatto e lo aggiunge all'ArrayList.
    			    */
    			    listapiatti.add(new Piatto( Name, prezzo, numint));
    			   
    			    currentLine = reader.readLine();
    		    }
    		    reader.close();
    	    }
    	    else if (numerotavolo==2) {
    	    	BufferedReader reader = new BufferedReader(new FileReader(file3));
    	    	String currentLine = reader.readLine();
    	    	while (currentLine != null){
    			    String[] datiPiatto = currentLine.split(",");
    			   
    			    String Name = datiPiatto[0];
    			    String Price =datiPiatto[1];
    			    String NumCat= datiPiatto[2];
    			    int numint= Integer.parseInt(NumCat);
    			    double prezzo = Double.parseDouble(Price);
    			    /**
    			    * Crea un oggetto Piatto e lo aggiunge all'ArrayList.
    			    */
    			    listapiatti.add(new Piatto( Name, prezzo, numint));
    			   
    			    currentLine = reader.readLine();
    		    }
    		    reader.close();
    	    }
    	    else if (numerotavolo==3) {
    	    	BufferedReader reader = new BufferedReader(new FileReader(file4));
    	    	String currentLine = reader.readLine();
    	    	while (currentLine != null){
    			    String[] datiPiatto = currentLine.split(",");
    			   
    			    String Name = datiPiatto[0];
    			    String Price =datiPiatto[1];
    			    String NumCat= datiPiatto[2];
    			    int numint= Integer.parseInt(NumCat);
    			    double prezzo = Double.parseDouble(Price);
    			    /**
    			    * Crea un oggetto Piatto e lo aggiunge all'ArrayList.
    			    */
    			    listapiatti.add(new Piatto( Name, prezzo, numint));
    			   
    			    currentLine = reader.readLine();
    		    }
    		    reader.close();
    	    }
    	    else {
    	    	BufferedReader reader = new BufferedReader(new FileReader(file5));
    	    	String currentLine = reader.readLine();
    	    	while (currentLine != null){
    			    String[] datiPiatto = currentLine.split(",");
    			   
    			    String Name = datiPiatto[0];
    			    String Price =datiPiatto[1];
    			    String NumCat= datiPiatto[2];
    			    int numint= Integer.parseInt(NumCat);
    			    double prezzo = Double.parseDouble(Price);
    			    /**
    			    * Crea un oggetto Piatto e lo aggiunge all'ArrayList.
    			    */
    			    listapiatti.add(new Piatto( Name, prezzo, numint));
    			   
    			    currentLine = reader.readLine();
    		    }
    		    reader.close();
    	    }
			
			
		    /**
		     * Legge il contenuto del file riga per riga.
		     */
		    

		    
		} catch(Exception ex){
			System.out.println("Exception msg: "+ ex);
		}
	}

}
