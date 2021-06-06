package gestore_ristorante.cameriere;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gestore_ristorante.MenuPrincipale;


public class ElencoTavoliCameriere {
	
	String nomitavoli[] ={"TAVOLO 1", "TAVOLO 2", "TAVOLO 3", "TAVOLO 4","TAVOLO 5"};
	ListaTavoli listat = new ListaTavoli();
	JFrame table_view= new JFrame("LISTA DEI TAVOLI");
	Container contenuto= table_view.getContentPane();
	JSplitPane pannello_centrale=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
    
	
	public ElencoTavoliCameriere() {
		
		
		visualizza();
	}
	
	
	
	public void visualizza() {
		
		table_view.setSize(600,600);
		
		JPanel up= new JPanel();
		up.setLayout(new GridLayout(1,3));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		JLabel tavoli = new JLabel("TAVOLI", SwingConstants.CENTER);
		tavoli.setFont(new Font("Garamond", Font.BOLD, 20));
	    tavoli.setForeground(Color.BLACK);
		up.add(tavoli);
		
		Icon freccia = new ImageIcon("images/freccia1.png");
		JButton back= new JButton(freccia);
		back.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    up.add(back);
	    
	    back.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	table_view.dispose(); 
		    	new MenuPrincipale();
		    }
	    });
	    
	    contenuto.add(pannello_centrale,BorderLayout.CENTER);
        pannello_centrale.setResizeWeight(0.8);
		pannello_centrale.setContinuousLayout(true);
		popolaPannello();
		table_view.setVisible(true);
		table_view.setLocationRelativeTo(null);
		table_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void popolaPannello() {
		JPanel center_left= new JPanel();
		center_left.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_left.setLayout(new GridLayout(5,2));
		pannello_centrale.setLeftComponent(center_left);
		
		JPanel center_right= new JPanel();
		center_right.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_right.setLayout(new GridLayout(5,2));
		pannello_centrale.setRightComponent(center_right);
		

		for (int i = 0; i < nomitavoli.length; i++) {
			JButton Tavolo = new JButton (nomitavoli[i]);
			Tavolo.setFont(new Font("Garamond", Font.BOLD, 45));
			Tavolo.setBackground(MenuPrincipale.COLORE_SFONDO);
			Tavolo.setForeground(Color.BLACK);
		    center_left.add(Tavolo);
		    if (listat.getTavolo(i).getStato().equals("I") || listat.getTavolo(i).getStato().equals("E")) {
		    	Tavolo.setEnabled(false);
		    }
		    int indice=i;
		
		    Tavolo.addActionListener(new ActionListener(){
		    	public void actionPerformed(ActionEvent evento) {
		    		int numero = listat.getTavolo(indice).getNumero();
		    		table_view.dispose();
		    		new Tavolo_Singolo(numero);
		    	}
		    });
		    
		    for (int j = 0; j < listat.size(); j++) {
	    		if (listat.getTavolo(j).getNumero()== i) {
	    			JLabel status = new JLabel("STATO ORDINE: " + listat.getTavolo(j).getStato());
		    		status.setFont(new Font("Times New Roman", Font.BOLD, 18));
				    status.setForeground(Color.BLACK);
			        center_right.add(status);
			        
	    		}
		    }
		}
	}
}