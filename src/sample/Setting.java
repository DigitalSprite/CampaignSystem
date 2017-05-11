package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

/**
 * Created by Stephen on 5/8/2017.
 */
public class Setting {
    protected boolean[][] HasPerson = new boolean[7][5];
    protected String[] NameText = new String[7];
    protected ArrayList<ArrayList<Label>> name = new ArrayList<ArrayList<Label>>();
    protected ArrayList<ArrayList<Label>> num = new ArrayList<ArrayList<Label>>();
    protected ArrayList<ArrayList<Button>> add = new ArrayList<ArrayList<Button>>();
    protected ArrayList<ArrayList<Button>> sub = new ArrayList<ArrayList<Button>>();

    protected void setVisible(int id, int row, boolean test){
        name.get(id).get(row).setVisible(test);
        num.get(id).get(row).setVisible(test);
        add.get(id).get(row).setVisible(test);
        sub.get(id).get(row).setVisible(test);
    }
}
