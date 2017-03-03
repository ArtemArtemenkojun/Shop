package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;


@Entity
public class Person extends AbstractEntity{
	
	private String email;
	private String passwordUser;
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean is_deleted;
	
	@OneToMany(mappedBy = "person")
	private List<Basket>baskets = new ArrayList<Basket>();

	public Person() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean getIs_deleted() {
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

	@Override
	public String toString() {
		return "Person [is_deleted=" + is_deleted + "]";
	}

	public String getPresentation(){
		return getEmail()+", "+getRole();
	}
}
