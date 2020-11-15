package ch02.problem.subclass;

public class ModPerson extends Person {
	public ModPerson(String name, String address) {
		super(name, address);
	}
	
	public String getName() {
		return "Modded";
	}
	
	public String getAddress() {
		return "Moon";
	}
	
	public String toString() {
        return "[ Person: name = " + getName() + ", address = " + getAddress() + " ]";
    }
}
