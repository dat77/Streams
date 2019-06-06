package com.gmail.students;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Student extends HumanBeing{
	
	private int id;
	private double averageGrade;

	public Student(String name, String surname, LocalDate birthDate, String sex, double averageGrade) {
		super(name, surname, birthDate, sex);
		this.id = super.hashCode();
		this.averageGrade = averageGrade;
	}

	public Student() {
	}

	public int getId() {
		return id;
	}
	
	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	@Override
	public String toString() {
		return String.format("%-20s %10h  %-10s  %.1f",
				getSurname()+" "+getName(),
				id,
				getBirthDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
				averageGrade);
	}

	@Override
	public void getInfo() {
		System.out.println(this);
		}
	
	public String getInfoInCommaStyle() {
		return getName() + ","
				+ getSurname() + ","
				+ getBirthDate() + ","
				+ getSex() + ","
				+ getAverageGrade();
	}

	public void setObjectFromCommaStyle(String commaString) {
		String[] fields = commaString.split(",");
		try {
			setName(fields[0]);
			setSurname(fields[1]);
			setBirthDate(LocalDate.parse(fields[2]));
			setSex(fields[3]);
			setAverageGrade(Double.parseDouble(fields[4]));
		} catch (NullPointerException|DateTimeParseException|NumberFormatException e) {
			throw new IllegalArgumentException("Object data format is invalid");
		}
		this.id = super.hashCode();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
