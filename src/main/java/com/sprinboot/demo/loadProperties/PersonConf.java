package com.sprinboot.demo.loadProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
@PropertySource(value = "classpath:person.properties",encoding = "UTF-8")
@Component
@ConfigurationProperties(prefix="person")
public class PersonConf {

	private String name;
	@Value("#{10*5}")
	private Integer age;
	private String[] friends;
	@Value("${person.insingle}")
	private Boolean insingle;
	@Value("${person.birth}")
	private Date birth;

	private Map<String,Object> maps;
	private List<Object> lists;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String[] getFriends() {
		return friends;
	}
	public void setFriends(String[] friends) {
		this.friends = friends;
	}
	public Boolean getInsingle() {
		return insingle;
	}
	public void setInsingle(Boolean insingle) {
		this.insingle = insingle;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Map<String, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	public List<Object> getLists() {
		return lists;
	}
	public void setLists(List<Object> lists) {
		this.lists = lists;
	}
	@Override
	public String toString() {
		return "PersonConf [name=" + name + ", age=" + age + ", friends=" + Arrays.toString(friends) + ", insingle="
				+ insingle + ", birth=" + birth + ", maps=" + maps + ", lists=" + lists + "]";
	}
	
	

}
