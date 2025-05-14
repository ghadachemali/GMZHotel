package com.flip.gmzhotel;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import java.io.*;
import javafx.scene.control.ListView;
import java.util.Scanner;




public class App extends Application {
    //room reservation variables
    private Label nameLabel, periodLabel, dateLabel,roomsReservationLabel, selectRoomLabel, roomCalculationResultLabel;
    private RadioButton regularRoomRadioButton, seaViewRoomRadioButton;
    private CheckBox breakfastCheckBox;
    private Button roomCalButton;
    private TextField nameTextField, dateTextField, periodTextField;
    private HBox resevationInformationLabelsHVB, resevationInformationTextFieldsHVB, roomCalculatButttionLabelHVB, mainHBox;
    private VBox roomselectionVVB,roomsReservationVVB,roomVBox;
    private ToggleGroup roomTypeToggleGroup;
    private String name, date;
    private int period;
    private boolean breakfast;
    private char roomType;
    
    //banquet variables
    private Label banquetReservationLabel, numberOfInvtedLabel, banquetTypeLabel, menuTypeLabel,banquetCalculationResultLabel;
    private TextField numberOfInvtedTextField;
    private RadioButton smallBanquetRadioButton, bigBamquetRadioButton, menu1RadioButton, menu2RadioButton;
    private HBox banquetReservationHVB, numberOfInvtedHVB, banquetCalculatButttionLabelHVB;
    private VBox banquetTypeVVB, menuTypeVVB, banquetVBox;
    private ToggleGroup banquetTypeToggleGroup, menuTypeToggleGroup;
    private Button banquetCalButton;
    private int invitedNumber, menuType, banquetType;
    
