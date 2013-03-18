package org.drewps.domain;

public class PasswordGenerator {
	public static void main(String[] args) {
		User user = new User();
		user.setPassword("ps@rsag");
		System.out.println(user.getPassword());
	}
}