package gestore_ristorante.cameriere;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gestore_ristorante.MenuPrincipale;


/**
 * Classe che implementa la grafica dei tavoli che visulizzerà il cameriere,
 *  il quale potrà selezionare quelli liberi e vedere quelli occupati.
 *
 */
public class Gestione_Tavoli {
	
	String tavoli[] ={"TAVOLO1", "TAVOLO2", "TAVOLO3", "TAVOLO4"};
	ListaTavoli listat= new ListaTavoli();
	int lunghezza= tavoli.length + listat.size();
	
	/**
	 * Con il metodo costruttore della classe Lista_Tavoli si crea un nuovo oggetto, cioè la lista dei tavoli liberi e occupati.
	 */
	public Gestione_Tavoli() {
		
		/**
		 * Si crea un oggetto JFrame, di grandezza 600x600.
		 */
		JFrame table_view= new JFrame("LISTA DEI TAVOLI");
		table_view.setSize(600,600); 
		
		/**
		 * Si crea un oggetto Container, che corrisponderà al contenuto del JFrame.
		 */
		Container contenuto= table_view.getContentPane();
		
		
		/**
		 * Si crea un primo JPanel "up",che implementa un GridLayout 1x2, e gli viene settato lo sfondo.
		 * Di conseguenza, il pannello "up" viene posto in posizione NORTH del Container, che invece implementa un BorderLayout.
		 */
		JPanel up= new JPanel();
		up.setLayout(new GridLayout(1,2));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		/**
		 * Si vanno poi a definire una label e un bottone che saranno posizionati sul JPanel "up".
		 * Si crea per primo una label menu, con testo, posizione, font e sfondo settati; la label viene infine aggiunta al pannello "up".
		 */
		JLabel nometavolo = new JLabel("TAVOLI", SwingConstants.CENTER);
		nometavolo.setFont(new Font("Garamond", Font.BOLD, 20));
	    nometavolo.setForeground(Color.BLACK);
		up.add(nometavolo);
	
		/**
		 * Si crea poi, per secondo, un bottone con un'icona e sfondo settato.
		 * Viene poi aggiunto al pannello "up".
		 */
		Icon icona = new ImageIcon("images/freccia1.png");
		JButton back= new JButton(icona);
		back.setBackground(new Color(220,220,220));
	    up.add(back);
	    
	    /**
	     * Viene poi gestito l'evento riguardante il clic sul bottone back.
	     */
	    back.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	
		    	/**
		    	 * In questo caso, il JFrame di Lista_Tavoli viene chiuso, e ne viene creato uno nuovo di tipo Menu_Principale, che riporta proprio alla schermata principale.
		    	 */
	    		table_view.dispose(); 
		    	new MenuPrincipale();
		    }
	    });
	    
	    /**
	     * Dopo il primo pannello up, viene creato un secondo pannello center, che gestirà il resto dello spazio dell'interfaccia.
	     * Il pannello center è di tipo JSplitPane, che consente di dividere il pannello in due porzioni e , nel nostro caso, verticalmente.
	     */
	    JPanel center_left= new JPanel();
		center_left.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_left.setLayout(new GridLayout(4,2));
	    
		JPanel center_right= new JPanel();
		center_right.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_right.setLayout(new GridLayout(4,2));
		
		JSplitPane center = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,center_left, center_right);
		contenuto.add(center,BorderLayout.CENTER);
		center.setResizeWeight(0.9);
        center.setContinuousLayout(true);
        JScrollPane scroll1= new JScrollPane(center);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
		
	    
	    
	    
		for (int i = 0; i < tavoli.length; i++) {
			JButton Tavolo = new JButton (tavoli[i]);
			Tavolo.setFont(new Font("Garamond", Font.BOLD, 45));
			Tavolo.setBackground(MenuPrincipale.COLORE_SFONDO);
			Tavolo.setForeground(Color.BLACK);
		    center_left.add(Tavolo);
		
		    Tavolo.addActionListener(new ActionListener(){
		    	public void actionPerformed(ActionEvent evento) {
		    		table_view.dispose();
		    		new Tavolo_Singolo();
		    	}
		    });
		    
		    
		    
		    for (int j = 0; j < listat.size(); j++) {
	    		if (listat.getTavolo(j).getNumero_tavolo()== i) {
	    			JLabel tavolo = new JLabel("STATO ORDINE: " + listat.getTavolo(j).getStato());
		    		tavolo.setFont(new Font("AR BLANCA", Font.BOLD, 20));
				    tavolo.setForeground(Color.BLACK);
			        center_right.add(tavolo);
	    		}
	    	}
		
		
		}
	
		/**
		 * Metodi per rendere visibile la finestra,per collocarla al centro dello schermo e per chiuderla tramite il tasto "X".
		 */
		table_view.setVisible(true);
		table_view.setLocationRelativeTo(null);
		table_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
}