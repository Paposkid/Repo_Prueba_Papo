package com.amx.service.bean;

public class EntityIdInfoTO {
	
	private Byte entityType;
	private Long entityId;
	
	public EntityIdInfoTO() {
		
	}

	public Byte getEntityType() {
		return entityType;
	}

	public void setEntityType(Byte entityType) {
		this.entityType = entityType;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	@Override
	public String toString() {
		return "EntityIdInfoTO [entityType=" + entityType + ", entityId="
				+ entityId + "]";
	}
	
	

}
