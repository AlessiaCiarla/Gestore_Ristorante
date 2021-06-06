package gestore_ristorante.cuoco;


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
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import gestore_ristorante.MenuPrincipale;
import gestore_ristorante.cameriere.ListaTavoli;
import gestore_ristorante.cassa.Scontrino;

public class RiepilogoCuoco{
	
	
	String categorie[] = {"ANTIPASTI", "PRIMI", "SECONDI", "CONTORNI", "DOLCI"};
	JFrame editable_menu= new JFrame("RIEPILOGO ORDINE");
	Container contenuto= editable_menu.getContentPane();
	ListaTavoli tavoli = new ListaTavoli();
	JPanel pannello_centrale;
	int numerotavolo;
	
	
	public RiepilogoCuoco(int num) {
		this.numerotavolo=num;
		visualizza();
	}
	
	
	
	public void visualizza() {
		Scontrino scontrino = new Scontrino(numerotavolo);
		
		int contatore=0;
		for (int i = 0; i<scontrino.size(); i++) {
			if (scontrino.getPiatto(i).getNumcategory()>0) {
				contatore++;
			}
		
		}
		int lunghezza = contatore;
		pannello_centrale = new JPanel(new GridLayout(lunghezza, 3));
		editable_menu.setSize(600,600); 
		pannello_centrale.setBackground(MenuPrincipale.COLORE_SFONDO);
		
		JPanel up= new JPanel();
		up.setLayout(new GridLayout(1,2));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		
		JPanel down= new JPanel();
		up.setLayout(new GridLayout(1,1));
		contenuto.add(down, BorderLayout.SOUTH);
		
		
		
		JLabel menu = new JLabel("RIEPILOGO", SwingConstants.CENTER);
		menu.setFont(new Font("Garamond", Font.BOLD, 22));
	    menu.setForeground(Color.BLACK);
		up.add(menu);
		
		Icon freccia = new ImageIcon("images/freccia1.png");
		JButton back= new JButton(freccia);
		back.setBackground(MenuPrincipale.COLORE_SFONDO);
	    up.add(back);
	    
	    
	    back.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	editable_menu.dispose(); 
		    	new ElencoTavoliCuoco();
		    }
	    });
	    
	    
	    JButton conferma = new JButton("EVADI ORDINE");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
	    conferma.setForeground(Color.BLACK);
	    down.add(conferma, BorderLayout.SOUTH);
	    
	    
	    
	    conferma.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
	    	    for (int k=0; k<tavoli.size(); k++) {
	    	    	if (numerotavolo==tavoli.getTavolo(k).getNumero())
			    	    tavoli.getTavolo(k).setStato("E");
	    	    		tavoli.write();
	    	    }
		    	editable_menu.dispose();
		    	new ElencoTavoliCuoco();
	    	}});
	    
	    
	    contenuto.add(pannello_centrale,BorderLayout.CENTER);
        JScrollPane scroll1= new JScrollPane(pannello_centrale);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
		popolaPannello(scontrino, pannello_centrale);
	    editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	public void popolaPannello(Scontrino scontrino,JPanel pannello_variabile ) {
		for (int j = 0; j < scontrino.size(); j++) {
					if (scontrino.getPiatto(j).getNumcategory()>0) {
						JLabel piatto = new JLabel(scontrino.getPiatto(j).getName());
			    		piatto.setFont(new Font("AR BLANCA", Font.BOLD, 20));
					    piatto.setForeground(Color.BLACK);
				        pannello_centrale.add(piatto);
				        
				        JLabel prezzo = new JLabel(scontrino.getPiatto(j).getPrice() + "   $");
			    		prezzo.setFont(new Font("AR BLANCA", Font.BOLD, 20));
					    prezzo.setForeground(Color.BLACK);
				        pannello_centrale.add(prezzo);
				        
				        JLabel quantita = new JLabel(scontrino.getPiatto(j).getNumcategory() + "");
			    		quantita.setFont(new Font("AR BLANCA", Font.BOLD, 20));
					    quantita.setForeground(Color.BLACK);
				        pannello_centrale.add(quantita);
					}
	   		}
	}
}
