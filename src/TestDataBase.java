
import java.sql.*;

public class TestDataBase {

   private String url = new String("jdbc:mysql://192.168.2.5/inventaire");
   private String user = new String("guest");
   private String passwd = new String("guest");
   private String driver = new String("com.mysql.jdbc.Driver");     
   
   public TestDataBase() {
       
   } 
   
   // Cette m�thode retourne un tableau compos� de deux chaines de caract�res
   // La premi�re contient le nom du vendeur, null si pas trouv�
   // La seconde contient l'adresse du vendeur, null si pas trouv�
   // Elle re�oit en argument l'identifiant OUI d'un �quipement r�seau sous la forme de 6 caract�res hexad�cimaux (0 � F)
   public String[] getVendorData(String mac) {  
      String request = "SELECT OrganizationName, OrganizationAddress FROM oui WHERE Assignment='"+mac+"'";
      String data[] = new String[2];
      Connection con = null;
      Statement st = null;
      ResultSet rs = null;   
      try { 
         Class.forName(driver).newInstance(); 
         con = DriverManager.getConnection(url, user, passwd); 
         st = con.createStatement();
         rs = st.executeQuery(request);
         while(rs.next()) {  
            data[0] = new String(rs.getString(1));
            data[1] = new String(rs.getString(2));               
         }   
      } 
      catch (Exception e) { 
         System.err.println("Exception: " + e.getMessage()); 
      }   	 
      finally { 
         try { 
            if(rs != null) rs.close(); 
            if(st != null) st.close(); 
            if(con != null) con.close(); 
         } 
         catch (SQLException e) { 
         }
      }
      return(data);   
   }
   
   public static void main(String arg[]) {       
      TestDataBase req = new TestDataBase();
      String test[] = new String[2];
      String mac = new String(arg[0]);
      
      test = req.getVendorData(mac); 
      
      System.out.println(mac);         
      System.out.println(test[0]);
      System.out.println(test[1]);
   }          
} 

