package chapters.models;

public class Bike implements IVehicle{
	
	private String name;
	private String modelNo;
	private String owner;
		

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getModelNo() {
		return modelNo;
	}

	@Override
	public String getOwner() {
		return owner;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
