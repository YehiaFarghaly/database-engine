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
import sql.SQLTerm;
import storage.Page;
import storage.Tuple;
import util.PagePrinter;
import util.filecontroller.Serializer;
//import java.io.Serializable;
import java.util.Iterator;

public class GUI {
    private static TextArea outputArea;
    private TextField inputField;
    private static DBApp dbApp =new DBApp();



    public static void main(String[] args) throws DBAppException {
        dbApp.init();
        SQLTerm[] sqlTerms = new SQLTerm[2];
        sqlTerms[0] = new SQLTerm("malek", "gpa", "=", 3);
        sqlTerms[1] = new SQLTerm("malek", "id", ">", 1);
        String[] strArrOperator = new String[] { "AND" };
        Iterator pages =  dbApp.selectFromTable(sqlTerms, strArrOperator);
        while (pages !=null && pages.hasNext()){
            System.out.println((Tuple)pages.next());

        }
        System.out.println("--------------------");
//        launch(args);
//        Page page = Serializer.deserializePage("malek", "0");
//        PagePrinter p = new PagePrinter(page);
//        p.printPage();
        StringBuffer command = new StringBuffer("SELECT * FROM malek WHERE id = 1");
        Iterator pag = dbApp.parseSQL(command);
        while (pag !=null && pag.hasNext()){
            System.out.println(pag.next());;
        }
    }

//    @Override
//    public void start(Stage stage) throws Exception {
//        commandScene(stage);
//    }

    private void commandScene(Stage primaryStage){
        primaryStage.setTitle("SuperMalekDB");
        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setStyle("-fx-control-inner-background: black; -fx-text-fill: white;-fx-border-color: black;");
        outputArea.setMinHeight(300);
        inputField = new TextField();
        inputField.setMinHeight(30);
        inputField.setStyle("-fx-focus-color: black;-fx-control-inner-background: black");
        inputField.setOnAction(event -> {
            try {
                processInput();
            } catch (DBAppException e) {
                throw new RuntimeException(e);
            }
        });
        check(primaryStage);
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
        dbApp.init();

//        StringBuffer input = new StringBuffer(inputField.getText());
//        System.out.println(input);

    }
}
//checkstyle: off