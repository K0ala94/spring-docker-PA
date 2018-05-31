package hello;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ExpensesService {

	
	
	public List<Month> getExpensesJSON() {
		
		List<Month> months = new ArrayList<>();
		try {

			URL url = new URL("https://personalaccountent.firebaseio.com/monthsWithExpenses.json?print=pretty");
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");

			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
			StringBuffer sb = new StringBuffer();
			while((line = reader.readLine()) != null){
				sb.append(line);
				sb.append("\n");
			}
			con.disconnect();
			
			//System.out.println(sb.toString());
			
			ObjectMapper mapper = new ObjectMapper();
			JSONObject json = new JSONObject(sb.toString());
			
			Iterator<String> keys = json.keys();
			while(keys.hasNext()){
				String monthKey = keys.next();
				Month month = mapper.readValue(json.getJSONObject(monthKey).toString(), Month.class);
				months.add(month);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return months;
	}
}
