import java.util.Set;

public class Student {

	public Student() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	   private String firstName; 
	   private String lastName;   
	   private String section ;
	   private Set cources;
	   
	   public Student(String fname, String lname, String section) {
		      this.firstName = fname;
		      this.lastName = lname;
		      this.section = section;
		   }
	   
	   public int getId() {
		      return id;
		   }
		   
		   public void setId( int id ) {
		      this.id = id;
		   }
		   
		   public String getFirstName() {
		      return firstName;
		   }
		   
		   public void setFirstName( String first_name ) {
		      this.firstName = first_name;
		   }
		   
		   public String getLastName() {
		      return lastName;
		   }
		   
		   public void setLastName( String last_name ) {
		      this.lastName = last_name;
		   }
		   
		   public String getSection() {
			      return section;
			   }
			   
			   public void setSection( String section ) {
			      this.section = section;
			   }

		   public Set getCources() {
		      return cources;
		   }
		   
		   public void setCources( Set cources ) {
		      this.cources = cources;
		   }
}
