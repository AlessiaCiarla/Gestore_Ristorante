package gestore_ristorante.cameriere;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import gestore_ristorante.MenuPrincipale;

public class RiepilogoCameriere{
	
	JFrame riepilogo= new JFrame("RIEPILOGO ORDINE");
	Container contenuto= riepilogo.getContentPane();
	Ordinazione listap = new Ordinazione();
	ListaTavoli tavoli = new ListaTavoli();
	JPanel pannello_centrale= new JPanel();	
	File infile =new File("file/riepilogo.txt");
	int numerotavolo;
	
	public RiepilogoCameriere(int num) {
		this.numerotavolo=num;
		visualizza();
	}
	
	public void visualizza() {
		
		riepilogo.setSize(600,600); 
		pannello_centrale.setLayout(new BoxLayout(pannello_centrale, BoxLayout.PAGE_AXIS));
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
	    		listap.clear();
	    		listap.write();
		    	riepilogo.dispose(); 
		    	new Tavolo_Singolo(numerotavolo);
		    }
	    });
	    
	    
		JPanel down= new JPanel();
		up.setLayout(new GridLayout(1,1));
		contenuto.add(down, BorderLayout.SOUTH);
		
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
						e.printStackTrace();
					}
	    	    
	    	    for (int k=0; k<tavoli.size(); k++) {
	    	    	if (numerotavolo==tavoli.getTavolo(k).getNumero())
			    	    tavoli.getTavolo(k).setStato("I");
	    	    		tavoli.write();
	    	    }
		    	riepilogo.dispose();
		    	new ElencoTavoliCameriere();
		    	JOptionPane.showMessageDialog(null, "Ordine inserito!");
	    	}});
	    
	    
	    contenuto.add(pannello_centrale,BorderLayout.CENTER);
        JScrollPane scroll= new JScrollPane(pannello_centrale);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll);
		popolaPannello();
	    riepilogo.setVisible(true);
		riepilogo.setLocationRelativeTo(null);
		riepilogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void popolaPannello() {
		for (int j = 0; j < listap.size(); j++) {
					if (listap.getPiatto(j).getNumcategory()>0) {
						pannello_centrale.add(Box.createRigidArea(new Dimension(0, 25)));
		    			JLabel piatto = new JLabel("PIATTO: " + listap.getPiatto(j).getName()); 
			    		piatto.setFont(new Font("Ink Free", Font.BOLD, 22));
					    piatto.setForeground(Color.BLACK);
					    piatto.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(piatto);
				        
				        JLabel prezzo = new JLabel("PREZZO: " + listap.getPiatto(j).getPrice() + "   €");
			    		prezzo.setFont(new Font("Ink Free", Font.BOLD, 22));
					    prezzo.setForeground(Color.BLACK);
					    prezzo.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(prezzo);
				        
				        JLabel quantita = new JLabel("N. PORZIONI: " + listap.getPiatto(j).getNumcategory() + "");
			    		quantita.setFont(new Font("Ink Free", Font.BOLD, 22)); 
					    quantita.setForeground(Color.BLACK);
					    quantita.setAlignmentX(Component.CENTER_ALIGNMENT);
				        pannello_centrale.add(quantita);
					}
	   		}
	}
}