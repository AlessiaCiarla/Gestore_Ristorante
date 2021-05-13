import javax.swing.JFrame;

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
		 * Metodi per rendere visibile la finestra,per collocarla al centro dello schermo e per chiuderla tramite il tasto "X".
		 */
		editable_menu.setVisible(true);
		editable_menu.setLocationRelativeTo(null);
		editable_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
