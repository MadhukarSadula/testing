
public class Passport {

	public Passport() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	   private String address;
	   private String uniqueNumber;
	   private String country;


	   
	   public Passport(String address,String uniqueNumber,String country) {
	      this.address = address; 
	      this.uniqueNumber = uniqueNumber; 
	      this.country = country; 
	   }
	   
	   public int getId() {
	      return id;
	   }
	   
	   public void setId( int id ) {
	      this.id = id;
	   }
	   
	   public String getAddress() {
	      return address;
	   }
	   
	   public void setAddress( String address ) {
	      this.address = address;
	   }
	   
	   public String getUniqueNumber() {
	      return uniqueNumber;
	   }
	   
	   public void setUniqueNumber( String uniqueNumber ) {
	      this.uniqueNumber = uniqueNumber;
	   }
	   
	   public String getCountry() {
	      return country;
	   }
	   
	   public void setCountry( String country ) {
	      this.country = country;
	   }
	   
	  
	   
}

