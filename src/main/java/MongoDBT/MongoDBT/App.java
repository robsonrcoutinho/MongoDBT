package MongoDBT.MongoDBT;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;


public class App{
	
	public static void main(String args[]) throws UnknownHostException, MongoException {
	    
        Mongo mongo = new Mongo("localhost", 27017);

        DB db = mongo.getDB("testemongodb");
         
        BasicDBObject doc = new BasicDBObject("username", "robsonc").
                      append("nome",   "Robson Coutinho").
                      append("cidade", "Salvador").
        			  append("uf", "Bahia");
                       
      DBCollection collec = db.getCollection("dados");
         
        collec.insert(doc);
       
      //lista as coleções
      DBCursor cursor = collec.find();
   int i=1;
   while (cursor.hasNext()) { 
      System.out.println("Documento Inserido: "+i); 
      System.out.println(cursor.next()); 
      i++;
   }
   
   System.out.println("Banco de dados armazenados:");
        List<String> dbs = mongo.getDatabaseNames();
        for(String dbStr : dbs){
               System.out.println(dbStr);
        }
         
        System.out.println("fim execucao");
       
}
}
