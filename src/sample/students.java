package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class students implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane frontstudent;

    @FXML
    private Button searchbtn;

    @FXML
    private TextField registration;

    @FXML
    private AnchorPane display;

    @FXML
    private TextField number;

    @FXML
    private TextField s1;

    @FXML
    private TextField s2;

    @FXML
    private TextField s3;

    @FXML
    private TextField s4;

    @FXML
    private TextField s5;

    @FXML
    private TextField s6;

    @FXML
    private TextField r1;

    @FXML
    private TextField r2;

    @FXML
    private TextField r3;

    @FXML
    private TextField r4;

    @FXML
    private TextField r5;

    @FXML
    private TextField r6;

    @FXML
    private Button close;

    @FXML
    private TextField gpa;

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet1,resultSet2,resultSet3,resultSet4;

    @FXML
    void closing(ActionEvent event) {
        display.setVisible(false);
        registration.clear();
    }

    @FXML
    void search(ActionEvent event) throws SQLException, ClassNotFoundException {
        frontstudent.setVisible(true);
        display.setVisible(true);
        String stuID = registration.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/result", "root", "");
            String sql = "SELECT * FROM cst2 WHERE  stuno=? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,stuID);
            resultSet1 = preparedStatement.executeQuery();

            if (resultSet1.next()) {
                number.setText(stuID);
                s1.setText("SystemAnalysisandDesign");
                String re1= resultSet1.getString("SystemAnalysisandDesign");
                r1.setText(re1);
                s2.setText("Programming");
                String re2= resultSet1.getString("Programming");
                r2.setText(re2);
                s3.setText("Network2");
                String re3= resultSet1.getString("Network2");
                r3.setText(re3);
                s4.setText("StaticalMethod");
                String re4= resultSet1.getString("StaticalMethod");
                r4.setText(re4);
                s5.setText("SoftwareEngineering");
                String re5= resultSet1.getString("SoftwareEngineering");
                r5.setText(re5);
                s6.setText("AestheticStudies");
                String re6= resultSet1.getString("AestheticStudies");
                r6.setText(re6);
                String re7= resultSet1.getString("gpa");
                gpa.setText(re7);
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/result", "root", "");
            String sqli = "SELECT * FROM iit2 WHERE  stuno=? ";
            preparedStatement = connection.prepareStatement(sqli);
            preparedStatement.setString(1,stuID);
            resultSet2 = preparedStatement.executeQuery();

            if (resultSet2.next()) {
                number.setText(stuID);
                s1.setText("SystemAnalysisandDesign");
                String re1= resultSet2.getString("SystemAnalysisandDesign");
                r1.setText(re1);
                s2.setText("SoftwareEngineering");
                String re2= resultSet2.getString("SoftwareEngineering");
                r2.setText(re2);
                s3.setText("Network2");
                String re3= resultSet2.getString("Network2");
                r3.setText(re3);
                s4.setText("Programming");
                String re4= resultSet2.getString("Programming");
                r4.setText(re4);
                s5.setText("FinancialAccounting");
                String re5= resultSet2.getString("FinancialAccounting");
                r5.setText(re5);
                s6.setText("AestheticStudies");
                String re6= resultSet2.getString("AestheticStudies");
                r6.setText(re6);
                String re7= resultSet2.getString("gpa");
                gpa.setText(re7);
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/result", "root", "");
            String sqlmrt = "SELECT * FROM mrt2 WHERE  stuno=? ";
            preparedStatement = connection.prepareStatement(sqlmrt);
            preparedStatement.setString(1,stuID);
            resultSet3 = preparedStatement.executeQuery();

            if (resultSet3.next()) {
                number.setText(stuID);
                s1.setText("PhysicalChemistry");
                String re1= resultSet3.getString("PhysicalChemistry");
                r1.setText(re1);
                s2.setText("ElectricityandMagnetisim");
                String re2= resultSet3.getString("ElectricityandMagnetisim");
                r2.setText(re2);
                s3.setText("Minerology");
                String re3= resultSet3.getString("Minerology");
                r3.setText(re3);
                s4.setText("Geology");
                String re4= resultSet3.getString("Geology");
                r4.setText(re4);
                s5.setText("Hydrology");
                String re5= resultSet3.getString("Hydrology");
                r5.setText(re5);
                s6.setText("AestheticStudies");
                String re6= resultSet3.getString("AestheticStudies");
                r6.setText(re6);
                String re7= resultSet3.getString("gpa");
                gpa.setText(re7);
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/result", "root", "");
            String sql3 = "SELECT * FROM sct2 WHERE  stuno=? ";
            preparedStatement = connection.prepareStatement(sql3);
            preparedStatement.setString(1,stuID);
            resultSet4 = preparedStatement.executeQuery();
            if (resultSet4.next()) {
                number.setText(stuID);
                s1.setText("MicroBiology");
                String re1= resultSet4.getString("MicroBiology");
                r1.setText(re1);

                s2.setText("PhysicalChemistry");
                String re2= resultSet4.getString("PhysicalChemistry");
                r2.setText(re2);
                s3.setText("AbstractAlgebra");
                String re3= resultSet4.getString("AbstractAlgebra");
                r3.setText(re3);
                s4.setText("StaticalMethod");
                String re4= resultSet4.getString("StaticalMethod");
                r4.setText(re4);
                s5.setText("Mechanics");
                String re5= resultSet4.getString("Mechanics");
                r5.setText(re5);
                s6.setText("BioChemistry");
                String re6= resultSet4.getString("BioChemistry");
                r6.setText(re6);
                String re7= resultSet4.getString("gpa");
                gpa.setText(re7);
            }
            else{
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Information Alert Dialog");
//                alert.setContentText("NO RECORDS FOUND");
//                alert.showAndWait();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}


