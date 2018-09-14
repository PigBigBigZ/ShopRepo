package com.yc.bean;

import javax.persistence.Entity;
<<<<<<< HEAD
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //实体类注解
@Table(name="role") //配置表名
=======
import javax.persistence.Id;

@Entity
>>>>>>> branch 'master' of https://github.com/PigBigBigZ/ShopRepo.git
public class Role {
	@Id
	private Integer rid;
	
	
	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "Role [rid=" + rid + "]";
	}

}
