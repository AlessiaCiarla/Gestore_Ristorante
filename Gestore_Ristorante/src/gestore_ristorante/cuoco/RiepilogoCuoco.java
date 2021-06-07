package gestore_ristorante.cuoco;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import gestore_ristorante.MenuPrincipale;
import gestore_ristorante.cameriere.ListaTavoli;
import gestore_ristorante.cassa.Scontrino;

/**
* Classe che implementa la grafica della comanda che visualizzerà il cuoco.
*
*/
public class RiepilogoCuoco{
	
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
	 * è il numero del tavolo di cui devo visualizzare la comanda.
	 */
	int numerotavolo;
	
	/**
	 * Il costruttore chiama la funzione visualizza.
	 * @param int num è il numero del tavolo di cui devo visualizzare la comanda.
	 */
	public RiepilogoCuoco(int num) {
		this.numerotavolo=num;
		visualizza();
	}
	
	
	
	public void visualizza() {
		/**
		 * viene creato un oggetto di tipo Scontrino, grazie al quale invece riesco ad avere tutte le quantità di ogni piatto ordinato.
		 */
		Scontrino comanda = new Scontrino(numerotavolo);
		
		/**
		 * la misura del frame viene impostata a 600x600, con relativo layout e background.
		 */
		editable_menu.setSize(600,600); 
		pannello_centrale.setLayout(new BoxLayout(pannello_centrale, BoxLayout.PAGE_AXIS));
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
		    	 * In questo caso, il JFrame di Menu_Chef viene chiuso, e ne viene creato uno nuovo di tipo Menu_Principale, che riporta proprio alla schermata principale.
		    	 */
	    		JFrame controllo= new JFrame();
	    		controllo.setSize(400,200);
	    		Container cont= controllo.getContentPane();
	    		
	    		JPanel center= new JPanel();
	    		center.setBackground(MenuPrincipale.COLORE_SFONDO);
	    		center.setLayout(new GridLayout(1,1));
	    		cont.add(center,BorderLayout.CENTER);
	    		
	    		JLabel domanda= new JLabel("Vuoi tornare alla lista dei Tavoli?",SwingConstants.CENTER);
	    		domanda.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    domanda.setForeground(Color.BLACK);
	    		center.add(domanda);
	    		
	    		JPanel down= new JPanel();
	    		down.setLayout(new GridLayout(1,2));
	    		cont.add(down, BorderLayout.SOUTH);
	    		
	    		JButton no = new JButton("NO");
	    		no.setFont(new Font("Garamond", Font.BOLD, 18));
	    	    no.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    	    no.setForeground(Color.BLACK);
	    	    down.add(no);
	    	    
	    	    no.addActionListener(new ActionListener(){
	    	    	public void actionPerformed(ActionEvent evento){
	    	    		controllo.dispose();
	    	    	}
	    	    });
	    	    
	    	    JButton si = new JButton("SI");
	    		si.setFont(new Font("Garamond", Font.BOLD, 18));
	    	    si.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    	    si.setForeground(Color.BLACK);
	    	    down.add(si);
	    	    
	    	    si.addActionListener(new ActionListener(){
	    	    	public void actionPerformed(ActionEvent evento){
	    	    		controllo.dispose();
	    	    		editable_menu.dispose(); 
	    		    	new ElencoTavoliCuoco();
	    	    	}
	    	    });
	    		
	    	    controllo.setVisible(true);
	    		controllo.setLocationRelativeTo(null);
	    		controllo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    }
	    });
		
	    /**
		 * Il pannello down contiene tutti quegli elementi che vengono disposti proprio nella parte bassa della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel down= new JPanel();
		up.setLayout(new GridLayout(1,1));
		contenuto.add(down, BorderLayout.SOUTH);
	    
		/**
	     * Viene aggiunto un bottone conferma, grazie al quale � possibile confermare l'ordine definitivamente.
	     */
	    JButton conferma = new JButton("EVADI ORDINE");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
	    conferma.setForeground(Color.BLACK);
	    down.add(conferma, BorderLayout.SOUTH);
	    
	    conferma.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
	    		/**
	    		 * Quando si clicca il bottone "conferma", si cambierà lo stato del tavolo da "NI" a "E".
	    		 */
	    	    for (int k=0; k<tavoli.size(); k++) {
	    	    	if (numerotavolo==tavoli.getTavolo(k).getNumero())
			    	    tavoli.getTavolo(k).setStato("E");
	    	    		tavoli.write();
	    	    }
	    	    /**
	    	     * Creo un nuovo JFrame creato dalla classe ElencoTavoliCuoco con un alert che l'ordine è stato evaso.
	    	     */
		    	editable_menu.dispose();
		    	new ElencoTavoliCuoco();
		    	JOptionPane.showMessageDialog(null, "Ordine evaso!");
	    	}});
	    
	    /**
         * il pannello centrale viene aggiungo al contenuto del frame , e vengono impostate delle specifiche, essendo il pannello un JSplitPane.
         */
	    contenuto.add(pannello_centrale,BorderLayout.CENTER);
	    
	    /**
		 * Viene inserito un oggetto JScrollPane, in modo tale da vedere bene tutti i piatti scorrendo con una barra, nel caso diventassero tanti.
		 */
        JScrollPane scroll= new JScrollPane(pannello_centrale);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll);
		/**
		 * viene poi chiamata la funzione grazie al quale i piatti con relativo nome, prezzo e quantita vengono aggiunti al pannello centrale.
		 */
		popolaPannello(comanda, pannello_centrale);
		
		/**
		 * Viene creata una label che visualizzera il totale da pagare.
		 */
	    editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * metodo che aggiunge al pannello centrale i piatti da evadere.
	 * @param scontrino è il file e l'ArrayList della comanda.
	 * @param pannello_variabile è il pannello centrale.
	 */
	public void popolaPannello(Scontrino comanda,JPanel pannello_variabile ) {
		/**
	     * si scorre la lista dei piatti, e si controlla se la quantita del piatto e maggiore di zero.
	     * Nel caso la risposta fosse si,il piatto viene aggiunto al pannello centrale.
	     */
		for (int j = 0; j < comanda.size(); j++) {
					if (comanda.getPiatto(j).getNumcategory()>0) {
						
						/**
		    			 * il nome del piatto viene aggiunto al pannello centrale.
		    			 */
						pannello_centrale.add(Box.createRigidArea(new Dimension(0, 25)));
						JLabel piatto = new JLabel("PIATTO: " + comanda.getPiatto(j).getName());
			    		piatto.setFont(new Font("Ink Free", Font.BOLD, 22));
					    piatto.setForeground(Color.BLACK);
					    piatto.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(piatto);
				        
				        /**
		    			 * il prezzo del piatto viene aggiunto al pannello centrale.
		    			 */
				        JLabel prezzo = new JLabel("PREZZO: " + comanda.getPiatto(j).getPrice() + "   €");
			    		prezzo.setFont(new Font("Ink Free", Font.BOLD, 22));
					    prezzo.setForeground(Color.BLACK);
					    prezzo.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(prezzo);
				        
				        /**
		    			 * la quantita del piatto viene aggiunto al pannello centrale.
		    			 */
				        JLabel quantita = new JLabel("N. PORZIONI: " + comanda.getPiatto(j).getNumcategory() + "");
			    		quantita.setFont(new Font("Ink Free", Font.BOLD, 22));
					    quantita.setForeground(Color.BLACK);
					    quantita.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(quantita);
					}
	   		}
	}
}
