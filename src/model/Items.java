package model;


public class Items {
	private String itemID;
	private String name;
	private String ownerID; // userID
	private String category;
	private String itemValue;
	private String condition;
	private String decription;
	private String picture;
	
	public Items() {
		itemID = null;
		name = null;
		ownerID = null; // userID
		category = null;
		itemValue = null;
		condition = null;
		decription = null;
		picture = null;
	}
	
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(String owner) {
		this.ownerID = owner;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItemValue() {
		return itemValue;
	}
	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
}
