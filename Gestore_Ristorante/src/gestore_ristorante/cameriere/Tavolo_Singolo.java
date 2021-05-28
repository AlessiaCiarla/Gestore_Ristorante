package gestore_ristorante.cameriere;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import gestore_ristorante.MenuPrincipale;
import gestore_ristorante.chef.ListaPiatti;



public class Tavolo_Singolo {

	
	public Tavolo_Singolo () {
		JFrame editable_menu= new JFrame("ORDINAZIONE");
		editable_menu.setSize(600,600); 
		
		/**
		 * Si crea un oggetto Container, che corrisponder� al contenuto del JFrame.
		 */
		Container contenuto= editable_menu.getContentPane();
		
		/**
		 * Si crea un primo JPanel "up",che implementa un GridLayout 1x2, e gli viene settato lo sfondo.
		 * Di conseguenza, il pannello "up" viene posto in posizione NORTH del Container, che invece implementa un BorderLayout.
		 */
		JPanel up= new JPanel();
		up.setLayout(new GridLayout(1,2));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		
		JPanel down= new JPanel();
		up.setLayout(new GridLayout(1,1));
		contenuto.add(down, BorderLayout.SOUTH);
		
		
		/**
		 * Si vanno poi a definire una label e un bottone che saranno posizionati sul JPanel "up".
		 * Si crea per primo una label menu, con testo, posizione, font e sfondo settati; la label viene infine aggiunta al pannello "up".
		 */
		JLabel menu = new JLabel("MENU", SwingConstants.CENTER);
		menu.setFont(new Font("Garamond", Font.BOLD, 22));
	    menu.setForeground(Color.BLACK);
		up.add(menu);
		
		/**
		 * Poi si crea, per secondo, un bottone con un'icona e sfondo settato.
		 * Viene poi aggiunto al pannello "up".
		 */
		Icon freccia = new ImageIcon("images/freccia1.png");
		JButton back= new JButton(freccia);
		back.setBackground(MenuPrincipale.COLORE_SFONDO);
	    up.add(back);
	    
	    /**
	     * Viene poi gestito l'evento riguardante il clic sul bottone back.
	     */
	    back.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	
		    	/**
		    	 * In questo caso, il JFrame di Menu_Chef viene chiuso, e ne viene creato uno nuovo di tipo Menu_Principale, che riporta proprio alla schermata principale.
		    	 */
		    	editable_menu.dispose(); 
		    	new Gestione_Tavoli();
		    }
	    });
	    
	    String categorie[] ={"ANTIPASTI", "PRIMI", "SECONDI", "CONTORNI", "DOLCI"};
		ListaPiatti listap= new ListaPiatti();
		int lunghezza= categorie.length + listap.size();
	    
		JPanel center_left= new JPanel();
		center_left.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_left.setLayout(new GridLayout(lunghezza,1));
	    
		JPanel center_right= new JPanel();
		center_right.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_right.setLayout(new GridLayout(lunghezza,1));

		
		JSplitPane center = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,center_left, center_right);
		contenuto.add(center,BorderLayout.CENTER);
		center.setResizeWeight(0.8);
        center.setContinuousLayout(true);
        JScrollPane scroll1= new JScrollPane(center);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
	    editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		for (int i = 0; i < categorie.length; i++) {
   		 JLabel categ = new JLabel(categorie[i], SwingConstants.CENTER);
   		 categ.setFont(new Font("Garamond", Font.BOLD, 22));
		 categ.setForeground(Color.BLACK);
		 center_left.add(categ);
		 
		 JLabel vuota = new JLabel();
		 vuota.setForeground(new Color(220,220,220));
		 center_right.add(vuota);
		
		for (int j = 0; j < listap.size(); j++) {
    		if (listap.getPiatto(j).getNumcategory()== i) {
    			JLabel piatto = new JLabel(listap.getPiatto(j).getName() + "     $" + listap.getPiatto(j).getPrice());
	    		piatto.setFont(new Font("AR BLANCA", Font.BOLD, 20));
			    piatto.setForeground(Color.BLACK);
		        center_left.add(piatto);
		        
		        SpinnerModel limite = new SpinnerNumberModel(0, 0, 10, 1);
				JSpinner aggiungi = new JSpinner(limite);
				aggiungi.setBackground(MenuPrincipale.COLORE_SFONDO);
				aggiungi.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		        center_right.add(aggiungi);
		       
    			}
			}
		
		}
		
		JButton conferma = new JButton("CONFERMA");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
	    conferma.setForeground(Color.BLACK);
	    down.add(conferma, BorderLayout.SOUTH);
	    
	  
	    
	    /**
		 * Metodi per rendere visibile la finestra,per collocarla al centro dello schermo e per chiuderla tramite il tasto "X".
		 */
		editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

