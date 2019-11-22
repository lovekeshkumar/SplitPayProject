package com.nested;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity(name = "grouprelations")
public class GroupRelation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer groupRelationId;

	@ManyToOne
	private User groupUser;

	@ManyToOne
	private Group group;

	@Transient
	private Integer ufk;

	@Transient
	private Integer gfk;

	public GroupRelation() {

	}

	public GroupRelation(Integer groupRelationId, User groupUser, Group group, Integer ufk, Integer gfk) {
		this.groupRelationId = groupRelationId;
		this.groupUser = groupUser;
		this.group = group;
		this.ufk = ufk;
		this.gfk = gfk;
	}

	public Integer getGroupRelationId() {
		return groupRelationId;
	}

	public void setGroupRelationId(Integer groupRelationId) {
		this.groupRelationId = groupRelationId;
	}

	public User getGroupUser() {
		return groupUser;
	}

	public void setGroupUser(User groupUser) {
		this.groupUser = groupUser;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Integer getUfk() {
		return ufk;
	}

	public void setUfk(Integer ufk) {
		this.ufk = ufk;
	}

	public Integer getGfk() {
		return gfk;
	}

	public void setGfk(Integer gfk) {
		this.gfk = gfk;
	}

	@Override
	public String toString() {
		return "GroupRelation [groupRelationId=" + groupRelationId + ", groupUser=" + groupUser + ", group=" + group
				+ "]";
	}

}
