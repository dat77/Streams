package com.gmail.students;

public class CapacityLimitExceedException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Capacity limit of array was exceeded";
	}

}
