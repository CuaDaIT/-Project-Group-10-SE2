package model;

public class EachDay {
	private int ID;
	private String date;
	private double cases;
	private double recovered;
	private double deaths;
	
	public EachDay(int ID,String date, double cases, double recovered, double deaths) {
		this.ID = ID;
		this.date = date;
		this.cases = cases;
		this.recovered = recovered;
		this.deaths = deaths;
	}
	public EachDay(String date, double cases, double recovered, double deaths) {
		this.date = date;
		this.cases = cases;
		this.recovered = recovered;
		this.deaths = deaths;
	}
	public EachDay() {
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getCases() {
		return cases;
	}

	public void setCases(double cases) {
		this.cases = cases;
	}

	public double getRecovered() {
		return recovered;
	}

	public void setRecovered(double recovered) {
		this.recovered = recovered;
	}

	public double getDeaths() {
		return deaths;
	}

	public void setDeaths(double deaths) {
		this.deaths = deaths;
	}
	public int getID() {
		return this.ID;
	}
	public void setID(int iD) {
		this.ID= iD;
	}
	
}
