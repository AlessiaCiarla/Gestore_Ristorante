package gestoreRistorante.cameriere;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import gestoreRistorante.Lista;
import gestoreRistorante.MenuPrincipale;

/**
 * Classe che implementa la grafica dell'ordinazione finale che visualizzerà il cameriere.
 *
 */
public class RiepilogoCameriere {
	
	/**
	 * Graficamente, viene creato un un nuovo JFrame, con il rispettivo ContentPane.
	 * Inoltre, viene creato come attributo anche il pannello che conterrà l'ordinazione.
	 */
	JFrame riepilogo = new JFrame("RIEPILOGO ORDINE");
	Container contenuto = riepilogo.getContentPane();
	JPanel pannello_centrale = new JPanel();	
	
	/**
	 * viene creato un oggetto di tipo Ordinazione, grazie al quale riesco ad avere tutte le quantità di ogni piatto ordinato.
	 */
	Ordinazione listap = new Ordinazione();
	
	/** In secondo luogo, viene creato un oggetto di tipo ListaTavoli, grazie al quale riesco ad avere tutti i tavoli.
	 * con relativi attributi in un ArrayList.
	 */
	ListaTavoli tavoli = new ListaTavoli();
	
	/**
	 * infile è il file in cui devo copiare tutta l'ordinazione in modo tale da poterla utilizzare successivamente come scontrino. 
	 */
	File infile = new File("file/appoggio.txt");
	
	/**
	 * numerotavolo è il numero del tavolo su cui sto prendendo l'ordinazione.
	 */
	int numerotavolo;
	
	/**
	 * Il costruttore chiama il metodo visualizza().
	 * @param int num : è il numero del tavolo su cui ho preso l'ordinazione.
	 */
	public RiepilogoCameriere(int num) {
		this.numerotavolo = num;
		visualizza();
	}
	
