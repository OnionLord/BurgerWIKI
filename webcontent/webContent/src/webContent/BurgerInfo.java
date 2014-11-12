package webContent;

import java.util.Date;

public class BurgerInfo 
{
	private int no;
	private String name;
	private String company;
	private double calone;
	private double calset;
	private int priceone;
	private int priceset;
	private String image;
	private String content;
	private Date modified;
	private String moduser;
	
	public BurgerInfo(int no, String name, String company, double calone, double calset,
			int priceone, int priceset, String image, String content,String moduser, Date modified) {
		super();
		this.no = no;
		this.name = name;
		this.company = company;
		this.calone = calone;
		this.calset = calset;
		this.priceone = priceone;
		this.priceset = priceset;
		this.image = image;
		this.content = content;
		this.moduser = moduser;
		this.modified = modified;
	}
	
	public void inputBurgerInfo(int no, String name, String company, double calone, double calset,
			int priceone, int priceset, String image, String content, String moduser, Date modified) {
		this.no = no;
		this.name = name;
		this.company = company;
		this.calone = calone;
		this.calset = calset;
		this.priceone = priceone;
		this.priceset = priceset;
		this.image = image;
		this.content = content;
		this.moduser = moduser;
		this.modified = modified;
	}
	
	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getModuser() {
		return moduser;
	}

	public void setModuser(String moduser) {
		this.moduser = moduser;
	}

	public BurgerInfo()
	{
		
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getCalone() {
		return calone;
	}
	public void setCalone(double calone) {
		this.calone = calone;
	}
	public double getCalset() {
		return calset;
	}
	public void setCalset(double calset) {
		this.calset = calset;
	}
	public int getPriceone() {
		return priceone;
	}
	public void setPriceone(int priceone) {
		this.priceone = priceone;
	}
	public int getPriceset() {
		return priceset;
	}
	public void setPriceset(int priceset) {
		this.priceset = priceset;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
