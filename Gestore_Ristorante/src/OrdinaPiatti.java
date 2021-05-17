import java.util.Comparator;

public class OrdinaPiatti implements Comparator<Piatto>{
	
	@Override
	public int compare(Piatto o1, Piatto o2) {
		// TODO Auto-generated method stub
		return o1.getNumcategory() - o2.getNumcategory();
	}
}
