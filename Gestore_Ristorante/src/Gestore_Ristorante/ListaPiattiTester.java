package Gestore_Ristorante;
import java.util.ArrayList;

import Chef.ListaPiatti;
import Chef.Piatto;

public class ListaPiattiTester {
	public static void main(String[] args){
		ArrayList<Piatto> listapiatti = new ArrayList<Piatto>();
		ListaPiatti lista= new ListaPiatti(listapiatti);
		Piatto piatto1= new Piatto("Primo", "lasagna", "13.50", 1);
		Piatto piatto2= new Piatto("Secondo", "bistecca", "17.50", 2);
		Piatto piatto3= new Piatto("Primo", "pasta al sugo", "11", 1);
		
		lista.add(piatto3);
		lista.add(piatto2);
		lista.add(piatto1);
		lista.write();
		lista.readArray();
		
	}
}
