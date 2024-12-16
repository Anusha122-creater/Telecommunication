
package com.Telecommunication.entity;

import javax.persistence.*;

@Entity

public class NetworkElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer networkElementId;

    public Integer getNetworkElementId() {
		return networkElementId;
	}

	public void setNetworkElementId(Integer networkElementId) {
		this.networkElementId = networkElementId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	private String type;
    private String location;

    @Override
    public String toString() { return "NetworkElement{" + "networkElementId=" + networkElementId + '}'; }
}
