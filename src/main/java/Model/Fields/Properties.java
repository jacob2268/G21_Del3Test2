package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.ChanceCards;
import Model.Player;

import java.util.Objects;

public class Properties extends Field {

    private boolean owned = false;
    private Player owner;
    private int price;

    public Properties(String title, String subText, boolean owned, Player owner, int price) {
        super(title, subText);
        this.owned = owned;
        this.owner = owner;
        this.price = price;
    }

    @Override
    public void doAction(GUIController guiController, Player player, GameController gameController, ChanceCards chanceCards) {
        guiController.showPropertiesMessage(player);


        if(!owned) { // hvis felt ikke er ejet
            guiController.showBuyingMessage();
            guiController.updateFieldStatus(player);
            player.subtractFromBalance(price);
            guiController.subtractFromGUIBalance(price, player);
            setOwner(player);
            owned = true;
            guiController.setBorderColor(player);


        } else { // hvis er ejet
            if(!Objects.equals(guiController.getOwnerName(player), player.getName())) { // hvis spiller ikke selv ejer feltet
                guiController.showRentMessage(player);
                player.payRent(price,player,this);
                guiController.payRent(price,player,this);

            }else  // hvis spiller selv ejer feltet
                guiController.showRentMessage(player);

        }
//        System.out.println("playerName: " + player.getName());
//        System.out.println("MODEL: " + player.getBalance());
//        System.out.println("PlayergetGUI: " + player.getGui_player().getBalance());
//        System.out.println("guicontroller: " + guiController.getGUIBalance(player));
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
