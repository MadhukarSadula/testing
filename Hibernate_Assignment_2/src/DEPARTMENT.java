import java.util.Set;

public class DEPARTMENT {
	private int id;
	   private String name; 
      private  Set Employees;
	public DEPARTMENT() {
		// TODO Auto-generated constructor stub
	}
 
	   public DEPARTMENT(String name) {
	      this.name = name;
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
	   
	
	   
	   public int hashCode() {
	      int tmp = 0;
	      tmp = ( id + name ).hashCode();
	      return tmp;
	   }
	   public Set getEmployees() {
		      return Employees;
		   }
		   
		   public void setEmployees( Set Employees) {
		      this.Employees = Employees;
		   }
	
}
