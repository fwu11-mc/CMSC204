
public class Road implements Comparable<Road>{
	protected Town source;
	protected Town destination;
	protected int degrees; 
	protected String name;

	public Road(Town source, Town destination,int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.degrees = degrees;
		this.name = name;
	}
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
	}
	public boolean contains(Town town) {
		return (this.getDestination().equals(town) || this.getSource().equals(town));
	}
	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
	public Town getDestination() {
		return destination;
	}
	public Town getSource() {
		return source;
	}
	@Override
	public int compareTo(Road o) {
		return o.name.compareTo(this.name);
	}
	public int getWeight() {
		return degrees;
	}
	public boolean equals(Object r) {
		Road a = (Road) r;
		if (a.contains(destination) && a.contains(source)) {
			return true;
		}
		else {
			return false;
		}
	}
	  public int getDistance() {
		    return degrees;
		  }


}
