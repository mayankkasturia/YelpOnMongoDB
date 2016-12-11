
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mayankkasturia
 */
public class loc {
            public void loc(){
        MongoClient mongoClient =new MongoClient("localhost",27017);
            DB dbBusiness = mongoClient.getDB("business");
                        DBCollection collBusiness = dbBusiness.getCollection("business");
                        List<DBObject> categoryIdList = new ArrayList<DBObject>();
                        DBCursor cursorForBusiness = collBusiness.find();
                        while (cursorForBusiness.hasNext()) {
                            categoryIdList.add(cursorForBusiness.next());   
                        }
                        for(DBObject s:categoryIdList){
                        System.out.println(s.get("business_id").toString());
                        System.out.println(s.get("longitude").toString());
                        System.out.println(s.get("latitude").toString());

                        BasicDBObject newDocument = new BasicDBObject();
                        BasicDBList addFields = new BasicDBList();
                            addFields.add(s.get("longitude").toString());
                            addFields.add(s.get("latitude").toString());
                        newDocument.append("$set", new BasicDBObject().append("loc",addFields));

                    BasicDBObject searchQuery = new BasicDBObject().append("business_id", s.get("business_id").toString());

                    collBusiness.update(searchQuery, newDocument);
                }
        
    }}

