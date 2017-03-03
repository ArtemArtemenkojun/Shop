package ua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


@Entity
public class Basket extends AbstractEntity{
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Production product;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Person person;
	
	private String dataship;
	private boolean is_deleted;
	
	public Basket() {
	
	}

	public Production getProduct() {
		return product;
	}

	public void setProduct(Production product) {
		this.product = product;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getDataship() {
		return dataship;
	}

	public void setDataship(String dataship) {
		this.dataship = dataship;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public String toString() {
		return "Basket [product=" + product + ", person=" + person + ", dataship=" + dataship + ", is_deleted="
				+ is_deleted + "]";
	}
	
//	public String getPresentation(){
//		return product.getPresentation()+","+person.getPresentation()+", " + getDataship();
//	}
	
}
