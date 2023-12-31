//A new view... the table in the previous one didn't lemme customize
//it as much

import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.control.*;


public class View2 extends StackPane {
	
	private Model theModel;
	private int rowIndex = 1; //first rowIndex sha is for headers
	private GridPane theTable = new GridPane();
	//the headers
	HBox headerOne = new HBox(), headerTwo = new HBox(), headerThree = new HBox();


	public View2(Model theModel) {
		this.theModel = theModel;
		this.setId("rootPane");
		//customizing column constraints for this grid
		ColumnConstraints nameCons = new ColumnConstraints(), heightCons = new ColumnConstraints(), placeCons = new ColumnConstraints();
		nameCons.setPercentWidth(40);
		heightCons.setPercentWidth(20);
		placeCons.setPercentWidth(40);
		//change this.. .I set it for debugging
		theTable.setId("theTable");

		theTable.getColumnConstraints().addAll(nameCons, heightCons, placeCons);
		//a region for spacing
		Region testRegion = new Region();
		testRegion.getStyleClass().add("heightSpacing");
		theTable.add(testRegion, 0, 0, 3, 1);
		//adding the headers
		headerOne.getChildren().add(new Text("Name"));
		headerTwo.getChildren().add(new Text("Height"));
		headerThree.getChildren().add(new Text("Place"));
		headerOne.getStyleClass().add("header");
		headerTwo.getStyleClass().add("header");
		headerThree.getStyleClass().add("header");
		theTable.add(headerOne, 0, rowIndex);
		theTable.add(headerTwo, 1, rowIndex);
		theTable.add(headerThree, 2, rowIndex);
		++rowIndex; //increasing row index

		ScrollPane preScroll = new ScrollPane(theTable);
		preScroll.setId("preScroll");
		//tryna fuck around this scrollpane.. it be trippin
		this.getChildren().add(preScroll);
		this.setAlignment(Pos.CENTER);
	}

	//the method to fill up the grid with mountains
	public void fillUp() {
		//at this point, the mountain list must have been done enough
		for(Mountain mountain:theModel.mountainList) {
			HBox[] cells = new HBox[3];
			(cells[0] = new HBox()).getChildren().add(new Text(mountain.getName()));
			(cells[1] = new HBox()).getChildren().add(new Text(mountain.getHeight().toString()));
			(cells[2] = new HBox()).getChildren().add(new Text(mountain.getPlace()));
			for(int i = 0; i < cells.length; i++) {
				cells[i].getStyleClass().add("cell");
				if(rowIndex % 2 == 0)
					cells[i].getStyleClass().add("even"); //for even rows.. so I can do zebra striping
				theTable.add(cells[i], i, rowIndex);
			}
			++rowIndex;
		}
	}
}