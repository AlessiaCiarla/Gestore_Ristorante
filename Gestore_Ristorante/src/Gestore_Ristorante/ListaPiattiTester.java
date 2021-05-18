package Gestore_Ristorante;
import java.util.ArrayList;
import java.util.Arrays;

import Chef.ListaPiatti;
import Chef.Piatto;

public class ListaPiattiTester {
	public static void main(String[] args){
		Piatto categ0 = new Piatto("Antipasti: ");
		Piatto categ1= new Piatto("Primi: ");
		Piatto categ2= new Piatto("Secondi: ");
		Piatto categ3 = new Piatto ("Contorni: ");
		Piatto categ4 = new Piatto ("Dessert: ");
		ArrayList<Piatto> listapiatti = new ArrayList<Piatto>(Arrays.asList(categ0, categ1, categ2, categ3, categ4));
		ListaPiatti lista= new ListaPiatti(listapiatti);
		Piatto piatto1= new Piatto("Primo", "lasagna", "13.50");
		Piatto piatto2= new Piatto("Secondo", "bistecca", "17.50");
		Piatto piatto3= new Piatto("Primo", "pasta al sugo", "11");
		
		lista.add(piatto3);
		lista.add(piatto2);
		lista.add(piatto1);
		lista.sort();
		lista.write();
		
	}
}
