package gestore_ristorante.cassa;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import gestore_ristorante.MenuPrincipale;
import gestore_ristorante.cameriere.ListaTavoli;

public class RiepilogoCassa{
	
	JFrame editable_menu= new JFrame("RIEPILOGO ORDINE");
	Container contenuto= editable_menu.getContentPane();
	ListaTavoli tavoli = new ListaTavoli();
	JPanel pannello_centrale= new JPanel();	
	int numerotavolo;
	double totale;
	
	public RiepilogoCassa(int num) {
		this.numerotavolo=num;
		visualizza();
	}
	
	public void visualizza() {
		Scontrino scontrino = new Scontrino(numerotavolo);
		
		pannello_centrale.setLayout(new BoxLayout(pannello_centrale, BoxLayout.PAGE_AXIS));
		editable_menu.setSize(600,600); 
		pannello_centrale.setBackground(MenuPrincipale.COLORE_SFONDO);
		
		JPanel up= new JPanel();
		up.setLayout(new GridLayout(1,2));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		JLabel menu = new JLabel("RIEPILOGO", SwingConstants.CENTER);
		menu.setFont(new Font("Garamond", Font.BOLD, 22));
	    menu.setForeground(Color.BLACK);
		up.add(menu);
		
		Icon freccia = new ImageIcon("images/freccia1.png");
		JButton back= new JButton(freccia);
		back.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    up.add(back);
	    
	    
	    back.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	editable_menu.dispose(); 
		    	new ElencoTavoliCassa();
		    }
	    });
		
		JPanel down= new JPanel();
		down.setLayout(new GridLayout(1,2));
		down.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(down, BorderLayout.SOUTH);
		
	    JButton conferma = new JButton("PAGA ORDINE");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_BOTTONI);
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
		    	JOptionPane.showMessageDialog(null, "Pagamento effettuato!");
	    	}});
	    
	    contenuto.add(pannello_centrale,BorderLayout.CENTER);
        JScrollPane scroll1= new JScrollPane(pannello_centrale);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
		popolaPannello(scontrino, pannello_centrale);
		
		JLabel prezzo = new JLabel("TOTALE: €" + totale, SwingConstants.CENTER);
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
						
						pannello_centrale.add(Box.createRigidArea(new Dimension(0, 25)));
						JLabel piatto = new JLabel("PIATTO: " + scontrino.getPiatto(j).getName());
			    		piatto.setFont(new Font("Bell MT", Font.BOLD, 22));
					    piatto.setForeground(Color.BLACK);
					    piatto.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(piatto);
				        
				        JLabel prezzo = new JLabel("PREZZO: " + scontrino.getPiatto(j).getPrice() + "   €");
			    		prezzo.setFont(new Font("Bell MT", Font.BOLD, 22));
					    prezzo.setForeground(Color.BLACK);
					    prezzo.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(prezzo);
				        
				        JLabel quantita = new JLabel("N. PORZIONI: " + scontrino.getPiatto(j).getNumcategory() + "");
			    		quantita.setFont(new Font("Bell MT", Font.BOLD, 22));
					    quantita.setForeground(Color.BLACK);
					    quantita.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(quantita);
				        
				        totale= totale + (scontrino.getPiatto(j).getPrice()*scontrino.getPiatto(j).getNumcategory());
					}
	   		}
	}
}
