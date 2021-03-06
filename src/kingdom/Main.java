package kingdom;

import java.util.ArrayList;

public class Main {
	public static void printAnimals(ArrayList<Animal> animals, CheckAnimal tester) {
		for (Animal animal : animals) {
			if (tester.test(animal)) {
				System.out.println(animal.getName());
			}
		}
	}




	public static void main(String[] args) {
		ArrayList<Animal> myAnimals = new ArrayList<Animal>();

		//mammals
		myAnimals.add(new Mammal("Panda", 1869));
		myAnimals.add(new Mammal("Zebra", 1778));
		myAnimals.add(new Mammal("Koala", 1816));
		myAnimals.add(new Mammal("Sloth", 1804));
		myAnimals.add(new Mammal("Armadillo", 1758));
		myAnimals.add(new Mammal("Raccoon", 1758));
		myAnimals.add(new Mammal("Bigfoot", 2021));

		//birds
		myAnimals.add(new Bird("Pigeon", 1837));
		myAnimals.add(new Bird("Peacock", 1821));
		myAnimals.add(new Bird("Toucan", 1758));
		myAnimals.add(new Bird("Parrot", 1824));
		myAnimals.add(new Bird("Swan", 1758));

		//fish
		myAnimals.add(new Fish("Salmon", 1758));
		myAnimals.add(new Fish("Catfish", 1817));
		myAnimals.add(new Fish("Perch", 1758));

		//lambda functions
		//list all animals in decending order by year named
		System.out.println("\n*** Printing animals by year discovered***");
		myAnimals.sort((a1, a2) -> a1.getYearDiscovered() - a2.getYearDiscovered());
		myAnimals.forEach(animal -> System.out.println(animal.getName() + ": " + animal.getYearDiscovered()));

		//list all the animals alphabetically
		System.out.println("\n*** Printing Animals Alphabetically ***");
		myAnimals.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
		myAnimals.forEach(animal -> System.out.println(animal.getName()));

		//list all animals by how they move
		System.out.println("\n*** Printing Animals by how they move***");
		myAnimals.sort((a1, a2) -> a1.move().compareToIgnoreCase(a2.move()));
		myAnimals.forEach(animal -> System.out.println(animal.getName() + ": " + animal.move()));

		//list only animals that breathe with lungs
		System.out.println("\n*** Printing Animals that breathe with lungs***");
		printAnimals(myAnimals, animal -> animal.breathe().equals("Lungs"));

		//list only animals that use lungs and were named in 1758
		System.out.println("\n*** Printing Animals that breathe with lungs & named in 1758***");
		printAnimals(myAnimals, animal -> animal.breathe().equals("Lungs") && animal.getYearDiscovered() == 1758);

		//list only animals that lay eggs and breathe using lungs
		System.out.println("\n*** Printing Animals that lay eggs & breathe using lungs***");
		printAnimals(myAnimals, animal -> animal.breathe().equals("Lungs") && animal.reproduce().equals("Eggs"));

		//list alphabetically only those animals that were named in 1758
		System.out.println("\n*** Printing Animals that were named in 1758 alphabetically***");
		myAnimals.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
		printAnimals(myAnimals, animal -> animal.getYearDiscovered() == 1758);


	}
}