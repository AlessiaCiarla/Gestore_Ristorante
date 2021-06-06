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
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import gestore_ristorante.MenuPrincipale;
import gestore_ristorante.cameriere.ListaTavoli;

public class ElencoTavoliCassa {
	String tavoli[] ={"TAVOLO 1", "TAVOLO 2", "TAVOLO 3", "TAVOLO 4","TAVOLO 5"};
	ListaTavoli listat = new ListaTavoli();
	JFrame table_view= new JFrame("LISTA DEI TAVOLI");
	Container contenuto= table_view.getContentPane();
	JSplitPane pannello_variabile=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
    
	
	public ElencoTavoliCassa() {
		visualizza();
	}
	
	public void visualizza() {
		table_view.setSize(600,600);
		
		JPanel up= new JPanel();
		up.setLayout(new GridLayout(1,3));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		JLabel nometavolo = new JLabel("TAVOLI", SwingConstants.CENTER);
		nometavolo.setFont(new Font("Garamond", Font.BOLD, 20));
	    nometavolo.setForeground(Color.BLACK);
		up.add(nometavolo);
		
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
	    
	    contenuto.add(pannello_variabile,BorderLayout.CENTER);
        pannello_variabile.setResizeWeight(0.8);
		pannello_variabile.setContinuousLayout(true);
        JScrollPane scroll1= new JScrollPane(pannello_variabile);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
		popolaPannello();
		table_view.setVisible(true);
		table_view.setLocationRelativeTo(null);
		table_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void popolaPannello() {
		JPanel center_left= new JPanel();
		center_left.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_left.setLayout(new GridLayout(5,2));
		pannello_variabile.setLeftComponent(center_left);
		
		JPanel center_right= new JPanel();
		center_right.setBackground(MenuPrincipale.COLORE_SFONDO);
		center_right.setLayout(new GridLayout(5,2));
		pannello_variabile.setRightComponent(center_right);
		

		for (int i = 0; i < tavoli.length; i++) {
			JButton Tavolo = new JButton (tavoli[i]);
			Tavolo.setFont(new Font("Garamond", Font.BOLD, 45));
			Tavolo.setBackground(MenuPrincipale.COLORE_SFONDO);
			Tavolo.setForeground(Color.BLACK);
		    center_left.add(Tavolo);
		    if (listat.getTavolo(i).getStato().equals("NI")||listat.getTavolo(i).getStato().equals("I")) {
		    	Tavolo.setEnabled(false);
		    }
		    int indice=i;
		
		    Tavolo.addActionListener(new ActionListener(){
		    	public void actionPerformed(ActionEvent evento) {
		    		int numero = listat.getTavolo(indice).getNumero();
		    		table_view.dispose();
		    		new RiepilogoCassa(numero);
		    	}
		    });
		    
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
