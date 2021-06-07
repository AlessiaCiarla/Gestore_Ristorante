package gestore_ristorante.cassa;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import gestore_ristorante.MenuPrincipale;
import gestore_ristorante.cameriere.ListaTavoli;

/**
 * Classe che implementa la grafica dello scontrino che visualizzer� la cassa.
 *
 */
public class RiepilogoCassa{
	
	/**
	 * Graficamente, viene creato un un nuovo JFrame, con il rispettivo ContentPane.
	 * Inoltre, viene creato come attributo anche il pannello che conterr� l'ordinazione e i bottoni,in modo tale che sia modificabile e riconoscibile in ogni funzione.
	 */
	JFrame editable_menu= new JFrame("RIEPILOGO ORDINE");
	Container contenuto= editable_menu.getContentPane();
	JPanel pannello_centrale= new JPanel();	
	
	/** In secondo luogo, viene creato un oggetto di tipo ListaTavoli, grazie al quale invece riesco ad avere tutti i tavoli 
	 * con relativi attributi in un ArrayList.
	 */
	ListaTavoli tavoli = new ListaTavoli();
	
	/**
	 * è il numero del tavolo di cui devo visualizzare lo scontrino.
	 */
	int numerotavolo;
	
	/**
	 * e' il totale da pagare.
	 */
	double totale;
	
	/**
	 * Il costruttore chiama la funzione visualizza.
	 * @param int num è il numero del tavolo di cui devo visualizzare lo scontrino.
	 */
	public RiepilogoCassa(int num) {
		this.numerotavolo=num;
		visualizza();
	}
	
