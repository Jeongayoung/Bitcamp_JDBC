package vo;

public class Ticket {

	private int ticketnumber;
	private String id;
	private int datenumber;

	public Ticket() {

	}

	public Ticket(String id) {
		this.id = id;
	}
	
	public Ticket(int ticketnumber, int datenumber) {
		this.ticketnumber = ticketnumber;
		this.datenumber = datenumber;
	}

	public Ticket(String id, int datenumber) {
		this.id = id;
		this.datenumber = datenumber;
	}
	
	public Ticket(int ticketnumber, String id, int datenumber) {
		super();
		this.ticketnumber = ticketnumber;
		this.id = id;
		this.datenumber = datenumber;
	}

	public int getTicketnumber() {
		return ticketnumber;
	}

	public void setTicketnumber(int ticketnumber) {
		this.ticketnumber = ticketnumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getDatenumber() {
		return datenumber;
	}

	public void setDatenumber(int datenumber) {
		this.datenumber = datenumber;
	}

	@Override
	public String toString() {
		return "Ticket [ticketnumber=" + ticketnumber + ", id=" + id + ", datenumber=" + datenumber + "]";
	}

}
