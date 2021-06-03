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
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import gestore_ristorante.MenuPrincipale;
import gestore_ristorante.cameriere.ListaTavoli;

public class RiepilogoCassa{
	
	
	String categorie[] = {"ANTIPASTI", "PRIMI", "SECONDI", "CONTORNI", "DOLCI"};
	JFrame editable_menu= new JFrame("RIEPILOGO ORDINE");
	Container contenuto= editable_menu.getContentPane();
	ListaTavoli tavoli = new ListaTavoli();
	int numerotavolo;
	double totale;
	
	
	public RiepilogoCassa(int num) {
		this.numerotavolo=num;
		visualizza();
	}
	
	
	
	public void visualizza() {
		Scontrino scontrino = new Scontrino(numerotavolo);
		int lunghezza= categorie.length + scontrino.size();
		JPanel pannello_variabile=new JPanel(new GridLayout(lunghezza, 1));
		editable_menu.setSize(600,600); 
		pannello_variabile.setBackground(MenuPrincipale.COLORE_SFONDO);
		
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
		    	new ElencoTavoliCassa();
		    }
	    });
	    
	    
	    
	    
		
		
	    JButton conferma = new JButton("PAGA ORDINE");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
	    conferma.setForeground(Color.BLACK);
	    down.add(conferma, BorderLayout.SOUTH);
	    
	    
	    
	    conferma.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
	    	    for (int k=0; k<tavoli.size(); k++) {
	    	    	if (numerotavolo==tavoli.getTavolo(k).getNumero())
			    	    tavoli.getTavolo(k).setStato("NI");
	    	    		tavoli.write();
	    	    }
		    	editable_menu.dispose();
		    	new ElencoTavoliCassa();
	    	}});
	    
	    
	    contenuto.add(pannello_variabile,BorderLayout.CENTER);
        JScrollPane scroll1= new JScrollPane(pannello_variabile);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
		popolaPannello(scontrino, pannello_variabile);
		JLabel prezzo = new JLabel("TOTALE: " + totale, SwingConstants.CENTER);
		prezzo.setFont(new Font("Garamond", Font.BOLD, 22));
	    prezzo.setForeground(Color.BLACK);
		down.add(prezzo, BorderLayout.SOUTH);
	    editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	public void popolaPannello(Scontrino scontrino,JPanel pannello_variabile ) {
		for (int j = 0; j < scontrino.size(); j++) {
					if (scontrino.getPiatto(j).getNumcategory()>0) {
					totale= totale + (scontrino.getPiatto(j).getPrice()*scontrino.getPiatto(j).getNumcategory());
	    			JLabel piatto = new JLabel(scontrino.getPiatto(j).getName() + "     � " + scontrino.getPiatto(j).getPrice() + " QUANTITA': "+scontrino.getPiatto(j).getNumcategory());
		    		piatto.setFont(new Font("AR BLANCA", Font.BOLD, 20));
				    piatto.setForeground(Color.BLACK);
			        pannello_variabile.add(piatto);
					}
	   		}
	}
}
