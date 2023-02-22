package org.openmrs.module.icare.store.models;

// Generated Oct 7, 2020 12:48:40 PM by Hibernate Tools 5.2.10.Final

import org.codehaus.jackson.annotate.JsonIgnore;
import org.openmrs.Location;
import org.openmrs.module.icare.core.Item;
import org.openmrs.module.icare.laboratory.models.TestAllocation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * StReorderLevel generated by hbm2java
 */
@Embeddable
class ReorderLevelId implements java.io.Serializable {
	
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
}

@Entity
@Table(name = "st_reorder_level")
public class ReorderLevel implements java.io.Serializable {
	
	@EmbeddedId
	@JsonIgnore
	private ReorderLevelId id;
	
	@Column(name = "quantity", nullable = false)
	private Double quantity;
	
	public Double getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	public void setItem(Item item) {
		if (id == null) {
			this.id = new ReorderLevelId();
		}
		this.id.setItem(item);
	}
	
	public void setLocation(Location location) {
		if (id == null) {
			this.id = new ReorderLevelId();
		}
		this.id.setLocation(location);
	}
	
	public Location getLocation() {
		return id.getLocation();
	}
	
	public Item getItem() {
		return id.getItem();
	}
	
	public static ReorderLevel fromMap(Map<String, Object> map) {
		ReorderLevel reorderLevel = new ReorderLevel();
		
		Item item = new Item();
		item.setUuid(((Map) map.get("item")).get("uuid").toString());
		reorderLevel.setItem(item);
		
		Location location = new Location();
		location.setUuid(((Map) map.get("location")).get("uuid").toString());
		reorderLevel.setLocation(location);
		
		reorderLevel.setQuantity(Double.valueOf(map.get("quantity").toString()));
		
		return reorderLevel;
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> reorderLevelObject = new HashMap<String, Object>();
		
		Map<String, Object> locationObject = new HashMap<String, Object>();
		
		locationObject.put("uuid", this.getLocation().getUuid());
		locationObject.put("display", this.getLocation().getDisplayString());
		
		reorderLevelObject.put("location", locationObject);
		
		reorderLevelObject.put("item", this.getItem().toMap());
		
		reorderLevelObject.put("quantity", this.getQuantity());
		
		return reorderLevelObject;
		
	}
	
}
