package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Supplier {
@Id
private String sid;
private String supplierName;
public String getSid() {
	return sid;
}
public void setSid(String sid) {
	this.sid = sid;
}
public String getSupplierName() {
	return supplierName;
}
public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}
}
