import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.*;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Menu extends Application {


    private Image imageback = new Image("file:src/main/resources/Mapa1.jpg");
    private Image imageback1 = new Image("file:src/main/resources/Mapa3.jpg");
    private Image card1 = new Image("file:src/main/resources/flags/australia.png");
    private Image card2 = new Image("file:src/main/resources/flags/japan.png");
    private Image card3 = new Image("file:src/main/resources/flags/germany.png");
    private Image card4 = new Image("file:src/main/resources/flags/madagascar.png");
    private Image card5 = new Image("file:src/main/resources/flags/brazil.png");
    private Image card6 = new Image("file:src/main/resources/flags/usa.png");
    private Image card01 = new Image("file:src/main/resources/names/australia_name.png");
    private Image card02 = new Image("file:src/main/resources/names/japan_name.png");
    private Image card03 = new Image("file:src/main/resources/names/germany_name.png");
    private Image card04 = new Image("file:src/main/resources/names/madagascar_name.png");
    private Image card05 = new Image("file:src/main/resources/names/brazil_name.png");
    private Image card06 = new Image("file:src/main/resources/names/usa_name.png");


    private static final int NUM_OF_PAIRS = 6;
    private static final int NUM_PER_ROW = 3;

    public Flag selected = null;
    private LocalTime startTime;
    private LocalTime endTime;
    private long playerScore;
    HashMap<String,Long> scoreFlag = new HashMap<>();;
    File savedHashMaps;


    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Stage primaryStage;

    public static final int getNUM_OF_PAIRS() {
        return NUM_OF_PAIRS;
    }

    private Parent createContentFlag() {


        GridPane root = new GridPane();
        root.setPrefSize(700, 500);
        root.setBackground(createBackground());
        root.setAlignment(Pos.TOP_LEFT);

        savedHashMaps = new File("Rankingi.list");
        scoreFlag.clear();
        loadMap();
        startTime = LocalTime.now();
        System.out.print("Start time: " + startTime);

        List<Flag> flags = new ArrayList<>();
        flags.add(new Flag(card1, this, "pair1"));
        flags.add(new Flag(card2, this, "pair2"));
        flags.add(new Flag(card3, this, "pair3"));
        flags.add(new Flag(card4, this, "pair4"));
        flags.add(new Flag(card5, this, "pair5"));
        flags.add(new Flag(card6, this, "pair6"));
        flags.add(new Flag(card1, this, "pair1"));
        flags.add(new Flag(card2, this, "pair2"));
        flags.add(new Flag(card3, this, "pair3"));
        flags.add(new Flag(card4, this, "pair4"));
        flags.add(new Flag(card5, this, "pair5"));
        flags.add(new Flag(card6, this, "pair6"));


        Collections.shuffle(flags);
        for (int i = 0; i < flags.size(); i++) {
            Flag flag = flags.get(i);
            flag.setTranslateX(110 + 160 * (i % NUM_PER_ROW));
            flag.setTranslateY(30 + 110 * (i / NUM_PER_ROW));
            root.getChildren().add(flag);
        }

        return root;
    }

    private Parent createContentNameFlag() {

        GridPane root = new GridPane();
        root.setPrefSize(700, 500);
        root.setBackground(createBackground());
        root.setAlignment(Pos.TOP_LEFT);

        savedHashMaps = new File("RankingiNF.list");
        scoreFlag.clear();
        loadMap();
        startTime = LocalTime.now();
        System.out.print("Start time: " + startTime);

        List<Flag> flags = new ArrayList<>();
        flags.add(new Flag(card1, this, "pair1"));
        flags.add(new Flag(card2, this, "pair2"));
        flags.add(new Flag(card3, this, "pair3"));
        flags.add(new Flag(card4, this, "pair4"));
        flags.add(new Flag(card5, this, "pair5"));
        flags.add(new Flag(card6, this, "pair6"));
        flags.add(new Flag(card01, this, "pair1"));
        flags.add(new Flag(card02, this, "pair2"));
        flags.add(new Flag(card03, this, "pair3"));
        flags.add(new Flag(card04, this, "pair4"));
        flags.add(new Flag(card05, this, "pair5"));
        flags.add(new Flag(card06, this, "pair6"));


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

        GridPane root = new GridPane();
        root.setPrefSize(700, 500);
        root.setBackground(createBackground());
        root.setAlignment(Pos.CENTER);
//        root.setGridLinesVisible(true);

        ColumnConstraints col0 = new ColumnConstraints(50);
        root.getColumnConstraints().add(col0);

        ColumnConstraints col1 = new ColumnConstraints(100);
        root.getColumnConstraints().add(col1);

        ColumnConstraints col2 = new ColumnConstraints(50);
        root.getColumnConstraints().add(col2);

        ColumnConstraints col3 = new ColumnConstraints(100);
        root.getColumnConstraints().add(col3);


        RowConstraints row1 = new RowConstraints(100);
        root.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints(50);
        root.getRowConstraints().add(row2);

        RowConstraints row3 = new RowConstraints(50);
        root.getRowConstraints().add(row3);

        RowConstraints row4 = new RowConstraints(100);
        root.getRowConstraints().add(row4);


        Button newbtnS = new Button();
        newbtnS.setText(getScoreAsString());
        newbtnS.setMinWidth(300);
        newbtnS.setMinHeight(75);
        newbtnS.setStyle("-fx-font-size: 2.5em; -fx-font-weight: BOLD; -fx-background-color: BLACK;  -fx-text-fill: STEELBLUE; -fx-border-color: STEELBLUE; ");

        root.add(newbtnS, 0, 0);

        Button newbtn1 = new Button();
        newbtn1.setText("SAVE");
        newbtn1.setMinWidth(200);
        newbtn1.setStyle("-fx-font-size: 2em; -fx-background-color: STEELBLUE;  -fx-text-fill: BLACK; -fx-border-color: BLACK;");

        newbtn1.setOnAction((e) -> {
            setName();
        });
        root.add(newbtn1, 1, 2);

        Button newbtn2 = new Button();
        newbtn2.setText("NEW GAME");
        newbtn2.setMinWidth(200);
        newbtn2.setStyle("-fx-font-size: 2em; -fx-background-color: STEELBLUE;  -fx-text-fill: BLACK; -fx-border-color: BLACK;");

        newbtn2.setOnAction((e) -> {
            chooseLvl("game");
        });
        root.add(newbtn2, 1, 3);

        Button newbtn3 = new Button();
        newbtn3.setText("EXIT");
        newbtn3.setMinWidth(200);
        newbtn3.setStyle("  -fx-font-size: 2em; -fx-background-color: STEELBLUE;  -fx-text-fill: BLACK; -fx-border-color: BLACK; ");

        newbtn3.setOnAction((e) -> {
            close();
        });
        root.add(newbtn3, 1, 4);

        return root;
    }
    public Parent chooseGameOrBoard(String gameOrBoard) {

        GridPane root = new GridPane();
        root.setPrefSize(700, 500);
        root.setBackground(createBackground());
        root.setAlignment(Pos.CENTER);
        //   root.setGridLinesVisible(true);

        ColumnConstraints col1 = new ColumnConstraints(50);
        root.getColumnConstraints().add(col1);

        ColumnConstraints col2 = new ColumnConstraints(100);
        root.getColumnConstraints().add(col2);

        ColumnConstraints col3 = new ColumnConstraints(100);
        root.getColumnConstraints().add(col3);

        ColumnConstraints col4 = new ColumnConstraints(50);
        root.getColumnConstraints().add(col4);

        RowConstraints row1 = new RowConstraints(100);
        root.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints(100);
        root.getRowConstraints().add(row2);

        final Label label = new Label("CHOOSE GAME:");
        label.setAlignment(Pos.CENTER);
        label.setMinWidth(200);
        label.setMinHeight(50);
        label.setStyle("-fx-font-size: 2em; -fx-font-weight: BOLD; -fx-background-color: BLACK;  -fx-text-fill: STEELBLUE; -fx-border-color: STEELBLUE");

        root.add(label, 1,0);

        Button newbtn1 = new Button();
        newbtn1.setText("FLAG - NAME");
        newbtn1.setMinWidth(200);
        newbtn1.setStyle("-fx-font-size: 2em; -fx-background-color: STEELBLUE;  -fx-text-fill: BLACK; -fx-border-color: BLACK;");

        root.add(newbtn1, 1,1);

        if (gameOrBoard.equals("game")) {
            newbtn1.setOnAction((e) -> {
                gameNF();
            });
        } else {
            newbtn1.setOnAction((e) -> {
                theScoreBoard("NF");
            });
        }
            Button newbtn2 = new Button();
            newbtn2.setText("FLAG - FLAG");
            newbtn2.setMinWidth(200);
            newbtn2.setStyle("-fx-font-size: 2em; -fx-background-color: STEELBLUE;  -fx-text-fill: BLACK; -fx-border-color: BLACK;");

            root.add(newbtn2, 1,2);

        if (gameOrBoard.equals("game")) {
            newbtn2.setOnAction((e) -> {
                game();
            });
        } else {
            newbtn2.setOnAction((e) -> {
                theScoreBoard("FF");
            });
        }

        return root;
    }

    public Parent createName() {

        GridPane root = new GridPane();
        root.setPrefSize(700, 500);
        root.setBackground(createBackground());
        root.setAlignment(Pos.CENTER);
     //   root.setGridLinesVisible(true);

        ColumnConstraints col1 = new ColumnConstraints(50);
        root.getColumnConstraints().add(col1);

        ColumnConstraints col2 = new ColumnConstraints(100);
        root.getColumnConstraints().add(col2);

        ColumnConstraints col3 = new ColumnConstraints(100);
        root.getColumnConstraints().add(col3);

        ColumnConstraints col4 = new ColumnConstraints(50);
        root.getColumnConstraints().add(col4);


        RowConstraints row1 = new RowConstraints(100);
        root.getRowConstraints().add(row1);

        TextField txtFld = new TextField ();
        txtFld.setPromptText("Enter your name...");
        txtFld.setAlignment(Pos.CENTER);
        txtFld.setMinWidth(200);
        txtFld.setStyle("-fx-font-size: 2em; -fx-background-color: STEELBLUE;  -fx-text-fill: BLACK; -fx-border-color: BLACK;");


        root.add(txtFld, 1,0);

        Button newbtn1 = new Button();
        newbtn1.setText("SAVE");
        newbtn1.setMinWidth(200);
        newbtn1.setStyle("-fx-font-size: 2em; -fx-background-color: STEELBLUE;  -fx-text-fill: BLACK; -fx-border-color: BLACK;");

        root.add(newbtn1, 1,1);


        if ("Rankingi.list".equals(savedHashMaps.getName())) {
            newbtn1.setOnAction((e) -> {
                saveResult(txtFld.getText(), playerScore);
                saveMap();
                theScoreBoard("FF");
            });
        } else if ("RankingiNF.list".equals(savedHashMaps.getName())) {
            newbtn1.setOnAction((e) -> {
                saveResult(txtFld.getText(), playerScore);
                saveMap();
                theScoreBoard("NF");
            });
        }
        return root;
    }

    public Parent createScoreBoard(String gameType) {

        GridPane root = new GridPane();
        root.setPrefSize(700, 500);
        root.setBackground(createBackground());
        root.setAlignment(Pos.CENTER);

        if (gameType.equals("FF")){
            savedHashMaps = new File("Rankingi.list");
        } else if (gameType.equals("NF")){
            savedHashMaps = new File("RankingiNF.list");
        }
        loadMap();
        scoreFlag.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(entry->{
                    System.out.println(entry.getKey() + " " + entry.getValue());
        });

        final Label label = new Label("LEADER BOARD");
        label.setAlignment(Pos.CENTER);
        label.setMinWidth(268);
        label.setMinHeight(43);
        label.setStyle("-fx-font-size: 2em; -fx-font-weight: BOLD; -fx-background-color: BLACK;  -fx-text-fill: STEELBLUE; -fx-border-color: STEELBLUE");

        TableView table = new TableView();
        table.setEditable(false);

       // table.setStyle(" -fx-font-size: 1em; -fx-border-color: BLACK; -fx-background-color: STEELBLUE;  -fx-text-fill: BLACK; ");

        TableColumn posCol = new TableColumn("No.");
        posCol.setStyle(" -fx-font-size: 1em; -fx-border-color: BLACK; -fx-background-color: LIGHTSTEELBLUE; -fx-font-weight: BOLD; -fx-text-fill: BLACK; -fx-alignment: center");
        posCol.setMinWidth(43);
        posCol.setCellValueFactory(new PropertyValueFactory<>("pos"));
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setStyle(" -fx-font-size: 1em; -fx-border-color: BLACK; -fx-background-color: LIGHTSTEELBLUE; -fx-text-fill: BLACK; -fx-alignment: center");
        nameCol.setMinWidth(112);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn scoreCol = new TableColumn("Score");
        scoreCol.setStyle(" -fx-font-size: 1em; -fx-border-color: BLACK; -fx-background-color: LIGHTSTEELBLUE; -fx-text-fill: BLACK; -fx-alignment: center");
        scoreCol.setMinWidth(112);
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));


        table.getColumns().addAll(posCol, nameCol, scoreCol);

        AtomicInteger counter = new AtomicInteger(1);
        scoreFlag.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(15).forEach(entry->{
            LeaderBoardRow row1 = new LeaderBoardRow(counter.getAndIncrement(),entry.getKey(), convertScoreToString(entry.getValue()));
            table.getItems().add(row1);

        });
        final VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(0, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        root.getChildren().addAll(vbox);


        Button newbtn1 = new Button();
        newbtn1.setText("EXIT");
        newbtn1.setMinHeight(30);
        newbtn1.setMinWidth(150);
        newbtn1.setStyle("  -fx-font-size: 1.5em; -fx-font-weight: BOLD; -fx-background-color: BLACK;  -fx-text-fill: STEELBLUE; -fx-border-color: STEELBLUE; ");

        newbtn1.setOnAction((e) -> {
            close();
        });
        root.add(newbtn1, 0, 0);

        Button newbtn2 = new Button();
        newbtn2.setText("NEW GAME");
        newbtn2.setMinHeight(30);
        newbtn2.setMinWidth(150);
        newbtn2.setStyle("  -fx-font-size: 1.5em; -fx-font-weight: BOLD; -fx-background-color: BLACK;  -fx-text-fill: STEELBLUE; -fx-border-color: STEELBLUE; ");

        newbtn2.setOnAction((e) -> {
            chooseLvl("game");
        });
        root.add(newbtn2, 0, 0);

        final HBox hbox = new HBox();
        hbox.setSpacing(50);
        hbox.setPadding(new Insets(20, 10, 10, 10));
        hbox.getChildren().addAll(newbtn1, vbox, newbtn2);

        root.getChildren().addAll(hbox);

        return root;
    }

        public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage1)  {

        primaryStage = primaryStage1;

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();

        RowConstraints row1 = new RowConstraints(50);
        grid.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints(100);
        grid.getRowConstraints().add(row2);

        grid.setBackground(background);
        grid.setAlignment(Pos.CENTER);

        Scene scene = new Scene(grid, 700, 500, Color.BLACK);

        Button newbtn1 = new Button();
        newbtn1.setText("NEW GAME");
        newbtn1.setMinWidth(250);
        newbtn1.setStyle("-fx-font-size: 2em; -fx-background-color: MIDNIGHTBLUE;  -fx-text-fill: LIGHTSKYBLUE; -fx-border-color: LIGHTSKYBLUE; ");

        newbtn1.setOnAction((e) -> {
            chooseLvl("game");
        });

        grid.add(newbtn1, 3, 0);

        Button newbtn2 = new Button();
        newbtn2.setText("SCOREBOARD");
        newbtn2.setMinWidth(250);
        newbtn2.setStyle("-fx-font-size: 2em; -fx-background-color: MIDNIGHTBLUE;  -fx-text-fill: LIGHTSKYBLUE; -fx-border-color: LIGHTSKYBLUE; ");
        grid.add(newbtn2, 3, 1);

        newbtn2.setOnAction((e) -> {
                chooseLvl("score");
        });

        primaryStage1.setTitle("Memory cards");
        primaryStage1.setScene(scene);
        primaryStage1.show();
    }

    public Background createBackground()  {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, false, true, false);
        BackgroundFill backgroundFill = new BackgroundFill(Color.BLACK, null, null);
        BackgroundImage backgroundImage = new BackgroundImage(imageback1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        BackgroundImage[] bi = new BackgroundImage[1];
        bi[0] = backgroundImage;
        BackgroundFill[] bf = new BackgroundFill[1];
        bf[0] = backgroundFill;
        Background background = new Background(bf, bi);

        return background;
    }

    public void game() {

        primaryStage.setScene(new Scene(createContentFlag()));
        primaryStage.show();
    }

    public void gameNF() {

        primaryStage.setScene(new Scene(createContentNameFlag()));
        primaryStage.show();
    }

    public void chooseLvl(String gameOrBoard) {

        primaryStage.setScene(new Scene(chooseGameOrBoard(gameOrBoard)));
        primaryStage.show();
    }

    public void setName() {

        primaryStage.setScene(new Scene(createName()));
        primaryStage.show();
    }

    public void theLastBoard() {

        primaryStage.setScene(new Scene(createEnd()));
        primaryStage.show();
    }

    public void theScoreBoard(String gameType) {

        primaryStage.setScene(new Scene(createScoreBoard(gameType)));
        primaryStage.show();
    }

    public double setPlayerScore() {
        playerScore = java.time.Duration.between(startTime, endTime).toMillis();
        return playerScore;
    }

    public String getScoreAsString() {
        return "SCORE: " + playerScore/ 60000 + ":" + playerScore/ 1000 + "." + playerScore% 1000;
    }

    public String convertScoreToString(long score) {
        return score/ 60000 + ":" + score/ 1000 + "." + score% 1000;
    }

   public void saveResult(String name, long playerScore) {
    scoreFlag.put(name, playerScore);
    }

   public void saveMap() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(savedHashMaps));
            oos.writeObject(scoreFlag);
            oos.close();
        } catch (Exception e) {
        }
    }

    public void loadMap() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedHashMaps));
            Object readMap = ois.readObject();
            if(readMap instanceof HashMap) {
                scoreFlag.putAll((HashMap) readMap);
            }
            ois.close();
        } catch (Exception e) {
        }

    }
    public void close() {
        primaryStage.close();
    }
}





