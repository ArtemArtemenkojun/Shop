package ua.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Production extends AbstractEntity{
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;
	private int price;
	@ManyToOne(fetch=FetchType.LAZY)
	private Description description;
	
	private boolean is_deleted;
	
	@OneToMany(mappedBy = "product")
	private List<Basket>baskets = new ArrayList<Basket>();
	
	public Production() {
		
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public List<Basket> getBaskets() {
		return baskets;
	}

	public void setBaskets(List<Basket> baskets) {
		this.baskets = baskets;
	}
	public String getPresentation(){
		return category.getPresentation()+","+description.getPresentation()+", " + getPrice()+", " +isIs_deleted();
	}
	
}
