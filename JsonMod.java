package ProgettoOOP.src;

public class JsonMod 
{
	protected Boolean type;
	protected String created_at;
	private String company;
	protected String location;
	protected String description;
	public Boolean getType() {
		return type;
	}
	public void setType(boolean j) {
		this.type = j;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
