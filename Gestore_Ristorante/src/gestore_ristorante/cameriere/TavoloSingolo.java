package gestore_ristorante.cameriere;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gestore_ristorante.MenuPrincipale;
import gestore_ristorante.chef.ListaPiatti;
import gestore_ristorante.chef.Piatto;


/**
 * Classe che implementa la grafica del men� che visualizzer� il cameriere, che sar� modificabile grazie ad alcuni bottoni.
 *
 */
public class TavoloSingolo{
	
	/**
	 * Le categorie sono fisse e sono 5, quindi viene creato un array di strighe,rappresentante le categorie.
	 * In secondo luogo, viene creato un oggetto di tipo ListaPiatti, grazie al quale invece riesco ad avere tutti i piatti nel men�.
	 */
	String categorie[] ={"ANTIPASTI", "PRIMI", "SECONDI", "CONTORNI", "DOLCI"};
	ListaPiatti listap= new ListaPiatti();
	
	/**
	 * si ricava la lunghezza giusta del pannello data dalla lunghezza dell'array delle categorie e la lista dei piatti.
	 */
	int lunghezza= categorie.length + listap.size();
	
	/**
	 * viene creato un oggetto di tipo Ordinazione, grazie al quale invece riesco ad avere tutte le quantità di ogni piatto ordinato.
	 */
	Ordinazione quantita = new Ordinazione();  
	
	/**
	 * è il numero del tavolo su cui sto prendendo l'ordinazione.
	 */
	int numerotavolo;
	
	/**
	 * Graficamente, viene creato un un nuovo JFrame, con il rispettivo ContentPane.
	 * Inoltre, viene creato come attributo anche il pannello che conterr� il men� ed i bottoni,in modo tale che sia modificabile e riconoscibile in ogni funzione.
	 */
	JFrame ordinazione= new JFrame("TAVOLO SINGOLO");
	Container contenuto= ordinazione.getContentPane();
	JSplitPane pannello_centrale=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	
	
	/**
	 * Il costruttore chiama la funzione visualizza.
	 * @param int num è il numero del tavolo su cui sto prendendo l'ordinazione.
	 */

	public TavoloSingolo (int num) {
		this.numerotavolo=num;
		visualizza();
	}
	
