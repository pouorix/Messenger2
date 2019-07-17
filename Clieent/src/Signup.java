import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ResourceBundle;

public class Signup implements Initializable {
    @FXML
    TextField txtffirstname;
    @FXML
    TextField txtflastname;
    @FXML
    TextField txtfusername;
    @FXML
    TextField txtfpassword;
    @FXML
    TextField txtfemail;
    @FXML
    TextField txtfphonenumber;
    @FXML
    Button register;
    @FXML
    Text status;
    @FXML
    Button back;

    public static String email;
    public static String fisrtname ;
    public static String lastname ;
    public static String username ;
    public static String password;
    public static String phonenumber ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        register.setOnAction(event -> {
            fisrtname = txtffirstname.getText();
            lastname = txtflastname.getText();
            username = txtfusername.getText();
            password = txtfpassword.getText();
            email = txtfemail.getText();
            phonenumber = txtfphonenumber.getText();
             try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Email.fxml"))));

            } catch (Exception e) {
                e.printStackTrace();
            }

        });





        txtfemail.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if(ke.getCode().equals(KeyCode.ENTER)){
                    fisrtname = txtffirstname.getText();
                    lastname = txtflastname.getText();
                    username = txtfusername.getText();
                    password = txtfpassword.getText();
                    email = txtfemail.getText();
                    phonenumber = txtfphonenumber.getText();
                    try {
                        Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Email.fxml"))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

        back.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }
}
