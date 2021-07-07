package gestoreRistorante.chef;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gestoreRistorante.Lista;
import gestoreRistorante.MenuPrincipale;

/**
 * Classe di front-end che implementa la grafica del menù che visualizzerà lo chef, che sarà modificabile grazie ad alcuni bottoni.
 *
 */
public class MenuChef {
	
	/**
	 * Le categorie sono fisse e sono 5, quindi viene creato un array di strighe,rappresentante le categorie.
	 * In secondo luogo, viene creato un oggetto di tipo ListaPiatti, grazie al quale invece riesco ad avere tutti i piatti nel menù.
	 */
	String categorie[] = {"ANTIPASTI", "PRIMI", "SECONDI", "CONTORNI", "DOLCI"};
	ListaPiatti listap = new ListaPiatti();
	
	/**
	 * Graficamente, viene creato un nuovo JFrame, con il rispettivo ContentPane.
	 * Inoltre, viene creato come attributo anche il pannello che conterrà il menù ed i bottoni, 
	 * in modo tale che sia modificabile e riconoscibile in ogni metodo.
	 */
	JFrame editable_menu = new JFrame("CHEF");
	Container contenuto = editable_menu.getContentPane();
	JSplitPane pannello_variabile = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	/**
	 * Il costruttore chiama il metodo visualizza().
	 */
	public MenuChef() {
		visualizza();
	}
	
