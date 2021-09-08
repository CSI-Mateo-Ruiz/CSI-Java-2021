package csi.ruiz.pkg;

public class AnimalFarm {
		static Animal[] animals;
		public static void main(String[] args) {
			animals = new Animal[5];
			animals[0]= new Animal("Canary",4,"Serinus canaria domestica", new Taxonomy("Eukaryote","Animalia","Aves","Passeriformes","Fringillidae","Carduelinae","Serinus","canaria"));
			animals[1]=new Animal("Cotorra",5, "Amazona vittata", new Taxonomy("Eukaryote","Animalia","Chordata","Aves","Psittaciformes","Psittacidae","Amazona","Amazona vitata"));
			animals[2]=new Animal("Mountain Chicken",6,"leptodactylus fallax", new Taxonomy("Eukaryote","animalia","Chordata","Amphibia","anura","leptodactylidae","leptodactylus","leptodactylus fallax"));
			animals[3]=new Animal("Platypus",5,"Ornithorhynchus anatinus", new Taxonomy("Eukaryote","animalia","Chordata","mammalia","monotremata","Ornithorhynchidae","Ornithorhynchus","Ornithorhynchus anatius"));
			animals[4]=null;
			System.out.println(animals[0]);
			System.out.println();
			System.out.println(animals[1]);
			System.out.println();
			System.out.println(animals[2]);
			System.out.println();
			System.out.println(animals[3]);
			System.out.println();
			System.out.println(animals[4]);
			
			
		}
} 

