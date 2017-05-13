package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.security.auth.callback.LanguageCallback;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Stephen on 5/8/2017.
 */
public class ViceController extends Setting implements Initializable {
    @FXML
    private AnchorPane Area = new AnchorPane();
    @FXML
    private TextField Input = new TextField();
    @FXML
    private Button Confirm = new Button();
    @FXML
    private Button Delete = new Button();

    private Boolean[][] hasPerson = new Boolean[3][4];
    private String TempName = new String();

    public void initialize(URL fxmlFileLocation, ResourceBundle resources){
        for(int i = 0; i <= 2; i++){
            name.add(new ArrayList<Label>());
            num.add(new ArrayList<Label>());
            add.add(new ArrayList<Button>());
            sub.add(new ArrayList<Button>());
            add_against.add(new ArrayList<Button>());
            sub_against.add(new ArrayList<Button>());
            against.add(new ArrayList<Label>());
            for(int j = 0; j <= 3; j++){
                hasPerson[i][j] = false;
                name.get(i).add(new Label());
                num.get(i).add(new Label());
                add.get(i).add(new Button());
                sub.get(i).add(new Button());
                add_against.get(i).add(new Button());
                sub_against.get(i).add(new Button());
                against.get(i).add(new Label());
                Area.getChildren().add(name.get(i).get(j));
                Area.getChildren().add(num.get(i).get(j));
                Area.getChildren().add(add.get(i).get(j));
                Area.getChildren().add(sub.get(i).get(j));
                Area.getChildren().add(add_against.get(i).get(j));
                Area.getChildren().add(sub_against.get(i).get(j));
                Area.getChildren().add(against.get(i).get(j));
                setVisible(i, j, false);
            }
        }
        AddItemListener();
        AddPersonListener();
        DeletePersonListener();
    }

    private void AddItemListener(){
        Input.setOnKeyReleased(event -> {
            TempName = Input.getText();
        });
    }

    private void DeletePersonListener(){
        Delete.setOnAction(event -> {
            for(int i = 2; i >= 0; i--){
                boolean t = false;
                for(int j = 3;j >= 0; j--){
                    if (hasPerson[i][j] == true){
                        hasPerson[i][j] = false;
                        setVisible(i, j, false);
                        t = true;
                        break;
                    }
                }
                if(t == true)
                    break;
            }
        });
    }

    private void AddPersonListener(){
        Confirm.setOnAction(event -> {
            for(int i = 0; i <= 2; i++){
                boolean t = false;
                for(int j = 0; j <= 3; j++){
                    if (hasPerson[i][j] == false){
                        hasPerson[i][j] = true;
                        AddPerson(i, j);
                        t = true;
                        break;
                    }
                }
                if(t == true)
                    break;
            }
        });

    }

    private void AddPerson(int id, int row){
        setVisible(id, row, true);
        name.get(id).get(row).setText(TempName);
        name.get(id).get(row).setFont(Font.font("Microsoft YaHei", 28));
        name.get(id).get(row).setLayoutX(300 + 500 * id);
        name.get(id).get(row).setLayoutY(50 + row * 160);
        num.get(id).get(row).setText("0");
        num.get(id).get(row).setFont(Font.font("Microsoft YaHei Light", 32));
        num.get(id).get(row).setLayoutX(300 + 500 * id);
        num.get(id).get(row).setLayoutY(100 + row * 160);
        against.get(id).get(row).setText("0");
        against.get(id).get(row).setFont(Font.font("Microsoft YaHei Light", 32));
        against.get(id).get(row).setTextFill(Color.RED);
        against.get(id).get(row).setLayoutX(370 + 500 * id);
        against.get(id).get(row).setLayoutY(row * 160 + 100);
        add.get(id).get(row).setText("O");
        add.get(id).get(row).setLayoutX(450 + 500 * id);
        add.get(id).get(row).setLayoutY(50 + row * 160);
        add.get(id).get(row).setMinSize(45, 25);
        add.get(id).get(row).setFont(Font.font("Microsoft YaHei", 18));
        sub.get(id).get(row).setText("<-");
        sub.get(id).get(row).setMinSize(45, 25);
        sub.get(id).get(row).setLayoutX(450 + 500 * id);
        sub.get(id).get(row).setLayoutY(100 + row * 160 );
        sub_against.get(id).get(row).setLayoutX(520 + 500 * id);
        sub_against.get(id).get(row).setLayoutY(row * 160 + 100);
        sub_against.get(id).get(row).setText("<-");
        sub_against.get(id).get(row).setFont(Font.font("Microsoft YaHei", 16));
        sub_against.get(id).get(row).setMinSize(45, 25);
        add_against.get(id).get(row).setLayoutX(520 + 500 * id);
        add_against.get(id).get(row).setLayoutY(row * 160 + 50);
        add_against.get(id).get(row).setText("X");
        add_against.get(id).get(row).setFont(Font.font("Microsoft YaHei", 18));
        add_against.get(id).get(row).setMinSize(45, 25);
        sub.get(id).get(row).setFont(Font.font("Microsoft YaHei", 18));

        add.get(id).get(row).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int vote = Integer.parseInt(num.get(id).get(row).getText());
                num.get(id).get(row).setText(Integer.toString(++vote));
            }
        });
        sub.get(id).get(row).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int vote = Integer.parseInt(num.get(id).get(row).getText());
                num.get(id).get(row).setText(Integer.toString(--vote));
            }
        });
        add_against.get(id).get(row).setOnAction(event -> {
            int vote = Integer.parseInt(against.get(id).get(row).getText());
            against.get(id).get(row).setText(Integer.toString(++vote));
        });
        sub_against.get(id).get(row).setOnAction(event -> {
            int vote = Integer.parseInt(against.get(id).get(row).getText());
            against.get(id).get(row).setText(Integer.toString(--vote));
        });
    }
}