	/**
	 * Il metodo visualizza() crea la parte alta della finestra e setta le spechifiche grafiche del pannello principale, 
	 * contenente il menù e i rispettivi bottoni.
	 */
	public void visualizza() {
		
		/**
		 * La misura del frame viene impostata a 600x600.
		 */
		editable_menu.setSize(600,600);
		
		/**
		 * Il pannello up contiene tutti quegli elementi che vengono disposti proprio nella parte alta della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel up = new JPanel();
		up.setLayout(new GridLayout(1,3));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
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
	    		JLabel domanda = new JLabel("Vuoi tornare al Menù Principale?",SwingConstants.CENTER);
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
	    	     * Se si clicca il tasto "no", si chiude semplicemente questo frame di controllo e si rimane sul Menù dello Chef.
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
	    	     * Se si clicca il tasto "si", viene chiuso il frame di controllo, viene chiuso il menù dello chef e si torna al menù principale.
	    	     */
	    	    si.addActionListener(new ActionListener() {
	    	    	public void actionPerformed(ActionEvent evento) {
	    	    		controllo.dispose();
	    	    		editable_menu.dispose(); 
	    		    	new MenuPrincipale();
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
	     * Viene aggiunto un bottone add, grazie al quale è possibile aggiungere un piatto al menù.
	     */
	    Icon piu = new ImageIcon("images/piu.png");
		JButton aggiungi = new JButton(piu);
		aggiungi.setBackground(MenuPrincipale.COLORE_BOTTONI);
        up.add(aggiungi);
	    
        aggiungi.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evento) {
	    		
	    		/**
	    		 * Quando si clicca il bottone "+", si aprirà un nuovo frame, di misura più contenuta.
	    		 */
	    		JFrame agg_piatto = new JFrame("AGGIUNGI UN PIATTO");
	    		agg_piatto.setSize(400,200);
	    		Container cont_agg = agg_piatto.getContentPane();
	    		
	    		/**
	    		 * In questo frame è possibile scegliere la categoria grazie a un menù a tendina, inserire un nome del piatto da tastiera
	    		 * e inserire il prezzo, sempre da tastiera.
	    		 */
	    		JPanel tendina1 = new JPanel();
	    		tendina1.setBackground(MenuPrincipale.COLORE_SFONDO);
	    		tendina1.setLayout(new GridLayout(3,2));
	    		cont_agg.add(tendina1,BorderLayout.CENTER);
	    		
	    		JLabel category = new JLabel("CATEGORIA:",SwingConstants.CENTER);
	    		category.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    category.setForeground(Color.BLACK);
	    		tendina1.add(category);
	    		
	    		final JComboBox<String> drop_down = new JComboBox<String>(categorie);
	    	    drop_down.setVisible(true);
	    	    tendina1.add(drop_down);
	    		
	    	    JLabel nome = new JLabel("NOME:",SwingConstants.CENTER);
	    		nome.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    nome.setForeground(Color.BLACK);
	    		tendina1.add(nome);
	    		
	    		JTextField name = new JTextField();
	    		tendina1.add(name);
	    		
	    		JLabel prezzo = new JLabel("PREZZO:",SwingConstants.CENTER);
	    		prezzo.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    prezzo.setForeground(Color.BLACK);
	    		tendina1.add(prezzo);
	    		
	    		JTextField price = new JTextField();
	    		tendina1.add(price);
	    		
	    		/**
	    		 * Alla fine, quando tutti i campi saranno compilati, cliccando il bottone "conferma", 
	    		 * si potrà visualizzare il frame del menù aggiornato.
	    		 */
	    		JPanel down = new JPanel();
	    		up.setLayout(new GridLayout(1,1));
	    		cont_agg.add(down, BorderLayout.SOUTH);
	    		
	    		JButton conferma = new JButton("CONFERMA");
	    		conferma.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
	    	    conferma.setForeground(Color.BLACK);
	    	    down.add(conferma);
	    	    
	    	    conferma.addActionListener(new ActionListener() {
	    	    	public void actionPerformed(ActionEvent evento) {
	    	    		
	    	    		/**
	    	    		 * Cliccando conferma, il frame dedicato all'aggiungimento del piatto verrà chiuso, 
	    	    		 * e verrà invocata la funzione aggiungiPiatto.
	    	    		 */
	    	    		try {
		    	    		String selectedcategory = (String) drop_down.getSelectedItem();
		    	    		int indice = -1;
		    	    		for (int i = 0; i < categorie.length; i++) {
		    	    			if (selectedcategory.equals(categorie[i])) {
		    	    				indice = i;
		    	    			}
		    	    		}
		    	    		String nuovo_prezzo = price.getText();
		    	    		double d_prezzo = Double.parseDouble(nuovo_prezzo);
		    	    		String nuovo_nome = name.getText();
	    	    			nuovo_nome = nuovo_nome.replace(",", " ");
		    	    		aggiungiPiatto(nuovo_nome,d_prezzo, indice);
		    	    		
		    	    		/**
		    	    		 * Il frame agg_piatto viene chiuso.
		    	    		 */
		    	    		agg_piatto.dispose();
		    	    	
		    	    	/**
		    	    	 * Nel caso in cui non venga inserito un nome o un prezzo valido da tastiera, compare un messaggio di alert.
		    	    	 */
	    	    		} catch (Exception ex) {
		    			    JOptionPane.showMessageDialog(null, "Per continuare, è necessario inserire un nome e un prezzo.");
	    	    		}
	    	    	}
	    	    });
	    	    
	    	    /**
	    	     * il frame agg_piatto deve essere visibile, viene collocato al centro dello schermo, e si chiude cliccando "X".
	    	     */
	    		agg_piatto.setVisible(true);
	    		agg_piatto.setLocationRelativeTo(null);
	    		agg_piatto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	}	
	    });
        
        /**
         * il pannello centrale viene aggiungo al contenuto del frame , e vengono impostate delle specifiche, essendo il pannello un JSplitPane.
         */
        contenuto.add(pannello_variabile,BorderLayout.CENTER);
        pannello_variabile.setResizeWeight(0.8);
		pannello_variabile.setContinuousLayout(true);
		
		/**
		 * Viene inserito un oggetto JScrollPane, in modo tale da vedere bene tutti i piatti scorrendo con una barra, 
		 * nel caso diventassero tanti.
		 */
        JScrollPane scroll1 = new JScrollPane(pannello_variabile);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
		
		/**
		 * Viene poi chiamato il metodo grazie al quale le categorie, i piatti e i relativi bottoni vengono inseriti sul pannello centrale.
		 */
		popolaPannello();
		
		/**
		 * Il frame viene reso visibile,settato al centro e chiudibile con il tasto "X".
		 */
		editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Il metodo popolaPannello(), come da nome, è in grado di popolare il pannello centrale con vari oggetti.
	 */
	public void popolaPannello() {
		
		/**
		 * Si ricava la lunghezza giusta del pannello data dalla lunghezza dell'array delle categorie e la lista dei piatti.
		 */
		int lunghezza = categorie.length + listap.size();
		
		/**
		 * Essendo il pannello centrale un JSplitPane, questo è caratterizzato dal fatto che è divisibile in 2 pannelli più piccoli;
		 * nel nostro caso, uno di sx e uno di dx.
		 * Entrambi usano il GridLayout e ne vengono settati i colori e aggiunti al pannello principale.
		 */
		JPanel center_left = new JPanel();
		center_left.setLayout(new GridLayout(lunghezza,1));
		center_left.setBackground(MenuPrincipale.COLORE_SFONDO);
		pannello_variabile.setLeftComponent(center_left);
	    
		JPanel center_right = new JPanel();
		center_right.setLayout(new GridLayout(lunghezza,1));
		center_right.setBackground(MenuPrincipale.COLORE_SFONDO);
		pannello_variabile.setRightComponent(center_right);
		
		/**
		 * Si scorre l'array delle categorie, e per ogni categoria letta si crea una label con il nome della categoria nel pannello di sx,
		 * e una label vuota per rispettare gli spazi nel pannello di dx.
		 */
		for (int i = 0; i < categorie.length; i++) {
			JLabel categ = new JLabel(categorie[i], SwingConstants.CENTER);
			categ.setFont(new Font("Garamond", Font.BOLD, 22));
		    categ.setForeground(Color.BLACK);
		    center_left.add(categ);
		     
		    JLabel category = new JLabel();
		    category.setBackground(MenuPrincipale.COLORE_SFONDO);
		    center_right.add(category);
		    
		    /**
		     * Mentre si scorrono le categorie, si scorre la lista dei piatti, e si controlla se l'iedntificativo del piatto 
		     * è uguale a quello della categoria.
		     * Nel caso la risposta fosse si, il piatto viene aggiunto al posto giusto, sotto la sua categoria di appartenenza.
		     */
	   		for (int j = 0; j < listap.size(); j++) {
	    		if (listap.getPiatto(j).getNumcategory() == i) {
	    			
	    			/**
	    			 * il nome del piatto e il suo prezzo vengono aggiunti al pannello di sx.
	    			 */
	    			JLabel piatto = new JLabel(listap.getPiatto(j).getName() + "     € " + listap.getPiatto(j).getPrice());
		    		piatto.setFont(new Font("AR BLANCA", Font.BOLD, 20));
				    piatto.setForeground(Color.BLACK);
			        center_left.add(piatto);
			        
			        /**
			         * Mi ricavo il nome, prezzo e categoria del piatto corrente, perchè serviranno in seguito.
			         */
			        String nomecorrente = listap.getPiatto(j).getName();
		    		double  prezzocorrente =listap.getPiatto(j).getPrice();
		    		int catcorrente = listap.getPiatto(j).getNumcategory();
		        
		    		/**
		    		 * Per ogni piatto aggiunto, nel pannello di destra viene creato un pulsante modifica,
		    		 *  grazie al quale è possibile modificare la categoria, il nome, il prezzo del piatto o rimuovere quest'ultimo.
		    		 */
			        Icon penna = new ImageIcon("images/penna.png");
					JButton modifica = new JButton(penna);
					modifica.setBackground(MenuPrincipale.COLORE_BOTTONI);
			        center_right.add(modifica);
		        
			        modifica.addActionListener(new ActionListener() {
				    	public void actionPerformed(ActionEvent evento) {
				    		
				    		/**
				    		 * Cliccando modifica viene creato un nuovo frame, di dimensioni più contenute.
				    		 *Da questo frame, è possibile cambiare la categoria da un menù a tendina, 
				    		 *inserire il nuovo nome e prezzo da tastiera e confermare, oppure rimuovere del tutto il piatto.
				    		 */
				    		JFrame mod_piatto = new JFrame("MODIFICA UN PIATTO");
				    		mod_piatto.setSize(400,200);
				    		Container cont_mod = mod_piatto.getContentPane();
			    		
				    		JPanel tendina2 = new JPanel();
				    		tendina2.setBackground(MenuPrincipale.COLORE_SFONDO);
				    		tendina2.setLayout(new GridLayout(3,2));
				    		cont_mod.add(tendina2,BorderLayout.CENTER);
				    		
				    		JLabel category = new JLabel("CATEGORIA:",SwingConstants.CENTER);
				    		category.setFont(new Font("Garamond", Font.BOLD, 20));
				    	    category.setForeground(Color.BLACK);
				    		tendina2.add(category);
			    		
				    		final JComboBox<String> drop_down = new JComboBox<String>(categorie);
				    	    drop_down.setVisible(true);
				    	    tendina2.add(drop_down);
				    		
				    	    JLabel nome = new JLabel("NOME:",SwingConstants.CENTER);
				    		nome.setFont(new Font("Garamond", Font.BOLD, 20));
				    	    nome.setForeground(Color.BLACK);
				    		tendina2.add(nome);
			    		
				    		JTextField name = new JTextField();
				    		tendina2.add(name);
				    		
				    		JLabel prezzo = new JLabel("PREZZO:",SwingConstants.CENTER);
				    		prezzo.setFont(new Font("Garamond", Font.BOLD, 20));
				    	    prezzo.setForeground(Color.BLACK);
				    		tendina2.add(prezzo);
			    		
				    		JTextField price = new JTextField();
				    		tendina2.add(price);
				    		
				    		JPanel down = new JPanel();
				    		down.setLayout(new GridLayout(1,2));
				    		cont_mod.add(down, BorderLayout.SOUTH);
				    		
				    		JButton rimuovi = new JButton("RIMUOVI PIATTO");
				    		rimuovi.setFont(new Font("Garamond", Font.BOLD, 18));
				    	    rimuovi.setBackground(MenuPrincipale.COLORE_SFONDO);
				    	    rimuovi.setForeground(Color.BLACK);
				    	    down.add(rimuovi);
				    	    
				    	    rimuovi.addActionListener(new ActionListener() {
						    	public void actionPerformed(ActionEvent evento) {
						    		
						    		/**
						    		 * Cliccando rimuovi piatto, si chiude il frame grazie al quale è possibile modificare o rimuovere 
						    		 * il piatto e viene richiamata la funzione rimuoviPiatto.
						    		 */
						    		mod_piatto.dispose();
						    		rimuoviPiatto(nomecorrente, prezzocorrente, catcorrente);
						    	}
				    	    });
				    		
				    	    /**
				    	     * Viene creato poi un bottone di conferma, grazie al quale il piatto sarà ancora presente nel menù, 
				    	     * ma con le modifiche impostate.
				    	     */
				    		JButton conferma = new JButton("CONFERMA");
				    		conferma.setFont(new Font("Garamond", Font.BOLD, 18));
				    	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
				    	    conferma.setForeground(Color.BLACK);
				    	    down.add(conferma);
				    	    
				    	    conferma.addActionListener(new ActionListener() {
						    	public void actionPerformed(ActionEvent evento) {
						    		
						    		/**
						    		 * Cliccando conferma, il frame viene chiuso e ,dopo aver ricavati i dati giusti, 
						    		 * viene chiamata la funzione modificaPiatto.
						    		 */
						    		try {
							    		String newcategory = (String) drop_down.getSelectedItem();
					    	    		int indice = -1;
					    	    		for (int i = 0; i < categorie.length; i++) {
					    	    			if (newcategory.equals(categorie[i])) {
					    	    				indice = i;
					    	    			}
					    	    		}
					    	    		String newprice = price.getText();
					    	    		double prezzomod = Double.parseDouble(newprice);
					    	    		String nomemod = name.getText();
					    	    		Piatto sostituto = new Piatto(nomemod,prezzomod,indice);
					    	    		Piatto dasostituire = new Piatto(nomecorrente,prezzocorrente,catcorrente);
					    	    		modificaPiatto(dasostituire, sostituto);
					    	    		
					    	    		/**
					    	    		 * Il frame mod_piatto viene infino chiuso.
					    	    		 */
					    	    		mod_piatto.dispose();
					    	    		
					    	    	/**
					    	    	 * Se non vengono inseriti nome o prezzo del piatto, viene lanciato un messaggio di alert.
					    	    	 */
						    		} catch (Exception ex) {
						    			JOptionPane.showMessageDialog(null, "Per continuare, è necessario inserire un nome e un prezzo.");
						    		}
						    	}
				    	    });
				    	    
				    	    /**
				    	     * Il frame per modificare il piatto viene reso visibile, posizionato al centro e chiudibile con "X".
				    	     */
				    		mod_piatto.setVisible(true);
				    		mod_piatto.setLocationRelativeTo(null);
				    		mod_piatto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					    }
			        });
	    		}
	   		}
		}
	}
	
	/**
	 * Il metodo aggiungiPiatto() permette di aggiungere un piatto sia graficamente che funzionalmente(sia back-end che front-end).
	 * @param nome_piatto : stringa che identifica il nome del piatto;
	 * @param prezzo_piatto : duoble che identifica il prezzo del piatto;
	 * @param category : intero che indentifica la categoria del piatto.
	 */
	public void aggiungiPiatto(String nome_piatto, double prezzo_piatto, int category) {
		
		/**
		 * Il contenuto del frame viene pulito, e viene ricostruito; di conseguenza viene creato anche un nuovo pannello di tipo JSplitPane.
		 */
		editable_menu.getContentPane().removeAll();
		contenuto = editable_menu.getContentPane();
		pannello_variabile = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		/**
		 * Viene creato un nuovo oggetto di tipo piatto, grazie ai 3 parametri in input.
		 */
		Piatto nuovo_piatto = new Piatto(nome_piatto,prezzo_piatto, category);
		
		/**
		 * il piatto viene aggiunto alla lista dei piatti.
		 * La lista viene poi ordinata.
		 * Si riscrive sul file il contenuto della lista, in questo caso con il piatto aggiunto.
		 */
		listap.add(nuovo_piatto);
		listap.sort();
		utilizzaPolimorfismo(listap);
		
		/**
		 * Viene richiamata la funzione visualizza, grazie alla quale è possibile ricreare il contenuto del frame e popolare nuovamente 
		 * il pannello centrale con il nuovo piatto.
		 */
		visualizza();
		
		/**
		 * Viene effettuato un refresh della finestra.
		 */
		editable_menu.invalidate();
		editable_menu.validate();
		editable_menu.repaint();
	}
	
	/**
	 * Il metodo rimuoviPiatto() permette di rimuovere un piatto sia graficamente che funzionalmente(sia back-end che front-end).
	 * @param nome_piatto : stringa che identifica il nome del piatto;
	 * @param prezzo_piatto : duoble che identifica il prezzo del piatto;
	 * @param category : intero che indentifica la categoria del piatto.
	 */
	public void rimuoviPiatto(String nome_piatto, double prezzo_piatto, int category) {
		
		/**
		 * il contenuto del frame viene pulito, e viene ricostruito; di conseguenza viene creato anche un nuovo pannello di tipo JSplitPane.
		 */
		editable_menu.getContentPane().removeAll();
		contenuto = editable_menu.getContentPane();
		pannello_variabile = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		/**
		 * Viene creato un nuovo oggetto di tipo piatto, grazie ai 3 parametri in input.
		 */
		Piatto darimuovere = new Piatto(nome_piatto, prezzo_piatto, category);
		
		/**
		 * il piatto viene rimosso dalla lista dei piatti.
		 * La lista viene poi ordinata.
		 * Si riscrive sul file il contenuto della lista, in questo caso con il piatto rimosso.
		 */
		listap.remove(darimuovere);
		utilizzaPolimorfismo(listap);
		visualizza();
		
		/**
		 * Viene effettuato un refresh della finestra.
		 */
		editable_menu.invalidate();
		editable_menu.validate();
		editable_menu.repaint();
	}
	
	/**
	 * Il metodo modificaPiatto() consente di modificare un piatto confrontando il piatto vecchio da sostituire, con il nuovo piatto con i dati modificati( sarà il suo sostituto).
	 * @param dasostituire: piatto già presente nel menù, i cui dati (alcuni o tutti) vogliono essere cambiati.
	 * @param sostituto : piatto che sarà il sostituto del primo parametro.
	 */
	public void modificaPiatto(Piatto dasostituire, Piatto sostituto) {
		
		/**
		 * il contenuto del frame viene pulito, e viene ricostruito; di conseguenza viene creato anche un nuovo pannello di tipo JSplitPane.
		 */
		editable_menu.getContentPane().removeAll();
		contenuto = editable_menu.getContentPane();
		pannello_variabile = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		/**
		 * il primo piatto viene sostituito dai dati del secondo.
		 * La lista viene poi ordinata.
		 * Si riscrive sul file il contenuto della lista, in questo caso con il piatto rimosso.
		 */
		listap.modify(dasostituire, sostituto);
		utilizzaPolimorfismo(listap);
		visualizza();
		
		/**
		 * Viene effettuato un refresh della finestra.
		 */
		editable_menu.invalidate();
		editable_menu.validate();
		editable_menu.repaint();
	}
	
	/**
	 * Utilizzo il polimorfismo per scrivere sul file.txt in base all'oggetto dichiarato in precedenza.
	 * @param po è l'interfaccia con il metodo write();
	 **/
	public static void utilizzaPolimorfismo(Lista po){
		po.write();
	}
	
}