 package gestoreRistorante;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import gestoreRistorante.cameriere.ElencoTavoliCameriere;
import gestoreRistorante.cameriere.ListaTavoli;
import gestoreRistorante.cassa.ElencoTavoliCassa;
import gestoreRistorante.chef.MenuChef;
import gestoreRistorante.cuoco.ElencoTavoliCuoco;

/**
 * Classe che implementa la grafica del menù iniziale, da cui è possibile scegliere un ruolo tra: chef, cameriere, cuoco e responsabile di cassa.
 */
public class MenuPrincipale {
	
	/**
	 * Vengono create due variabili statiche per mantenere i colori utilizzati nel programma.
	 */
	public final static Color COLORE_SFONDO = new Color(171,205,239);  
	public final static Color COLORE_BOTTONI = new Color(224,255,255);
	
	/**
	 * Si crea un oggetto JFrame, di grandezza 600x600.
	 */
	JFrame start = new JFrame("GESTORE DI UN RISTORANTE");
	
	/**
	 * Si crea un oggetto Container, che corrisponderà al contenuto del JFrame.
	 */
	Container contenuto = start.getContentPane();
	
	/**
	 * Si crea un oggetto di tipo ListaTavoli.
	 */
	ListaTavoli tavoli = new ListaTavoli();
	
	
	/**
	 * Con il metodo costruttore, si richiama il metodo visualizza().
	 */
	public MenuPrincipale() {
		visualizza();
	}
	
