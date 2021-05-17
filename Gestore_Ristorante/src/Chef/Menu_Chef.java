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
		up.setBackground(new Color(220,220,220));
		contenuto.add(up, BorderLayout.NORTH);
		
		/**
		 * Si vanno poi a definire una label e un bottone che saranno posizionati sul JPanel "up".
		 * Si crea per primo una label menu, con testo, posizione, font e sfondo settati; la label viene infine aggiunta al pannello "up".
		 */
		JLabel menu = new JLabel("MENU", SwingConstants.CENTER);
		menu.setFont(new Font("Garamond", Font.BOLD, 20));
	    menu.setForeground(Color.BLACK);
		up.add(menu);
		
		/**
		 * Si crea poi, per secondo, un bottone con un'icona e sfondo settato.
		 * Viene poi aggiunto al pannello "up".
		 */
		Icon icona = new ImageIcon("images/freccia1.png");
		JButton back= new JButton(icona);
		back.setBackground(new Color(220,220,220));
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
	    
	    /**
	     * Dopo il primo pannello up, viene creato un secondo pannello center, che gestirà il resto dello spazio dell'interfaccia.
	     * Il pannello center è di tipo JSplitPane, che consente di dividere il pannello in due porzioni e , nel nostro caso, verticalmente.
	     */
	    JPanel center_left= new JPanel();
		center_left.setBackground(new Color(220,220,220));
		center_left.setLayout(new BoxLayout(center_left,BoxLayout.Y_AXIS));
	    
		JPanel center_right= new JPanel();
		center_right.setBackground(new Color(220,220,220));
		center_right.setLayout(new BoxLayout(center_right,BoxLayout.Y_AXIS));
		
		JSplitPane center = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,center_left, center_right);
		contenuto.add(center,BorderLayout.CENTER);
		center.setResizeWeight(0.5);
        center.setContinuousLayout(true);
        JScrollPane scroll1= new JScrollPane(center);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contenuto.add(scroll1);
		
		/**
		 * Metodi per rendere visibile la finestra,per collocarla al centro dello schermo e per chiuderla tramite il tasto "X".
		 */
		editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
}
