package app;

import exceptions.DBAppException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import storage.Cell;
import storage.Tuple;

import java.util.ArrayList;
import java.util.Iterator;

public class GUI extends Application{
    private static TextArea outputArea;
    private TextField inputField;
    private static DBApp dbApp =new DBApp();

    @Override
    public void start(Stage stage) throws Exception {
        dbApp.init();
        commandScene(stage);
    }

    private void commandScene(Stage primaryStage){
        primaryStage.setTitle("SuperMalekDB");
        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setStyle("-fx-control-inner-background: black; -fx-text-fill: white;-fx-border-color: black;");
        outputArea.setMinHeight(300);
        outputArea.setFont(javafx.scene.text.Font.font("Monospaced", 12));
        inputField = new TextField();
        inputField.setMinHeight(30);
        inputField.setStyle("-fx-focus-color: black;-fx-control-inner-background: black");
        executeCommand(primaryStage);
    }

    private void executeCommand(Stage primaryStage) {
        check(primaryStage);
        inputField.setOnAction(event -> {
            try {
                processInput();
            } catch (DBAppException e) {
                outputArea.setText("Error in executing command: " + e.getLocalizedMessage());
                System.out.println("Error in executing command: " + e.getMessage());
                System.out.println("Error in executing command: " + e.getLocalizedMessage());
            } catch (RuntimeException e){
                e.printStackTrace();
            }
        });

    }

    public void check(Stage primaryStage){
        VBox vbox = new VBox(outputArea);
        vbox.setPadding(new Insets(10));
        vbox.setStyle("-fx-background-color: black;");
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: black;");
        root.setCenter(vbox);
        root.setBottom(inputField);
        BorderPane.setMargin(inputField, new Insets(10)); // Add margin to the input field
        BorderPane.setAlignment(inputField, javafx.geometry.Pos.BOTTOM_CENTER); // Align input field to the bottom center
        Scene scene = new Scene(root, 800, 500);
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void processInput() throws DBAppException {
        StringBuffer command = new StringBuffer(inputField.getText());
        Iterator pag;
        try {
            pag = dbApp.parseSQL(command);
        } catch (Exception e) {
            throw new DBAppException(e);
        }
        ArrayList<String> arrStr = new ArrayList<>();
        boolean first = true;
        while (pag != null && pag.hasNext()){
            Tuple t = (Tuple) pag.next();
            if (first){
                arrStr.add(concat(true, t));
                first = false;
            }
            arrStr.add(concat(false, t));
        }
        outputResults(arrStr);
    }

    private void outputResults(ArrayList<String> arrStr) {
        String results = "";
        results = computeResult(arrStr);
        results += "command executed successfully";
        outputArea.setText(results);
    }

    private String computeResult(ArrayList<String> arrStr) {
        String result = "";
        for (String s:arrStr) {
            result += s.substring(0, s.length()-2)+ "\n";
            result += newLine(s)+ "\n";
        }
        result += "\n\n";
        return result;
    }

    private String newLine(String s) {
        String result = "";
        for (int i =0; i < s.length(); i++) {
            result += ".";
        }
        return result;
    }

    private String concat(boolean flag, Tuple t){
        String s = "";
        for (Cell cell:t.getCells()) {
            s += calcStringLen((flag? cell.getKey():cell.getValue())+"");
        }
        return s;

    }

    private String calcStringLen(String s){
        String tmp = "";
        for (int i = 0; i < 15; i++) {
            if (i< s.length()) continue;
            tmp += " ";
        }
        s += tmp+ "| ";
        return s;
    }
}
