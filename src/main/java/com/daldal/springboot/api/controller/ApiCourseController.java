package com.daldal.springboot.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.*;
import org.bson.BSON;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.*;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;

import java.util.Arrays;
import org.bson.Document;
import org.bson.codecs.*;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.configuration.*;


@RestController
@RequestMapping(value="/api/course")
public class ApiCourseController {
	
	
	@RequestMapping(value="/testtopten",method=RequestMethod.POST)
	public String testtopten(@RequestBody String position) throws JSONException {
		System.out.println("postion:"+position);
		
		MongoClient mongoClient = null;
		DB db = null;
		
		mongoClient = new MongoClient(new ServerAddress("192.168.1.28",27017));
		db = mongoClient.getDB("log");
		DBCollection collection = db.getCollection("daldalfoodstore");
		
		JSONArray monjson = new JSONArray();
		
		DBCursor cursor = collection.find().limit(60);
		
		String str = "[";
		int i = 0 ;
		
		while(cursor.hasNext()) {
			monjson.put(cursor.next());
			str += monjson.get(i) +",";
			System.out.println(monjson.get(i));
			i++;
		}
		System.out.println(str);
		str = str.substring(0, str.length()-1);
		str += "]";
		System.out.println(str);
		
		return str;
	}
	
	
	@RequestMapping(value="/topten",method=RequestMethod.POST)
	public String tenCourse(@RequestBody String position) throws JSONException {
		System.out.println("position:"+position);
		
		MongoClient mongoClient = null;
		MongoDatabase db = null;
		
		
		JSONArray j = new JSONArray("["+position+"]");
		String lat = ((JSONObject)j.get(0)).getString("lat");
		String lng = ((JSONObject)j.get(0)).getString("lng");
		Map<String, String> map = new HashMap<String,String>();
		
		Double doulat = Double.parseDouble(lat);
		Double doulng = Double.parseDouble(lng);
		
		
		Block<Document> printBlock = new Block<Document>() {
		       @Override
		       public void apply(final Document document) {
		           System.out.println(document.toJson());
		       }
		};
		
		//mongodb 에서 바로 top10 뽑아오면됨
		mongoClient = new MongoClient(new ServerAddress("192.168.1.28",27017));
		db = mongoClient.getDatabase("log");
		MongoCollection<Document> collection = db.getCollection("daldalfoodstore");
		
		
		// doulat , doulng
		Double maxdis = (double) 1000;
		Double mindis = (double) 500;
		
		System.out.println("first");
		Position posi = new Position(doulat, doulng);
		System.out.println("posi:"+posi);
		Point place = new Point(posi);
		System.out.println("place:"+place);
		
		Bson binary = nearSphere("place.position", place , maxdis, mindis);
		
		//binary 데이터를 object형태로 바꿔줘야함
		System.out.println("binary:"+binary);
		
		System.out.println("second");
		MongoCursor<Document> cursor2 = collection.find(
				new Document("place.position",
						new Document("$nearSphere",place)
						)).limit(2).iterator();
		System.out.println("third");
		
		while(cursor2.hasNext()) {
			System.out.println(cursor2.next());
		}
		
		// System.out.println(collection.count());
		
		/*DBCursor cursor = collection.find("stars",new Document("$gte",2)
				.append("$lt", 5)
				.append("categories", "Bakery").forEach(printBlock));*/
		
		// {'foodstore.position':{'$nearSphere':[127.0352915,37.5360206],'$maxDistance':20}}
		// .limit(10);
		JSONArray monjson = new JSONArray();
		DBObject obj = null;
		
		String str = "[";
		int i = 0 ;
		/*while(cursor.hasNext()) {
			monjson.put(cursor.next());
			str += monjson.get(i) +",";
			System.out.println(monjson.get(i));
			i++;
		}*/
		System.out.println(str);
		str = str.substring(0, str.length()-1);
		str += "]";
		System.out.println(str);
		
		/*Document doc = new Document("name", "MongoDB")
        .append("type", "database")
        .append("count", 1)
        .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
        .append("info", new Document("x", 203).append("y", 102));*/
		
		return str;
	}

}
