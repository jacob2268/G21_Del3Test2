package Controller;
import Model.Board;
import Model.FieldFactory;
import gui_fields.GUI_Field;
import gui_main.GUI;

public class GameController {
    GUIController guiController;

    private Board gameBoard;

    public GameController() {
        GUIController guiController;
    }



    public void playGame() {
        setupGame();
    }

    public void setupGame() {
        guiController.createBoard();
    }
}

