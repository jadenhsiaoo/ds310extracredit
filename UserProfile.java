package com.azure.cosmosdb.cassandra.examples; 
import java.io.IOException; 
import com.azure.cosmosdb.cassandra.repository.UserRepository; 
import com.azure.cosmosdb.cassandra.util.CassandraUtils; 
import com.datastax.driver.core.PreparedStatement; 
import com.datastax.driver.core.Session; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 


public class UserProfile { 

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProfile.class); 
    public static void main(String[] s) throws Exception { 
        CassandraUtils utils = new CassandraUtils(); 
        Session cassandraSession = utils.getSession(); 
        try { 
            UserRepository repository = new UserRepository(cassandraSession); 
            //Create keyspace in cassandra database 
            repository.createKeyspace(); 
            //Create table in cassandra database 
            repository.createTable();
	//Insert rows into user table
PreparedStatement preparedStatement = repository.prepareInsertStatement();
  repository.insertUser(preparedStatement, 1, "JohnH", "Seattle");
  repository.insertUser(preparedStatement, 2, "EricK", "Spokane");
  repository.insertUser(preparedStatement, 3, "MatthewP", "Tacoma");
  repository.insertUser(preparedStatement, 4, "DavidA", "Renton");
  repository.insertUser(preparedStatement, 5, "PeterS", "Everett");
 repository.insertUser(preparedStatement, 6, "NaserS", "Boston"); 
 repository.insertUser(preparedStatement, 7, "JadenH", "Boston"); 
 repository.insertUser(preparedStatement, 8, "ThomasB", "Boston"); 
 repository.insertUser(preparedStatement, 9, "Lize", "Boston"); 
 repository.insertUser(preparedStatement, 10, "Selina", "Boston"); 
   

} 


finally { 
            utils.close(); 
            LOGGER.info("Please delete your table after verifying the presence of the data in portal or from CQL"); 
        } 
    } 

}