import javafx.beans.property.*;
import javafx.collections.*;

//the mountain class for our mountain object
 class Mountain { //making it static so it can be accessed by outsiders
		//the properties of this class
		StringProperty name, place;
		DoubleProperty height;

		//I swear to God.. I forgot the constructors
		public Mountain() {
			this.name = new SimpleStringProperty(this, "Name", "");
			this.height = new SimpleDoubleProperty(this, "Height", 0);
			this.place = new SimpleStringProperty(this, "Place", "");
		}
		public Mountain(String name, Double height, String place) {
			this.name = new SimpleStringProperty(this, "Name", name);
			this.height = new SimpleDoubleProperty(this, "Height", height);
			this.place = new SimpleStringProperty(this, "Place", place);
		}


		//getters and setters
		//name
		public String getName() {
			return this.name.get();
		}
		public void setName(String newName) {
			this.name.set(newName);
		}
		public StringProperty nameProperty() {
			return this.name;
		}
		//height
		public Double getHeight() {
			return this.height.get();
		}
		public void setHeight(double newHeight) {
			this.height.set(newHeight);
		}
		public DoubleProperty heightProperty() {
			return this.height;
		}
		//place
		public String getPlace() {
			return this.place.get();
		}
		public void setPlace(String newPlace) {
			this.place.set(newPlace);
		}
		public StringProperty placeProperty() {
			return this.place;
		}
	}

public class Model {

	//the model for the mountain is an array of mountains.. I'd be using an arraylist...
	//P.S.... I hate java
	public ObservableList<Mountain> mountainList;

	public Model() {
		mountainList = FXCollections.observableArrayList();
	}

	//shit for adding and removing mountains
	public void addMountain(String name, Double height, String place) {
		mountainList.add(new Mountain(name, height, place));
	}
	public void removeMountain(int index) {
		mountainList.remove(mountainList.get(index));
	}
	//get mountain
	public Mountain getMountain(int index) {
		return mountainList.get(index);
	}

	//toString
	public String toString() {
		String out = "";
		for(Mountain mountain: mountainList) {
			String mountString = "{"; //building string for each mountain
			mountString += mountain.getName() + ", ";
			mountString += mountain.getHeight() + ", ";
			mountString += mountain.getPlace() + "}";
			out += mountString + "\n";
		}
		return out;
	}
	
}