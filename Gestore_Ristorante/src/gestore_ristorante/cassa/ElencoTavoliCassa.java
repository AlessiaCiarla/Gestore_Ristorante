package gestore_ristorante.cassa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import gestore_ristorante.MenuPrincipale;
import gestore_ristorante.cameriere.ListaTavoli;
/**
 * Classe che implementa la gestione dei tavoli da parte della cassa.
 *
 */
public class ElencoTavoliCassa {
	
	/**
	 * I tavoli sono fissi e sono 5, quindi viene creato un array di strighe,rappresentante l'insieme dei tavoli.
	 * In secondo luogo, viene creato un oggetto di tipo ListaTavoli, grazie al quale invece riesco ad avere tutti i tavoli 
	 * con relativi attributi in un ArrayList.
	 */
	String tavoli[] ={"TAVOLO 1", "TAVOLO 2", "TAVOLO 3", "TAVOLO 4","TAVOLO 5"};
	ListaTavoli listat = new ListaTavoli();
	
	/**
	 * Graficamente, viene creato un un nuovo JFrame, con il rispettivo ContentPane.
	 * Inoltre, viene creato come attributo anche il pannello che conterrï¿½ il menï¿½ ed i bottoni,in modo tale che sia modificabile e riconoscibile in ogni funzione.
	 */
	JFrame table_view= new JFrame("LISTA DEI TAVOLI");
	Container contenuto= table_view.getContentPane();
	JSplitPane pannello_variabile=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
    
	/**
	 * Il costruttore chiama la funzione visualizza.
	 */
	public ElencoTavoliCassa() {
		visualizza();
	}
	
	/**
	 * La funzione visualizza in sintesi crea la parte alta della finestra 
	 * e setta le spechifiche grafiche del pannello principale,contenente la lista dei tavoli e i rispettivi bottoni.
	 */
	public void visualizza() {
		
		/**
		 * la misura del frame viene impostata a 600x600.
		 */
		table_view.setSize(600,600);
		
		/**
		 * Il pannello up contiene tutti quegli elementi che vengono disposti proprio nella parte alta della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel up= new JPanel();
		up.setLayout(new GridLayout(1,3));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		/**
		 * Viene aggiunta una label nometavolo, per dare un contesto al frame, e ne vengono impostate le specifiche.
		 */
		JLabel nometavolo = new JLabel("TAVOLI", SwingConstants.CENTER);
		nometavolo.setFont(new Font("Garamond", Font.BOLD, 20));
	    nometavolo.setForeground(Color.BLACK);
		up.add(nometavolo);
		
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
	    		
	    		JLabel domanda= new JLabel("Vuoi tornare al Menù Principale?",SwingConstants.CENTER);
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
	    	    		table_view.dispose(); 
	    		    	new MenuPrincipale();
	    	    	}
	    	    });
	    		
	    	    controllo.setVisible(true);
	    		controllo.setLocationRelativeTo(null);
	    		controllo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    }
	    });
	    
	    /**
         * il pannello centrale viene aggiungo al contenuto del frame ,
         *  e vengono impostate delle specifiche, essendo il pannello un JSplitPane.
         */
	    contenuto.add(pannello_variabile,BorderLayout.CENTER);
        pannello_variabile.setResizeWeight(0.8);
		pannello_variabile.setContinuousLayout(true);
		
		/**
		 * viene poi chiamata la funzione grazie al quale i tavoli con i rielativi stati vengono inseriti sul pannello centrale.
		 */
		popolaPannello();
		
		/**
		 * il frame viene reso visibile,settato al centro e chiudibile con il tasto "X".
		 */
		table_view.setVisible(true);
		table_view.setLocationRelativeTo(null);
		table_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * La funzione popolaPannello,come da nome, ï¿½ in grado di popolare il pannello centrale con vari oggetti.
	 */
	public void popolaPannello() {
		
		/**
		 * Essendo il pannello centrale un JSplitPane, questo ï¿½ caratterizzato dal fatto che ï¿½ divisibile in 2 pannelli piï¿½ piccoli;
		 * nel nostro caso, uno di sx e uno di dx.
		 * Entrambi usato il GridLayout e ne vengono settati i colori e aggiunti al pannello principale.
		 */
		JPanel center_left= new JPanel();
		center_left.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_left.setLayout(new GridLayout(5,2));
		pannello_variabile.setLeftComponent(center_left);
		
		JPanel center_right= new JPanel();
		center_right.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_right.setLayout(new GridLayout(5,2));
		pannello_variabile.setRightComponent(center_right);
		
		/**
		 * Si scorre l'array dei tavoli, e per ogni tavolo si crea un bottone con il nome  nel pannello di sx,
		 * e una label con lo stato dell'ordine nel pannello di dx.
		 */
		for (int i = 0; i < tavoli.length; i++) {
			/**
			 * il nome del tavolo viene aggiunto al pannello di sx.
			 */
			JButton Tavolo = new JButton (tavoli[i]);
			Tavolo.setFont(new Font("Garamond", Font.BOLD, 45));
			Tavolo.setBackground(MenuPrincipale.COLORE_SFONDO);
			Tavolo.setForeground(Color.BLACK);
		    center_left.add(Tavolo);
		    
		    /**
			 * Se lo stato dell'ordine non Ã¨ stato inserito o inserito allora il bottone del tavolo viene disattivato
			 */
		    if (listat.getTavolo(i).getStato().equals("NI")||listat.getTavolo(i).getStato().equals("I")) {
		    	Tavolo.setEnabled(false);
		    }
		    
		    /*
		     * indice identifica il numero del tavolo.
		     */
		    int indice=i;
		    
		    /**
    		 * Cliccando su un tavolo viene creato un nuovo frame dato dalla classe RiepilogoCassa, dove mi porto dietro il numero del tavolo su cui ho cliccato.
    		 */
		    Tavolo.addActionListener(new ActionListener(){
		    	public void actionPerformed(ActionEvent evento) {
		    		int numero = listat.getTavolo(indice).getNumero();
		    		table_view.dispose();
		    		new RiepilogoCassa(numero);
		    	}
		    });
		    
		    /**
			 * lo stato dell'ordine del tavolo viene aggiunto al pannello di dx.
			 */
		    for (int j = 0; j < listat.size(); j++) {
	    		if (listat.getTavolo(j).getNumero()== i) {
	    			JLabel status = new JLabel("STATO ORDINE: " + listat.getTavolo(j).getStato());
		    		status.setFont(new Font("Times New Roman", Font.BOLD, 20));
				    status.setForeground(Color.BLACK);
			        center_right.add(status);    
	    		}
		    }
		}
	}
}
