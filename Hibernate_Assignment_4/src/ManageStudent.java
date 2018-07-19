import java.util.*;
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageStudent{
   private static SessionFactory factory; 
   public static void main(String[] args) {
      
      try {
         factory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      
      ManageStudent ME = new ManageStudent();
    
      HashSet courcesset = new HashSet();

      courcesset.add(new Courses("MCA"));
      courcesset.add(new Courses("MBA"));
      courcesset.add(new Courses("PMP"));
     
     
      Integer studentID1 = ME.addStudent("Manoj", "Kumar", "a-1", courcesset);

   
      Integer studentID2 = ME.addStudent("Dilip", "Kumar", "B-1", courcesset);

   
      ME.listStudents();

      



      ME.deleteStudnet(studentID1);

      ME.listStudents();


   }

   
   public Integer addStudent(String fname, String lname, String section, Set courses){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer studentID = null;
      
      try {
         tx = session.beginTransaction();
         Student std = new Student(fname, lname, section);
         std.setCources(courses);
         studentID = (Integer) session.save(std); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return studentID;
   }


   public void listStudents( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List students = session.createQuery("FROM Student").list(); 
         for (Iterator iterator1 = students.iterator(); iterator1.hasNext();){
            Student std = (Student) iterator1.next(); 
            System.out.print("First Name: " + std.getFirstName()); 
            System.out.print("  Last Name: " + std.getLastName()); 
            System.out.println("  Section: " + std.getSection());
            Set coursesset = std.getCources();
            for (Iterator iterator2 = coursesset.iterator(); iterator2.hasNext();){
               Courses courseName = (Courses) iterator2.next(); 
               System.out.println("Cources: " + courseName.getName()); 
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


   public void deleteStudnet(Integer studentID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Student std = (Student)session.get(Student.class, studentID); 
         session.delete(std); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
}