
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mvc.util.DBConnection;

public class LoginValidation {
   public String authenticateUser(Login login){
         String userName = login.getUserName(); //Assign user entered values to temporary variables.
         String password = login.getPassword();
         
         Connection con = null;
         Statement statement = null;
         ResultSet resultSet = null;
 
         String userNameDB = "";
         String passwordDB = "";
 
         try
         {
             con = DBConnection.createConnection(); //Fetch database connection object
             statement = con.createStatement(); //Statement is used to write queries. 
             resultSet = statement.executeQuery("select user_id,user_name,paw_hash,paw_salt from users where user_name = 'prasadi'"); //the table name is users and user_name,paw_hash,paw_salt are columns.

             if(resultSet.next()) // if the resultset has data; it goes in. Otherwise it return false
             {
              userId = resultSet.getString("user_id"); //fetch the values present in database
              userNameDB = resultSet.getString("user_name"); 
              passwordDB = resultSet.getString("paw_hash");
              saltInDB = resultSet.getString("paw_salt");
              String passwordHash = getPasswordHash(saltInDB,password);
 
 
               if(userName.equals(userNameDB) && passwordHash.equals(passwordDB))
               {
                  return "Successfuly Logged In!"; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
               }else{
                  return "Invalid user credentials"; // Return appropriate message in case of failure

               }
             }
            }
             catch(SQLException e)
             {
                e.printStackTrace();
             }
         
     }

   public String getPasswordHash(String password_salt, String password) {
      // function to return hashed password after concatnating the salt and th given
      // pasword
      return hash_pasword;
   }

   // password reset function

   public void changePasword(int userId,String newPasword,String password_salt, String upassword,String passwordDb){
      String user_given_paw = getPasswordHash(password_salt,upassword);
      try{
      if(user_given_paw.equals(passwordDb)){
         con = DBConnection.createConnection(); //Fetch database connection object
         Statement st1=con.createStatement();
         int i=st1.executeUpdate("update login set password='"+newPasword+"' where id='"+userId+"'");
         System.out.println("Password changed successfully");
         st1.close();
         con.close();
         }
         else{
         out.println("Invalid Current Password");
         }
         }catch(Exception e){
         out.println(e);
         }

   }

}