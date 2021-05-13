package ro.upt.fis.sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ro.upt.fis.sample.model.Customer;
import ro.upt.fis.sample.model.Hotel;
import ro.upt.fis.sample.services.CustomerServices;
import ro.upt.fis.sample.services.HotelServices;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private TextField loginUsername;

    @FXML
    private Button loginButton;

    @FXML
    private Button loginSignUpButton;

    private HotelServices hotelServices = new HotelServices();
    private CustomerServices customerServices = new CustomerServices();

    @FXML
    void initialize() {
//        String loginText = loginUsername.getText();
//        String loginPwd = loginPassword.getText();

//        System.out.println(loginText + " " + loginPwd);

        loginButton.setOnAction(actionEvent -> {
            String loginText = loginUsername.getText();
            String loginPwd = loginPassword.getText();

            System.out.println(loginText + " " + loginPwd);

            if (!loginText.isEmpty() && !loginPwd.isEmpty()) {
                // init database
                CustomerServices.initDataBase();
                HotelServices.initDatabase();

                // execute login
                Customer customer = customerServices.getClient(loginText, loginPwd);
                Hotel hotel = hotelServices.getClient(loginText, loginPwd);
                if (hotel != null) {
                    System.out.println("hotel registered successfully: " + hotel.getEmail());
                } else if (customer != null) {
                    System.out.println("customer login was successful: " + customer.getEmail());
                } else {
                    System.out.println("ERROR LOGIN");
                }
            } else {
                System.out.println("INTRODUCE CREDENTIALS");
            }
        });

        loginSignUpButton.setOnAction(actionEvent -> {
            // take users to sign up screen
            loginSignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("/customerSignUp.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void loginUser(String userName, String password) {
        // check in the database if the user exists, if true
        // we take it to customerView screen
    }
}
