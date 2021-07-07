package gestoreRistorante.cuoco;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gestoreRistorante.Lista;
import gestoreRistorante.MenuPrincipale;
import gestoreRistorante.cameriere.ListaTavoli;
import gestoreRistorante.cassa.Scontrino;

/**
* Classe che implementa la grafica della comanda che visualizzerà il cuoco.
*
*/
public class RiepilogoCuoco {
	
	/**
	 * Graficamente, viene creato un un nuovo JFrame, con il rispettivo ContentPane.
	 * Inoltre, viene creato come attributo anche il pannello che conterrà l'ordinazione e i bottoni, in modo tale che sia 
	 * modificabile e riconoscibile in ogni metodo.
	 */
	JFrame editable_menu = new JFrame("RIEPILOGO ORDINE");
	Container contenuto = editable_menu.getContentPane();
	JPanel pannello_centrale = new JPanel();	
	
	/** In secondo luogo, viene creato un oggetto di tipo ListaTavoli, grazie al quale invece riesco ad avere tutti i tavoli 
	 * con relativi attributi in un ArrayList.
	 */
	ListaTavoli tavoli = new ListaTavoli();
	
	/**
	 *numerotavolo è il numero del tavolo di cui devo visualizzare la comanda.
	 */
	int numerotavolo;
	
	/**
	 * Il costruttore chiama il metodo visualizza().
	 * @param int num: è il numero del tavolo di cui devo visualizzare la comanda.
	 */
	public RiepilogoCuoco(int num) {
		this.numerotavolo = num;
		visualizza();
	}
	
