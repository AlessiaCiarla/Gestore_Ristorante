package Chef;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Gestore_Ristorante.MenuPrincipale;

/**
 * Classe che implementa la grafica del menù che visulizzerà lo chef, che sarà modificabile grazie ad alcuni bottoni.
 *
 */
public class Menu_Chef {
	
	/**
	 * Con il metodo costruttore della classe Menu_Chef si crea un nuovo oggetto, cioè il menù dello Chef.
	 */
	public Menu_Chef() {
		
		/**
		 * Si crea un oggetto JFrame, di grandezza 600x600.
		 */
		JFrame editable_menu= new JFrame("CHEF");
		editable_menu.setSize(600,600); 
		
		/**
		 * Si crea un oggetto Container, che corrisponderà al contenuto del JFrame.
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
		    	new MenuPrincipale();
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
		center.setResizeWeight(0.7);
        center.setContinuousLayout(true);
        JScrollPane scroll1= new JScrollPane(center);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
		
		for (int i = 0; i < categorie.length; i++) {
    		 JLabel categ = new JLabel(categorie[i], SwingConstants.CENTER);
    		 categ.setFont(new Font("Garamond", Font.BOLD, 22));
 		     categ.setForeground(Color.BLACK);
 		     center_left.add(categ);
 		     
 		    Icon piu = new ImageIcon("images/piu.png");
			JButton aggiungi = new JButton(piu);
			aggiungi.setBackground(MenuPrincipale.COLORE_SFONDO);
	        center_right.add(aggiungi);
	        
	        aggiungi.addActionListener(new ActionListener(){
		    	public void actionPerformed(ActionEvent evento){
		    		JFrame agg_piatto= new JFrame("AGGIUNGI UN PIATTO");
		    		agg_piatto.setSize(400,200);
		    		Container cont_agg= agg_piatto.getContentPane();
		    		JPanel tendina= new JPanel();
		    		tendina.setBackground(MenuPrincipale.COLORE_SFONDO);
		    		cont_agg.add(tendina, BorderLayout.NORTH);
		    		agg_piatto.setVisible(true);
		    		agg_piatto.setLocationRelativeTo(null);
		    		agg_piatto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    }
		    });
		        
	    	for (int j = 0; j < listap.size(); j++) {
	    		if (listap.getPiatto(j).getNumcategory()== i) {
	    			JLabel piatto = new JLabel(listap.getPiatto(j).getName() + "     € " + listap.getPiatto(j).getPrice());
		    		piatto.setFont(new Font("AR BLANCA", Font.BOLD, 20));
				    piatto.setForeground(Color.BLACK);
			        center_left.add(piatto);
			        
			        Icon penna = new ImageIcon("images/penna1.png");
					JButton modifica = new JButton(penna);
					modifica.setBackground(MenuPrincipale.COLORE_SFONDO);
			        center_right.add(modifica);
			        
			        modifica.addActionListener(new ActionListener(){
				    	public void actionPerformed(ActionEvent evento){
				    		JFrame agg_piatto= new JFrame("MODIFICA UN PIATTO");
				    		agg_piatto.setSize(400,200); 
				    		agg_piatto.setVisible(true);
				    		agg_piatto.setLocationRelativeTo(null);
				    		agg_piatto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    	}
			        });
	    		}
	    	}
	    }
		
	    
		
		
		/**
		 * Metodi per rendere visibile la finestra,per collocarla al centro dello schermo e per chiuderla tramite il tasto "X".
		 */
		editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
}
