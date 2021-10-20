package sample;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.prism.impl.Disposer;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class admin implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label welcome;

    @FXML
    private Label welname;

    @FXML
    private TextField usr;

    @FXML
    private PasswordField psw;

    @FXML
    private Button btnadd;

    @FXML
    private ComboBox cbox;

    @FXML
    private AnchorPane Addencoder;

    @FXML
    private AnchorPane Viewencoder;

    @FXML
    private AnchorPane Checkresults;

    @FXML
    private Button logoutbtn;

    @FXML
    private Button resetbtn;

    @FXML
    private Button addencoderbtn;

    @FXML
    private Button viewencoderbtn;

    @FXML
    private Button checkresultsbtn;

    @FXML
    private TableView<EncoderTable> table;

    @FXML
    private TableColumn<EncoderTable, String> usercolumn;

    @FXML
    private TableColumn<EncoderTable, String> passcolumn;

    @FXML
    private TableColumn<EncoderTable, String> departcolumn;

    @FXML
    private TableColumn<EncoderTable, EncoderTable> actioncolumn;

    @FXML
    private ComboBox degree;

    @FXML
    private ComboBox year;

    @FXML
    private Button resultreset;

    @FXML
    private Button search;

    @FXML
    private TableView table2;

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

    EncoderTable selectedEncoderTable;

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet, rs;

    ObservableList<EncoderTable> observationlist = FXCollections.observableArrayList();

    private void TableSelect() {
        String degreename1 = (String) degree.getSelectionModel().getSelectedItem();
        if (degreename1 == "CST") {
            TableView<cst2> table2;

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
            TableView<iit2> table2;

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
            TableView<sct2> table2;

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
            TableView<mrt2> table2;

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
    void addencoder(ActionEvent event) {
        Addencoder.setVisible(true);
        welname.setVisible(false);
        welcome.setVisible(false);
        Viewencoder.setVisible(false);
        Checkresults.setVisible(false);
    }

    @FXML
    void add(ActionEvent event) {
        if(btnadd.getText() == "Update" ){
            updateEncoderTable(selectedEncoderTable);
        }
        else{
            insertEncoderTable();
        }
    }

    @FXML
    void reset(ActionEvent event) {
        usr.clear();
        psw.clear();
        cbox.valueProperty().set(null);
    }

    @FXML
    void viewencoder(ActionEvent event) {
        Viewencoder.setVisible(true);
        welname.setVisible(false);
        welcome.setVisible(false);
        Checkresults.setVisible(false);
        Addencoder.setVisible(false);

        buildTableAndData ();

}

    private void buildTableAndData () {

            try {
                usercolumn.setCellValueFactory(new PropertyValueFactory<EncoderTable, String>("username"));
                passcolumn.setCellValueFactory(new PropertyValueFactory<EncoderTable, String>("password"));
                departcolumn.setCellValueFactory(new PropertyValueFactory<>("department"));
                actioncolumn.setCellValueFactory(new PropertyValueFactory<>(""));
                table.setItems(getRegisteredList());
                Callback<TableColumn<EncoderTable, EncoderTable>, TableCell<EncoderTable, EncoderTable>> cellFactory = new Callback<TableColumn<EncoderTable, EncoderTable>, TableCell<EncoderTable, EncoderTable>>() {
                    @Override
                    public TableCell call(final TableColumn<EncoderTable, EncoderTable> param) {
                        final TableCell<EncoderTable, EncoderTable> cell = new TableCell<EncoderTable, EncoderTable>() {

                            @Override
                            public void updateItem(EncoderTable item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    final Button editBtn = new Button("EDIT");
                                    final Button dltBtn = new Button("DELETE");

                                    editBtn.setOnAction(event -> {
                                        Addencoder.setVisible(true);
                                        Viewencoder.setVisible(false);
                                        welname.setVisible(false);
                                        welcome.setVisible(false);
                                        Checkresults.setVisible(false);
                                        Addencoder.setVisible(true);

                                        btnadd.setText("Update");

                                        selectedEncoderTable = getTableView().getItems().get(getIndex());
                                        usr.setText(selectedEncoderTable.getUsername());
                                        psw.setText(selectedEncoderTable.getPassword());
                                        cbox.setValue(selectedEncoderTable.getDepartment().toString());
                                    });

                                    dltBtn.setOnAction(event -> {
                                        selectedEncoderTable = getTableView().getItems().get(getIndex());
                                        deleteEncoderTable(selectedEncoderTable);
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

                actioncolumn.setCellFactory(cellFactory);
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    private void insertEncoderTable() {
        connection = sqlconnector.ConnectDb();
        String sql_insert = "INSERT INTO data_encoder(username,password,department) VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql_insert);
            preparedStatement.setString(1, usr.getText().toString());
            preparedStatement.setString(2, psw.getText());
            preparedStatement.setString(3, cbox.getValue().toString());

            preparedStatement.execute();

            usr.setText("");
            psw.setText("");
            cbox.valueProperty().set(null);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Alert Dialog");
            alert.setContentText("Data encoder successfully added");
            alert.showAndWait();

        } catch (Exception e) {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Waring Alert Dialog");
            alert1.setContentText("Error! Empty field");
            alert1.showAndWait();
        }
    }

    public ObservableList<EncoderTable> getRegisteredList () throws SQLException {
                String sql = "SELECT * FROM data_encoder";
                ObservableList<EncoderTable> list = FXCollections.observableArrayList();
                list.clear();
                try {
                    connection = sqlconnector.ConnectDb();
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        EncoderTable p = new EncoderTable(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("department"));
                        list.add(p);
                    }
                    rs.close();
                    connection.close();
                } catch (SQLException ex) {
                }
                return list;
            }

    private void updateEncoderTable (EncoderTable selectedEncoderTable){
            try {
                connection = sqlconnector.ConnectDb();
                String sql = "UPDATE data_encoder SET username=?, password=?, department=? WHERE id=?";
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, usr.getText());
                statement.setString(2, psw.getText());
                statement.setString(3, cbox.getValue().toString());
                statement.setInt(4, selectedEncoderTable.getId());

                int rowsInserted = statement.executeUpdate();

                if(usr.getText() == "" || psw.getText() == "" || cbox.getValue().toString() == null){
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

                    btnadd.setText("Submit");

                    usr.setText("");
                    psw.setText("");
                    cbox.valueProperty().set(null);

                    table.setItems(getRegisteredList());

                    Viewencoder.setVisible(true);
                    welname.setVisible(false);
                    welcome.setVisible(false);
                    Checkresults.setVisible(false);
                    Addencoder.setVisible(false);

                }
                statement.close();
                connection.close();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    private void deleteEncoderTable (EncoderTable selectedEncoderTable){
            try {
                connection = sqlconnector.ConnectDb();
                String sql = "DELETE FROM data_encoder WHERE id=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, selectedEncoderTable.getId());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Alert Dialog");
                    alert.setContentText("DELETED Successfully!");
                    alert.showAndWait();

                    table.setItems(getRegisteredList());
                }
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    @FXML
    void checkresults(ActionEvent event) {
        Checkresults.setVisible(true);
        welname.setVisible(false);
        welcome.setVisible(false);
        Viewencoder.setVisible(false);
        Addencoder.setVisible(false);
    }

    @FXML
    void reset2(ActionEvent event) {
        degree.valueProperty().set(null);
        year.valueProperty().set(null);
        table2.setVisible(false);
    }

    @FXML
    void search(ActionEvent event) {
        table2.setVisible(true);

        buildTableAndData2();
    }

    private void buildTableAndData2() {
        TableSelect();

        String yeartype1 = (String) year.getSelectionModel().getSelectedItem();
        String degreename1 = (String) degree.getSelectionModel().getSelectedItem();
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

                table2.setItems(getRegisteredList1());

                Callback<TableColumn<cst2, cst2>, TableCell<cst2, cst2>> cellFactory = new Callback<TableColumn<cst2, cst2>, TableCell<cst2, cst2>>() {
                    @Override
                    public TableCell call(final TableColumn<cst2, cst2> param) {
                        final TableCell<cst2, cst2> cell = new TableCell<cst2, cst2>() {

                        };
                        return cell;
                    }
                };

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

                table2.setItems(getRegisteredList2());

                Callback<TableColumn<iit2, iit2>, TableCell<iit2, iit2>> cellFactory = new Callback<TableColumn<iit2, iit2>, TableCell<iit2, iit2>>() {
                    @Override
                    public TableCell call(final TableColumn<iit2, iit2> param) {
                        final TableCell<iit2, iit2> cell = new TableCell<iit2, iit2>() {

                        };
                        return cell;
                    }
                };


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

                table2.setItems(getRegisteredList3());

                Callback<TableColumn<sct2, sct2>, TableCell<sct2, sct2>> cellFactory = new Callback<TableColumn<sct2, sct2>, TableCell<sct2, sct2>>() {
                    @Override
                    public TableCell call(final TableColumn<sct2, sct2> param) {
                        final TableCell<sct2, sct2> cell = new TableCell<sct2, sct2>() {


                        };
                        return cell;
                    }
                };

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

                table2.setItems(getRegisteredList4());

                Callback<TableColumn<mrt2, mrt2>, TableCell<mrt2, mrt2>> cellFactory = new Callback<TableColumn<mrt2, mrt2>, TableCell<mrt2, mrt2>>() {
                    @Override
                    public TableCell call(final TableColumn<mrt2, mrt2> param) {
                        final TableCell<mrt2, mrt2> cell = new TableCell<mrt2, mrt2>() {


                        };
                        return cell;
                    }
                };


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

    @FXML
    void logoutaction(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Login");
        logoutbtn.getScene().getWindow().hide();

        Controller controller = loader.getController();
        stage.show();
    }

    @FXML
    void initialize() {

    }

    public void Details(String display_name){
        welname.setText(display_name);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        cbox.getItems().addAll("CSI","SCT","MGT","TECH","EAG");

        degree.getItems().addAll("CST","IIT","SCT","MRT","EAG","TEA","PLT","AQT","ANS","BBST");
        year.getItems().addAll( "first year","second year","third year","fourth year");
    }
}
