package gestoreRistorante.cameriere;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gestoreRistorante.Lista;
import gestoreRistorante.MenuPrincipale;
import gestoreRistorante.chef.ListaPiatti;
import gestoreRistorante.chef.Piatto;

/**
 * Classe che implementa la grafica del menù per prendere l'ordinazione del tavolo selezionato.
 *
 */
public class TavoloSingolo{
	
	/**
	 * Le categorie sono fisse e sono 5, quindi viene creato un array di strighe,rappresentante le categorie.
	 * In secondo luogo, viene creato un oggetto di tipo ListaPiatti, grazie al quale invece riesco ad avere tutti i piatti nel menù.
	 */
	String categorie[] = {"ANTIPASTI", "PRIMI", "SECONDI", "CONTORNI", "DOLCI"};
	ListaPiatti listap = new ListaPiatti();
	
	/**
	 * si ricava la lunghezza giusta del pannello data dalla lunghezza dell'array delle categorie e la lista dei piatti.
	 */
	int lunghezza = categorie.length + listap.size();
	
	/**
	 * viene creato un oggetto di tipo Ordinazione, grazie al quale invece riesco ad avere tutte le quantità di ogni piatto ordinato.
	 */
	Ordinazione quantita = new Ordinazione();  
	
	/**
	 * numerotavolo è il numero del tavolo su cui sto prendendo l'ordinazione.
	 */
	int numerotavolo;
	
	/**
	 * Graficamente, viene creato un un nuovo JFrame, con il rispettivo ContentPane.
	 * Inoltre, viene creato come attributo anche il pannello che conterrà il menù ed i bottoni,
	 *  in modo tale che sia modificabile e riconoscibile in ogni metodo.
	 */
	JFrame ordinazione = new JFrame("TAVOLO SINGOLO");
	Container contenuto = ordinazione.getContentPane();
	JSplitPane pannello_centrale = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	/**
	 * Variabile che serve a far uscire un alert se non è stata selezionata nessuna quantità.
	 */
	int contatore_quantita = 0;
	
	/**
	 * Il costruttore chiama il metodo visualizza().
	 * @param int num: è il numero del tavolo su cui sto prendendo l'ordinazione.
	 */

	public TavoloSingolo(int num) {
		this.numerotavolo = num;
		visualizza();
	}
	
