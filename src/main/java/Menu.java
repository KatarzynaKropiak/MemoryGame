import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Menu extends Application {


    private Image imageback = new Image("file:src/main/resources/Mapa1.jpg");
    private Image imageback1 = new Image("file:src/main/resources/Mapa3.jpg");
    private Image card1 = new Image("file:src/main/resources/flags/australia.png");
    private Image card2 = new Image("file:src/main/resources/flags/japan.png");
    private Image card3 = new Image("file:src/main/resources/flags/germany.png");
    private Image card4 = new Image("file:src/main/resources/flags/madagascar.png");
    private Image card5 = new Image("file:src/main/resources/flags/peru.png");
    private Image card6 = new Image("file:src/main/resources/flags/usa.png");
    private Image backside = new Image("file:src/main/resources/flags/backside.png");


    private static final int NUM_OF_PAIRS = 6;
    private static final int NUM_PER_ROW = 3;

    public Flag selected = null;

    public Stage primaryStage;

    public static final int getNUM_OF_PAIRS() {
        return NUM_OF_PAIRS;
    }


    private Parent createContentFlag() {

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, false, true, false);
        BackgroundFill backgroundFill = new BackgroundFill(Color.BLACK, null, null);
        BackgroundImage backgroundImage = new BackgroundImage(imageback1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        BackgroundImage[] bi = new BackgroundImage[1];
        bi[0] = backgroundImage;
        BackgroundFill[] bf = new BackgroundFill[1];
        bf[0] = backgroundFill;
        Background background = new Background(bf, bi);


        GridPane root = new GridPane();
        root.setPrefSize(700, 500);
        root.setBackground(background);
        root.setAlignment(Pos.TOP_LEFT);


        List<Flag> flags = new ArrayList<>();
        flags.add(new Flag(card1, this));
        flags.add(new Flag(card2, this));
        flags.add(new Flag(card3, this));
        flags.add(new Flag(card4, this));
        flags.add(new Flag(card5, this));
        flags.add(new Flag(card6, this));
        flags.add(new Flag(card1, this));
        flags.add(new Flag(card2, this));
        flags.add(new Flag(card3, this));
        flags.add(new Flag(card4, this));
        flags.add(new Flag(card5, this));
        flags.add(new Flag(card6, this));


        Collections.shuffle(flags);
        for (int i = 0; i < flags.size(); i++) {
            Flag flag = flags.get(i);
            flag.setTranslateX(110 + 160 * (i % NUM_PER_ROW));
            flag.setTranslateY(30 + 110 * (i / NUM_PER_ROW));
            root.getChildren().add(flag);
        }

        return root;
    }

    public Parent createEnd() {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, false, true, false);
        BackgroundFill backgroundFill = new BackgroundFill(Color.BLACK, null, null);
        BackgroundImage backgroundImage = new BackgroundImage(imageback1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        BackgroundImage[] bi = new BackgroundImage[1];
        bi[0] = backgroundImage;
        BackgroundFill[] bf = new BackgroundFill[1];
        bf[0] = backgroundFill;
        Background background = new Background(bf, bi);

        GridPane root = new GridPane();
        root.setPrefSize(700, 500);
        root.setBackground(background);
        root.setAlignment(Pos.CENTER);

        RowConstraints row1 = new RowConstraints(100);
        root.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints(50);
        root.getRowConstraints().add(row2);


        Button newbtn1 = new Button();
        newbtn1.setText("NEW GAME");
        newbtn1.setMinWidth(200);
        newbtn1.setStyle("  -fx-font-size: 2em; -fx-background-color: STEELBLUE;  -fx-text-fill: BLACK; -fx-border-color: BLACK; ");

        newbtn1.setOnAction((e) -> {
            game();
        });
        root.add(newbtn1, 3, 0);

        Button newbtn2 = new Button();
        newbtn2.setText("EXIT");
        newbtn2.setMinWidth(200);
        newbtn2.setStyle("  -fx-font-size: 2em; -fx-background-color: STEELBLUE;  -fx-text-fill: BLACK; -fx-border-color: BLACK; ");

        newbtn2.setOnAction((e) -> {
           close();
        });
        root.add(newbtn2, 3, 1);

        return root;
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage1)  throws Exception {

        primaryStage = primaryStage1;

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);


        GridPane grid = new GridPane();

        RowConstraints row1 = new RowConstraints(100);
        grid.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints(50);
        grid.getRowConstraints().add(row2);


        grid.setBackground(background);
        grid.setAlignment(Pos.CENTER);


        Scene scene = new Scene(grid, 700, 500, Color.BLACK);

        Button newbtn1 = new Button();
        newbtn1.setText("NEW GAME");
        newbtn1.setMinWidth(250);
        newbtn1.setStyle("  -fx-font-size: 2em; -fx-background-color: MIDNIGHTBLUE;  -fx-text-fill: LIGHTSKYBLUE; -fx-border-color: LIGHTSKYBLUE; ");

        newbtn1.setOnAction((e) -> {
            game();
        });

        grid.add(newbtn1, 3, 0);


        Button newbtn2 = new Button();
        newbtn2.setText("SCOREBOARD");
        newbtn2.setMinWidth(250);
        newbtn2.setStyle("; -fx-font-size: 2em; -fx-background-color: MIDNIGHTBLUE;  -fx-text-fill: LIGHTSKYBLUE; -fx-border-color: LIGHTSKYBLUE; ");
        grid.add(newbtn2, 3, 1);

        primaryStage1.setTitle("Memory cards");
        primaryStage1.setScene(scene);
        primaryStage1.show();

    }


    public void game() {
        primaryStage.setScene(new Scene(createContentFlag()));

        primaryStage.show();

    }

    public void theLastBoard() {

        primaryStage.setScene(new Scene(createEnd()));
        primaryStage.show();
    }

    public void close() {
        primaryStage.close();
    }
}




