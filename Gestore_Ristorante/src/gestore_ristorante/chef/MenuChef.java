package gestore_ristorante.chef;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gestore_ristorante.MenuPrincipale;

/**
 * Classe che implementa la grafica del men� che visualizzer� lo chef, che sar� modificabile grazie ad alcuni bottoni.
 *
 */
public class MenuChef {
	
	/**
	 * Le categorie sono fisse e sono 5, quindi viene creato un array di strighe,rappresentante le categorie.
	 * In secondo luogo, viene creato un oggetto di tipo ListaPiatti, grazie al quale invece riesco ad avere tutti i piatti nel men�.
	 */
	String categorie[] ={"ANTIPASTI", "PRIMI", "SECONDI", "CONTORNI", "DOLCI"};
	ListaPiatti listap= new ListaPiatti();
	
	/**
	 * Graficamente, viene creato un un nuovo JFrame, con il rispettivo ContentPane.
	 * Inoltre, viene creato come attributo anche il pannello che conterr� il men� ed i bottoni,in modo tale che sia modificabile e riconoscibile in ogni funzione.
	 */
	JFrame editable_menu= new JFrame("CHEF");
	Container contenuto= editable_menu.getContentPane();
	JSplitPane pannello_variabile=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	/**
	 * Il costruttore chiama la funzione visualizza.
	 */
	public MenuChef() {
		visualizza();
	}
	
