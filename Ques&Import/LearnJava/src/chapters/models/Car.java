package chapters.models;

public class Car implements IVehicle{

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
	
	@Override
	public String tintColour() {
		return "BLUE";
	}
}
