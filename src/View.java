import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.beans.value.*;
import javafx.geometry.*;

public class View extends VBox{
	private Model theModel;
	private Stage theStage;
	//gon create everything then add em to the scrollpane

	//the table
	private TableView<Mountain> theTable = new TableView<>();
	private TableColumn<Mountain, String> nameCol = new TableColumn<>("Name"), placeCol = new TableColumn<>("Place");
	private TableColumn<Mountain, Double> heightCol = new TableColumn<>("Height");
	ScrollPane tableScroll = new ScrollPane();
	
	//a region for spacing
	Region spaceRegion = new Region();
	
	public View(Model theModel, Stage theStage) {
		this.theModel = theModel;
		this.theStage = theStage;

		spaceRegion.setId("spaceRegion");
		this.getChildren().add(spaceRegion);

		nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		heightCol.setCellValueFactory(cellData -> cellData.getValue().heightProperty().asObject());
		placeCol.setCellValueFactory(cellData -> cellData.getValue().placeProperty());
		nameCol.setSortable(false);
		heightCol.setSortable(false);
		placeCol.setSortable(false);
		//table customization
		theTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		//adding listener to the Screen width to make the table responsive
		theStage.widthProperty().addListener(this::tableResponsive);
		theStage.heightProperty().addListener(this::tableResponsive);
		theTable.getColumns().addAll(nameCol, heightCol, placeCol);
		//initialising the view's data
		theTable.setItems(theModel.mountainList);
		theTable.setId("theTable");
		//adding them all to the gidigba
		this.getChildren().add(theTable);
		this.setId("rootBox");
		this.setAlignment(Pos.CENTER);
	}

	public void tableResponsive(ObservableValue<? extends Number> prop, Number oldVal, Number newVal) {
		theTable.setPrefWidth(theStage.getWidth() );
		theTable.setPrefHeight(theStage.getHeight());
	}

}