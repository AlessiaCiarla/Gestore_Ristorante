import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe grazie alla quale si può premere un bottone e generare un evento.
 *
 */
public class ClickListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//se viene cliccato il tasto chef:
		System.out.println("ho premuto chef");
	}

	
}
