package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.util.Callback;


public class dataEncoder implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label welcome;

    @FXML
    private Label welname;

    @FXML
    private Button addresultsbtn;

    @FXML
    private Button checkresultsbtn;

    @FXML
    private Button logoutbtn;

    @FXML
    private Button settingsbtn;

    @FXML
    private AnchorPane adding;

    @FXML
    private AnchorPane selection;

    @FXML
    private ComboBox degree;

    @FXML
    private ComboBox year;

    @FXML
    private Button show;

    @FXML
    private AnchorPane detail;

    @FXML
    private AnchorPane Checkresults;

    @FXML
    private Button clear;

    @FXML
    private Button insert;

    @FXML
    private TextField gpa;

    @FXML
    private TextField sub6;

    @FXML
    private TextField sub5;

    @FXML
    private TextField sub4;

    @FXML
    private TextField sub3;

    @FXML
    private TextField sub2;

    @FXML
    private TextField sub1;

    @FXML
    private ComboBox opt1;

    @FXML
    private ComboBox opt2;

    @FXML
    private ComboBox opt3;

    @FXML
    private ComboBox opt4;

    @FXML
    private ComboBox opt5;

    @FXML
    private ComboBox opt6;

    @FXML
    private TextField regno;

    @FXML
    private Label lbladd1;

    @FXML
    private ComboBox degree1;

    @FXML
    private ComboBox year1;

    @FXML
    private Button resultreset;

    @FXML
    private Button search;

    @FXML
    private TableView table;

    @FXML
    private TableColumn colentroll;

    @FXML
    private TableColumn col2;

    @FXML
    private TableColumn col3;

    @FXML
    private TableColumn col4;

    @FXML
    private TableColumn col5;

    @FXML
    private TableColumn col6;

    @FXML
    private TableColumn col7;

    @FXML
    private TableColumn colgpa;

    @FXML
    private TableColumn actioncol;


    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet, rs;


    cst2 selectedcst2;
    iit2 selectediit2;
    sct2 selectedsct2;
    mrt2 selectedmrt2;


    private void TableSelect() {
        String degreename1 = (String) degree1.getSelectionModel().getSelectedItem();
        if (degreename1 == "CST") {
            TableView<cst2> table;

            TableColumn<cst2, String> colentroll;

            TableColumn<cst2, String> col2;

            TableColumn<cst2, String> col3;

            TableColumn<cst2, String> col4;

            TableColumn<cst2, String> col5;

            TableColumn<cst2, String> col6;

            TableColumn<cst2, String> col7;

            TableColumn<cst2, String> colgpa;

            TableColumn<cst2, cst2> actioncol;

            ObservableList<cst2> observationlist1 = FXCollections.observableArrayList();
        }

        else if (degreename1 == "IIT") {
            TableView<iit2> table;

            TableColumn<iit2, String> colentroll;

            TableColumn<iit2, String> col2;

            TableColumn<iit2, String> col3;

            TableColumn<iit2, String> col4;

            TableColumn<iit2, String> col5;

            TableColumn<iit2, String> col6;

            TableColumn<iit2, String> col7;

            TableColumn<iit2, String> colgpa;

            TableColumn<iit2, iit2> actioncol;

            ObservableList<iit2> observationlist2 = FXCollections.observableArrayList();
        }

        else if (degreename1 == "SCT") {
            TableView<sct2> table;

            TableColumn<sct2, String> colentroll;

            TableColumn<sct2, String> col2;

            TableColumn<sct2, String> col3;

            TableColumn<sct2, String> col4;

            TableColumn<sct2, String> col5;

            TableColumn<sct2, String> col6;

            TableColumn<sct2, String> col7;

            TableColumn<sct2, String> colgpa;

            TableColumn<sct2, sct2> actioncol;

            ObservableList<sct2> observationlist3 = FXCollections.observableArrayList();
        }

        else if (degreename1 == "MRT") {
            TableView<mrt2> table;

            TableColumn<mrt2, String> colentroll;

            TableColumn<mrt2, String> col2;

            TableColumn<mrt2, String> col3;

            TableColumn<mrt2, String> col4;

            TableColumn<mrt2, String> col5;

            TableColumn<mrt2, String> col6;

            TableColumn<mrt2, String> col7;

            TableColumn<mrt2, String> colgpa;

            TableColumn<mrt2, mrt2> actioncol;

            ObservableList<mrt2> observationlist4 = FXCollections.observableArrayList();
        }
    }

    @FXML
    void addresults(ActionEvent event) {
        welname.setVisible(false);
        welcome.setVisible(false);
        Checkresults.setVisible(false);
        degree.setVisible(true);
        year.setVisible(true);
        show.setVisible(true);
        selection.setVisible(true);

    }

    @FXML
    void checkresults(ActionEvent event) {
        Checkresults.setVisible(true);
        selection.setVisible(false);
        welname.setVisible(false);
        welcome.setVisible(false);
    }

    @FXML
    void settings(ActionEvent event) {
        selection.setVisible(false);
        welname.setVisible(false);
        welcome.setVisible(false);
        Checkresults.setVisible(false);
    }

    @FXML
    void logoutaction(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Login");
        logoutbtn.getScene().getWindow().hide();

        Controller controller = loader.getController();
        stage.show();
    }

    public void Details1(String display_name) {
        welname.setText(" " + display_name);
    }

    @FXML
    void enterResult(ActionEvent event) {
        detail.setVisible(true);

        String degreename =degree.getSelectionModel().getSelectedItem().toString();
        if (degreename =="CST")
        {
            String yeartype =year.getSelectionModel().getSelectedItem().toString();
            if(yeartype =="second year")
            {
                sub1.setText("System Analysis and Design");
                sub2.setText("Programming");
                sub3.setText("Network2");
                sub4.setText("Staticals Methods");
                sub5.setText("Software Engineering");
                sub6.setText("Aesthetic Studies");
            }
        }
        else if(degreename =="IIT")
        {
            String yeartype =  year.getSelectionModel().getSelectedItem().toString();
            if(yeartype =="second year"){
                sub1.setText("System Analysis and Design");
                sub2.setText("Software Engineering");
                sub3.setText("Network2");
                sub4.setText("Programming");
                sub5.setText("Financial Accounting");
                sub6.setText("Aesthetic Studies");
            }
        }

        else if(degreename =="SCT")
        {
            String yeartype = year.getSelectionModel().getSelectedItem().toString();
            if(yeartype =="second year") {
                sub1.setText("Micro Biology");
                sub2.setText("Physical Chemistry");
                sub3.setText("Abstract Algebra");
                sub4.setText("Statical Method");
                sub5.setText("Mechanics");
                sub6.setText("BioChemistry");
            }
        }

        else if(degreename =="MRT")
        {
            String yeartype = year.getSelectionModel().getSelectedItem().toString();
            if(yeartype =="second year"){
                sub1.setText("Physical Chemistry");
                sub2.setText("Electricity and Magnetisim");
                sub3.setText("Minerology");
                sub4.setText("Geology");
                sub5.setText("Hydrology");
                sub6.setText("Aesthetic Studies");
            }
        }
        else{
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Waring Alert Dialog");
            alert1.setContentText("Error! Empty Data");
            alert1.showAndWait();
        }
    }

    @FXML
    void clearall(ActionEvent event) {
        gpa.clear();
        regno.clear();
        opt1.getSelectionModel().clearSelection();
        opt2.getSelectionModel().clearSelection();
        opt3.getSelectionModel().clearSelection();
        opt4.getSelectionModel().clearSelection();
        opt5.getSelectionModel().clearSelection();
        opt6.getSelectionModel().clearSelection();
    }

    @FXML
    void submit(ActionEvent event) {
            if(insert.getText() == "Update"){
                    updatecst2(selectedcst2);
            }
            else if(insert.getText() == "update"){
                updateiit2(selectediit2);
            }
            else if(insert.getText() == "UPDATE"){
                updatesct2(selectedsct2);
            }
            else if(insert.getText() == "Update."){
                updatemrt2(selectedmrt2);
            }
            else{
                insertResultTable();
            }
        }

    private void insertResultTable() {

        String degreename =degree.getSelectionModel().getSelectedItem().toString();
        if (degreename =="CST")
        {
         String yeartype =year.getSelectionModel().getSelectedItem().toString();
            if(yeartype =="second year")
            {
                sub1.setText("System Analysis and Design");
                sub2.setText("Programming");
                sub3.setText("Network2");
                sub4.setText("Staticals Methods");
                sub5.setText("Software Engineering");
                sub6.setText("Aesthetic Studies");
            }
            connection = sqlconnector.ConnectDb();
            String sql_insert = "INSERT INTO cst2(stuno,SystemAnalysisandDesign,Programming,Network2,StaticalMethod,SoftwareEngineering,AestheticStudies,gpa) VALUES(?,?,?,?,?,?,?,?)";
            try {
                preparedStatement = connection.prepareStatement(sql_insert);
                preparedStatement.setString(1, regno.getText().toString());
                preparedStatement.setString(2, opt1.getValue().toString());
                preparedStatement.setString(3,opt2.getValue().toString());
                preparedStatement.setString(4,opt3.getValue().toString());
                preparedStatement.setString(5,opt4.getValue().toString());
                preparedStatement.setString(6,opt5.getValue().toString());
                preparedStatement.setString(7,opt6.getValue().toString());
                preparedStatement.setString(8,gpa.getText().toString());

                preparedStatement.execute();
                gpa.clear();
                regno.clear();
                opt1.getSelectionModel().clearSelection();
                opt2.getSelectionModel().clearSelection();
                opt3.getSelectionModel().clearSelection();
                opt4.getSelectionModel().clearSelection();
                opt5.getSelectionModel().clearSelection();
                opt6.getSelectionModel().clearSelection();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Alert Dialog");
                alert.setContentText("Grade successfully added to CST table");
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.setTitle("Waring Alert Dialog");
                alert1.setContentText("Error! Empty field");
                alert1.showAndWait();
            }

        }
        else if(degreename =="IIT")
        {
        String yeartype =  year.getSelectionModel().getSelectedItem().toString();
            if(yeartype =="second year"){
                sub1.setText("System Analysis and Design");
                sub2.setText("Software Engineering");
                sub3.setText("Network2");
                sub4.setText("Programming");
                sub5.setText("Financial Accounting");
                sub6.setText("Aesthetic Studies");
            }
            connection = sqlconnector.ConnectDb();
            String sql_insert = "INSERT INTO iit2 VALUES(?,?,?,?,?,?,?,?)";
            try {
                preparedStatement = connection.prepareStatement(sql_insert);
                preparedStatement.setString(1, regno.getText());
                preparedStatement.setString(2, opt1.getValue().toString());
                preparedStatement.setString(3,opt2.getValue().toString());
                preparedStatement.setString(4,opt3.getValue().toString());
                preparedStatement.setString(5,opt4.getValue().toString());
                preparedStatement.setString(6,opt5.getValue().toString());
                preparedStatement.setString(7,opt6.getValue().toString());
                preparedStatement.setString(8,gpa.getText());

                preparedStatement.execute();
                gpa.clear();
                regno.clear();
                opt1.getSelectionModel().clearSelection();
                opt2.getSelectionModel().clearSelection();
                opt3.getSelectionModel().clearSelection();
                opt4.getSelectionModel().clearSelection();
                opt5.getSelectionModel().clearSelection();
                opt6.getSelectionModel().clearSelection();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Alert Dialog");
                alert.setContentText("Grade successfully added to IIT table");
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.setTitle("Waring Alert Dialog");
                alert1.setContentText("Error! Empty field");
                alert1.showAndWait();
            }
        }

        else if(degreename =="SCT")
        {
            String yeartype = year.getSelectionModel().getSelectedItem().toString();
            if(yeartype =="second year") {
                sub1.setText("Micro Biology");
                sub2.setText("Physical Chemistry");
                sub3.setText("Abstract Algebra");
                sub4.setText("Statical Method");
                sub5.setText("Mechanics");
                sub6.setText("BioChemistry");
            }
            connection = sqlconnector.ConnectDb();
            String sql_insert = "INSERT INTO sct2 VALUES(?,?,?,?,?,?,?,?)";
            try {
                preparedStatement = connection.prepareStatement(sql_insert);
                preparedStatement.setString(1, regno.getText());
                preparedStatement.setString(2, opt1.getValue().toString());
                preparedStatement.setString(3,opt2.getValue().toString());
                preparedStatement.setString(4,opt3.getValue().toString());
                preparedStatement.setString(5,opt4.getValue().toString());
                preparedStatement.setString(6,opt5.getValue().toString());
                preparedStatement.setString(7,opt6.getValue().toString());
                preparedStatement.setString(8,gpa.getText());

                preparedStatement.execute();
                gpa.clear();
                regno.clear();
                opt1.getSelectionModel().clearSelection();
                opt2.getSelectionModel().clearSelection();
                opt3.getSelectionModel().clearSelection();
                opt4.getSelectionModel().clearSelection();
                opt5.getSelectionModel().clearSelection();
                opt6.getSelectionModel().clearSelection();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Alert Dialog");
                alert.setContentText("Grade successfully added to SCT table");
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.setTitle("Waring Alert Dialog");
                alert1.setContentText("Error! Empty field");
                alert1.showAndWait();
            }
        }

        else if(degreename =="MRT")
        {
            String yeartype = year.getSelectionModel().getSelectedItem().toString();
            if(yeartype =="second year"){
                sub1.setText("Physical Chemistry");
                sub2.setText("Electricity and Magnetisim");
                sub3.setText("Minerology");
                sub4.setText("Geology");
                sub5.setText("Hydrology");
                sub6.setText("Aesthetic Studies");
            }
            connection = sqlconnector.ConnectDb();
            String sql_insert = "INSERT INTO mrt2 VALUES(?,?,?,?,?,?,?,?)";
            try {
                preparedStatement = connection.prepareStatement(sql_insert);
                preparedStatement.setString(1, regno.getText());
                preparedStatement.setString(2, opt1.getValue().toString());
                preparedStatement.setString(3,opt2.getValue().toString());
                preparedStatement.setString(4,opt3.getValue().toString());
                preparedStatement.setString(5,opt4.getValue().toString());
                preparedStatement.setString(6,opt5.getValue().toString());
                preparedStatement.setString(7,opt6.getValue().toString());
                preparedStatement.setString(8,gpa.getText());

                preparedStatement.execute();
                gpa.clear();
                regno.clear();
                opt1.getSelectionModel().clearSelection();
                opt2.getSelectionModel().clearSelection();
                opt3.getSelectionModel().clearSelection();
                opt4.getSelectionModel().clearSelection();
                opt5.getSelectionModel().clearSelection();
                opt6.getSelectionModel().clearSelection();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Alert Dialog");
                alert.setContentText("Grade successfully added to MRT table");
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.setTitle("Waring Alert Dialog");
                alert1.setContentText("Error! Empty field");
                alert1.showAndWait();
            }
        }

        else{
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Waring Alert Dialog");
            alert1.setContentText("Error! Empty Data");
            alert1.showAndWait();
        }
    }


    @FXML
    void reset(ActionEvent event) {
        degree1.valueProperty().set(null);
        year1.valueProperty().set(null);
        table.setVisible(false);
    }

    @FXML
    void search(ActionEvent event) {
        table.setVisible(true);

        buildTableAndData();
    }

    private void buildTableAndData() {
       TableSelect();

        String yeartype1 = (String) year1.getSelectionModel().getSelectedItem();
        String degreename1 = (String) degree1.getSelectionModel().getSelectedItem();
            if (degreename1 == "CST" && yeartype1 == "second year") {

                try {
                    colentroll.setCellValueFactory(new PropertyValueFactory<cst2, String>("eno"));
                    col2.setCellValueFactory(new PropertyValueFactory<cst2, String>("col2"));
                    col3.setCellValueFactory(new PropertyValueFactory<cst2, String>("col3"));
                    col4.setCellValueFactory(new PropertyValueFactory<cst2, String>("col4"));
                    col5.setCellValueFactory(new PropertyValueFactory<cst2, String>("col5"));
                    col6.setCellValueFactory(new PropertyValueFactory<cst2, String>("col6"));
                    col7.setCellValueFactory(new PropertyValueFactory<cst2, String>("col7"));
                    colgpa.setCellValueFactory(new PropertyValueFactory<cst2, String>("gpa"));
                    actioncol.setCellValueFactory(new PropertyValueFactory<>(""));

                    table.setItems(getRegisteredList1());

                    Callback<TableColumn<cst2, cst2>, TableCell<cst2, cst2>> cellFactory = new Callback<TableColumn<cst2, cst2>, TableCell<cst2, cst2>>() {
                        @Override
                        public TableCell call(final TableColumn<cst2, cst2> param) {
                            final TableCell<cst2, cst2> cell = new TableCell<cst2, cst2>() {

                                @Override
                                public void updateItem(cst2 item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        final Button editBtn = new Button("EDIT");
                                        final Button dltBtn = new Button("DELETE");

                                        editBtn.setOnAction(event -> {
                                            Checkresults.setVisible(false);
                                            selection.setVisible(true);
                                            welname.setVisible(false);
                                            welcome.setVisible(false);
                                            detail.setVisible(true);


                                    insert.setText("Update");
                                            degree.setValue("CST");
                                            year.setValue("second year");
                                            sub1.setText("System Analysis and Design");
                                            sub2.setText("Programming");
                                            sub3.setText("Network2");
                                            sub4.setText("Staticals Methods");
                                            sub5.setText("Software Engineering");
                                            sub6.setText("Aesthetic Studies");

                                    selectedcst2 = getTableView().getItems().get(getIndex());

                                        regno.setText(selectedcst2.getEno());
                                        opt1.setValue(selectedcst2.getCol2().toString());
                                        opt2.setValue(selectedcst2.getCol3().toString());
                                        opt3.setValue(selectedcst2.getCol4().toString());
                                        opt4.setValue(selectedcst2.getCol5().toString());
                                        opt5.setValue(selectedcst2.getCol6().toString());
                                        opt6.setValue(selectedcst2.getCol7().toString());
                                        gpa.setText(selectedcst2.getGpa());
                                        });

                                        dltBtn.setOnAction(event -> {
                                            selectedcst2 = getTableView().getItems().get(getIndex());
                                            deletecst2(selectedcst2);
                                        });

                                        HBox hb = new HBox();
                                        hb.setSpacing(2);
                                        hb.getChildren().addAll(editBtn, dltBtn);
                                        setGraphic(hb);
                                        setText(null);
                                    }
                                }
                            };
                            return cell;
                        }
                    };

                    actioncol.setCellFactory(cellFactory);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);

                }
            }

        else if (degreename1 == "IIT" && yeartype1 == "second year") {

                try {
                    colentroll.setCellValueFactory(new PropertyValueFactory<cst2, String>("eno"));
                    col2.setCellValueFactory(new PropertyValueFactory<cst2, String>("col2"));
                    col3.setCellValueFactory(new PropertyValueFactory<cst2, String>("col3"));
                    col4.setCellValueFactory(new PropertyValueFactory<cst2, String>("col4"));
                    col5.setCellValueFactory(new PropertyValueFactory<cst2, String>("col5"));
                    col6.setCellValueFactory(new PropertyValueFactory<cst2, String>("col6"));
                    col7.setCellValueFactory(new PropertyValueFactory<cst2, String>("col7"));
                    colgpa.setCellValueFactory(new PropertyValueFactory<cst2, String>("gpa"));
                    actioncol.setCellValueFactory(new PropertyValueFactory<>(""));

                    table.setItems(getRegisteredList2());

                    Callback<TableColumn<iit2, iit2>, TableCell<iit2, iit2>> cellFactory = new Callback<TableColumn<iit2, iit2>, TableCell<iit2, iit2>>() {
                        @Override
                        public TableCell call(final TableColumn<iit2, iit2> param) {
                            final TableCell<iit2, iit2> cell = new TableCell<iit2, iit2>() {

                                @Override
                                public void updateItem(iit2 item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        final Button editBtn = new Button("EDIT");
                                        final Button dltBtn = new Button("DELETE");

                                        editBtn.setOnAction(event -> {
                                            Checkresults.setVisible(false);
                                            selection.setVisible(true);
                                            welname.setVisible(false);
                                            welcome.setVisible(false);
                                            detail.setVisible(true);


                                            insert.setText("update");
                                            degree.setValue("IIT");
                                            year.setValue("second year");
                                            sub1.setText("System Analysis and Design");
                                            sub2.setText("Software Engineering");
                                            sub3.setText("Network2");
                                            sub4.setText("Programming");
                                            sub5.setText("Financial Accounting");
                                            sub6.setText("Aesthetic Studies");

                                            selectediit2 = getTableView().getItems().get(getIndex());

                                            regno.setText(selectediit2.getEno());
                                            opt1.setValue(selectediit2.getCol2().toString());
                                            opt2.setValue(selectediit2.getCol3().toString());
                                            opt3.setValue(selectediit2.getCol4().toString());
                                            opt4.setValue(selectediit2.getCol5().toString());
                                            opt5.setValue(selectediit2.getCol6().toString());
                                            opt6.setValue(selectediit2.getCol7().toString());
                                            gpa.setText(selectediit2.getGpa());
                                        });

                                        dltBtn.setOnAction(event -> {
                                            selectediit2 = getTableView().getItems().get(getIndex());
                                            deleteiit2(selectediit2);
                                        });

                                        HBox hb = new HBox();
                                        hb.setSpacing(2);
                                        hb.getChildren().addAll(editBtn, dltBtn);
                                        setGraphic(hb);
                                        setText(null);
                                    }
                                }
                            };
                            return cell;
                        }
                    };

                    actioncol.setCellFactory(cellFactory);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);

                }
            }

        else if (degreename1 == "SCT" && yeartype1 == "second year") {

                try {
                    colentroll.setCellValueFactory(new PropertyValueFactory<cst2, String>("eno"));
                    col2.setCellValueFactory(new PropertyValueFactory<cst2, String>("col2"));
                    col3.setCellValueFactory(new PropertyValueFactory<cst2, String>("col3"));
                    col4.setCellValueFactory(new PropertyValueFactory<cst2, String>("col4"));
                    col5.setCellValueFactory(new PropertyValueFactory<cst2, String>("col5"));
                    col6.setCellValueFactory(new PropertyValueFactory<cst2, String>("col6"));
                    col7.setCellValueFactory(new PropertyValueFactory<cst2, String>("col7"));
                    colgpa.setCellValueFactory(new PropertyValueFactory<cst2, String>("gpa"));
                    actioncol.setCellValueFactory(new PropertyValueFactory<>(""));

                    table.setItems(getRegisteredList3());

                    Callback<TableColumn<sct2, sct2>, TableCell<sct2, sct2>> cellFactory = new Callback<TableColumn<sct2, sct2>, TableCell<sct2, sct2>>() {
                        @Override
                        public TableCell call(final TableColumn<sct2, sct2> param) {
                            final TableCell<sct2, sct2> cell = new TableCell<sct2, sct2>() {

                                @Override
                                public void updateItem(sct2 item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        final Button editBtn = new Button("EDIT");
                                        final Button dltBtn = new Button("DELETE");

                                        editBtn.setOnAction(event -> {
                                            Checkresults.setVisible(false);
                                            selection.setVisible(true);
                                            welname.setVisible(false);
                                            welcome.setVisible(false);
                                            detail.setVisible(true);


                                            insert.setText("UPDATE");
                                            degree.setValue("SCT");
                                            year.setValue("second year");
                                            sub1.setText("Micro Biology");
                                            sub2.setText("Physical Chemistry");
                                            sub3.setText("Abstract Algebra");
                                            sub4.setText("Statical Method");
                                            sub5.setText("Mechanics");
                                            sub6.setText("BioChemistry");

                                            selectedsct2 = getTableView().getItems().get(getIndex());

                                            regno.setText(selectedsct2.getEno());
                                            opt1.setValue(selectedsct2.getCol2().toString());
                                            opt2.setValue(selectedsct2.getCol3().toString());
                                            opt3.setValue(selectedsct2.getCol4().toString());
                                            opt4.setValue(selectedsct2.getCol5().toString());
                                            opt5.setValue(selectedsct2.getCol6().toString());
                                            opt6.setValue(selectedsct2.getCol7().toString());
                                            gpa.setText(selectedsct2.getGpa());
                                        });

                                        dltBtn.setOnAction(event -> {
                                            selectedsct2 = getTableView().getItems().get(getIndex());
                                            deletesct2(selectedsct2);
                                        });

                                        HBox hb = new HBox();
                                        hb.setSpacing(2);
                                        hb.getChildren().addAll(editBtn, dltBtn);
                                        setGraphic(hb);
                                        setText(null);
                                    }
                                }
                            };
                            return cell;
                        }
                    };

                    actioncol.setCellFactory(cellFactory);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);

                }
        }

        else if (degreename1 == "MRT" && yeartype1 == "second year") {

                try {
                    colentroll.setCellValueFactory(new PropertyValueFactory<cst2, String>("eno"));
                    col2.setCellValueFactory(new PropertyValueFactory<cst2, String>("col2"));
                    col3.setCellValueFactory(new PropertyValueFactory<cst2, String>("col3"));
                    col4.setCellValueFactory(new PropertyValueFactory<cst2, String>("col4"));
                    col5.setCellValueFactory(new PropertyValueFactory<cst2, String>("col5"));
                    col6.setCellValueFactory(new PropertyValueFactory<cst2, String>("col6"));
                    col7.setCellValueFactory(new PropertyValueFactory<cst2, String>("col7"));
                    colgpa.setCellValueFactory(new PropertyValueFactory<cst2, String>("gpa"));
                    actioncol.setCellValueFactory(new PropertyValueFactory<>(""));

                    table.setItems(getRegisteredList4());

                    Callback<TableColumn<mrt2, mrt2>, TableCell<mrt2, mrt2>> cellFactory = new Callback<TableColumn<mrt2, mrt2>, TableCell<mrt2, mrt2>>() {
                        @Override
                        public TableCell call(final TableColumn<mrt2, mrt2> param) {
                            final TableCell<mrt2, mrt2> cell = new TableCell<mrt2, mrt2>() {

                                @Override
                                public void updateItem(mrt2 item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        final Button editBtn = new Button("EDIT");
                                        final Button dltBtn = new Button("DELETE");

                                        editBtn.setOnAction(event -> {
                                            Checkresults.setVisible(false);
                                            selection.setVisible(true);
                                            welname.setVisible(false);
                                            welcome.setVisible(false);
                                            detail.setVisible(true);


                                            insert.setText("Update.");
                                            degree.setValue("MRT");
                                            year.setValue("second year");
                                            sub1.setText("Physical Chemistry");
                                            sub2.setText("Electricity and Magnetisim");
                                            sub3.setText("Minerology");
                                            sub4.setText("Geology");
                                            sub5.setText("Hydrology");
                                            sub6.setText("Aesthetic Studies");

                                            selectedmrt2 = getTableView().getItems().get(getIndex());

                                            regno.setText(selectedmrt2.getEno());
                                            opt1.setValue(selectedmrt2.getCol2().toString());
                                            opt2.setValue(selectedmrt2.getCol3().toString());
                                            opt3.setValue(selectedmrt2.getCol4().toString());
                                            opt4.setValue(selectedmrt2.getCol5().toString());
                                            opt5.setValue(selectedmrt2.getCol6().toString());
                                            opt6.setValue(selectedmrt2.getCol7().toString());
                                            gpa.setText(selectedmrt2.getGpa());
                                        });

                                        dltBtn.setOnAction(event -> {
                                            selectedmrt2 = getTableView().getItems().get(getIndex());
                                            deletemrt2(selectedmrt2);
                                        });

                                        HBox hb = new HBox();
                                        hb.setSpacing(2);
                                        hb.getChildren().addAll(editBtn, dltBtn);
                                        setGraphic(hb);
                                        setText(null);
                                    }
                                }
                            };
                            return cell;
                        }
                    };

                    actioncol.setCellFactory(cellFactory);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        else{
                table.setVisible(false);

                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.setTitle("Waring Alert Dialog");
                alert1.setContentText("Error! Empty Data");
                alert1.showAndWait();
            }
        }

    public ObservableList<cst2> getRegisteredList1() throws SQLException {

                String sql = "SELECT * FROM cst2";
                ObservableList<cst2> list = FXCollections.observableArrayList();
                list.clear();
                try {
                    connection = sqlconnector.ConnectDb();
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        cst2 p = new cst2(rs.getString("stuno"), rs.getString("SystemAnalysisandDesign"), rs.getString("Programming"), rs.getString("Network2"), rs.getString("StaticalMethod"), rs.getString("SoftwareEngineering"), rs.getString("AestheticStudies"), rs.getString("gpa"));
                        list.add(p);

                        col2.setText("CST 241-3");
                        col3.setText("CST 224-2");
                        col4.setText("CST 212-2");
                        col5.setText("CST 232-2");
                        col6.setText("CST 242-3");
                        col7.setText("BGE 211-2");


                    }
                    rs.close();
                    connection.close();
                } catch (SQLException ex) {
                }
                return list;
            }

    public ObservableList<iit2> getRegisteredList2() throws SQLException {

        String sql = "SELECT * FROM iit2";
        ObservableList<iit2> list = FXCollections.observableArrayList();
        list.clear();
        try {
            connection = sqlconnector.ConnectDb();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                iit2 p = new iit2(rs.getString("stuno"), rs.getString("SystemAnalysisandDesign"), rs.getString("SoftwareEngineering"), rs.getString("Network2"),rs.getString("Programming"), rs.getString("FinancialAccounting"),  rs.getString("AestheticStudies"), rs.getString("gpa"));
                list.add(p);
                col2.setText("CST 241-3");
                col3.setText("CST 224-2");
                col4.setText("CST232-2");
                col5.setText("CST 242-3");
                col6.setText("IIT 221-1");
                col7.setText("BGE 211-2");
            }
            rs.close();
            connection.close();
        } catch (SQLException ex) {
        }
        return list;
    }

    public ObservableList<sct2> getRegisteredList3() throws SQLException {

        String sql = "SELECT * FROM sct2";
        ObservableList<sct2> list = FXCollections.observableArrayList();
        list.clear();
        try {
            connection = sqlconnector.ConnectDb();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                sct2 p = new sct2(rs.getString("stuno"), rs.getString("MicroBiology"), rs.getString("PhysicalChemistry"), rs.getString("AbstractAlgebra"), rs.getString("StaticalMethod"), rs.getString("Mechanics"), rs.getString("BioChemistry"), rs.getString("gpa"));
                list.add(p);
                col2.setText("SCT 231-2");
                col3.setText("SCT 222-2");
                col4.setText("SCT 234-3");
                col5.setText("SCT 211-2");
                col6.setText("SCT 281-1");
                col7.setText("SCT 251-2");
            }
            rs.close();
            connection.close();
        } catch (SQLException ex) {
        }
        return list;
    }

    public ObservableList<mrt2> getRegisteredList4() throws SQLException {

        String sql = "SELECT * FROM mrt2";
        ObservableList<mrt2> list = FXCollections.observableArrayList();
        list.clear();
        try {
            connection = sqlconnector.ConnectDb();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                mrt2 p = new mrt2(rs.getString("stuno"), rs.getString("PhysicalChemistry"), rs.getString("ElectricityandMagnetisim"), rs.getString("Minerology"), rs.getString("Geology"), rs.getString("Hydrology"), rs.getString("AestheticStudies"), rs.getString("gpa"));
                list.add(p);
                col2.setText("SCT 201-1");
                col3.setText("SCT 211-2");
                col4.setText("SCT 231-2");
                col5.setText("MRT 252-2");
                col6.setText("MRT 253-2");
                col7.setText("BGE 211-2");
            }
            rs.close();
            connection.close();
        } catch (SQLException ex) {
        }
        return list;
    }

    private void updatecst2 (cst2 selectedcst2){
                try {
                    connection = sqlconnector.ConnectDb();
                    String sql_update = "UPDATE cst2 SET SystemAnalysisandDesign=?, Programming=?, Network2=?, StaticalMethod=?, SoftwareEngineering=?, AestheticStudies=?, gpa=? WHERE stuno=?";

                    PreparedStatement statement = connection.prepareStatement(sql_update);

                    statement.setString(1, opt1.getValue().toString());
                    statement.setString(2, opt2.getValue().toString());
                    statement.setString(3, opt3.getValue().toString());
                    statement.setString(4, opt4.getValue().toString());
                    statement.setString(5, opt5.getValue().toString());
                    statement.setString(6, opt6.getValue().toString());
                    statement.setString(7, gpa.getText());
                    statement.setString(8, selectedcst2.getEno());

                    int rowsInserted = statement.executeUpdate();

                    if (gpa.getText() == "" || opt1.getValue().toString() == null || opt2.getValue().toString() == null || opt3.getValue().toString() == null || opt4.getValue().toString() == null || opt5.getValue().toString() == null || opt6.getValue().toString() == null) {
                        Alert alert1 = new Alert(Alert.AlertType.WARNING);
                        alert1.setTitle("Waring Alert Dialog");
                        alert1.setContentText("Error! Empty field");
                        alert1.showAndWait();
                    }

                    else if (rowsInserted > 0) {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Alert Dialog");
                        alert.setContentText("UPDATED Successfully!");
                        alert.showAndWait();

                        insert.setText("Add result");

                        regno.setText("");
                        gpa.setText("");
                        opt1.getSelectionModel().clearSelection();
                        opt2.getSelectionModel().clearSelection();
                        opt3.getSelectionModel().clearSelection();
                        opt4.getSelectionModel().clearSelection();
                        opt5.getSelectionModel().clearSelection();
                        opt6.getSelectionModel().clearSelection();


                        table.setItems(getRegisteredList1());

                        Checkresults.setVisible(true);
                        selection.setVisible(false);
                        welname.setVisible(false);
                        welcome.setVisible(false);

                    }
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

    private void updateiit2 (iit2 selectediit2){
        try {
            connection = sqlconnector.ConnectDb();
            String sql_update = "UPDATE iit2 SET SystemAnalysisandDesign=?, SoftwareEngineering=?, Network2=?, Programming=?, FinancialAccounting=?, AestheticStudies=?, gpa=? WHERE stuno=?";

            PreparedStatement statement = connection.prepareStatement(sql_update);

            statement.setString(1, opt1.getValue().toString());
            statement.setString(2, opt2.getValue().toString());
            statement.setString(3, opt3.getValue().toString());
            statement.setString(4, opt4.getValue().toString());
            statement.setString(5, opt5.getValue().toString());
            statement.setString(6, opt6.getValue().toString());
            statement.setString(7, gpa.getText());
            statement.setString(8, selectediit2.getEno());

            int rowsInserted = statement.executeUpdate();

            if (gpa.getText() == "" || opt1.getValue().toString() == null || opt2.getValue().toString() == null || opt3.getValue().toString() == null || opt4.getValue().toString() == null || opt5.getValue().toString() == null || opt6.getValue().toString() == null) {
                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.setTitle("Waring Alert Dialog");
                alert1.setContentText("Error! Empty field");
                alert1.showAndWait();
            }

            else if (rowsInserted > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Alert Dialog");
                alert.setContentText("UPDATED Successfully!");
                alert.showAndWait();

                insert.setText("Add result");

                regno.setText("");
                gpa.setText("");
                opt1.getSelectionModel().clearSelection();
                opt2.getSelectionModel().clearSelection();
                opt3.getSelectionModel().clearSelection();
                opt4.getSelectionModel().clearSelection();
                opt5.getSelectionModel().clearSelection();
                opt6.getSelectionModel().clearSelection();


                table.setItems(getRegisteredList2());

                Checkresults.setVisible(true);
                selection.setVisible(false);
                welname.setVisible(false);
                welcome.setVisible(false);

            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updatesct2 (sct2 selectedsct2){
        try {
            connection = sqlconnector.ConnectDb();
            String sql_update = "UPDATE sct2 SET MicroBiology=?, PhysicalChemistry=?, AbstractAlgebra=?, StaticalMethod=?, Mechanics=?, BioChemistry=?, gpa=? WHERE stuno=?";

            PreparedStatement statement = connection.prepareStatement(sql_update);

            statement.setString(1, opt1.getValue().toString());
            statement.setString(2, opt2.getValue().toString());
            statement.setString(3, opt3.getValue().toString());
            statement.setString(4, opt4.getValue().toString());
            statement.setString(5, opt5.getValue().toString());
            statement.setString(6, opt6.getValue().toString());
            statement.setString(7, gpa.getText());
            statement.setString(8, selectedsct2.getEno());

            int rowsInserted = statement.executeUpdate();

            if (gpa.getText() == "" || opt1.getValue().toString() == null || opt2.getValue().toString() == null || opt3.getValue().toString() == null || opt4.getValue().toString() == null || opt5.getValue().toString() == null || opt6.getValue().toString() == null) {
                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.setTitle("Waring Alert Dialog");
                alert1.setContentText("Error! Empty field");
                alert1.showAndWait();
            }

            else if (rowsInserted > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Alert Dialog");
                alert.setContentText("UPDATED Successfully!");
                alert.showAndWait();

                insert.setText("Add result");

                regno.setText("");
                gpa.setText("");
                opt1.getSelectionModel().clearSelection();
                opt2.getSelectionModel().clearSelection();
                opt3.getSelectionModel().clearSelection();
                opt4.getSelectionModel().clearSelection();
                opt5.getSelectionModel().clearSelection();
                opt6.getSelectionModel().clearSelection();


                table.setItems(getRegisteredList3());

                Checkresults.setVisible(true);
                selection.setVisible(false);
                welname.setVisible(false);
                welcome.setVisible(false);

            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updatemrt2 (mrt2 selectedmrt2){
        try {
            connection = sqlconnector.ConnectDb();
            String sql_update = "UPDATE mrt2 SET PhysicalChemistry=?, ElectricityandMagnetisim=?, Minerology=?, Geology=?, Hydrology=?, AestheticStudies=?, gpa=? WHERE stuno=?";

            PreparedStatement statement = connection.prepareStatement(sql_update);

            statement.setString(1, opt1.getValue().toString());
            statement.setString(2, opt2.getValue().toString());
            statement.setString(3, opt3.getValue().toString());
            statement.setString(4, opt4.getValue().toString());
            statement.setString(5, opt5.getValue().toString());
            statement.setString(6, opt6.getValue().toString());
            statement.setString(7, gpa.getText());
            statement.setString(8, selectedmrt2.getEno());

            int rowsInserted = statement.executeUpdate();

            if (gpa.getText() == "" || opt1.getValue().toString() == null || opt2.getValue().toString() == null || opt3.getValue().toString() == null || opt4.getValue().toString() == null || opt5.getValue().toString() == null || opt6.getValue().toString() == null) {
                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.setTitle("Waring Alert Dialog");
                alert1.setContentText("Error! Empty field");
                alert1.showAndWait();
            }

            else if (rowsInserted > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Alert Dialog");
                alert.setContentText("UPDATED Successfully!");
                alert.showAndWait();

                insert.setText("Add result");

                regno.setText("");
                gpa.setText("");
                opt1.getSelectionModel().clearSelection();
                opt2.getSelectionModel().clearSelection();
                opt3.getSelectionModel().clearSelection();
                opt4.getSelectionModel().clearSelection();
                opt5.getSelectionModel().clearSelection();
                opt6.getSelectionModel().clearSelection();


                table.setItems(getRegisteredList4());

                Checkresults.setVisible(true);
                selection.setVisible(false);
                welname.setVisible(false);
                welcome.setVisible(false);

            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void deletecst2 (cst2 selectedcst2){
        try {
            connection = sqlconnector.ConnectDb();
            String sql = "DELETE FROM cst2 WHERE stuno=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, selectedcst2.getEno());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Alert Dialog");
                alert.setContentText("DELETED Successfully!");
                alert.showAndWait();

                table.setItems(getRegisteredList1());
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteiit2 (iit2 selectediit2){
        try {
            connection = sqlconnector.ConnectDb();
            String sql = "DELETE FROM iit2 WHERE stuno=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, selectediit2.getEno());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Alert Dialog");
                alert.setContentText("DELETED Successfully!");
                alert.showAndWait();

                table.setItems(getRegisteredList2());
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deletesct2 (sct2 selectedsct2){
        try {
            connection = sqlconnector.ConnectDb();
            String sql = "DELETE FROM sct2 WHERE stuno=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, selectedsct2.getEno());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Alert Dialog");
                alert.setContentText("DELETED Successfully!");
                alert.showAndWait();

                table.setItems(getRegisteredList3());
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deletemrt2 (mrt2 selectedmrt2){
        try {
            connection = sqlconnector.ConnectDb();
            String sql = "DELETE FROM mrt2 WHERE stuno=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, selectedmrt2.getEno());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Alert Dialog");
                alert.setContentText("DELETED Successfully!");
                alert.showAndWait();

                table.setItems(getRegisteredList4());
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        degree.getItems().addAll("CST","IIT","SCT","MRT","EAG","TEA","PLT","AQT","ANS","BBST");
        year.getItems().addAll( "first year","second year","third year","fourth year");
        opt6.getItems().addAll("A+","A","A-","B+","B","B-","C+","C","C-","D+","D","E");
        opt5.getItems().addAll("A+","A","A-","B+","B","B-","C+","C","C-","D+","D","E");
        opt4.getItems().addAll("A+","A","A-","B+","B","B-","C+","C","C-","D+","D","E");
        opt3.getItems().addAll("A+","A","A-","B+","B","B-","C+","C","C-","D+","D","E");
        opt2.getItems().addAll("A+","A","A-","B+","B","B-","C+","C","C-","D+","D","E");
        opt1.getItems().addAll("A+","A","A-","B+","B","B-","C+","C","C-","D+","D","E");

        degree1.getItems().addAll("CST","IIT","SCT","MRT","EAG","TEA","PLT","AQT","ANS","BBST");
        year1.getItems().addAll( "first year","second year","third year","fourth year");
    }
}