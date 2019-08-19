package chapters.models;

public class Cycle implements IVehicle{

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
}
