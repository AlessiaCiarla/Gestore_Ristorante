package gestoreRistorante.chef;

import java.util.Comparator;

/**
 * Classe che implementa l'interfaccia Comparator, grazie al quale è possibile confrontare due identificatori di categorie.
 *
 */
public class OrdinaPiatti implements Comparator<Piatto> {
	
	@Override
	public int compare(Piatto o1, Piatto o2) {
		return o1.getNumcategory() - o2.getNumcategory();
	}
}
