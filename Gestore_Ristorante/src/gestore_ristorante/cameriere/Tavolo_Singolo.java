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
import gestore_ristorante.chef.Piatto;



public class Tavolo_Singolo{
	
	String categorie[] ={"ANTIPASTI", "PRIMI", "SECONDI", "CONTORNI", "DOLCI"};
	ListaPiatti listap= new ListaPiatti();
	int lunghezza= categorie.length + listap.size();
	ListaPiatti quantità = new ListaPiatti();
	JFrame editable_menu= new JFrame("ORDINAZIONE");
	 
	
	
	Container contenuto= editable_menu.getContentPane();
	
	JSplitPane pannello_variabile=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	
	public Tavolo_Singolo () {
		visualizza();
	}
	
	public void visualizza() {
		
		editable_menu.setSize(600,600);
		JPanel up= new JPanel();
		up.setLayout(new GridLayout(1,2));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		
		JPanel down= new JPanel();
		up.setLayout(new GridLayout(1,1));
		contenuto.add(down, BorderLayout.SOUTH);
		
		

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
	    
	    
	    back.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	
		    	/**
		    	 * In questo caso, il JFrame di Menu_Chef viene chiuso, e ne viene creato uno nuovo di tipo Menu_Principale, che riporta proprio alla schermata principale.
		    	 */
		    	editable_menu.dispose(); 
		    	new Gestione_Tavoli();
		    }
	    });
	    
	    JButton conferma = new JButton("CONFERMA");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
	    conferma.setForeground(Color.BLACK);
	    down.add(conferma, BorderLayout.SOUTH);
	    
	    conferma.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	
		    	/**
		    	 * In questo caso, il JFrame di Menu_Chef viene chiuso, e ne viene creato uno nuovo di tipo Menu_Principale, che riporta proprio alla schermata principale.
		    	 */
		    	editable_menu.dispose();
		    	new Riepilogo();
		    }
	    });
	    
	    
	    
	    contenuto.add(pannello_variabile,BorderLayout.CENTER);
        pannello_variabile.setResizeWeight(0.8);
		pannello_variabile.setContinuousLayout(true);
        JScrollPane scroll1= new JScrollPane(pannello_variabile);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
		popolaPannello();
	    editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
	public void popolaPannello() {
		JPanel center_left= new JPanel();
		center_left.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_left.setLayout(new GridLayout(lunghezza,1));
		pannello_variabile.setLeftComponent(center_left);
		
		JPanel center_right= new JPanel();
		center_right.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_right.setLayout(new GridLayout(lunghezza,1));
		pannello_variabile.setRightComponent(center_right);
		
		
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
		        
		        String value = aggiungi.getValue() + "";
		        quantità.add(new Piatto(listap.getPiatto(j).getName(), listap.getPiatto(j).getPrice(), Integer.parseInt(value)));
    			}
			}
		}	
	}
}