	public void visualizza() {
	
		/**
		 * Viene settata la misura del frame.
		 */
		start.setSize(600,600); 
		
		/**
		 * Si crea un oggetto JPanel, grazie al quale si imposta un layout.
		 * In questo caso, si crea una griglia 4x1 e viene aggiunta al Container, grazie all'uso di GridLayout.
		 */
		JPanel pannello = new JPanel();
		pannello.setLayout(new GridLayout(4,1));
		pannello.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(pannello,BorderLayout.CENTER );
		
		/**
		 * Si creano 4 bottoni di tipo JButton, uno per ogni ruolo all'interno del ristorante.
		 * Inoltre, vengono effettuate delle modifiche ai bottoni:
		 * con setFont, viene settato il Font del testo del bottone e la sua grandezza;
		 * con setBackground, viene impostato il colore dello sfondo del bottone;
		 * con setForeground, viene impostato il colore del testo del bottone.
		 * Infine, i bottoni vengono aggiunti al JPanel.
		 */
		JButton chef = new JButton("CHEF");
		chef.setFont(new Font("Garamond", Font.BOLD, 40));
	    chef.setBackground(MenuPrincipale.COLORE_SFONDO);
	    chef.setForeground(Color.BLACK);
	    pannello.add(chef);
		
	    JButton cameriere = new JButton("CAMERIERE");
	    cameriere.setFont(new Font("Garamond", Font.BOLD, 40));
	    cameriere.setBackground(MenuPrincipale.COLORE_SFONDO);
	    cameriere.setForeground(Color.BLACK);
	    pannello.add(cameriere);
	    
	    JButton cuoco = new JButton("CUOCO");
	    cuoco.setFont(new Font("Garamond", Font.BOLD, 40));
	    cuoco.setBackground(MenuPrincipale.COLORE_SFONDO);
	    cuoco.setForeground(Color.BLACK);
	    pannello.add(cuoco);
	    
	    JButton cassa = new JButton("CASSA");
	    cassa.setFont(new Font("Garamond", Font.BOLD, 40));
	    cassa.setBackground(MenuPrincipale.COLORE_SFONDO);
	    cassa.setForeground(Color.BLACK);
	    pannello.add(cassa);
	    
	    /**
	     * Grazie all'interfaccia ActionListener, è possibile gestire gli eventi, come nel caso dei 4 bottoni che abbiamo.
	     * Utilizziamo allora addActionListener, per assegnare un "ascoltatore" ad ogni bottone.
	     * L'interfaccia ActionListener ha un solo metodo: ActionPerformed, che prende come parametro un ActionEvent: un evento di azione.
	     * * Nel metodo, vengono poi inserite le istruzioni che devono verificarsi premendo il bottone.
	     */
	    chef.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evento) {
		    	
	    		/**
		    	 * In questo caso, il JFrame del menù principale viene chiuso, e ne viene creato uno nuovo di tipo MenuChef, 
		    	 * che implementerà una nuova grafica.
		    	 */
		    	start.dispose(); 
		    	new MenuChef();
		    }
	    });
	    
	    cameriere.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evento) {
	    		
	    		/**
		    	 * In questo caso, il JFrame del menù principale viene chiuso, e ne viene creato uno nuovo di tipo ElencoTavoliCameriere, 
		    	 * che implementerà una nuova grafica.
		    	 */
		    	start.dispose(); 
		    	new ElencoTavoliCameriere();
		    }
	    });
	    
	    cuoco.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evento) {
	    		
	    		/**
		    	 * In questo caso, il JFrame del menù principale viene chiuso, e ne viene creato uno nuovo di tipo ElencoTavoliCuoco, 
		    	 * che implementerà una nuova grafica.
		    	 */
		    	start.dispose(); 
		    	new ElencoTavoliCuoco();
		    }
	    });
	    

	    cassa.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evento) {
	    		
	    		/**
		    	 * In questo caso, il JFrame del menù principale viene chiuso, e ne viene creato uno nuovo di tipo ElencoTavoliCassa, 
		    	 * che implementerà una nuova grafica.
		    	 */
		    	start.dispose(); 
		    	new ElencoTavoliCassa();
		    }
	    });
	    
	    /**
	     * Si crea un pannello down situato nella parte sud del frame.
	     * Ha un'impostazione a griglia 1x1.
	     * Ne viene settato anche lo sfondo.
	     */
	    JPanel down = new JPanel();
		down.setLayout(new GridLayout(1,1));
		down.setBackground(COLORE_SFONDO);
		contenuto.add(down,BorderLayout.SOUTH );
	    
		/**
		 * Viene poi creato un bottone, di cui vengono settati font e colori.
		 * Viene poi aggiunto al pannello down.
		 */
		JButton chiudi_sessione = new JButton("CHIUDI SESSIONE");
	    chiudi_sessione.setFont(new Font("Garamond", Font.BOLD, 20));
	    chiudi_sessione.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    chiudi_sessione.setForeground(Color.BLACK);
	    down.add(chiudi_sessione);
	    
	    /**
	     * Viene creato un ActionListener  per il bottone chiudi_sessione.
	     */
	    chiudi_sessione.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evento) {
	    		
		    	/**
		    	 * Se si chiude la sessione il programma verrà chiuso e verranno puliti tutti i file che contengono i
		    	 *  dati di ordinazione, scontrini e gli stati dei tavoli cambieranno in NI.
		    	 */
	    		for (int i = 0; i < tavoli.size(); i++) {
					tavoli.getTavolo(i).setStato("NI");
					tavoli.write();
				}
	    		
	    		PrintWriter pw1;
	    		PrintWriter pw2;
	    		PrintWriter pw3;
	    		PrintWriter pw4;
	    		PrintWriter pw5;
	    		PrintWriter pw6;
	    		
				try {
					pw1 = new PrintWriter("file/scontrino_tavolo1.txt");
					pw1.close();
					pw2 = new PrintWriter("file/scontrino_tavolo2.txt");
					pw2.close();
					pw3 = new PrintWriter("file/scontrino_tavolo3.txt");
					pw3.close();
					pw4 = new PrintWriter("file/scontrino_tavolo4.txt");
					pw4.close();
					pw5 = new PrintWriter("file/scontrino_tavolo5.txt");
					pw5.close();
					pw6 = new PrintWriter("file/appoggio.txt");
					pw6.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						}		
		    		start.dispose(); 
		    	}
	    	});
	    
		/**
		 * Metodi per rendere visibile la finestra, per collocarla al centro dello schermo e per chiuderla tramite il tasto "X".
		 */
		start.setVisible(true);
	    start.setLocationRelativeTo(null);
	    start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
}
