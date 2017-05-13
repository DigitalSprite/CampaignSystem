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

import javax.jnlp.IntegrationService;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller extends Setting implements Initializable{
    @FXML
    AnchorPane TotalArea = new AnchorPane();
    @FXML
    private Button Add1 = new Button();
    @FXML
    private  Button Sub1 = new Button();
    @FXML
    private TextField Text1 = new TextField();
    @FXML
    private Button Add2 = new Button();
    @FXML
    private  Button Sub2 = new Button();
    @FXML
    private TextField Text2 = new TextField();
    @FXML
    private Button Add3 = new Button();
    @FXML
    private  Button Sub3 = new Button();
    @FXML
    private TextField Text3 = new TextField();
    @FXML
    private Button Add4 = new Button();
    @FXML
    private  Button Sub4 = new Button();
    @FXML
    private TextField Text4 = new TextField();
    @FXML
    private Button Add5 = new Button();
    @FXML
    private  Button Sub5 = new Button();
    @FXML
    private TextField Text5 = new TextField();
    @FXML
    private Button Add6 = new Button();
    @FXML
    private  Button Sub6 = new Button();
    @FXML
    private TextField Text6 = new TextField();
    @FXML
    private Button Add7 = new Button();
    @FXML
    private  Button Sub7 = new Button();
    @FXML
    private TextField Text7 = new TextField();

    //事件侦听
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources){
        for(int i = 0; i <= 6; i++){
            name.add(new ArrayList<Label>());
            num.add(new ArrayList<Label>());
            add.add(new ArrayList<Button>());
            sub.add(new ArrayList<Button>());
            add_against.add(new ArrayList<Button>());
            sub_against.add(new ArrayList<Button>());
            against.add(new ArrayList<Label>());
            for(int j = 0; j <= 4; j++){
                HasPerson[i][j] = false;
                name.get(i).add(new Label());
                num.get(i).add(new Label());
                add.get(i).add(new Button());
                sub.get(i).add(new Button());
                add_against.get(i).add(new Button());
                sub_against.get(i).add(new Button());
                against.get(i).add(new Label());
                TotalArea.getChildren().add(name.get(i).get(j));
                TotalArea.getChildren().add(num.get(i).get(j));
                TotalArea.getChildren().add(add.get(i).get(j));
                TotalArea.getChildren().add(sub.get(i).get(j));
                TotalArea.getChildren().add(add_against.get(i).get(j));
                TotalArea.getChildren().add(sub_against.get(i).get(j));
                TotalArea.getChildren().add(against.get(i).get(j));
                setVisible(i, j, false);
            }
        }
        TextFieldListener(Text1);
        TextFieldListener(Text2);
        TextFieldListener(Text3);
        TextFieldListener(Text4);
        TextFieldListener(Text5);
        TextFieldListener(Text6);
        TextFieldListener(Text7);
        AddPersonListener(Add1);
        AddPersonListener(Add2);
        AddPersonListener(Add3);
        AddPersonListener(Add4);
        AddPersonListener(Add5);
        AddPersonListener(Add6);
        AddPersonListener(Add7);
        DeletePersonListener(Sub1);
        DeletePersonListener(Sub2);
        DeletePersonListener(Sub3);
        DeletePersonListener(Sub4);
        DeletePersonListener(Sub5);
        DeletePersonListener(Sub6);
        DeletePersonListener(Sub7);
    }
    protected void AddPersonListener(Button temp){
        temp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int ID = Integer.parseInt(temp.getId().substring(3)) - 1;
                for (int i = 0; i <= 4; i++){
                    if(HasPerson[ID][i] == false){
                        HasPerson[ID][i] = true;
                        AddPerson(ID, i);
                        break;
                    }
                }
            }
        });
    }

    private void TextFieldListener(TextField temp){
        temp.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                int ID = Integer.parseInt(temp.getId().substring(4)) - 1;
                NameText[ID] = temp.getText();
            }
        });
    }

    private void DeletePersonListener(Button temp){
        temp.setOnAction(event -> {
            int ID = Integer.parseInt(temp.getId().substring(3)) - 1;
            for (int i = 4; i >= 0; i--){
                if(HasPerson[ID][i] == true){
                    HasPerson[ID][i] = false;
                    setVisible(ID, i, false);
                    break;
                }
            }
        });
    }

    private void AddPerson(int id, int row){
        setVisible(id, row, true);
        name.get(id).get(row).setText(NameText[id]);
        name.get(id).get(row).setFont(Font.font("Microsoft YaHei", 28));
        name.get(id).get(row).setLayoutX(20 + 280 * id);
        name.get(id).get(row).setLayoutY(row * 120 + 100);
        num.get(id).get(row).setText("0");
        num.get(id).get(row).setFont(Font.font("Microsoft YaHei Light", 32));
        num.get(id).get(row).setLayoutX(30 + 280 * id);
        num.get(id).get(row).setLayoutY(row * 120 + 150);
        against.get(id).get(row).setText("0");
        against.get(id).get(row).setFont(Font.font("Microsoft YaHei Light", 32));
        against.get(id).get(row).setTextFill(Color.RED);
        against.get(id).get(row).setLayoutX(90 + 280 * id);
        against.get(id).get(row).setLayoutY(row * 120 + 150);
        add.get(id).get(row).setText("O");
        add.get(id).get(row).setLayoutX(140 + 280 * id);
        add.get(id).get(row).setLayoutY(row * 120 + 105);
        add.get(id).get(row).setMinSize(35, 25);
        add.get(id).get(row).setFont(Font.font("Microsoft YaHei", 18));
        sub.get(id).get(row).setText("<-");
        sub.get(id).get(row).setMinSize(35, 25);
        sub.get(id).get(row).setLayoutX(140 + 280 * id);
        sub.get(id).get(row).setLayoutY(row * 120 + 150);
        sub.get(id).get(row).setFont(Font.font("Microsoft YaHei", 16));
        sub_against.get(id).get(row).setLayoutX(190 + 280 * id);
        sub_against.get(id).get(row).setLayoutY(row * 120 + 150);
        sub_against.get(id).get(row).setText("<-");
        sub_against.get(id).get(row).setFont(Font.font("Microsoft YaHei", 16));
        sub_against.get(id).get(row).setMinSize(35, 25);
        add_against.get(id).get(row).setLayoutX(190 + 280 * id);
        add_against.get(id).get(row).setLayoutY(row * 120 + 105);
        add_against.get(id).get(row).setText("X");
        add_against.get(id).get(row).setFont(Font.font("Microsoft YaHei", 18));
        add_against.get(id).get(row).setMinSize(35, 25);
        add.get(id).get(row).setOnAction(event -> {
            int vote = Integer.parseInt(num.get(id).get(row).getText());
            num.get(id).get(row).setText(Integer.toString(++vote));
        });
        sub.get(id).get(row).setOnAction(event -> {
            int vote = Integer.parseInt(num.get(id).get(row).getText());
            num.get(id).get(row).setText(Integer.toString(--vote));
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