	/**
	 * Il metodo visualizza() in sintesi crea la parte alta della finestra e setta le spechifiche grafiche del pannello principale.
	 */
	public void visualizza() {
		
		/**
		 * la misura del frame viene impostata a 600x600, con relativo layout e background.
		 */
		riepilogo.setSize(600,600); 
		pannello_centrale.setLayout(new BoxLayout(pannello_centrale, BoxLayout.PAGE_AXIS));
		pannello_centrale.setBackground(MenuPrincipale.COLORE_SFONDO);
		
		/**
		 * Il pannello up contiene tutti quegli elementi che vengono disposti proprio nella parte alta della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel up = new JPanel();
		up.setLayout(new GridLayout(1,2));
		up.setBackground(MenuPrincipale.COLORE_SFONDO);
		contenuto.add(up, BorderLayout.NORTH);
		
		/**
		 * Viene aggiunta una label menu, per dare un contesto al frame, e ne vengono impostate le specifiche.
		 */
		JLabel menu = new JLabel("RIEPILOGO", SwingConstants.CENTER);
		menu.setFont(new Font("Garamond", Font.BOLD, 22));
	    menu.setForeground(Color.BLACK);
		up.add(menu);
		
		/**
		 * Viene aggiunto un pulsante back, per tornare alla schermata principale.
		 */
		Icon freccia = new ImageIcon("images/freccia.png");
		JButton back = new JButton(freccia);
		back.setBackground(MenuPrincipale.COLORE_BOTTONI);
	    up.add(back);
		
	    back.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evento) {
	    		/**
		    	 * In questo caso, il JFrame di RiepilogoCameriere viene chiuso, e ne viene creato uno nuovo di tipo TavoloSingolo, 
		    	 * che riporta proprio alla schermata dell'ordinazione.
		    	 * Inoltre viene azzerato il contenuto del file di appoggio e ripulita la lista che contiene i piatti ordinati.
		    	 */
	    		listap.clear();
	    		utilizzaPolimorfismo(listap);
		    	riepilogo.dispose(); 
		    	new TavoloSingolo(numerotavolo);
		    }
	    });
	    
	    /**
		 * Il pannello down contiene tutti quegli elementi che vengono disposti proprio nella parte bassa della finestra.
		 * Vengono impostati il layout, il colore dello sfondo, e viene aggiunto al contenuto del frame.
		 */
		JPanel down = new JPanel();
		up.setLayout(new GridLayout(1,1));
		contenuto.add(down, BorderLayout.SOUTH);
		
		/**
	     * Viene aggiunto un bottone conferma, grazie al quale è possibile confermare l'ordine definitivamente.
	     */
	    JButton conferma = new JButton("INSERISCI ORDINE");
		conferma.setFont(new Font("Garamond", Font.BOLD, 22));
	    conferma.setBackground(MenuPrincipale.COLORE_SFONDO);
	    conferma.setForeground(Color.BLACK);
	    down.add(conferma, BorderLayout.SOUTH);
	    
	    conferma.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evento) {
	    		
	    		/**
	    		 * Quando si clicca il bottone "conferma", si copierà il contenuto nel file di appoggio nel file dello scontrino.
	    		 */
	    		FileInputStream instream = null;
	    		FileOutputStream outstream = null;
	    	    	try{
	    	    		
	    	    		/**
	    	    		 * In base al numero del tavolo si copia l'ordine nel rispettivo scontrino.
	    	    		 */
	    	    	    instream = new FileInputStream(infile);
	    	    	    
	    	    	    if (numerotavolo == 0) {
	    	    	    	File outfile = new File("file/scontrino_tavolo1.txt");
	    	    	    	outstream = new FileOutputStream(outfile);
	    	    	    } else if (numerotavolo == 1) {
	    	    	    	File outfile = new File("file/scontrino_tavolo2.txt");
	    	    	    	outstream = new FileOutputStream(outfile);
	    	    	    } else if (numerotavolo == 2) {
	    	    	    	File outfile = new File("file/scontrino_tavolo3.txt");
	    	    	    	outstream = new FileOutputStream(outfile);
	    	    	    } else if (numerotavolo == 3) {
	    	    	    	File outfile = new File("file/scontrino_tavolo4.txt");
	    	    	    	outstream = new FileOutputStream(outfile);
	    	    	    } else {
	    	    	    	File outfile = new File("file/scontrino_tavolo5.txt");
	    	    	    	outstream = new FileOutputStream(outfile);
	    	    	    }
	    	    	  
	    	    	    byte[] buffer = new byte[1024];
	    	 
	    	    	    int length;
	    	    	    while ((length = instream.read(buffer)) > 0) {
	    	    	    	outstream.write(buffer, 0, length);
	    	    	    }

	    	    	    instream.close();
	    	    	    outstream.close();
	    	    	} catch (IOException ioe) {
	    	    		ioe.printStackTrace();
	    	    	 }
	    	    if (infile.exists()) {
	    	    	    infile.delete();
	    	    	}
	    	    	try {
						infile.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
	    	    
    	    	/**
    	    	 * Una volta confermato l'ordine vado a cambiare lo stato del tavolo annesso.
    	    	 */
	    	    for (int k = 0; k < tavoli.size(); k++) {
	    	    	if (numerotavolo == tavoli.getTavolo(k).getNumero())
			    	    tavoli.getTavolo(k).setStato("I");
	    	    		utilizzaPolimorfismo(tavoli);
	    	    }
	    	    
	    	    /**
	    	     * Creo un nuovo JFrame creato dalla classe ElencoTavoliCameriere con un alert che l'ordine è stato inserito.
	    	     */
		    	riepilogo.dispose();
		    	new ElencoTavoliCameriere();
		    	JOptionPane.showMessageDialog(null, "Ordine inserito!");
	    }});
	    
	    /**
         * Il pannello centrale viene aggiunto al contenuto del frame, e vengono impostate delle specifiche, 
         * essendo il pannello un JSplitPane.
         */
	    contenuto.add(pannello_centrale,BorderLayout.CENTER);
	    
	    /**
		 * Viene inserito un oggetto JScrollPane, in modo tale da vedere bene tutti i piatti scorrendo con una barra, 
		 * nel caso diventassero tanti.
		 */
        JScrollPane scroll = new JScrollPane(pannello_centrale);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll);
		
		/**
		 * viene poi chiamato il metodo grazie al quale i piatti con relativo nome, prezzo e quantita vengono aggiunti al pannello centrale.
		 */
		popolaPannello();
		
		/**
		 * Il frame viene reso visibile, settato al centro e chiudibile con il tasto "X".
		 */
	    riepilogo.setVisible(true);
		riepilogo.setLocationRelativeTo(null);
		riepilogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Il metodo popolaPannello(), come da nome, è in grado di popolare il pannello centrale con vari oggetti.
	 */
	public void popolaPannello() {
		
		/**
	     * Si scorre la lista dei piatti, e si controlla se la quantita del piatto è maggiore di zero.
	     * Nel caso la risposta fosse si, il piatto viene aggiunto al pannello centrale.
	     */
		for (int j = 0; j < listap.size(); j++) {
			if (listap.getPiatto(j).getNumcategory() > 0) {
				
				/**
    			 * Il nome del piatto viene aggiunto al pannello centrale.
    			 * Tra un piatto e l'altro viene inserita una RigidArea,che permette di ordinare al meglio il contenuto
    			 *  da un punto di vista grafico.
    			 */
				pannello_centrale.add(Box.createRigidArea(new Dimension(0, 25)));
    			JLabel piatto = new JLabel("PIATTO: " + listap.getPiatto(j).getName()); 
	    		piatto.setFont(new Font("Ink Free", Font.BOLD, 22));
			    piatto.setForeground(Color.BLACK);
			    piatto.setAlignmentX(Component.CENTER_ALIGNMENT);
		        pannello_centrale.add(piatto);
		        
		        /**
    			 * Il prezzo del piatto viene aggiunto al pannello centrale.
    			 */
		        JLabel prezzo = new JLabel("PREZZO: " + listap.getPiatto(j).getPrice() + "   €");
	    		prezzo.setFont(new Font("Ink Free", Font.BOLD, 22));
			    prezzo.setForeground(Color.BLACK);
			    prezzo.setAlignmentX(Component.CENTER_ALIGNMENT);
		        pannello_centrale.add(prezzo);
		        
		        /**
    			 * La quantita del piatto viene aggiunto al pannello centrale.
    			 */
		        JLabel quantita = new JLabel("N. PORZIONI: " + listap.getPiatto(j).getNumcategory() + "");
	    		quantita.setFont(new Font("Ink Free", Font.BOLD, 22)); 
			    quantita.setForeground(Color.BLACK);
			    quantita.setAlignmentX(Component.CENTER_ALIGNMENT);
		        pannello_centrale.add(quantita);
			}
	   	}
	}
	
	/**
	 * Utilizzo il polimorfismo per scrivere sul file.txt in base all'oggetto dichiarato in precedenza.
	 * @param po è l'interfaccia con il metodo write();
	 **/
	public static void utilizzaPolimorfismo(Lista po){
		po.write();
	}
}