    ////////////////////////
    private Label selectedNameLabel,reservationNameLabel;
    private ListView<String> reservationListView;
    private TextField reservationNameTextField;
    private VBox reservationListViewLabelVVB , serchImageVVB, resevationInfoVVB;
    private HBox resevationTextFieldLabelHVB;
    private Image searchImage;
    private ImageView searchImageView;
    private String searchName, line;
    private File banquetResevationFile,roomResevationFile;

        
    @Override
    public void start(Stage stage) {
        ///////////////////////////////////////////////////////
        //Rooms reservations
        //first VB
        roomsReservationLabel = new Label("Room Reservation");
        roomsReservationVVB = new VBox(roomsReservationLabel);
        
        nameLabel = new Label("Enter reservation name");
        periodLabel= new Label("Enter reservation period");
        dateLabel = new Label("Enter reservation start date");
        resevationInformationLabelsHVB = new HBox(100, nameLabel, periodLabel, dateLabel);
        
        //second VB
        nameTextField = new TextField();
        periodTextField = new TextField();
        dateTextField = new TextField();
        resevationInformationTextFieldsHVB = new HBox(50,nameTextField, periodTextField, dateTextField);
        
        //3rd VB
        selectRoomLabel = new Label("Select your room type");
        
        regularRoomRadioButton = new RadioButton("Regular Room(200$ per night).");
        seaViewRoomRadioButton = new RadioButton("seaViewRoom(300$ per night).");
        regularRoomRadioButton.setSelected(true);
        
        roomTypeToggleGroup = new ToggleGroup();
        regularRoomRadioButton.setToggleGroup(roomTypeToggleGroup);
        seaViewRoomRadioButton.setToggleGroup(roomTypeToggleGroup);
        
        breakfastCheckBox = new CheckBox("Include Breakfast(+25.5$ pear night).");
        
        roomselectionVVB = new VBox(10,selectRoomLabel,regularRoomRadioButton,seaViewRoomRadioButton,breakfastCheckBox);
        
        //4th VB
        roomCalButton = new Button("Reserve");
        roomCalculationResultLabel = new Label("");
       
        roomCalculatButttionLabelHVB = new HBox(30, roomCalButton, roomCalculationResultLabel);
        roomCalButton.setOnAction(new roomCalButtonHandler());
        
        //5th VBox
        roomVBox = new VBox(30, roomsReservationVVB,resevationInformationLabelsHVB, resevationInformationTextFieldsHVB, roomselectionVVB,roomCalculatButttionLabelHVB);
        
        ////////////////////////////////////////////////////////////////////////////
        //Banquet reservation
        //first VB
        banquetReservationLabel = new Label("Banquet Reservation");
        banquetReservationHVB = new HBox(30,banquetReservationLabel);
        
        //2ND VB
        numberOfInvtedLabel = new Label("Enter Number Of Invited");
        numberOfInvtedTextField = new TextField();
        numberOfInvtedHVB = new HBox(30,numberOfInvtedLabel, numberOfInvtedTextField);
        
        //3rd VB
        banquetTypeLabel = new Label("Select Banquet Type");
        
        smallBanquetRadioButton = new RadioButton("Small Banquet(20$ per person.");
        bigBamquetRadioButton = new RadioButton("Big Banquet(45$ per person).");
        smallBanquetRadioButton.setSelected(true);
        
        banquetTypeToggleGroup = new ToggleGroup();
        
        smallBanquetRadioButton.setToggleGroup(banquetTypeToggleGroup);
        bigBamquetRadioButton.setToggleGroup(banquetTypeToggleGroup);
        banquetTypeVVB = new VBox(10,banquetTypeLabel,smallBanquetRadioButton, bigBamquetRadioButton);
        
        // 4th VB
        
        menuTypeLabel = new Label("Select Menu Type");
        menu1RadioButton = new RadioButton("Menu A (+30.5$ per person).");
        menu2RadioButton = new RadioButton("Menu B (+55$ per person).");
        menu1RadioButton.setSelected(true);
        
        menuTypeToggleGroup = new ToggleGroup();
        
        menu1RadioButton.setToggleGroup(menuTypeToggleGroup);
        menu2RadioButton.setToggleGroup(menuTypeToggleGroup);
        
        menuTypeVVB = new VBox(10,menuTypeLabel,menu1RadioButton,menu2RadioButton);
        
        //5th VB
        banquetCalButton = new Button("Reserve");
        banquetCalculationResultLabel = new Label("");
        banquetCalculatButttionLabelHVB = new HBox(30, banquetCalButton, banquetCalculationResultLabel);
        
        banquetCalButton.setOnAction(new banquetCalButtonHandler());
        

        
        //6th VB
        banquetVBox = new VBox(30,banquetReservationHVB,numberOfInvtedHVB,banquetTypeVVB,menuTypeVVB,banquetCalculatButttionLabelHVB);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //fIRST VBOX 
        selectedNameLabel = new Label("Reservation Information");
        
        reservationListView = new ListView<>();
        reservationListView.setPrefSize(300, 200);
        
        reservationListViewLabelVVB = new VBox(10,selectedNameLabel,reservationListView);
        
       //2ND VBOX
       reservationNameLabel = new Label("Enter reservation name:");
       reservationNameTextField = new TextField();
       
       resevationTextFieldLabelHVB = new HBox(30,reservationNameLabel,reservationNameTextField);
       
       //3rd VBOX
       searchImage = new Image("file:C:\\Users\\ghada\\Desktop\\GHADA Schoolcraft Classes\\Fall 2022\\Java"
               + "\\Final Project(GMZ Hotel)\\GMZHotel\\searchImage.png");
       
       searchImageView = new ImageView(searchImage);
       searchImageView.setFitWidth(50);
       searchImageView.setPreserveRatio(true);
       
       serchImageVVB = new VBox(searchImageView);
       serchImageVVB.setAlignment(Pos.CENTER);
       
       //4th box
       
       resevationInfoVVB = new VBox(30,reservationListViewLabelVVB,resevationTextFieldLabelHVB,serchImageVVB);
       
       
        /////////////////////////////////////////////////////////////////////////////////////////////
        //main VB
        
        mainHBox = new  HBox(100,roomVBox,banquetVBox,resevationInfoVVB);
        mainHBox.setAlignment(Pos.CENTER);
        mainHBox.setPadding(new Insets(10));
        
        
        
        var scene = new Scene(mainHBox);
        stage.setScene(scene);
        stage.setTitle("GMZ Hotel");
        stage.show();
        
        searchImageView.setOnMouseClicked(event ->
        {
            
            try {
                searchName = reservationNameTextField.getText();
                
                banquetResevationFile = new File("C:\\Users\\ghada\\Desktop\\GHADA Schoolcraft Classes\\Fall 2022\\Java"
                        + "\\Final Project(GMZ Hotel)\\GMZHotel\\BanquetReservation.txt");
                roomResevationFile = new File("C:\\Users\\ghada\\Desktop\\GHADA Schoolcraft Classes\\Fall 2022\\Java"
                        + "\\Final Project(GMZ Hotel)\\GMZHotel\\RoomReservationList.txt");
                
                Scanner banquetResevationinputFile = new Scanner(banquetResevationFile);
                Scanner roomResevationFileinputFile = new Scanner(roomResevationFile);
                
                while (roomResevationFileinputFile.hasNext())
                {
                    
                    line = roomResevationFileinputFile.nextLine();

                    if (line.startsWith(searchName))
                    {
                         
                        reservationListView.getItems().addAll(line);
                    }
  
                    
                }
                
                
                while (banquetResevationinputFile.hasNext())
                {
                    line = banquetResevationinputFile.nextLine();
                    if (line.startsWith(searchName))
                    {
                         
                        reservationListView.getItems().addAll(line);
                    }
                }
                
                
                banquetResevationinputFile.close();
                roomResevationFileinputFile.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
 
       });
    }

    public static void main(String[] args) {
        launch();
    }
    
   //Event handler class for roomCalButton
class roomCalButtonHandler implements EventHandler<ActionEvent>
	{
	    @Override
		public void handle(ActionEvent event)
		    {
                        try{
                            name = nameTextField.getText();
                            date = dateTextField.getText();
                            period = Integer.parseInt(periodTextField.getText()) ;
                            
                            if (regularRoomRadioButton.isSelected())
                            {
                                roomType = 'R';
                            }
                            else
                            {
                                roomType = 'S';
                            }
                            
                            if (breakfastCheckBox.isSelected())
                            {
                                breakfast = true;
                            }
                            else
                            {
                                breakfast = false;
                            }
                            
                            RoomReservation roomReservation = new RoomReservation(name,date,period,breakfast,roomType);
                            roomReservation.calculateTotalCost();
                            roomCalculationResultLabel.setText(String.format("$%,.2f", roomReservation.getTotalCost()) + " Reservation Completed Successfully");
                            


                            try {
                                
                               FileWriter RoomReservationListWriter = new FileWriter("C:\\Users\\ghada\\Desktop\\GHADA Schoolcraft Classes\\Fall 2022\\Java"
                                       + "\\Final Project(GMZ Hotel)\\GMZHotel\\RoomReservationList.txt", true);
                               PrintWriter outputFile = new PrintWriter(RoomReservationListWriter);
                              
                               outputFile.println(name +" "+ period +" Nights " +" "+ date +" "+ roomType + " " +roomReservation.getTotalCost()+ "Room");
                               outputFile.close();
                               
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }


                            

                        }
                        catch (NumberFormatException e)
                        {
                            roomCalculationResultLabel.setText("Inavlid Data");
                        }

                                             
		     }
	   
    }
//Event handler class for banquetCalButton 
class banquetCalButtonHandler implements EventHandler<ActionEvent>
{
   @Override
        public void handle(ActionEvent event)
	 {
             try{
                 name = nameTextField.getText();
                 date = dateTextField.getText();
                 period = period = Integer.parseInt(periodTextField.getText());
                 invitedNumber = Integer.parseInt(numberOfInvtedTextField.getText());
                 
                 if(menu1RadioButton.isSelected())
                 {
                     menuType = 1;
                 }
                 else
                 {
                     menuType = 2;
                 }
                 
                         
                 if(smallBanquetRadioButton.isSelected())
                 {
                     banquetType = 1;
                 }
                 else
                 {
                     banquetType = 2;
                 }
                 
                 BanquetsReservation banquetReservation = new BanquetsReservation(name,date,period,banquetType,menuType,invitedNumber);
                 banquetReservation.calculateTotalCost();
                 banquetCalculationResultLabel.setText(String.format("$%,.2f", banquetReservation.getTotalCost()) + " Reservation Completed Successfully");
                 
                try {
                                
                 FileWriter BanquetsReservation = new FileWriter("C:\\Users\\ghada\\Desktop\\GHADA Schoolcraft Classes\\Fall 2022\\Java\\Final Project(GMZ Hotel)"
                         + "\\GMZHotel\\BanquetReservation.txt", true);
                 PrintWriter outputFile = new PrintWriter(BanquetsReservation);
                
                 outputFile.println(name +"  "+ period +" Nights " +"  "+ date +"  "+ roomType + "  " +banquetReservation.getTotalCost() +" Banquet");
                 outputFile.close();
                               
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                 
             }catch (NumberFormatException e)
               {
                 banquetCalculationResultLabel.setText("Inavlid Data");
               }
          } 
}
}