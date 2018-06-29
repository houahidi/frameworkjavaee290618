package fr.uni.training.spring.aop;


/**
 * 
 * @author houahidi
 *
 */
public class User {
	
	

	private int age;
	private String name;
	
	
	
	/**
	 * @param age
	 * @param fooName
	 */
	public User(String name,int age) {
		super();
		this.age = age;
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
