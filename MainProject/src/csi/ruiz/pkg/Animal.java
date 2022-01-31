package csi.ruiz.pkg;

public class Animal {
	String name;
	int age;
	String scientificName;
	Taxonomy taxonomy;

	// los constructor
	public Animal(String name, int age, String scientificName) {
		this.name = name;
		this.age = age;
		this.scientificName = scientificName;
	}

	public Animal() {
	}

	public Animal(String name, int age, String scientificName, Taxonomy t) {
		this.name = name;
		this.age = age;
		this.scientificName = scientificName;
		this.taxonomy = t;
	}

	public Taxonomy getTaxonomy() {
		return taxonomy;
	}

	public void setTaxonomy(Taxonomy taxonomy) {
		this.taxonomy = taxonomy;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	public String toString(){
		String tomas = String.format("""
name: %s
age:  %d
scientificName: %s
taxonomy: %s
""",name, age,scientificName, taxonomy);
				
				return tomas;
	}
	
	

	// Main Method
	public static void main(String[] args) {
		Animal a = new Animal();
		a.setName("Mountain Chiken");
		a.setAge(6);
		a.setScientificName("Leptodactylus fallax");
		Taxonomy chickent = new Taxonomy("Eukaryote","animalia","Chordata","Amphibia","anura","leptodactylidae","leptodactylus","leptodactylus fallax"); 
		System.out.println("Name: " + a.getName());
		System.out.println("Age: " + a.getAge());
		System.out.println("Scientific Name: " + a.getScientificName());

		Animal a2 = new Animal("Cotorra", 5, "Amazona vittata");
		System.out.println("Name: " + a2.getName());
		System.out.println("Age: " + a2.getAge());
		System.out.println("Scientific Name: " + a2.getScientificName());
		Taxonomy cottorrat = new Taxonomy("Eukaryote","Animalia","Chordata","Aves","Psittaciformes","Psittacidae","Amazona","Amazona vitata");

		System.out.println();
		Taxonomy t = new Taxonomy("Eukaryote","Animalia","Aves","Passeriformes","Fringillidae","Carduelinae","Serinus","canaria");
//		System.out.println("    Canary Taxonomy       ");
//		System.out.println("Domain: " + t.getDomain())  ; 
//		System.out.println("Kingdom: " + t.getKingdom());
//		System.out.println("Phylum: " + t.getPhylum())  ;
//		System.out.println("Classs: " + t.getClasss())  ;
//		System.out.println("Order: " + t.getOrder())    ;
//		System.out.println("Family: " + t.getFamily())  ;
//		System.out.println("Genus: " + t.getGenus())    ;
//		System.out.println("Species: " + t.getSpecies());
		
		Animal a3 = new Animal("Canary",4,"Serinus canaria domestica",t);	
		System.out.println(a3);
		
		Animal a4 = new Animal("Platypus",5,"Ornithorhynchus anatinus");
		Taxonomy platypust = new Taxonomy("Eukaryote","animalia","Chordata","mammalia","monotremata","Ornithorhynchidae","Ornithorhynchus","Ornithorhynchus anatius");
		
		Animal a5=new Animal(null, (Integer) null, null);
	}
	

}
