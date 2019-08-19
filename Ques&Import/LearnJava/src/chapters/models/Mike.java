package chapters.models;

import java.util.List;

public class Mike{
	
	private String name;
	private Integer modelNo;
	private Long weight;
	private List<String> nos;
		
	public Mike(String name,Integer modelNo, Long weight,List<String> nos) {
		this.name = name;
		this.modelNo = modelNo;
		this.weight = weight;
		this.nos = nos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getModelNo() {
		return modelNo;
	}

	public void setModelNo(Integer modelNo) {
		this.modelNo = modelNo;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public List<String> getNos() {
		return nos;
	}

	public void setNos(List<String> nos) {
		this.nos = nos;
	}

}
