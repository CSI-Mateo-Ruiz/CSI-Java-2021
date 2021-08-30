package csi.ruiz.pkg;

public class Animal {
	        String name;
	        int age;
	        String scientificName;
	        //los constructor
	        public Animal(String name,int age,String scientificName) {
	    		this.name = name;
	    		this.age = age;
	    		this.scientificName = scientificName;
	    	}
	    	public Animal() {
	    		
	    	}
	    	
	       
	        
	                //  Getters and Setters  
	                public String getName(){
	                    return name;
	                }
	                public void setName(String name){
	                    this.name = name;
	                }
	                
	                public int getAge(){
	                    return age;
	                }
	                public void setAge(int age){
	                    this.age = age;
	                }
	                
	                public String getScientificName(){
	                    return scientificName;
	                }
	                public void setScientificName(String scientificName){
	                    this.scientificName = scientificName;
	                }
	        //  Main Method
	        public static void main(String[] args){
	            Animal a = new Animal(); 
	            a.setName("Mountain Chiken");
	            a.setAge(6);  
	            a.setScientificName("Leptodactylus fallax");
	            
	            System.out.println("Name: " + a.getName());
	            System.out.println("Age: " + a.getAge());
	            System.out.println("Scientific Name: " + a.getScientificName());
	            
	            Animal a2 = new Animal("Cotorra",5,"Amazona vittata");
	            System.out.println("Name: " + a2.getName());
	            System.out.println("Age: " + a2.getAge());
	            System.out.println("Scientific Name: " + a2.getScientificName());
	            
	           
	 
	        }	


}
