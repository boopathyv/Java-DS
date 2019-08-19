package chapters.models;

public interface IVehicle {
	// variables are always ---Static final---
	public int VEHICLE_NO=0;
	
	public String getName();
	
	public String getModelNo();
	
	public String getOwner();
	
	default String tintColour() {
		return "";
	}
}