	/**
	 * La funzione visualizza in sintesi crea la parte alta della finestra e setta le spechifiche grafiche del pannello principale,contenente il men� e i rispettivi bottoni.
	 */
	public void visualizza() {
		
		/**
		 * la misura del frame viene impostata a 600x600.
		 */
		editable_menu.setSize(600,600);
		
		/**
		 * Il pannello up contiene tutti quegli elementi che vengono disposti proprio nella parte alta della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel up= new JPanel();
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
		Icon freccia = new ImageIcon("images/freccia1.png");
		JButton back= new JButton(freccia);
		back.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    up.add(back);
	    
	    back.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	
		    	/**
		    	 * In questo caso, il JFrame di Menu_Chef viene chiuso, e ne viene creato uno nuovo di tipo Menu_Principale, che riporta proprio alla schermata principale.
		    	 */
		    	editable_menu.dispose(); 
		    	new MenuPrincipale();
		    }
	    });
	    
	    /**
	     * Viene aggiunto un bottone add, grazie al quale � possibile aggiungere un piatto al men�.
	     */
	    Icon piu = new ImageIcon("images/piu.png");
		JButton aggiungi = new JButton(piu);
		aggiungi.setBackground(MenuPrincipale.COLORE_BOTTONI);
        up.add(aggiungi);
	    
        aggiungi.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
	    		
	    		/**
	    		 * Quando si clicca il bottone "+", si aprir� un nuovo frame, di misura pi� contenuta.
	    		 */
	    		JFrame agg_piatto= new JFrame("AGGIUNGI UN PIATTO");
	    		agg_piatto.setSize(400,200);
	    		Container cont_agg= agg_piatto.getContentPane();
	    		
	    		/**
	    		 * In questo frame � possibile scegliere la categoria grazei a un men� a tendina, inserire un nome del piatto da tastiera, e inserire il prezzo, sempre da tastiera.
	    		 */
	    		JPanel tendina1= new JPanel();
	    		tendina1.setBackground(MenuPrincipale.COLORE_SFONDO);
	    		tendina1.setLayout(new GridLayout(3,2));
	    		cont_agg.add(tendina1,BorderLayout.CENTER);
	    		
	    		JLabel category= new JLabel("CATEGORIA:",SwingConstants.CENTER);
	    		category.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    category.setForeground(Color.BLACK);
	    		tendina1.add(category);
	    		
	    		final JComboBox<String> drop_down = new JComboBox<String>(categorie);
	    	    drop_down.setVisible(true);
	    	    tendina1.add(drop_down);
	    		
	    	    JLabel nome= new JLabel("NOME:",SwingConstants.CENTER);
	    		nome.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    nome.setForeground(Color.BLACK);
	    		tendina1.add(nome);
	    		
	    		JTextField name= new JTextField();
	    		tendina1.add(name);
	    		
	    		JLabel prezzo= new JLabel("PREZZO:",SwingConstants.CENTER);
	    		prezzo.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    prezzo.setForeground(Color.BLACK);
	    		tendina1.add(prezzo);
	    		
	    		JTextField price= new JTextField();
	    		tendina1.add(price);
	    		
	    		/**
	    		 * Alla fine, quando tutti i campi saranno compilati, cliccando il bottone "conferma", si potr� visualizzare il frame del men� aggiornato.
	    		 */
	    		JPanel down= new JPanel();
	    		up.setLayout(new GridLayout(1,1));
	    		cont_agg.add(down, BorderLayout.SOUTH);
	    		
	    		JButton conferma = new JButton("CONFERMA");
	    		conferma.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
	    	    conferma.setForeground(Color.BLACK);
	    	    down.add(conferma);
	    	    
	    	    conferma.addActionListener(new ActionListener(){
	    	    	public void actionPerformed(ActionEvent evento){
	    	    		
	    	    		/**
	    	    		 * Cliccando conferma, il frame dedicato all'aggiungimento del piatto verr� chiuso, e verr� invocata la funzione aggiungiPiatto.
	    	    		 */
	    	    		agg_piatto.dispose();
	    	    		String selectedcategory= (String) drop_down.getSelectedItem();
	    	    		int indice=-1;
	    	    		for (int i = 0; i < categorie.length; i++) {
	    	    			if (selectedcategory.equals(categorie[i])) {
	    	    				indice= i;
	    	    			}
	    	    		}
	    	    		String nuovo_prezzo= price.getText();
	    	    		double d_prezzo=Double.parseDouble(nuovo_prezzo);
	    	    		String nuovo_nome= name.getText();
	    	    		aggiungiPiatto(nuovo_nome,d_prezzo, indice);
	    	    	}
	    	    });
	    	    
	    	    /**
	    	     * il frame agg_piatto deve essere visiile, viene collocato al centro dello schermo, e si chiude cliccando "X".
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
		 * Viene inserito un oggetto JScrollPane, in modo tale da vedere bene tutti i piatti scorrendo con una barra, nel caso diventassero tanti.
		 */
        JScrollPane scroll1= new JScrollPane(pannello_variabile);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
		
		/**
		 * viene poi chiamata la funzione grazie al quale le cateogrie, i piatti e i relativi bottoni vengono inseriti sul pannello centrale.
		 */
		popolaPannello();
		
		/**
		 * il frame viene reso visibile,settato al centro e chiudibile con il tasto "X".
		 */
		editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * La funzione popolaPannello,come da nome, � in grado di popolare il pannello centrale con vari oggetti.
	 */
	public void popolaPannello() {
		
		/**
		 * si ricava la lunghezza giusta del pannello data dalla lunghezza dell'array delle categorie e la lista dei piatti.
		 */
		int lunghezza= categorie.length + listap.size();
		
		/**
		 * Essendo il pannello centrale un JSplitPane, questo � caratterizzato dal fatto che � divisibile in 2 pannelli pi� piccoli;
		 * nel nostro caso, uno di sx e uno di dx.
		 * Entrambi usato il GridLayout e ne vengono settati i colori e aggiunti al pannello principale.
		 */
		JPanel center_left= new JPanel();
		center_left.setLayout(new GridLayout(lunghezza,1));
		center_left.setBackground(MenuPrincipale.COLORE_SFONDO);
		pannello_variabile.setLeftComponent(center_left);
	    
		JPanel center_right= new JPanel();
		center_right.setLayout(new GridLayout(lunghezza,1));
		center_right.setBackground(MenuPrincipale.COLORE_SFONDO);
		pannello_variabile.setRightComponent(center_right);
		
		/**
		 * Si scorre l'array delle categorie, e per ogni categoria letta si crea una label con il nome della categoria nel pannello di sx,e una label vuota per rispettare gli spazi nel pannello di dx.
		 */
		for (int i = 0; i < categorie.length; i++) {
			JLabel categ = new JLabel(categorie[i], SwingConstants.CENTER);
			categ.setFont(new Font("Garamond", Font.BOLD, 22));
		    categ.setForeground(Color.BLACK);
		    center_left.add(categ);
		     
		    JLabel category= new JLabel();
		    category.setBackground(MenuPrincipale.COLORE_SFONDO);
		    center_right.add(category);
		    
		    /**
		     * Mentre si scorrono le categorie, si scorre la lista dei piatti, e si controlla se l'iedntificativo del piatto � uguale a quello della categoria.
		     * Nel caso la risposta fosse si,il piatto viene aggiunto al posto giusto, sotto la sua categoria di appartenenza.
		     */
	   		for (int j = 0; j < listap.size(); j++) {
	    		if (listap.getPiatto(j).getNumcategory()== i) {
	    			
	    			/**
	    			 * il nome del piatto e il suo prezzo vengono aggiunti al pannello di sx.
	    			 */
	    			JLabel piatto = new JLabel(listap.getPiatto(j).getName() + "     � " + listap.getPiatto(j).getPrice());
		    		piatto.setFont(new Font("AR BLANCA", Font.BOLD, 20));
				    piatto.setForeground(Color.BLACK);
			        center_left.add(piatto);
			        
			        String nomecorrente= listap.getPiatto(j).getName();
		    		double  prezzocorrente=listap.getPiatto(j).getPrice();
		    		int catcorrente= listap.getPiatto(j).getNumcategory();
		        
		    		/**
		    		 * Per ogni piatto aggiunto, nel pannello di destra viene creato un pulsante modifica,grazie al quale � possibile modificare la categoria, il nome, il prezzo del piatto o rimuovere quest'ultimo.
		    		 */
			        Icon penna = new ImageIcon("images/penna1.png");
					JButton modifica = new JButton(penna);
					modifica.setBackground(MenuPrincipale.COLORE_BOTTONI);
			        center_right.add(modifica);
		        
			        modifica.addActionListener(new ActionListener(){
				    	public void actionPerformed(ActionEvent evento){
				    		
				    		/**
				    		 * Cliccando modifica viene creato un nuovo frame, di dimensioni pi� contenute.
				    		 *Da questo frame, � possibile cambiare la categoria da un men� a tendina, inserire il nuovo nome e prezzo da tastiera e confermare, oppure rimuovere del tutto il piatto.
				    		 */
				    		JFrame mod_piatto= new JFrame("MODIFICA UN PIATTO");
				    		mod_piatto.setSize(400,200);
				    		Container cont_mod= mod_piatto.getContentPane();
			    		
				    		JPanel tendina2= new JPanel();
				    		tendina2.setBackground(MenuPrincipale.COLORE_SFONDO);
				    		tendina2.setLayout(new GridLayout(3,2));
				    		cont_mod.add(tendina2,BorderLayout.CENTER);
				    		
				    		JLabel category= new JLabel("CATEGORIA:",SwingConstants.CENTER);
				    		category.setFont(new Font("Garamond", Font.BOLD, 20));
				    	    category.setForeground(Color.BLACK);
				    		tendina2.add(category);
			    		
				    		final JComboBox<String> drop_down = new JComboBox<String>(categorie);
				    	    drop_down.setVisible(true);
				    	    tendina2.add(drop_down);
				    		
				    	    JLabel nome= new JLabel("NOME:",SwingConstants.CENTER);
				    		nome.setFont(new Font("Garamond", Font.BOLD, 20));
				    	    nome.setForeground(Color.BLACK);
				    		tendina2.add(nome);
			    		
				    		JTextField name= new JTextField();
				    		tendina2.add(name);
				    		
				    		JLabel prezzo= new JLabel("PREZZO:",SwingConstants.CENTER);
				    		prezzo.setFont(new Font("Garamond", Font.BOLD, 20));
				    	    prezzo.setForeground(Color.BLACK);
				    		tendina2.add(prezzo);
			    		
				    		JTextField price= new JTextField();
				    		tendina2.add(price);
				    		
				    		JPanel down= new JPanel();
				    		down.setLayout(new GridLayout(1,2));
				    		cont_mod.add(down, BorderLayout.SOUTH);
				    		
				    		JButton rimuovi = new JButton("RIMUOVI PIATTO");
				    		rimuovi.setFont(new Font("Garamond", Font.BOLD, 18));
				    	    rimuovi.setBackground(MenuPrincipale.COLORE_SFONDO);
				    	    rimuovi.setForeground(Color.BLACK);
				    	    down.add(rimuovi);
				    	    
				    	    rimuovi.addActionListener(new ActionListener(){
						    	public void actionPerformed(ActionEvent evento){
						    		
						    		/**
						    		 * Cliccandi rimuovi piatto, si chiude il frame grazei al quale � possibile modificare o rimuovere il piatto e viene richiamata la funzione rimuoviPiatto.
						    		 */
						    		mod_piatto.dispose();
						    		rimuoviPiatto(nomecorrente, prezzocorrente, catcorrente);
						    	}
				    	    });
				    		
				    	    /**
				    	     * Se, invece, con conferma, il piatto sar� ancora presente nel men�, ma con le modifiche impostate.
				    	     */
				    		JButton conferma = new JButton("CONFERMA");
				    		conferma.setFont(new Font("Garamond", Font.BOLD, 18));
				    	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
				    	    conferma.setForeground(Color.BLACK);
				    	    down.add(conferma);
				    	    
				    	    conferma.addActionListener(new ActionListener(){
						    	public void actionPerformed(ActionEvent evento){
						    		
						    		/**
						    		 * Cliccando conferma, il frame viene chiuso e ,dopo aver ricavati i dati giusti, viene chiaata la funzione modificaPiatto.
						    		 */
						    		mod_piatto.dispose();
						    		String newcategory= (String) drop_down.getSelectedItem();
				    	    		int indice=-1;
				    	    		for (int i = 0; i < categorie.length; i++) {
				    	    			if (newcategory.equals(categorie[i])) {
				    	    				indice= i;
				    	    			}
				    	    		}
				    	    		String newprice= price.getText();
				    	    		double prezzomod=Double.parseDouble(newprice);
				    	    		String nomemod= name.getText();
				    	    		Piatto sostituto=new Piatto(nomemod,prezzomod,indice);
				    	    		Piatto dasostituire= new Piatto(nomecorrente,prezzocorrente,catcorrente);
				    	    		modificaPiatto(dasostituire, sostituto);
						    	}
				    	    });
				    	    
				    	    /**
				    	     * il frame per modificare il piatto viene reso visibile, posizionato al centro e chiudibile con "X".
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
	 * La funzione aggiungiPiatto permette di aggiungere un piatto sia graficamente che funzionalmente(sia back-end che front-end).
	 * @param nome_piatto : stringa che identifica il nome del piatto;
	 * @param prezzo_piatto : suoble che identifica il prezzo del piatto;
	 * @param category : intero che indentifica la categoria del piatto.
	 */
	public void aggiungiPiatto(String nome_piatto, double prezzo_piatto, int category) {
		
		/**
		 * il contenuto del frame viene pulito,e viene ricostruito; di conseguenza viene creato anche un nuovo pannello di tipo JSplitPane.
		 */
		editable_menu.getContentPane().removeAll();
		contenuto= editable_menu.getContentPane();
		pannello_variabile=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		/**
		 * Viene creato un nuovo oggetto di tipo piatto, grazie ai 3 parametri in input.
		 */
		Piatto nuovo_piatto= new Piatto(nome_piatto,prezzo_piatto, category);
		
		/**
		 * il piatto viene aggiunto alla lista dei piatti.
		 * La lista viene poi ordinata.
		 * Si riscrive sul file il contenuto della lista, in questo caso con il piatto aggiunto.
		 */
		listap.add(nuovo_piatto);
		listap.sort();
		listap.write();
		
		/**
		 * Viene richiamata la funzione visualizza, grazie alla quale � possibile ricreare il contenuto del frame e popolare nuovamente il pannello centrale con il nuovo piatto.
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
	 * La funzione rimuoviPiatto permette di rimuovere un piatto sia graficamente che funzionalmente(sia back-end che front-end).
	 * @param nome_piatto : stringa che identifica il nome del piatto;
	 * @param prezzo_piatto : suoble che identifica il prezzo del piatto;
	 * @param category : intero che indentifica la categoria del piatto.
	 */
	public void rimuoviPiatto(String nome_piatto, double prezzo_piatto, int category) {
		
		/**
		 * il contenuto del frame viene pulito,e viene ricostruito; di conseguenza viene creato anche un nuovo pannello di tipo JSplitPane.
		 */
		editable_menu.getContentPane().removeAll();
		contenuto= editable_menu.getContentPane();
		pannello_variabile=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		/**
		 * Viene creato un nuovo oggetto di tipo piatto, grazie ai 3 parametri in input.
		 */
		Piatto darimuovere= new Piatto(nome_piatto, prezzo_piatto, category);
		
		/**
		 * il piatto viene rimosso dalla lista dei piatti.
		 * La lista viene poi ordinata.
		 * Si riscrive sul file il contenuto della lista, in questo caso con il piatto rimosso.
		 */
		listap.remove(darimuovere);
		listap.write();
		visualizza();
		
		/**
		 * Viene effettuato un refresh della finestra.
		 */
		editable_menu.invalidate();
		editable_menu.validate();
		editable_menu.repaint();
	}
	
	/**
	 * La funzione modificaPiatto consente di modificare un piatto confrontando il piatto vecchio da sostituire, con il nuovo piatto con i dati modificati( sar� il suo sostituto).
	 * @param dasostituire: piatto gi� presente nel men�, i cui dati (alcuni o tutti) vogliono essere cambiati.
	 * @param sostituto : piatto che sar� il sostituto del primo parametro.
	 */
	public void modificaPiatto(Piatto dasostituire, Piatto sostituto) {
		
		/**
		 * il contenuto del frame viene pulito,e viene ricostruito; di conseguenza viene creato anche un nuovo pannello di tipo JSplitPane.
		 */
		editable_menu.getContentPane().removeAll();
		contenuto= editable_menu.getContentPane();
		pannello_variabile=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		/**
		 * il primo piatto viene sostituito dai dati del secondo.
		 * La lista viene poi ordinata.
		 * Si riscrive sul file il contenuto della lista, in questo caso con il piatto rimosso.
		 */
		listap.modify(dasostituire, sostituto);
		listap.write();
		visualizza();
		
		/**
		 * Viene effettuato un refresh della finestra.
		 */
		editable_menu.invalidate();
		editable_menu.validate();
		editable_menu.repaint();
	}
	
}