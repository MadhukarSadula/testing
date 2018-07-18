import java.util.*;
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
   private static SessionFactory factory; 
   public static void main(String[] args) {
      
      try {
         factory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      
      ManageEmployee ME = new ManageEmployee();
      /* Let us have a set of certificates for the first deparment  */
      HashSet set1 = new HashSet();
      set1.add(new Employee("employee1", 100));
      set1.add(new Employee("employee2",200));
      set1.add(new Employee("employee3",300));
     
      /* Add department records in the database */
      Integer DepID1 = ME.addDepartment("MCA", set1);

      /* Another set of certificates for the second deparment  */
      HashSet set2 = new HashSet();
      set2.add(new Employee("employee4",400));
      set2.add(new Employee("employee5",300));

      /* Add another department record in the database */
      Integer DepID2 = ME.addDepartment("MBA", set2);

      /* List down all the employees */
      ME.listDepartments();

   
    

   }

   /* Method to add an employee record in the database */
   public Integer addDepartment(String name, Set emp){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer DepID = null;
      
      try {
         tx = session.beginTransaction();
         DEPARTMENT department = new DEPARTMENT(name);
         department.setEmployees(emp);
         DepID = (Integer) session.save(department); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return  DepID;
   }

   /* Method to list all the Department detail */
   public void listDepartments( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List Departments = session.createQuery("FROM Department").list(); 
         for (Iterator iterator1 = Departments.iterator(); iterator1.hasNext();){
            DEPARTMENT department = (DEPARTMENT) iterator1.next(); 
            System.out.print("name: " + department.getName()); 
            Set employees = department.getEmployees();
            for (Iterator iterator2 = employees.iterator(); iterator2.hasNext();){
               Employee empName = (Employee) iterator2.next(); 
               System.out.println("name: " + empName.getName()); 
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
 
}