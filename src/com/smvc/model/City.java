package com.smvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import com.vividsolutions.jts.geom.Point;


@Entity
@Table(name = "city")
@JsonIgnoreProperties(value = { "geom" }) 
public class City implements Serializable{
	private static final long serialVersionUID = -4613221349104974906L;
	private int id;
	private String name;
	private Point geom;
	private String coord;
	public City(){
		super();
	}
	@Id
	@GeneratedValue(generator="paymentableGenerator")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//在插入数据的时候主键由程序处理（很常用），这是<generator>元素没有指定时的默认生成策略。等同于JPA中的AUTO。
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")   
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "name",  nullable = false, length = 50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Type(type="org.hibernate.spatial.GeometryType")
	@Column(name = "geom",nullable = false)
	public Point getGeom() {
		return geom;
	}
	public void setGeom(Point geom) {
		this.geom = geom;
	}
	@Transient
	public String getCoord() {
		return coord;
	}
	public void setCoord(String coord) {
		this.coord = coord;
	}
}
