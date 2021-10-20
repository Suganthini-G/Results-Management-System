package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.logging.Level;


public class Controller{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label logstatuslbl;

    @FXML
    private TextField userlbl;

    @FXML
    private PasswordField passlbl;

    @FXML
    private Button logbtn;

    Connection connection;
    PreparedStatement preparedStatement;
    PreparedStatement preparedStatement2;
    ResultSet resultSet;
    ResultSet resultSet2;

    @FXML
    void loginAction(ActionEvent event) throws Exception{

        String username = userlbl.getText();
        String password = passlbl.getText();

        if(username.equals("") || password.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Waring Alert Dialog");
            alert.setContentText("Error! Empty field");
            alert.showAndWait();
        }
        else
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/result", "root", "");

                    preparedStatement = connection.prepareStatement("select * from admin where username=? and password=?");
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    resultSet = preparedStatement.executeQuery();

                    preparedStatement2 = connection.prepareStatement("select username,password from data_encoder where username=? and password=?");
                    preparedStatement2.setString(1, username);
                    preparedStatement2.setString(2, password);
                    resultSet2 = preparedStatement2.executeQuery();


                    if (resultSet.next()) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Alert Dialog");
                        alert.setContentText("Login success");
                        alert.showAndWait();
                        logbtn.getScene().getWindow().hide();

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
                        Stage stage = new Stage();
                        stage.setScene(new Scene(loader.load()));
                        stage.setTitle("Admin view");

                        admin Admin = loader.getController();
                        Admin.Details(username);
                        stage.show();
                    }

                    else if (resultSet2.next()){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Alert Dialog");
                        alert.setContentText("Login success");
                        alert.showAndWait();
                        logbtn.getScene().getWindow().hide();

                        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("dataEncoder.fxml"));
                        Stage stage1 = new Stage();
                        stage1.setScene(new Scene(loader1.load()));
                        stage1.setTitle("Data encoder view");

                        dataEncoder dataencoder = loader1.getController();
                        dataencoder.Details1(username);
                        stage1.show();
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Waring Alert Dialog");
                        alert.setContentText("Invalid login please try again");
                        alert.showAndWait();
                        userlbl.setText("");
                        passlbl.setText("");
                    }
            }

            catch(ClassNotFoundException e)
            {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @FXML
    void initialize() {

    }
}
