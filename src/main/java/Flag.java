import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.time.LocalTime;


public class Flag extends StackPane {

    public ImageView picture;
    public String pair;
    private Flag selected = null;
    Menu menu;
    private static int isOpenCount = 0;


    public Flag(Image image, Menu menu, String pair) {
        this.menu = menu;
        this.pair = pair;
        this.picture = new ImageView(image);
        picture.setFitHeight(100);
        picture.setFitWidth(150);
        Rectangle border = new Rectangle(150, 100);
        border.setFill(null);
        border.setStroke(Color.DODGERBLUE);


        setAlignment(Pos.CENTER);
        getChildren().addAll(border, picture);

        setOnMouseClicked(this::handleMouseClick);

        close();
    }

    public void handleMouseClick(MouseEvent event) {

        if (isOpen())
            return;
        System.out.println("selected: " + menu.selected);

        if (menu.selected == null) {
            menu.selected = this;
            open(() -> {
            });
        } else {
            open(() -> {
                System.out.println("hasSameValue(selected): " + hasSameValue(menu.selected));
                if (!hasSameValue(menu.selected)) {
                    menu.selected.close();
                    this.close();
                } else {
                    menu.selected.isOpen();
                    this.isOpen();
                    isOpenCount++;
                    System.out.println("OpenPairs count: " + isOpenCount);
                }
                if (isOpenCount == Menu.getNUM_OF_PAIRS()) {
                    System.out.println("KONIEC");
                    menu.setEndTime(LocalTime.now());
                    menu.setPlayerScore();
                    System.out.println(menu.getScoreAsString());
                    isOpenCount = 0;
                    menu.theLastBoard();
                }

                menu.selected = null;

            });
        }
    }

    public boolean isOpen() {
        return picture.getOpacity() == 1;
    }

    public void open(Runnable action) {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.3), picture);
        ft.setToValue(1);
        ft.setOnFinished(e -> action.run());
        ft.play();
    }

    public void close() {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.3), picture);
        ft.setToValue(0);
        ft.play();
    }

    public boolean hasSameValue(Flag other) {
        if (pair != null &&
                other.pair != null) {
            return
                    pair.equals(other.pair);
        } else
            return false;
    }
}



