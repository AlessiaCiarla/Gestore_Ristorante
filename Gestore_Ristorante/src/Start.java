import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Classe che implementa l'interfaccia iniziale, da cui è possibile scegliere un ruolo.
 */
public class Start implements ActionListener{
	public static void main(String[] args){
		
		/**
		 * Si crea un oggetto JFrame, di grandezza 600x600.
		 */
		JFrame frame= new JFrame("GESTORE DI UN RISTORANTE");
		frame.setSize(600,600); 
		
		/**
		 * Si crea un oggetto Container, che corrisponderà al contenuto del JFrame.
		 */
		Container contenuto=frame.getContentPane();
		
		/**
		 * Si crea un oggetto JPanel, grazie al quale si imposta un layout.
		 * In questo caso, si crea una griglia 4x1 e viene aggiunta al Container.
		 */
		JPanel pannello= new JPanel();
		pannello.setLayout(new GridLayout(4,1));
		contenuto.add(pannello);
		
		/**
		 * Si creano 4 bottoni di tipo JButton, uno per ogni ruolo all'interno del ristorante.
		 * Inoltre, vengono effettuate delle modifiche ai bottoni:
		 * con setFont, viene settato il Font del testo del bottone e la sua grandezza;
		 * con setBackground, viene impostato il colore dello sfondo del bottone;
		 * con setForeground, viene impostato il colore del testo del bottone.
		 * 
		 */
		JButton chef = new JButton("CHEF");
		chef.setFont(new Font("Garamond", Font.BOLD, 40));
	    chef.setBackground(new Color(220,220,220));
	    chef.setForeground(Color.BLACK);
	    pannello.add(chef);
		
	    JButton cameriere = new JButton("CAMERIERE");
	    cameriere.setFont(new Font("Garamond", Font.BOLD, 40));
	    cameriere.setBackground(new Color(220,220,220));
	    cameriere.setForeground(Color.BLACK);
	    pannello.add(cameriere);
	    
	    JButton cuoco = new JButton("CUOCO");
	    cuoco.setFont(new Font("Garamond", Font.BOLD, 40));
	    cuoco.setBackground(new Color(220,220,220));
	    cuoco.setForeground(Color.BLACK);
	    pannello.add(cuoco);
	    
	    JButton cassa= new JButton("CASSA");
	    cassa.setFont(new Font("Garamond", Font.BOLD, 40));
	    cassa.setBackground(new Color(220,220,220));
	    cassa.setForeground(Color.BLACK);
	    pannello.add(cassa);
		
		/**
		 * Metodi per rendere visibile la finestra,per collocarla al centro e per chiuderla tramite il tasto "X".
		 */
		frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
