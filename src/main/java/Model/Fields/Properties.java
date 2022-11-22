package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.Board;
import Model.CardDeck;
import Model.ChanceCards;
import Model.Player;

import java.util.Objects;

public class Properties extends Field {

    private boolean owned = false;
    private Player owner;
    private int price;
    private boolean bothOwned;
    private boolean forFree = false;

    public Properties(String title, String subText, boolean owned, Player owner, int price, boolean bothOwned, boolean forFree) {
        super(title, subText);
        this.owned = owned;
        this.owner = owner;
        this.price = price;
        this.bothOwned = bothOwned;
        this.forFree = forFree;
    }

    @Override
    public void doAction(GUIController guiController, Player player, GameController gameController, CardDeck cardDeck, Board gameBoard) {

        guiController.showPropertiesMessage(player);


        if(!owned) { // hvis felt ikke er ejet
            //guiController.showMessage("Du køber feltet for "+ price )
                guiController.showBuyingMessage();
                guiController.updateFieldStatus(player);
                player.subtractFromBalance(price);
                guiController.subtractFromGUIBalance(price, player);
                setOwner(player);
                owned = true;
                guiController.setBorderColor(player);

//            if(owner.getName() = ) {
//                bothOwned = true;
//            }


        } else { // hvis er ejet
            if(!Objects.equals(guiController.getOwnerName(player), player.getName())) { // hvis spiller ikke selv ejer feltet
                if(bothOwned) { // hvis ejeren ejer begge felttyper
                    player.payDoubleRent(price,player,this);
                    guiController.payDoubleRent(price,player,this);
                } else { // hvis ejeren kun ejer den ene af felttyperne
                    guiController.showRentMessage(player);
                    player.payRent(price,player,this);
                    guiController.payRent(price,player,this);
                }

            }else  // hvis spiller selv ejer feltet
                guiController.showRentMessage(player);

        }
    }

    public void GetforFree(GUIController guiController, Player player, GameController gameController, CardDeck cardDeck, Board gameBoard) {
        guiController.showPropertiesMessage(player);
        if(!owned) { // hvis felt ikke er ejet får man det gratis
                guiController.updateFieldStatus(player);
                setOwner(player);
                owned = true;
                guiController.setBorderColor(player);

        } else { // hvis er ejet
            if(!Objects.equals(guiController.getOwnerName(player), player.getName())) { // hvis spiller ikke selv ejer feltet
                if(bothOwned) { // hvis ejeren ejer begge felttyper
                    player.payDoubleRent(price,player,this);
                    guiController.payDoubleRent(price,player,this);
                } else { // hvis ejeren kun ejer den ene af felttyperne
                    guiController.showRentMessage(player);
                    player.payRent(price,player,this);
                    guiController.payRent(price,player,this);
                }

            }else  // hvis spiller selv ejer feltet
                guiController.showRentMessage(player);

        }
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

    public boolean isBothOwned() {
        return bothOwned;
    }

    public void setBothOwned(boolean bothOwned) {
        this.bothOwned = bothOwned;
    }

    public boolean isForFree() {
        return forFree;
    }

    public void setForFree(boolean forFree) {
        this.forFree = forFree;
    }
}
