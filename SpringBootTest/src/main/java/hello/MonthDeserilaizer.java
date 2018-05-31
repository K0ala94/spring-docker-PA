package hello;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class MonthDeserilaizer extends StdDeserializer<Month> {

	public MonthDeserilaizer(Class<?> vc) {
		super(vc);
	}
	
	public MonthDeserilaizer() {
		this(null);
	}

	@Override
	public Month deserialize(JsonParser jp, DeserializationContext context) throws IOException, JsonProcessingException {
		
		Month month = new Month();
		JsonNode node = jp.getCodec().readTree(jp);
		int income = node.get("income").asInt();
		int monthNum = node.get("month").asInt();
		int year = node.get("year").asInt();
		int saving = node.get("saving").asInt();
		int expSum = node.get("expenseSum").asInt();
		if(node.get("label") != null){
			month.setLabel(node.get("label").asText());
		}
		
		month.setIncome(income);
		month.setSaving(saving);
		month.setYear(year);
		month.setMonth(monthNum);
		month.setExpenseSum(expSum);
		
		JsonNode expensesNode = node.get("expenses");
		Iterator<JsonNode> expensesIterator = expensesNode.elements();
		
		while(expensesIterator.hasNext()){
			JsonNode expenseNode = expensesIterator.next();
			
			Expense expense = new Expense();
			int amount = expenseNode.get("amount").asInt();
			String currency = expenseNode.get("currency").asText();
			Long date = expenseNode.get("date").asLong();
			String description = expenseNode.get("description").asText();
			String key = expenseNode.get("key").asText();
			String type = expenseNode.get("type").asText();
			
			expense.setAmount(amount);
			expense.setCurrency(currency);
			expense.setDate(date);
			expense.setKey(key);
			expense.setDescription(description);
			expense.setType(type);
			
			month.addExpense(expense);
		}
		
		return month;
	}

}