	/**
	 * Il metodo visualizza() in sintesi crea la parte alta della finestra e setta le spechifiche grafiche del pannello principale
	 */
	public void visualizza() {
		
		/**
		 * Viene creato un oggetto di tipo Scontrino, grazie al quale invece riesco ad avere tutte le quantità di ogni piatto ordinato.
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
		JPanel up = new JPanel();
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
		 * Viene aggiunto un pulsante back, per tornare alla lista dei tavoli.
		 */
		Icon freccia = new ImageIcon("images/freccia.png");
		JButton back = new JButton(freccia);
		back.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    up.add(back);
	    
	    back.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evento) {
		    	
	    		/**
		    	 *Viene creato un frame che si occupa di controllare se l'utente abbia cliccato per sbaglio sul tasto back; 
		    	 *ci sono 2 opzioni disponibili.
		    	 *Viene settata la misura e gli viene associato un ContentPane.
		    	 */
	    		JFrame controllo = new JFrame();
	    		controllo.setSize(400,200);
	    		Container cont = controllo.getContentPane();
	    		
	    		/**
	    		 * Viene creato un pannello che viene aggiunto al ContentPane e ne vengono settati sfondo e layout.
	    		 */
	    		JPanel center = new JPanel();
	    		center.setBackground(MenuPrincipale.COLORE_SFONDO);
	    		center.setLayout(new GridLayout(1,1));
	    		cont.add(center,BorderLayout.CENTER);
	    		
	    		/**
	    		 * Viene aggiunta una JLabel al pannello centrale del frame.
	    		 * Ne vengono settati font e colore.
	    		 */
	    		JLabel domanda = new JLabel("Vuoi tornare alla lista dei Tavoli?",SwingConstants.CENTER);
	    		domanda.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    domanda.setForeground(Color.BLACK);
	    		center.add(domanda);
	    		
	    		/**
	    		 * Viene creato un poi un secondo pannello,situato nella parte bassa del frame.
	    		 * Ne vengono impostati layout e viene aggiunto al ContentPane.
	    		 */
	    		JPanel down = new JPanel();
	    		down.setLayout(new GridLayout(1,2));
	    		cont.add(down, BorderLayout.SOUTH);
	    		
	    		/**
	    		 * Viene aggiunto il bottone "no" al pannello down, con le impostazioni grafiche settate.
	    		 */
	    		JButton no = new JButton("NO");
	    		no.setFont(new Font("Garamond", Font.BOLD, 18));
	    	    no.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    	    no.setForeground(Color.BLACK);
	    	    down.add(no);
	    	    
	    	    /**
	    	     * Se si clicca il tasto "no", si chiude semplicemente questo frame di controllo e si rimane sullo scontrino.
	    	     */
	    	    no.addActionListener(new ActionListener() {
	    	    	public void actionPerformed(ActionEvent evento) {
	    	    		controllo.dispose();
	    	    	}
	    	    });
	    	    
	    	    /**
	    	     * Si crea poi anche un bottone "si" che viene aggiunto al pannello down, con le impostazioni grafiche settate.
	    	     */
	    	    JButton si = new JButton("SI");
	    		si.setFont(new Font("Garamond", Font.BOLD, 18));
	    	    si.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    	    si.setForeground(Color.BLACK);
	    	    down.add(si);
	    	    
	    	    /**
	    	     * Se si clicca il tasto "si", viene chiuso il frame di controllo, viene chiuso il menu dello chef e 
	    	     * si torna all'elenco dei tavoli.
	    	     */
	    	    si.addActionListener(new ActionListener() {
	    	    	public void actionPerformed(ActionEvent evento) {
	    	    		controllo.dispose();
	    	    		editable_menu.dispose(); 
	    		    	new ElencoTavoliCuoco();
	    	    	}
	    	    });
	    		
	    	    /**
	    	     * Si rende visibile il frame editable_menu, si colloca al centro e si può chiudere con il tasto "X".
	    	     */
	    	    controllo.setVisible(true);
	    		controllo.setLocationRelativeTo(null);
	    		controllo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    }
	    });
		
	    /**
		 * Il pannello down contiene tutti quegli elementi che vengono disposti proprio nella parte bassa della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel down = new JPanel();
		up.setLayout(new GridLayout(1,1));
		contenuto.add(down, BorderLayout.SOUTH);
	    
		/**
	     * Viene aggiunto un bottone conferma, grazie al quale è possibile confermare l'ordine definitivamente.
	     */
	    JButton conferma = new JButton("EVADI ORDINE");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
	    conferma.setForeground(Color.BLACK);
	    down.add(conferma, BorderLayout.SOUTH);
	    
	    conferma.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evento) {
	    		
	    		/**
	    		 * Quando si clicca il bottone "conferma", si cambierà lo stato del tavolo da "NI" a "E".
	    		 */
	    	    for (int k = 0; k < tavoli.size(); k++) {
	    	    	if (numerotavolo == tavoli.getTavolo(k).getNumero())
			    	    tavoli.getTavolo(k).setStato("E");
	    	    		utilizzaPolimorfismo(tavoli);
	    	    }
	    	    
	    	    /**
	    	     * Creo un nuovo JFrame creato dalla classe ElencoTavoliCuoco con un alert che l'ordine è stato evaso.
	    	     */
		    	editable_menu.dispose();
		    	new ElencoTavoliCuoco();
		    	JOptionPane.showMessageDialog(null, "Ordine evaso!");
	    	}});
	    
	    /**
         * Il pannello centrale viene aggiungo al contenuto del frame, e vengono impostate delle specifiche, 
         * essendo il pannello un JSplitPane.
         */
	    contenuto.add(pannello_centrale,BorderLayout.CENTER);
	    
	    /**
		 * Viene inserito un oggetto JScrollPane, in modo tale da vedere bene tutti i piatti scorrendo con una barra, 
		 * nel caso diventassero tanti.
		 */
        JScrollPane scroll = new JScrollPane(pannello_centrale);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll);
		
		/**
		 * viene poi chiamata la funzione popolaPannello grazie al quale i piatti con relativo nome, 
		 * prezzo e quantita vengono aggiunti al pannello centrale.
		 */
		popolaPannello(comanda, pannello_centrale);
		
		/**
		 * Il frame viene reso visibile,settato al centro e chiudibile con il tasto "X".
		 */
	    editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Metodo che aggiunge al pannello centrale i piatti da evadere.
	 * @param comanda: è il file e l'ArrayList della comanda.
	 * @param pannello_variabile : è il pannello centrale.
	 */
	public void popolaPannello(Scontrino comanda,JPanel pannello_variabile ) {
		
		/**
	     * Si scorre la lista dei piatti, e si controlla se la quantita del piatto è maggiore di zero.
	     * Nel caso la risposta fosse si, il piatto viene aggiunto al pannello centrale.
	     */
		for (int j = 0; j < comanda.size(); j++) {
					if (comanda.getPiatto(j).getNumcategory()>0) {
						
						/**
		    			 * Il nome del piatto viene aggiunto al pannello centrale.
		    			 * Tra un piatto e l'altro viene inserita una RigidArea,che permette di ordinare al meglio 
		    			 * il contenuto da un punto di vista grafico.
		    			 */
						pannello_centrale.add(Box.createRigidArea(new Dimension(0, 25)));
						JLabel piatto = new JLabel("PIATTO: " + comanda.getPiatto(j).getName());
			    		piatto.setFont(new Font("Ink Free", Font.BOLD, 22));
					    piatto.setForeground(Color.BLACK);
					    piatto.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(piatto);
				        
				        /**
		    			 * Il prezzo del piatto viene aggiunto al pannello centrale.
		    			 */
				        JLabel prezzo = new JLabel("PREZZO: " + comanda.getPiatto(j).getPrice() + "   €");
			    		prezzo.setFont(new Font("Ink Free", Font.BOLD, 22));
					    prezzo.setForeground(Color.BLACK);
					    prezzo.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(prezzo);
				        
				        /**
		    			 * La quantita del piatto viene aggiunto al pannello centrale.
		    			 */
				        JLabel quantita = new JLabel("N. PORZIONI: " + comanda.getPiatto(j).getNumcategory() + "");
			    		quantita.setFont(new Font("Ink Free", Font.BOLD, 22));
					    quantita.setForeground(Color.BLACK);
					    quantita.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(quantita);
					}
	   		}
	}
	
	/**
	 * Utilizzo il polimorfismo per scrivere sul file.txt in base all'oggetto dichiarato in precedenza.
	 * @param po è l'interfaccia con il metodo write();
	 **/
	public static void utilizzaPolimorfismo(Lista po){
		po.write();
	}
}
