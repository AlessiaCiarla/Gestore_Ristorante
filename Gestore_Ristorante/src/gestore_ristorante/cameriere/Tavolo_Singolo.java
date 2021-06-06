package gestore_ristorante.cameriere;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gestore_ristorante.MenuPrincipale;
import gestore_ristorante.chef.ListaPiatti;
import gestore_ristorante.chef.Piatto;



public class Tavolo_Singolo{
	
	String categorie[] ={"ANTIPASTI", "PRIMI", "SECONDI", "CONTORNI", "DOLCI"};
	ListaPiatti listap= new ListaPiatti();
	int lunghezza= categorie.length + listap.size();
	Ordinazione quantita = new Ordinazione();   
	JFrame ordinazione= new JFrame("ORDINAZIONE");
	Container contenuto= ordinazione.getContentPane();
	JSplitPane pannello_centrale=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	int numerotavolo;
	
	
	
	public Tavolo_Singolo (int num) {
		this.numerotavolo=num;
		visualizza();
	}
	
	public void visualizza() {
		quantita.clear();
		ordinazione.setSize(600,600);
		
		JPanel up= new JPanel();
		up.setLayout(new GridLayout(1,2));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		JPanel down= new JPanel();
		up.setLayout(new GridLayout(1,1));
		down.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(down, BorderLayout.SOUTH);
		
		
		JLabel menu = new JLabel("MENU", SwingConstants.CENTER);
		menu.setFont(new Font("Garamond", Font.BOLD, 22));
	    menu.setForeground(Color.BLACK);
		up.add(menu);
		
		Icon freccia = new ImageIcon("images/freccia1.png");
		JButton back= new JButton(freccia);
		back.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    up.add(back);
	    
	    back.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
		    	
		    	ordinazione.dispose(); 
		    	new ElencoTavoliCameriere();
		    }
	    });
	    
	    JButton conferma = new JButton("CONFERMA");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    conferma.setForeground(Color.BLACK);
	    down.add(conferma, BorderLayout.SOUTH);
	    
	    conferma.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento) {
		    	ordinazione.dispose();
		    	quantita.write();
		    	new RiepilogoCameriere(numerotavolo);
		    }
	    });
	    
	    contenuto.add(pannello_centrale,BorderLayout.CENTER);
        pannello_centrale.setResizeWeight(0.8);
		pannello_centrale.setContinuousLayout(true);
        JScrollPane scroll= new JScrollPane(pannello_centrale);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll);
		popolaPannello();
	    ordinazione.setVisible(true);
		ordinazione.setLocationRelativeTo(null);
		ordinazione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
	public void popolaPannello() {
		JPanel center_left= new JPanel();
		center_left.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_left.setLayout(new GridLayout(lunghezza,1));
		pannello_centrale.setLeftComponent(center_left);
		
		JPanel center_right= new JPanel();
		center_right.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_right.setLayout(new GridLayout(lunghezza,4));
		pannello_centrale.setRightComponent(center_right);
		
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
		
			for (int j = 0; j < listap.size(); j++) {
	    		if (listap.getPiatto(j).getNumcategory()== i) {
	    			 
	    			JLabel piatto = new JLabel(listap.getPiatto(j).getName() + "     €" + listap.getPiatto(j).getPrice());
		    		piatto.setFont(new Font("AR BLANCA", Font.BOLD, 20));
				    piatto.setForeground(Color.BLACK);
			        center_left.add(piatto);
			        
			        Icon meno = new ImageIcon("images/meno.jpeg");
					JButton diminuisci = new JButton(meno);
					diminuisci.setBackground(MenuPrincipale.COLORE_BOTTONI);
			        center_right.add(diminuisci);
			       
			        JLabel numpor = new JLabel("   0");
					numpor.setForeground(MenuPrincipale.COLORE_SFONDO);
					numpor.setFont(new Font("Garamond", Font.BOLD, 22));
					numpor.setForeground(Color.BLACK);
					center_right.add(numpor);
			        
					Icon piu = new ImageIcon("images/piu.png");
					JButton aggiungi = new JButton(piu);
					aggiungi.setBackground(MenuPrincipale.COLORE_BOTTONI);
				    center_right.add(aggiungi);
					
			        String nomecorrente= listap.getPiatto(j).getName();
		    		double  prezzocorrente=listap.getPiatto(j).getPrice();
		    		int indicecorrente = j;
		    		Integer counter = 0;
		    		aggiungiPiatto(nomecorrente, prezzocorrente, counter);
		    		
		    		diminuisci.addActionListener(new ActionListener(){
		    	    	public void actionPerformed(ActionEvent evento){
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
	
	public void aggiungiPiatto(String nome_piatto, double prezzo_piatto, int porzioni) {
		Piatto nuovo_piatto= new Piatto(nome_piatto,prezzo_piatto, porzioni);
		quantita.add(nuovo_piatto);
		quantita.sort();
	}
}

