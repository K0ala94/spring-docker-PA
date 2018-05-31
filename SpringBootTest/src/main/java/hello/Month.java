package hello;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = MonthDeserilaizer.class)
public class Month {
	
	protected int year;
    protected int month;
    protected int expenseSum;
    protected int income;
    protected int saving;
    private String label;
    private List<Expense> expenses = new ArrayList<>();
    
    public void addExpense(Expense e){
    	expenses.add(e);
    }
    
    public String getMonthAsString(){
    	if(label != null) {
            return label;
        }
        return new DateFormatSymbols().getMonths()[month];
    }
    
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getExpenseSum() {
		return expenseSum;
	}
	public void setExpenseSum(int expenseSum) {
		this.expenseSum = expenseSum;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getSaving() {
		return saving;
	}
	public void setSaving(int saving) {
		this.saving = saving;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<Expense> getExpenses() {
		return expenses;
	}
	
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
    
    
}
