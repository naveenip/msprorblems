package ms;

public class EmployeeRequest {

	private String id;
	private int buildingFrom;
	private int buildingTo;
	private boolean isReqServed;
	
	
	
	public EmployeeRequest(String id, int reqForm, int reqTo) {
		super();
		this.id = id;
		this.buildingFrom = reqForm;
		this.buildingTo = reqTo;
		this.isReqServed = false;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBuildingFrom() {
		return buildingFrom;
	}
	public void setBuildingFrom(int reqForm) {
		this.buildingFrom = reqForm;
	}
	public int getBuildingTo() {
		return buildingTo;
	}
	public void setBuildingTo(int reqTo) {
		this.buildingTo = reqTo;
	}
	public boolean isReqServed() {
		return isReqServed;
	}
	public void setReqServed(boolean isServed) {
		this.isReqServed = isServed;
	}
	
	
	
	
}
