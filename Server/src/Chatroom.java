import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Chatroom implements Initializable {
    public static String pm;
    @FXML
    TextField pminput;
    @FXML
    TextArea pms;
    @FXML
    Button send;
    @FXML
    Button info;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        info.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ouserinfo.fxml"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

send.setOnAction(event -> {


    new Thread(()->{

        try {
            pm=pminput.getText();
            Server.dataOutput.writeUTF(Login.username + ": "+  pm+"\n");
//            pms.setText(pm);
//            pms.setText(pm +"\n");
            pms.appendText("You : " + pm + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }).start();



});


        new Thread(()->{
            try {
                pm=pminput.getText();
//                pms.setText(Server.dataInput.readUTF()+"\n");
                pms.appendText(Server.dataInput.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
