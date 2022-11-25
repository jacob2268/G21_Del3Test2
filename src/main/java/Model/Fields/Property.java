package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.Board;
import Model.CardDeck;
import Model.Constants;
import Model.Player;

import java.util.Objects;

public class Property extends Field {

    private boolean owned = false;
    private Player owner;
    private int price;
    private boolean bothOwned;
    private boolean forFree = false;

    public Property(String title, String subText, boolean owned, Player owner, int price, boolean bothOwned, boolean forFree) {
        super(title, subText);
        this.owned = owned;
        this.owner = owner;
        this.price = price;
        this.bothOwned = bothOwned;
        this.forFree = forFree;
    }

    @Override
    public void doAction(Constants c, Player player,GameController gameController) {
        c.getGuiController().showMessage(c.getMsg().propertyMessage(player.getName()));


        if(!owned) { // hvis felt ikke er ejet
            //guiController.showMessage("Du køber feltet for "+ price )
                c.getGuiController().showMessage(c.getMsg().buyingMessage(price));
                c.getGuiController().updateFieldStatus(player);
                player.subtractFromBalance(price);
                c.getGuiController().subtractFromGUIBalance(price, player);
                setOwner(player);
                owned = true;
                c.getGuiController().setBorderColor(player);

//            if(owner.getName() = ) {
//                bothOwned = true;
//            }


        } else { // hvis er ejet
            if(!Objects.equals(c.getGuiController().getOwnerName(player), player.getName())) { // hvis spiller ikke selv ejer feltet
                if(bothOwned) { // hvis ejeren ejer begge felttyper
                    player.payDoubleRent(price,player,this);
                    c.getGuiController().payDoubleRent(price,player,this);
                } else { // hvis ejeren kun ejer den ene af felttyperne
                    c.getGuiController().showMessage(c.getMsg().payRentMessage(price,c.getGuiController().getOwnerName(player)));
                    player.payRent(price,player,this);
                    c.getGuiController().payRent(price,player,this);
                }

            }else  // hvis spiller selv ejer feltet
                c.getGuiController().showMessage(c.getMsg().ownPropertyMessage());

        }
    }

//    public void getForFree(GUIController guiController, Player player, GameController gameController, CardDeck cardDeck, Board gameBoard) {
//        guiController.showPropertiesMessage(player);
//        if(!owned) { // hvis felt ikke er ejet får man det gratis
//                guiController.updateFieldStatus(player);
//                setOwner(player);
//                owned = true;
//                guiController.setBorderColor(player);
//
//        } else { // hvis er ejet
//            if(!Objects.equals(guiController.getOwnerName(player), player.getName())) { // hvis spiller ikke selv ejer feltet
//                if(bothOwned) { // hvis ejeren ejer begge felttyper
//                    player.payDoubleRent(price,player,this);
//                    guiController.payDoubleRent(price,player,this);
//                } else { // hvis ejeren kun ejer den ene af felttyperne
//                    c.getMsg().payRentMessage(this.getPrice(),c.getGuiController().getOwnerName(player));
//                    player.payRent(price,player,this);
//                    guiController.payRent(price,player,this);
//                }
//
//            }else  // hvis spiller selv ejer feltet
//                guiController.showRentMessage(player);
//
//        }
//    }
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
