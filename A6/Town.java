
public class Town implements Comparable<Town>{

	private String name;
	public Town(String name) {
		this.name = name;
	}
	public Town(Town templateTown) {
		this.name = templateTown.name;
	}
	public String getName() {
		return name;
	}
	@Override
	public int compareTo(Town o) {
		return name.compareTo(o.name);
	}
	@Override
	public String toString() {
        return name;
	}
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Town a = (Town) obj;
		if (a.name.equals(name)) {
			return true;
		}
		else {
			return false;
		}
	}

}
