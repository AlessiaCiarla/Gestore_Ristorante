import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

public class Menu {
	public static void main(String[] args) {
		/**
		 * Si crea un oggetto JFrame, di grandezza 600x600.
		 */
		JFrame frame= new JFrame("CHEF");
		frame.setSize(600,600); 
		
		/**
		 * Si crea un oggetto Container, che corrisponder� al contenuto del JFrame.
		 */
		Container contenuto=frame.getContentPane();
		
		
		/**
		 * Si crea un oggetto JPanel, grazie al quale si imposta un layout.
		 * In questo caso, si crea una griglia 4x1 e viene aggiunta al Container.
		 */
		
		/**
		 * Si crea un oggetto JPanel, grazie al quale si imposta un layout.
		 */
		JPanel pannello= new JPanel();
		pannello.setLayout(new BorderLayout());
		contenuto.add(pannello);
		
		/**
		 * Si crea un oggetto JLabel per dare un titolo alla schermata
		 */
		JLabel label = new JLabel("MENU");
	    label.setVerticalAlignment(JLabel.CENTER);
	    label.setHorizontalAlignment(JLabel.CENTER);
	    label.setFont(new Font("Garamond", Font.BOLD, 15));
	    label.setPreferredSize(new Dimension(50, 50));
	    label.setForeground(new Color(255, 0, 0));
	    //Border border = BorderFactory.createLineBorder(Color.RED);
	    //label.setBorder(border);
		pannello.add(label, BorderLayout.PAGE_START);
	
		
		
		/**
		 * Si crea un oggetto JTextField che serve a caricare il file di testo 
		 * dove al suo interno ci sara il menu del ristorante che si vuole modificare.
		 */
		JTextField menu = new JTextField();
		try {
		    String textLine;
		    FileReader fr = new FileReader("menu.txt");
		    BufferedReader reader = new BufferedReader(fr);
		    menu.read(reader, "jTextArea1");
		   
		}
		catch (IOException ioe) {
		    System.err.println(ioe);
		    System.exit(1);
		}
		menu.setHorizontalAlignment(JTextField.CENTER);
		menu.setFont(new Font("Garamond", Font.BOLD, 15));
		pannello.add(menu, BorderLayout.CENTER);
		
		/**
		 * Si crea un oggetto JButton, che servirà a salvare le modifiche 
		 * effettuate nel JTextField nel file.
		 */
		JButton save=new JButton("Save");
		save.setFont(new Font("Garamond", Font.BOLD, 20));
		save.setBackground(new Color(220,220,220));
		save.setForeground(Color.BLACK);
		pannello.add(save, BorderLayout.PAGE_END);
	    
		
		/**
		 * ActionListener che serve a salvare le modifiche effettuate nel Menu.
		 */
		save.addActionListener(e1->{
	        try{
	            BufferedWriter bw = new BufferedWriter(new FileWriter("menu.txt"));
	            bw.write(menu.getText());
	            bw.close();
	            System.out.println("Done");
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	    });
		
	    /**
		 * Metodi per rendere visibile la finestra,per collocarla al centro e per chiuderla tramite il tasto "X".
		 */
		frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	    

	}