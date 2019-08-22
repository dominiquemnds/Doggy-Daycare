
public class Appointment extends Dog{

	private Dog doggy;
	private String droptime;
	private String pickuptime;
	private String date;
	
	public void setDropTime(String d) {
		this.droptime=d;
	}
	public String getDropTime() {
		return this.droptime;
	}
	//******************
	public void setPickUpTime(String p) {
		this.pickuptime=p;
	}
	public String getPickUpTime() {
		return this.pickuptime;
	}
	//******************
	public void setDate(String d) {
		this.date=d;
	}
	public String getDate() {
		return this.date;
	}
	public void setDog(Dog d) {
		this.doggy=d;
	}
	public Dog getDog() {
		return this.doggy;
	}
}
