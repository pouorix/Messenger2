import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchANDHistory implements Initializable {
    @FXML
    TextField userinput;
    @FXML
    Button next;
    @FXML
    Text status;
    @FXML
    Button setting;
    @FXML
    TextField history;
    @FXML
    Button nexthistory;

    public static String username;
    public static String opsearchusername;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setting.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Setting.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });





        next.setOnAction(event -> {

            try {
              username =userinput.getText();
                int boolian=0;
                PersonDB personDB=new PersonDB();

//
//            for (int i = 0; i <personDB.getPersonsusername().size() ; i++) {
//                System.out.println(personDB.getPersonsusername().get(i));
//            }
//

                for (int i = 0; i <personDB.getPersonsusername().size() ; i++) {

                    if (username.equals(personDB.getPersonsusername().get(i))) {
                        status.setText("Username  Found !");
                        boolian = 1;
                       // Thread.sleep(1000);
                      //  Server.dataOutput.writeUTF(username);

                        lonDB londb=new lonDB();
                        londb.changess(username);
//                        new Thread(()-> {
//                            try {
                             //   opsearchusername = Server.dataInput.readUTF();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }).start();

                        Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Chatroom.fxml"))));

                    }
                }
                if(boolian==0)
                    status.setText("Username Not Found");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
