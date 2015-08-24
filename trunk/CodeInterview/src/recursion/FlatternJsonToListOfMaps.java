package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * company: Uber, stage: phone

flatten json to a list of map, 有一段json，比如说如下：
{
  "uuid": "abc",
  "properties": {
    "sessionName": "Test session name",
    "waypoints": [
      {"uuid": "def", "properties": {"latitude": 3}}
    ]
  }
}


把它转化成List<Map<String, Object>>， map里面uuid是key, properties是value。 
所以结果应该像下面

[

  {"uuid": "abc", "properties": {"sessionName": "Test session name", "
waypoints": ["def"]}},

  {"uuid": "def", "properties": {"latitude": 3}},

  ...
]
 */
public class FlatternJsonToListOfMaps {
	
	public static JSONArray flatten(JSONObject json) {
	    return flatten(json, new JSONArray());
	}
	  
	private static JSONArray flatten(Object object, JSONArray result) {	
		if (object instanceof JSONArray) {
			JSONArray jsonArray = (JSONArray) object;
			for (Object item : jsonArray) {
				flatten(item, result);
			}
		} else if (object instanceof JSONObject) {
			JSONObject json = (JSONObject) object;
			if (json.containsKey("uuid")) {
				JSONObject obj = new JSONObject();
				obj.put("uuid", json.get("uuid"));
				obj.put("properties", json.get("properties")); // wrong
				result.add(obj);
			}
			
			for (Object item : json.values()) {
				flatten(item, result);
			}
		} else if (object instanceof JSONValue) {
			// nothing to do
		}
		
		return result;
	} 

	public static void main(String[] args) throws ParseException {
		String s = "{\"uuid\":\"abc\",\"properties\":{\"sessionName\":\"Test session name\",\"waypoints\":[{\"uuid\":\"def\",\"properties\":{\"latitude\":3}}]}}";
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(s);
		
		System.out.println("Before flattening: " + json);
		System.out.println("After flattening: " + flatten(json));
	}

}

/**
 * wrong
import json

class Solution(object):
    def __init__(self):
        self.map_list = []

    def flatten_json(self, json_str):
        d = json.loads(json_str)
        self.do_flatten_json(d)
        return '\n'.join(map(str, self.map_list))

    def do_flatten_json(self, d):
        if isinstance(d, list):
            map(self.do_flatten_json, d)
            return
            
        if not isinstance(d, dict):
            return

        if 'uuid' in d and 'properties' in d:
            self.map_list.append({
                'uuid': d['uuid'],
                'properties': d['properties']})

        for (key, value) in d.items():
            self.do_flatten_json(value)

j = '''
{
  "uuid": "abc",
  "properties": {
    "sessionName": "Test session name",
    "waypoints": [
      {"uuid": "def", "properties": {"latitude": 3}}
    ]
  }
}
'''

S = Solution()
print S.flatten_json(j)
*/
