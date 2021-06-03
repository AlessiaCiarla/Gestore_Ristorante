package gestore_ristorante;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gestore_ristorante.cameriere.ElencoTavoliCameriere;
import gestore_ristorante.cassa.ElencoTavoliCassa;
import gestore_ristorante.chef.Menu_Chef;
import gestore_ristorante.cuoco.ElencoTavoliCuoco;

/**
 * Classe che implementa la grafica del men� iniziale, da cui � possibile scegliere un ruolo tra: chef, cameriere, cuoco e responsabile di cassa.
 */
public class MenuPrincipale{
	
	public final static Color COLORE_SFONDO=new Color(171,205,239);  
	public final static Color COLORE_BOTTONI=new Color(224,255,255);
	/**
	 * Con il metodo costruttore della classe Start si crea un nuovo oggetto, che � proprio il men� iniziale.
	 */
	public MenuPrincipale() {

		/**
		 * Si crea un oggetto JFrame, di grandezza 600x600.
		 */
		JFrame start= new JFrame("GESTORE DI UN RISTORANTE");
		start.setSize(600,600); 
		
		/**
		 * Si crea un oggetto Container, che corrisponder� al contenuto del JFrame.
		 */
		Container contenuto=start.getContentPane();
		
		/**
		 * Si crea un oggetto JPanel, grazie al quale si imposta un layout.
		 * In questo caso, si crea una griglia 4x1 e viene aggiunta al Container, grazie all'uso di GridLayout.
		 */
		JPanel pannello= new JPanel();
		pannello.setLayout(new GridLayout(4,1));
		contenuto.add(pannello);
		
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
	    
	    JButton cassa= new JButton("CASSA");
	    cassa.setFont(new Font("Garamond", Font.BOLD, 40));
	    cassa.setBackground(MenuPrincipale.COLORE_SFONDO);
	    cassa.setForeground(Color.BLACK);
	    pannello.add(cassa);
	    
	    /**
	     * Grazie all'interfaccia ActionListener, � possibile gestire gli eventi, come nel caso dei 4 bottoni che abbiamo.
	     * Utilizziamo allora addActionListener, per assegnare un "ascoltatore" ad ogni bottone.
	     * L'interfaccia ActionListener ha un solo metodo: ActionPerformed, che prende come parametro un ActionEvent: un evento di azione.
	     * * Nel metodo, vengono poi inserite le istruzioni che devono verificarsi premendo il bottone.
	     */
	    
	    chef.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	
		    	/**
		    	 * In questo caso, il JFrame del men� principale viene chiuso, e ne viene creato uno nuovo di tipo Menu_Chef, che implementer� una nuova interfaccia.
		    	 */
		    	start.dispose(); 
		    	new Menu_Chef();
		    }
	    });
	    
	    cameriere.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	
		 
		    	start.dispose(); 
		    	new ElencoTavoliCameriere();
		    }
	    });
	    
	    cuoco.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	
		 
		    	start.dispose(); 
		    	new ElencoTavoliCuoco();
		    }
	    });
	    

	    cassa.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	
		 
		    	start.dispose(); 
		    	new ElencoTavoliCassa();
		    }
	    });
	    
	    
		/**
		 * Metodi per rendere visibile la finestra,per collocarla al centro dello schermo e per chiuderla tramite il tasto "X".
		 */
		start.setVisible(true);
	    start.setLocationRelativeTo(null);
	    start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	}
}
