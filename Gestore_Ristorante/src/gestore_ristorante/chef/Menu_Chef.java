package gestore_ristorante.chef;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gestore_ristorante.MenuPrincipale;

/**
 * Classe che implementa la grafica del menù che visulizzerà lo chef, che sarà modificabile grazie ad alcuni bottoni.
 *
 */
public class Menu_Chef {
	String categorie[] ={"ANTIPASTI", "PRIMI", "SECONDI", "CONTORNI", "DOLCI"};
	ListaPiatti listap= new ListaPiatti();
	
	JFrame editable_menu= new JFrame("CHEF");
	Container contenuto= editable_menu.getContentPane();
	JSplitPane pannello_variabile=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	public Menu_Chef() {
		visualizza();
	}
	
	public void visualizza() {
		editable_menu.setSize(600,600);
		
		JPanel up= new JPanel();
		up.setLayout(new GridLayout(1,3));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
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
		    	
		    	/**
		    	 * In questo caso, il JFrame di Menu_Chef viene chiuso, e ne viene creato uno nuovo di tipo Menu_Principale, che riporta proprio alla schermata principale.
		    	 */
		    	editable_menu.dispose(); 
		    	new MenuPrincipale();
		    }
	    });
	    
	    Icon piu = new ImageIcon("images/piu.png");
		JButton aggiungi = new JButton(piu);
		aggiungi.setBackground(MenuPrincipale.COLORE_BOTTONI);
        up.add(aggiungi);
	    
        aggiungi.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
	    		JFrame agg_piatto= new JFrame("AGGIUNGI UN PIATTO");
	    		agg_piatto.setSize(400,200);
	    		Container cont_agg= agg_piatto.getContentPane();
	    		
	    		JPanel tendina1= new JPanel();
	    		tendina1.setBackground(MenuPrincipale.COLORE_SFONDO);
	    		tendina1.setLayout(new GridLayout(3,2));
	    		cont_agg.add(tendina1,BorderLayout.CENTER);
	    		
	    		JLabel category= new JLabel("CATEGORIA:",SwingConstants.CENTER);
	    		category.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    category.setForeground(Color.BLACK);
	    		tendina1.add(category);
	    		
	    		final JComboBox<String> drop_down = new JComboBox<String>(categorie);
	    	    drop_down.setVisible(true);
	    	    tendina1.add(drop_down);
	    		
	    	    JLabel nome= new JLabel("NOME:",SwingConstants.CENTER);
	    		nome.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    nome.setForeground(Color.BLACK);
	    		tendina1.add(nome);
	    		
	    		JTextField name= new JTextField();
	    		tendina1.add(name);
	    		
	    		JLabel prezzo= new JLabel("PREZZO:",SwingConstants.CENTER);
	    		prezzo.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    prezzo.setForeground(Color.BLACK);
	    		tendina1.add(prezzo);
	    		
	    		JTextField price= new JTextField();
	    		tendina1.add(price);
	    		
	    		JPanel down= new JPanel();
	    		up.setLayout(new GridLayout(1,1));
	    		cont_agg.add(down, BorderLayout.SOUTH);
	    		
	    		JButton conferma = new JButton("CONFERMA");
	    		conferma.setFont(new Font("Garamond", Font.BOLD, 20));
	    	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
	    	    conferma.setForeground(Color.BLACK);
	    	    down.add(conferma);
	    	    
	    	    conferma.addActionListener(new ActionListener(){
	    	    	public void actionPerformed(ActionEvent evento){
	    	    		agg_piatto.dispose();
	    	    		String selectedcategory= (String) drop_down.getSelectedItem();
	    	    		int indice=-1;
	    	    		for (int i = 0; i < categorie.length; i++) {
	    	    			if (selectedcategory.equals(categorie[i])) {
	    	    				indice= i;
	    	    			}
	    	    		}
	    	    		String nuovo_prezzo= price.getText();
	    	    		double d_prezzo=Double.parseDouble(nuovo_prezzo);
	    	    		String nuovo_nome= name.getText();
	    	    		aggiungiPiatto(nuovo_nome,d_prezzo, indice);
	    	    	}
	    	    });
	    	    
	    		agg_piatto.setVisible(true);
	    		agg_piatto.setLocationRelativeTo(null);
	    		agg_piatto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		int lunghezza= categorie.length + listap.size();
		
		JPanel center_left= new JPanel();
		center_left.setLayout(new GridLayout(lunghezza,1));
		center_left.setBackground(MenuPrincipale.COLORE_SFONDO);
		pannello_variabile.setLeftComponent(center_left);
	    
		JPanel center_right= new JPanel();
		center_right.setLayout(new GridLayout(lunghezza,1));
		center_right.setBackground(MenuPrincipale.COLORE_SFONDO);
		pannello_variabile.setRightComponent(center_right);
		
		for (int i = 0; i < categorie.length; i++) {
			JLabel categ = new JLabel(categorie[i], SwingConstants.CENTER);
			categ.setFont(new Font("Garamond", Font.BOLD, 22));
		    categ.setForeground(Color.BLACK);
		    center_left.add(categ);
		     
		    JLabel category= new JLabel();
		    category.setBackground(MenuPrincipale.COLORE_SFONDO);
		    center_right.add(category);
		    
	   		for (int j = 0; j < listap.size(); j++) {
	    		if (listap.getPiatto(j).getNumcategory()== i) {
	    			JLabel piatto = new JLabel(listap.getPiatto(j).getName() + "     € " + listap.getPiatto(j).getPrice());
		    		piatto.setFont(new Font("AR BLANCA", Font.BOLD, 20));
				    piatto.setForeground(Color.BLACK);
			        center_left.add(piatto);
			        
			        String nomecorrente= listap.getPiatto(j).getName();
		    		double  prezzocorrente=listap.getPiatto(j).getPrice();
		    		int catcorrente= listap.getPiatto(j).getNumcategory();
		        
			        Icon penna = new ImageIcon("images/penna1.png");
					JButton modifica = new JButton(penna);
					modifica.setBackground(MenuPrincipale.COLORE_BOTTONI);
			        center_right.add(modifica);
		        
			        modifica.addActionListener(new ActionListener(){
				    	public void actionPerformed(ActionEvent evento){
				    		JFrame mod_piatto= new JFrame("MODIFICA UN PIATTO");
				    		mod_piatto.setSize(400,200);
				    		Container cont_mod= mod_piatto.getContentPane();
			    		
				    		JPanel tendina2= new JPanel();
				    		tendina2.setBackground(MenuPrincipale.COLORE_SFONDO);
				    		tendina2.setLayout(new GridLayout(3,2));
				    		cont_mod.add(tendina2,BorderLayout.CENTER);
				    		
				    		JLabel category= new JLabel("CATEGORIA:",SwingConstants.CENTER);
				    		category.setFont(new Font("Garamond", Font.BOLD, 20));
				    	    category.setForeground(Color.BLACK);
				    		tendina2.add(category);
			    		
				    		final JComboBox<String> drop_down = new JComboBox<String>(categorie);
				    	    drop_down.setVisible(true);
				    	    tendina2.add(drop_down);
				    		
				    	    JLabel nome= new JLabel("NOME:",SwingConstants.CENTER);
				    		nome.setFont(new Font("Garamond", Font.BOLD, 20));
				    	    nome.setForeground(Color.BLACK);
				    		tendina2.add(nome);
			    		
				    		JTextField name= new JTextField();
				    		tendina2.add(name);
				    		
				    		JLabel prezzo= new JLabel("PREZZO:",SwingConstants.CENTER);
				    		prezzo.setFont(new Font("Garamond", Font.BOLD, 20));
				    	    prezzo.setForeground(Color.BLACK);
				    		tendina2.add(prezzo);
			    		
				    		JTextField price= new JTextField();
				    		tendina2.add(price);
				    		
				    		JPanel down= new JPanel();
				    		down.setLayout(new GridLayout(1,2));
				    		cont_mod.add(down, BorderLayout.SOUTH);
				    		
				    		JButton rimuovi = new JButton("RIMUOVI PIATTO");
				    		rimuovi.setFont(new Font("Garamond", Font.BOLD, 18));
				    	    rimuovi.setBackground(MenuPrincipale.COLORE_SFONDO);
				    	    rimuovi.setForeground(Color.BLACK);
				    	    down.add(rimuovi);
				    	    
				    	    rimuovi.addActionListener(new ActionListener(){
						    	public void actionPerformed(ActionEvent evento){
						    		mod_piatto.dispose();
						    		rimuoviPiatto(nomecorrente, prezzocorrente, catcorrente);
						    	}
				    	    });
				    		
				    		JButton conferma = new JButton("CONFERMA");
				    		conferma.setFont(new Font("Garamond", Font.BOLD, 18));
				    	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
				    	    conferma.setForeground(Color.BLACK);
				    	    down.add(conferma);
				    	    
				    	    conferma.addActionListener(new ActionListener(){
						    	public void actionPerformed(ActionEvent evento){
						    		mod_piatto.dispose();
						    		String newcategory= (String) drop_down.getSelectedItem();
				    	    		int indice=-1;
				    	    		for (int i = 0; i < categorie.length; i++) {
				    	    			if (newcategory.equals(categorie[i])) {
				    	    				indice= i;
				    	    			}
				    	    		}
				    	    		String newprice= price.getText();
				    	    		double prezzomod=Double.parseDouble(newprice);
				    	    		String nomemod= name.getText();
				    	    		Piatto sostituto=new Piatto(nomemod,prezzomod,indice);
				    	    		Piatto dasostituire= new Piatto(nomecorrente,prezzocorrente,catcorrente);
				    	    		modificaPiatto(dasostituire, sostituto);
						    	}
				    	    });
			    	    
				    		mod_piatto.setVisible(true);
				    		mod_piatto.setLocationRelativeTo(null);
				    		mod_piatto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					    }
			        });
	    		}
	   		}
		}
	}
	
	public void aggiungiPiatto(String nome_piatto, double prezzo_piatto, int category) {
		editable_menu.getContentPane().removeAll();
		contenuto= editable_menu.getContentPane();
		pannello_variabile=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		Piatto nuovo_piatto= new Piatto(nome_piatto,prezzo_piatto, category);
		listap.add(nuovo_piatto);
		listap.sort();
		listap.write();
		visualizza();
		editable_menu.invalidate();
		editable_menu.validate();
		editable_menu.repaint();
	}
	
	public void rimuoviPiatto(String nome_piatto, double prezzo_piatto, int category) {
		editable_menu.getContentPane().removeAll();
		contenuto= editable_menu.getContentPane();
		pannello_variabile=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		Piatto darimuovere= new Piatto(nome_piatto, prezzo_piatto, category);
		listap.remove(darimuovere);
		listap.write();
		visualizza();
		editable_menu.invalidate();
		editable_menu.validate();
		editable_menu.repaint();
	}
	
	public void modificaPiatto(Piatto dasostituire, Piatto sostituto) {
		editable_menu.getContentPane().removeAll();
		contenuto= editable_menu.getContentPane();
		pannello_variabile=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		listap.modify(dasostituire, sostituto);
		listap.write();
		visualizza();
		editable_menu.invalidate();
		editable_menu.validate();
		editable_menu.repaint();
	}
	
}