package Gestore_Ristorante;
import java.util.ArrayList;
import java.util.Arrays;

import Chef.ListaPiatti;
import Chef.Piatto;

public class ListaPiattiTester {
	public static void main(String[] args){
		Piatto categ0 = new Piatto("Antipasti: ", 0);
		Piatto categ1= new Piatto("Primi: ", 1);
		Piatto categ2= new Piatto("Secondi: ", 2);
		Piatto categ3 = new Piatto ("Contorni: ", 3);
		Piatto categ4 = new Piatto ("Dessert: ", 4);
		ArrayList<Piatto> listapiatti = new ArrayList<Piatto>(Arrays.asList(categ0, categ1, categ2, categ3, categ4));
		ListaPiatti lista= new ListaPiatti(listapiatti);
		Piatto piatto1= new Piatto("Primo", "lasagna", "13.50", 1);
		Piatto piatto2= new Piatto("Secondo", "bistecca", "17.50", 2);
		Piatto piatto3= new Piatto("Primo", "pasta al sugo", "11", 1);
		
		lista.add(piatto3);
		lista.add(piatto1);
		lista.sort();
		lista.readArray();
		lista.write();
		
	}
}
