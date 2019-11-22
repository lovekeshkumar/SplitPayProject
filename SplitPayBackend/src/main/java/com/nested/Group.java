package com.nested;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "groups")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer groupId;

	String groupName;

	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<GroupRelation> groupRelations;

	public Group() {

	}

	public Group(Integer groupId, String groupName, List<GroupRelation> groupRelations) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupRelations = groupRelations;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@JsonIgnore
	public List<GroupRelation> getGroupRelations() {
		return groupRelations;
	}

	public void setGroupRelations(List<GroupRelation> groupRelations) {
		this.groupRelations = groupRelations;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + "]";
	}

}
