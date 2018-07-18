public class Employee {
   private int id;
   private String name; 
 
   private String band;  

   public Employee() {}
   public Employee(String name, String Band) {
      this.name = name;
      this.band =Band;
     
   }
   
   public int getId() {
      return id;
   }
   
   public void setId( int id ) {
      this.id = id;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName( String name ) {
      this.name = name;
   }
   
   public String getBand() {
      return band;
   }
   
   public void setBand( String band ) {
      this.band = band;
   }
   
 
}