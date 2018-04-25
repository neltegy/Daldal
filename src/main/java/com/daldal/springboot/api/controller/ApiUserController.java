package com.daldal.springboot.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daldal.springboot.mapper.MongoMapper;
import com.daldal.springboot.mapper.UserMapper;
import com.daldal.springboot.service.UserService;
import com.daldal.springboot.userdto.UserJoinDto;
import com.daldal.springboot.userdto.UserLoginDto;
import com.daldal.springboot.uservo.UserLoginVo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;


@RestController
@RequestMapping(value="/api/user")
public class ApiUserController {
	
	@Autowired
	private UserMapper usermapper;
	
	@Autowired
	private MongoMapper mongomapper;
	
	@Autowired
	private UserService userservice;
	
	
	
	@RequestMapping(value="/overlap",method=RequestMethod.POST)
	public String test(@RequestBody String jsonobject) throws JSONException {
		JSONObject j = new JSONObject(jsonobject);
		String checkvalue = j.getString("joinidcheck");
		System.out.println(checkvalue);
		
		JSONObject json = new JSONObject();
		json.put("joinidcheck", checkvalue);
		System.out.println(json.toString());
		
		String userid = usermapper.selectId(json.getString("joinidcheck"));
		String res;
		if(userid == null) {
			res = "possible";
		}else {
			res = "impossible";
		}
		json.remove("joinidcheck");
		json.put("joinidcheck", res);
		System.out.println(json.toString());
		
		return json.toString();
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestBody String idpw) throws JSONException { // map에는 위도경도,로그인정보가 들어있음
		System.out.println("input data: "+idpw.toString());
		JSONObject json = new JSONObject(idpw);
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", json.getString("id"));
		map.put("pw", json.getString("pw"));
		UserLoginVo userloginvo = userservice.loginsession(map);
		if(userloginvo == null) {
			System.out.println("사용자 정보가 없음");
			return null;
		}else {
			System.out.println(userloginvo.getNickname());
			JSONObject res_json = new JSONObject("{\"nickname\":\""+userloginvo.getNickname()+"\"}");
			System.out.println("output data: "+json.toString());
			return res_json.toString(); //nickname
		}
		
	}
	
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@RequestBody String joininfo) throws JSONException {
		System.out.println(joininfo.toString());
		JSONObject json = new JSONObject(joininfo);
		UserJoinDto userjoindto = new UserJoinDto(json.getString("id"), json.getString("nickname")
				, json.getString("pw"), json.getInt("age"), json.getString("email"));
		userservice.join(userjoindto);
		// 회원정보 저장하기
		return "{}";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String postSubmit(@RequestBody String writeinfo) throws JSONException {
		// json post 형식으로 들어온 text가 @RequestBody Dto dto 로 자동 바인딩된다.
		// json post 형식으로 들어온 text가 @RequestBody Map map 로 자동 바인딩된다.
		//세션에서 아이디값 받아와서 dto에 넣어줘야함
		String res_json = null;
		JSONArray jsonarray = new JSONArray(writeinfo); // 임시로 대괄호 붙여줌
		String jsonobjFirst = ((JSONObject)jsonarray.get(0)).toString();
		String jsonobjSecond = ((JSONObject)jsonarray.get(1)).toString();
		String str = jsonobjFirst.substring(0, jsonobjFirst.length()-1);
		str += ",";
		str += jsonobjSecond.substring(1);
		
		System.out.println("first");
		try {
			
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("http://localhost:5000/write");
			
			JSONObject json = new JSONObject(str);
			// System.out.println("first:"+json.toString());
			
			httpPost.addHeader("content-type", "application/json");
			httpPost.addHeader("Accept","application/json");
			httpPost.setEntity(new StringEntity(json.toString(), HTTP.UTF_8));
			
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				System.out.println(response.getStatusLine());
				//API서버로부터 받은 JSON 문자열 데이터
				//System.out.println(EntityUtils.toString(response.getEntity()));
				res_json = EntityUtils.toString(response.getEntity()); //한번 소비되면 닫혀서 이 코드를두번 쓸수 없다
				HttpEntity entity = response.getEntity();
				EntityUtils.consume(entity);
				// System.out.println("second:"+res_json);
			}finally {
				response.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// System.out.println("str:"+str);
		return res_json;
	}
	
	
}
