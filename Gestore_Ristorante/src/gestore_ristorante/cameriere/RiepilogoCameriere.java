package gestore_ristorante.cameriere;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import gestore_ristorante.MenuPrincipale;

public class RiepilogoCameriere{
	
	
	String categorie[] = {"ANTIPASTI", "PRIMI", "SECONDI", "CONTORNI", "DOLCI"};
	JFrame editable_menu= new JFrame("RIEPILOGO ORDINE");
	Container contenuto= editable_menu.getContentPane();
	Ordinazione listap = new Ordinazione();
	Ordinazione scontrino = new Ordinazione();
	ListaTavoli tavoli = new ListaTavoli();
	int lunghezza= categorie.length + listap.size();
	JPanel pannello_variabile=new JPanel(new GridLayout(lunghezza, 1));
	File infile =new File("file/riepilogo.txt");
	int numerotavolo;
	
	
	public RiepilogoCameriere(int num) {
		this.numerotavolo=num;
		visualizza();
	}
	
	
	
	public void visualizza() {
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
	    		listap.clear();
	    		listap.write();
		    	editable_menu.dispose(); 
		    	new Tavolo_Singolo(numerotavolo);
		    }
	    });
	    
	    
	    JButton conferma = new JButton("INSERISCI ORDINE");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
	    conferma.setForeground(Color.BLACK);
	    down.add(conferma, BorderLayout.SOUTH);
	    
	    
	    
	    conferma.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evento){
	    		FileInputStream instream = null;
	    		FileOutputStream outstream = null;
	    	    	try{
	    	    		
	    	    	    instream = new FileInputStream(infile);
	    	    	    
	    	    	    if (numerotavolo==0) {
	    	    	    	File outfile =new File("file/riepilogo1.txt");
	    	    	    	outstream = new FileOutputStream(outfile);
	    	    	    }
	    	    	    else if (numerotavolo==1) {
	    	    	    	File outfile =new File("file/riepilogo2.txt");
	    	    	    	outstream = new FileOutputStream(outfile);
	    	    	    }
	    	    	    else if (numerotavolo==2) {
	    	    	    	File outfile =new File("file/riepilogo3.txt");
	    	    	    	outstream = new FileOutputStream(outfile);
	    	    	    }
	    	    	    else if (numerotavolo==3) {
	    	    	    	File outfile =new File("file/riepilogo4.txt");
	    	    	    	outstream = new FileOutputStream(outfile);
	    	    	    }
	    	    	    else {
	    	    	    	File outfile =new File("file/riepilogo5.txt");
	    	    	    	outstream = new FileOutputStream(outfile);
	    	    	    }
	    	    	    
	    	    	    byte[] buffer = new byte[1024];
	    	 
	    	    	    int length;
	    	    	    while ((length = instream.read(buffer)) > 0){
	    	    	    	outstream.write(buffer, 0, length);
	    	    	    }

	    	    	    instream.close();
	    	    	    outstream.close();

	    	 
	    	    	}catch(IOException ioe){
	    	    		ioe.printStackTrace();
	    	    	 }
	    	    if(infile.exists()){
	    	    	    infile.delete();
	    	    	}
	    	    	try {
						infile.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	    
	    	    for (int k=0; k<tavoli.size(); k++) {
	    	    	if (numerotavolo==tavoli.getTavolo(k).getNumero())
			    	    tavoli.getTavolo(k).setStato("I");
	    	    		tavoli.write();
	    	    }
		    	editable_menu.dispose();
		    	new ElencoTavoliCameriere();
	    	}});
	    
	    
	    contenuto.add(pannello_variabile,BorderLayout.CENTER);
        JScrollPane scroll1= new JScrollPane(pannello_variabile);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
		popolaPannello();
	    editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	public void popolaPannello() {
		for (int j = 0; j < listap.size(); j++) {
					if (listap.getPiatto(j).getNumcategory()>0) {
	    			JLabel piatto = new JLabel(listap.getPiatto(j).getName() + "     � " + listap.getPiatto(j).getPrice() + " QUANTITA': " +listap.getPiatto(j).getNumcategory());
		    		piatto.setFont(new Font("AR BLANCA", Font.BOLD, 20));
				    piatto.setForeground(Color.BLACK);
			        pannello_variabile.add(piatto);
					}
	   		}
	}
}
