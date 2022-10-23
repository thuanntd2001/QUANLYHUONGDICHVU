package spring.bean;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spring.config.restConfig.RestClient;

public class Collector <T>{
	private RestClient rc;
	private TypeReference<List<T>> mapType ;
	private ObjectMapper objectMapper;
	public Collector() {
		super();
		 rc= new RestClient();
		 mapType = new TypeReference<List<T>>() {};
		 objectMapper = new ObjectMapper();
	}
	public List<T> getListAll(String url) {
		List<T> list=null;

        try {
		 list = objectMapper.readValue(rc.get(url), mapType);

        } catch (JsonParseException e) {
			System.out.print("loi json");

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.print("loi mapping");

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("chua bat api");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
}
