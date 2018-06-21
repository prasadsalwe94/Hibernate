package scp.java9.HibernateCaching.SecondLevelCache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="LaptopTable")
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
public class Laptop {
	@Id
	@Column(name="Id")
	private int id;
	@Column(name="LaptopMobel")
	private String modelName;
	@Column(name="LaptopPrice")
	private double price;
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laptop(int id, String modelName, double price) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", modelName=" + modelName + ", price="
				+ price + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
