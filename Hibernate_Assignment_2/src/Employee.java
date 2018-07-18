import java.util.*;

public class Employee {
   private int id;
   private String name; 
  
   private int salary;
  

   public Employee() {}
   
   public Employee(String fname, int salary) {
      this.name = fname;
     
      this.salary = salary;
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
   
   public void setFirstName( String name ) {
      this.name = name;
   }
   
  
   
   public int getSalary() {
      return salary;
   }
   
   public void setSalary( int salary ) {
      this.salary = salary;
   }
   public boolean equals(Object obj) {
	      if (obj == null) return false;
	      if (!this.getClass().equals(obj.getClass())) return false;

	      Employee obj2 = (Employee)obj;
	      if((this.id == obj2.getId()) && (this.name.equals(obj2.getName()))) {
	         return true;
	      }
	      return false;
	   }
   
  
}