	/**
	 * La funzione visualizza in sintesi crea la parte alta della finestra e setta le spechifiche grafiche del pannello principale,contenente il men� e i rispettivi bottoni.
	 */
	public void visualizza() {
		/**
		 * viene creato un oggetto di tipo Scontrino, grazie al quale invece riesco ad avere tutte le quantità di ogni piatto ordinato.
		 */
		Scontrino scontrino = new Scontrino(numerotavolo);
		
		/**
		 * la misura del frame viene impostata a 600x600, con relativo layout e background.
		 */
		pannello_centrale.setLayout(new BoxLayout(pannello_centrale, BoxLayout.PAGE_AXIS));
		editable_menu.setSize(600,600); 
		pannello_centrale.setBackground(MenuPrincipale.COLORE_SFONDO);
		
		/**
		 * Il pannello up contiene tutti quegli elementi che vengono disposti proprio nella parte alta della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel up= new JPanel();
		up.setLayout(new GridLayout(1,2));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		/**
		 * Viene aggiunta una label menu, per dare un contesto al frame, e ne vengono impostate le specifiche.
		 */
		JLabel menu = new JLabel("RIEPILOGO", SwingConstants.CENTER);
		menu.setFont(new Font("Garamond", Font.BOLD, 22));
	    menu.setForeground(Color.BLACK);
		up.add(menu);
		
		/**
		 * Viene aggiunto un pulsante back, per tornare alla schermata principale.
		 */
		Icon freccia = new ImageIcon("images/freccia.png");
		JButton back= new JButton(freccia);
		back.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    up.add(back);
	    
	    
	    back.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
	    		/**
		    	 * In questo caso, il JFrame di RiepilogoCassa viene chiuso, e ne viene creato uno nuovo di tipo ElencoTavoliCassa.
		    	 */
		    	editable_menu.dispose(); 
		    	new ElencoTavoliCassa();
		    }
	    });
		
	    /**
		 * Il pannello down contiene tutti quegli elementi che vengono disposti proprio nella parte bassa della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel down= new JPanel();
		down.setLayout(new GridLayout(1,2));
		down.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(down, BorderLayout.SOUTH);
		
		/**
	     * Viene aggiunto un bottone conferma, grazie al quale � possibile confermare l'ordine definitivamente.
	     */
	    JButton conferma = new JButton("PAGA ORDINE");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    conferma.setForeground(Color.BLACK);
	    down.add(conferma, BorderLayout.SOUTH);
	    
	    conferma.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
	    		/**
	    		 * Quando si clicca il bottone "conferma", si cambierà lo stato del tavolo da "E" a "NI".
	    		 */
	    	    for (int k=0; k<tavoli.size(); k++) {
	    	    	if (numerotavolo==tavoli.getTavolo(k).getNumero())
			    	    tavoli.getTavolo(k).setStato("NI");
	    	    		tavoli.write();
	    	    }
	    	    /**
	    	     * Creo un nuovo JFrame creato dalla classe ElencoTavoliCassa con un alert che l'ordine è stato pagato.
	    	     */
		    	editable_menu.dispose();
		    	new ElencoTavoliCassa();
		    	JOptionPane.showMessageDialog(null, "Pagamento effettuato!");
	    	}});
	    
	    /**
         * il pannello centrale viene aggiungo al contenuto del frame , e vengono impostate delle specifiche, essendo il pannello un JSplitPane.
         */
	    contenuto.add(pannello_centrale,BorderLayout.CENTER);
	    
	    /**
		 * Viene inserito un oggetto JScrollPane, in modo tale da vedere bene tutti i piatti scorrendo con una barra, nel caso diventassero tanti.
		 */
        JScrollPane scroll1= new JScrollPane(pannello_centrale);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
		
		/**
		 * viene poi chiamata la funzione grazie al quale i piatti con relativo nome, prezzo e quantita vengono aggiunti al pannello centrale.
		 */
		popolaPannello(scontrino, pannello_centrale);
		
		/**
		 * Viene creata una label che visualizzera il totale da pagare.
		 */
		JLabel prezzo = new JLabel("TOTALE: �" + totale, SwingConstants.CENTER);
		prezzo.setFont(new Font("Garamond", Font.BOLD, 22));
	    prezzo.setForeground(Color.BLACK);
		down.add(prezzo, BorderLayout.SOUTH);
		
		/**
		 * il frame viene reso visibile,settato al centro e chiudibile con il tasto "X".
		 */
	    editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	/**
	 * metodo che aggiunge al pannello centrale i piatti da pagare.
	 * @param scontrino è il file e l'ArrayList dello scontrino.
	 * @param pannello_variabile è il pannello centrale.
	 */
	public void popolaPannello(Scontrino scontrino,JPanel pannello_variabile ) {
		
		/**
	     * si scorre la lista dei piatti, e si controlla se la quantita del piatto e maggiore di zero.
	     * Nel caso la risposta fosse si,il piatto viene aggiunto al pannello centrale.
	     */
		for (int j = 0; j < scontrino.size(); j++) {
					if (scontrino.getPiatto(j).getNumcategory()>0) {
						
						/**
		    			 * il nome del piatto viene aggiunto al pannello centrale.
		    			 */
						pannello_centrale.add(Box.createRigidArea(new Dimension(0, 25)));
						JLabel piatto = new JLabel("PIATTO: " + scontrino.getPiatto(j).getName());
			    		piatto.setFont(new Font("Bell MT", Font.BOLD, 22));
					    piatto.setForeground(Color.BLACK);
					    piatto.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(piatto);
				        
				        /**
		    			 * il prezzo del piatto viene aggiunto al pannello centrale.
		    			 */
				        JLabel prezzo = new JLabel("PREZZO: " + scontrino.getPiatto(j).getPrice() + "   �");
			    		prezzo.setFont(new Font("Bell MT", Font.BOLD, 22));
					    prezzo.setForeground(Color.BLACK);
					    prezzo.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(prezzo);
				        
				        /**
		    			 * la quantita del piatto viene aggiunto al pannello centrale.
		    			 */
				        JLabel quantita = new JLabel("N. PORZIONI: " + scontrino.getPiatto(j).getNumcategory() + "");
			    		quantita.setFont(new Font("Bell MT", Font.BOLD, 22));
					    quantita.setForeground(Color.BLACK);
					    quantita.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(quantita);
				        
				        /**
				         * E' il totale da pagare.
				         */
				        totale= totale + (scontrino.getPiatto(j).getPrice()*scontrino.getPiatto(j).getNumcategory());
					}
	   		}
	}
}
