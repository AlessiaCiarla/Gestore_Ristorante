package gestore_ristorante.cassa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

import gestore_ristorante.chef.OrdinaPiatti;
import gestore_ristorante.chef.Piatto;

public class Scontrino {
	ArrayList<Piatto> listapiatti = new ArrayList<Piatto>();
	File file1 = new File("file/riepilogo1.txt");
	File file2 = new File("file/riepilogo2.txt");
	File file3 = new File("file/riepilogo3.txt");
	File file4 = new File("file/riepilogo4.txt");
	File file5 = new File("file/riepilogo5.txt");
	int numerotavolo=0;
	
	
	
	public Scontrino (int numero) {
		this.numerotavolo=numero;
		read();
	}

	/**
	 * Aggiunge un piatto all'ArrayList dei piatti.
	 * @param piatto � il piatto da aggiungere.
	 */
	public void add(Piatto datiPiatto){
		if (!listapiatti.contains(datiPiatto)) {
			listapiatti.add(datiPiatto);
		}
	}
	
	/**
	 * Ordina la lista dei piatti tramite una Collections.sort.
	 * Questo avviene tramite la creazione di un nuovo oggetto di tipo OrdinaPiatti.
	 */
	public void sort(){
		Collections.sort(listapiatti, new OrdinaPiatti());
	}
	
	/**
	 * Rimuove tutto il contenuto dell'ArrayList.
	 */
	public void clear(){
		listapiatti.clear();
	}
	
	/**
	 * Rimuove un piatto specifico all'interno dell'ArrayList.
	 * @param piatto � il piatto da rimuovere.
	 */
	public void remove(Piatto datiPiatto) {
		listapiatti.remove(datiPiatto);
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
	 * Mostra il contenuto dell'ArrayList,stampandolo a video.
	 */
	public void readArray() {
		for (Piatto datiPiatto : listapiatti){
			System.out.println(datiPiatto.getName() 
								+ ","+ datiPiatto.getPrice() 
								+ ","+ datiPiatto.getNumcategory());
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