	/**
	 * Il metodo visualizza() in sintesi crea la parte alta della finestra e setta le spechifiche grafiche
	 *  del pannello principale,contenente il menù e i rispettivi bottoni.
	 */
	public void visualizza() {
		
		/**
		 * Ad ogni avvio pulisco il file appoggio.txt e l'ArrayList dove è contenuta l'ordinazione,
		 *  per poter prendere in modo corretto una nuova ordinazione.
		 */
		quantita.clear();
		
		/**
		 * La misura del frame viene impostata a 600x600.
		 */
		ordinazione.setSize(600,600);
		
		/**
		 * Il pannello up contiene tutti quegli elementi che vengono disposti proprio nella parte alta della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel up = new JPanel();
		up.setLayout(new GridLayout(1,2));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		/**
		 * Il pannello down contiene tutti quegli elementi che vengono disposti proprio nella parte bassa della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel down = new JPanel();
		up.setLayout(new GridLayout(1,1));
		down.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(down, BorderLayout.SOUTH);
		
		/**
		 * Viene aggiunta una label menu, per dare un contesto al frame, e ne vengono impostate le specifiche.
		 */
		JLabel menu = new JLabel("MENU", SwingConstants.CENTER);
		menu.setFont(new Font("Garamond", Font.BOLD, 22));
	    menu.setForeground(Color.BLACK);
		up.add(menu);
		
		/**
		 * Viene aggiunto un pulsante back, per tornare alla schermata principale.
		 */
		Icon freccia = new ImageIcon("images/freccia.png");
		JButton back = new JButton(freccia);
		back.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    up.add(back);
	    
	    back.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	
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
	    	     * Se si clicca il tasto "no", si chiude semplicemente questo frame di controllo e si rimane sul Menù.
	    	     */
	    	    no.addActionListener(new ActionListener(){
	    	    	public void actionPerformed(ActionEvent evento){
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
	    	     * Se si clicca il tasto "si", viene chiuso il frame di controllo, viene chiuso il menù e si torna all'elenco dei tavoli.
	    	     */
	    	    si.addActionListener(new ActionListener() {
	    	    	public void actionPerformed(ActionEvent evento) {
	    	    		controllo.dispose();
	    	    		ordinazione.dispose(); 
	    		    	new ElencoTavoliCameriere();
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
	     * Viene aggiunto un bottone conferma al pannello down, grazie al quale è possibile confermare l'ordine e creare una comanda.
	     */
	    JButton conferma = new JButton("CONFERMA");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    conferma.setForeground(Color.BLACK);
	    down.add(conferma, BorderLayout.SOUTH);
	    
	    /**
	     * Viene creato un ActionListener per il pulsante conferma.
	     */
	    conferma.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evento) {
	    		
	    		/**
	    		 * Se il contatore che tiene la quantità dei piatto ordinati è uguale a 0, significa che non è stato aggiunto alcun piatto.
	    		 * Compare quindi un messaggio di alert, in quanto non è possibile creare un nuovo ordine che sia vuoto.
	    		 */
	    		if (contatore_quantita == 0) {
	    			JOptionPane.showMessageDialog(null, "Per proseguire, è necessario ordinare almeno una porzione.");
	    			
	    		/**
	    		 * Altrimenti, viene chiuso il frame del menù delle ordinazioni, viene scritta la comanda sul file 
	    		 * e viene creato un nuovo frame di tipo RiepilogoCameriere.
	    		 */
	    		} else {
			    	ordinazione.dispose();
			    	utilizzaPolimorfismo(quantita);
			    	new RiepilogoCameriere(numerotavolo);
	    		}
		    }
	    });
	    
	    /**
         * il pannello centrale viene aggiungo al contenuto del frame, e vengono impostate delle specifiche, 
         * essendo il pannello un JSplitPane.
         */
	    contenuto.add(pannello_centrale,BorderLayout.CENTER);
        pannello_centrale.setResizeWeight(0.8);
		pannello_centrale.setContinuousLayout(true);
		
		/**
		 * Viene inserito un oggetto JScrollPane, in modo tale da vedere bene tutti i piatti scorrendo con una barra, 
		 * nel caso diventassero tanti.
		 */
        JScrollPane scroll = new JScrollPane(pannello_centrale);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll);
		
		/**
		 * viene poi chiamato il metodo grazie al quale le categorie, i piatti e i relativi bottoni vengono inseriti sul pannello centrale.
		 */
		popolaPannello();
		
		/**
		 * Il frame viene reso visibile, settato al centro e chiudibile con il tasto "X".
		 */
	    ordinazione.setVisible(true);
		ordinazione.setLocationRelativeTo(null);
		ordinazione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
	/**
	 * Il metodo popolaPannello(), come da nome, è in grado di popolare il pannello centrale con vari oggetti.
	 */
	public void popolaPannello() {
		
		/**
		 * Essendo il pannello centrale un JSplitPane, questo è caratterizzato dal fatto che è divisibile in 2 pannelli più piccoli;
		 * nel nostro caso, uno di sx e uno di dx.
		 * Entrambi usano il GridLayout e ne vengono settati i colori e vengonos aggiunti al pannello principale.
		 */
		JPanel center_left = new JPanel();
		center_left.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_left.setLayout(new GridLayout(lunghezza,1));
		pannello_centrale.setLeftComponent(center_left);
		
		JPanel center_right = new JPanel();
		center_right.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_right.setLayout(new GridLayout(lunghezza,4));
		pannello_centrale.setRightComponent(center_right);
		
		/**
		 * Si scorre l'array delle categorie, e per ogni categoria letta si crea una label con il nome della categoria nel pannello di sx,
		 *  e tre label vuote per rispettare gli spazi nel pannello di dx.
		 */
		for (int i = 0; i < categorie.length; i++) {
   		 JLabel categ = new JLabel(categorie[i], SwingConstants.CENTER);
   		 categ.setFont(new Font("Garamond", Font.BOLD, 22));
		 categ.setForeground(Color.BLACK);
		 center_left.add(categ);
		 
		 JLabel vuota1 = new JLabel();
		 vuota1.setForeground(MenuPrincipale.COLORE_SFONDO);
		 center_right.add(vuota1);
		 JLabel vuota2 = new JLabel();
		 vuota2.setForeground(MenuPrincipale.COLORE_SFONDO);
		 center_right.add(vuota2);
		 JLabel vuota3 = new JLabel();
		 vuota3.setForeground(MenuPrincipale.COLORE_SFONDO);
		 center_right.add(vuota3);
		 	
		 	/**
		     * Mentre si scorrono le categorie, si scorre la lista dei piatti, e si controlla se l'identificativo del piatto è uguale 
		     * a quello della categoria.
		     * Nel caso la risposta fosse si, il piatto viene aggiunto al posto giusto, sotto la sua categoria di appartenenza.
		     */
			for (int j = 0; j < listap.size(); j++) {
	    		if (listap.getPiatto(j).getNumcategory() == i) {
	    			 
	    			/**
	    			 * il nome del piatto e il suo prezzo vengono aggiunti al pannello di sx.
	    			 */
	    			JLabel piatto = new JLabel(listap.getPiatto(j).getName() + "     €" + listap.getPiatto(j).getPrice());
		    		piatto.setFont(new Font("AR BLANCA", Font.BOLD, 20));
				    piatto.setForeground(Color.BLACK);
			        center_left.add(piatto);
			     
			        /**
	    			 * viene aggiunto al pannello di dx un bottone per diminuire la quantita da selezionare.
	    			 */
			        Icon meno = new ImageIcon("images/meno.jpeg");
					JButton diminuisci = new JButton(meno);
					diminuisci.setBackground(MenuPrincipale.COLORE_BOTTONI);
			        center_right.add(diminuisci);
			        
			        /**
	    			 * viene aggiunto al pannello di dx una label che identifica il numero di porzioni da ordinare.
	    			 */
			        JLabel numpor = new JLabel("   0");
					numpor.setForeground(MenuPrincipale.COLORE_SFONDO);
					numpor.setFont(new Font("Garamond", Font.BOLD, 22));
					numpor.setForeground(Color.BLACK);
					center_right.add(numpor);
			        
					/**
	    			 * viene aggiunto al pannello di dx un bottone per aumentare la quantita da selezionare.
	    			 */
					Icon piu = new ImageIcon("images/piu.png");
					JButton aggiungi = new JButton(piu);
					aggiungi.setBackground(MenuPrincipale.COLORE_BOTTONI);
				    center_right.add(aggiungi);
					
				    /**
				     * attributi che identificano il piatto che sto selezionando.
				     */
			        String nomecorrente = listap.getPiatto(j).getName();
		    		double  prezzocorrente = listap.getPiatto(j).getPrice();
		    		int indicecorrente = j;
		    		Integer counter = 0;
		    		
		    		/**
		    		 * metodo che aggiunge il piatto nell'ArrayList e nel file di ordinazione.
		    		 */
		    		aggiungiPiatto(nomecorrente, prezzocorrente, counter);
		    		
		    		diminuisci.addActionListener(new ActionListener() {
		    	    	public void actionPerformed(ActionEvent evento) {
		    	    		
		    	    		/**
				    		 * Cliccando "-", diminuisco l'attributo relativo alle quantita.
				    		 */
		    	    		String por = numpor.getText().trim();
		    	    		if (Integer.parseInt(por)>0) {
		    			
		    	    		Integer count = quantita.getPiatto(indicecorrente).getNumcategory() - 1;
		    	    		quantita.getPiatto(indicecorrente).setNumcategory(count);
		    	    		String porz = count.toString();
    	    				numpor.setText("   " + porz);
    	    				contatore_quantita=count;
		    	    		}
		    	    	}
			        });
		    		
		    		aggiungi.addActionListener(new ActionListener() {
		    	    	public void actionPerformed(ActionEvent evento) {
		    	    		/**
				    		 * Cliccando "+", aumento l'attributo relativo alle quantita.
				    		 */
		    	    		Integer count = quantita.getPiatto(indicecorrente).getNumcategory() + 1;
		    	    		quantita.getPiatto(indicecorrente).setNumcategory(count);
		    	    		String por = count.toString();
    	    				numpor.setText("   " + por);
    	    				contatore_quantita = count;
		    	    	}
			        });
	    		}
			}
		}
	}
	
	/**
	 * Il metodo aggiungiPiatto() permette di aggiungere un piatto sia graficamente che funzionalmente(sia back-end che front-end).
	 * @param nome_piatto : stringa che identifica il nome del piatto;
	 * @param prezzo_piatto : double che identifica il prezzo del piatto;
	 * @param porzioni : intero che indentifica le porzioni del piatto.
	 */
	public void aggiungiPiatto(String nome_piatto, double prezzo_piatto, int porzioni) {
		Piatto nuovo_piatto= new Piatto(nome_piatto,prezzo_piatto, porzioni);
		quantita.add(nuovo_piatto);
		quantita.sort();
	}
	
	/**
	 * Utilizzo il polimorfismo per scrivere sul file.txt in base all'oggetto dichiarato in precedenza.
	 * @param po è l'interfaccia con il metodo write();
	 **/
	public static void utilizzaPolimorfismo(Lista po)
	{
		po.write();
	}
}