	/**
	 * La funzione visualizza in sintesi crea la parte alta della finestra e setta le spechifiche grafiche del pannello principale,contenente il men� e i rispettivi bottoni.
	 */
	public void visualizza() {
		/**
		 * Ad ogni avvio pulisco il file appoggio.txt e l'ArrayList dove è contenuta l'ordinazione.
		 */
		quantita.clear();
		
		/**
		 * la misura del frame viene impostata a 600x600.
		 */
		ordinazione.setSize(600,600);
		
		/**
		 * Il pannello up contiene tutti quegli elementi che vengono disposti proprio nella parte alta della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel up= new JPanel();
		up.setLayout(new GridLayout(1,2));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		/**
		 * Il pannello down contiene tutti quegli elementi che vengono disposti proprio nella parte bassa della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel down= new JPanel();
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
	    	    		ordinazione.dispose(); 
	    		    	new ElencoTavoliCameriere();
	    	    	}
	    	    });
	    		
	    	    controllo.setVisible(true);
	    		controllo.setLocationRelativeTo(null);
	    		controllo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    }
	    });
	    
	    /**
	     * Viene aggiunto un bottone conferma, grazie al quale � possibile conferma l'ordine e creare una comanda.
	     */
	    JButton conferma = new JButton("CONFERMA");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    conferma.setForeground(Color.BLACK);
	    down.add(conferma, BorderLayout.SOUTH);
	    
	    conferma.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento) {
	    		
	    		if (quantita.size()==0) {
	    			JOptionPane.showMessageDialog(null, "Per proseguire, è necessario ordinare almeno una porzione.");
	    		} else {
		    	ordinazione.dispose();
		    	quantita.write();
		    	new RiepilogoCameriere(numerotavolo);
	    		}
		    }
	    });
	    /**
         * il pannello centrale viene aggiungo al contenuto del frame , e vengono impostate delle specifiche, essendo il pannello un JSplitPane.
         */
	    contenuto.add(pannello_centrale,BorderLayout.CENTER);
        pannello_centrale.setResizeWeight(0.8);
		pannello_centrale.setContinuousLayout(true);
		
		/**
		 * Viene inserito un oggetto JScrollPane, in modo tale da vedere bene tutti i piatti scorrendo con una barra, nel caso diventassero tanti.
		 */
        JScrollPane scroll= new JScrollPane(pannello_centrale);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll);
		
		/**
		 * viene poi chiamata la funzione grazie al quale le cateogrie, i piatti e i relativi bottoni vengono inseriti sul pannello centrale.
		 */
		popolaPannello();
		
		/**
		 * il frame viene reso visibile,settato al centro e chiudibile con il tasto "X".
		 */
	    ordinazione.setVisible(true);
		ordinazione.setLocationRelativeTo(null);
		ordinazione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
	/**
	 * La funzione popolaPannello,come da nome, � in grado di popolare il pannello centrale con vari oggetti.
	 */
	public void popolaPannello() {
		
		/**
		 * Essendo il pannello centrale un JSplitPane, questo � caratterizzato dal fatto che � divisibile in 2 pannelli pi� piccoli;
		 * nel nostro caso, uno di sx e uno di dx.
		 * Entrambi usato il GridLayout e ne vengono settati i colori e aggiunti al pannello principale.
		 */
		JPanel center_left= new JPanel();
		center_left.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_left.setLayout(new GridLayout(lunghezza,1));
		pannello_centrale.setLeftComponent(center_left);
		
		JPanel center_right= new JPanel();
		center_right.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_right.setLayout(new GridLayout(lunghezza,4));
		pannello_centrale.setRightComponent(center_right);
		
		/**
		 * Si scorre l'array delle categorie, e per ogni categoria letta si crea una label con il nome della categoria nel pannello di sx, e tre label vuote per rispettare gli spazi nel pannello di dx.
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
		     * Mentre si scorrono le categorie, si scorre la lista dei piatti, e si controlla se l'iedntificativo del piatto � uguale a quello della categoria.
		     * Nel caso la risposta fosse si,il piatto viene aggiunto al posto giusto, sotto la sua categoria di appartenenza.
		     */
			for (int j = 0; j < listap.size(); j++) {
	    		if (listap.getPiatto(j).getNumcategory()== i) {
	    			 
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
	    			 * viene aggiunto al pannello di dx una label che identifica il nuero di porzioni da ordinare.
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
			        String nomecorrente= listap.getPiatto(j).getName();
		    		double  prezzocorrente=listap.getPiatto(j).getPrice();
		    		int indicecorrente = j;
		    		Integer counter = 0;
		    		
		    		/**
		    		 * metodo che aggiunge il piatto nell'ArrayList e nel file di ordinazione.
		    		 */
		    		aggiungiPiatto(nomecorrente, prezzocorrente, counter);
		    		
		    		diminuisci.addActionListener(new ActionListener(){
		    	    	public void actionPerformed(ActionEvent evento){
		    	    		
		    	    		/**
				    		 * Cliccando "-", diminuisco l'attributo relativo alle quantita.
				    		 */
		    	    		String por = numpor.getText().trim();
		    	    		if (Integer.parseInt(por)>0) {
		    			
		    	    		Integer count=quantita.getPiatto(indicecorrente).getNumcategory()-1;
		    	    		quantita.getPiatto(indicecorrente).setNumcategory(count);
		    	    		String porz = count.toString();
    	    				numpor.setText("   " + porz);
		    	    		}
		    	    	}
			        });
		    		
		    		aggiungi.addActionListener(new ActionListener(){
		    	    	public void actionPerformed(ActionEvent evento){
		    	    		/**
				    		 * Cliccando "+", aumento l'attributo relativo alle quantita.
				    		 */
		    	    		Integer count=quantita.getPiatto(indicecorrente).getNumcategory()+1;
		    	    		quantita.getPiatto(indicecorrente).setNumcategory(count);
		    	    		String por = count.toString();
    	    				numpor.setText("   " + por);
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
	 * @param porzioni : intero che indentifica le porzioni del piatto.
	 */
	public void aggiungiPiatto(String nome_piatto, double prezzo_piatto, int porzioni) {
		Piatto nuovo_piatto= new Piatto(nome_piatto,prezzo_piatto, porzioni);
		quantita.add(nuovo_piatto);
		quantita.sort();
	}
}

