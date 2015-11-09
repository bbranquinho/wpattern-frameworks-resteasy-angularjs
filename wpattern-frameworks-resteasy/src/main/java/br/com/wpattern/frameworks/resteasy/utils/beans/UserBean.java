package br.com.wpattern.frameworks.resteasy.utils.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserBean extends BaseBean {

	private static final long serialVersionUID = 201511052147L;

	private Long id;

	private String name;

	private Integer age;

	private String email;

	public UserBean() {
	}

	public UserBean(String name, Integer age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
