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
            if(player.isGetPropertyFree()) { // Hvis man får det gratis
                c.getGuiController().showMessage(c.getMsg().getForFree());
                c.getGuiController().updateFieldStatus(player);
                setOwner(player);
                owned = true;
                c.getGuiController().setBorderColor(player);
                player.setGetPropertyFree(false);

            } else { // Hvis man ikke får det gratis
                c.getGuiController().showMessage(c.getMsg().buyingMessage(price));
                c.getGuiController().updateFieldStatus(player);
                player.subtractFromBalance(price);
                c.getGuiController().subtractFromGUIBalance(price, player);
                setOwner(player);
                owned = true;
                c.getGuiController().setBorderColor(player);
            }
//            if(player.getPosition() < c.getGameBoard().getGameBoard().length) {
//                // hvis feltet, som spilleren står på
//                if (c.getGameBoard().getGameBoard()[player.getPosition()].getClass() == c.getGameBoard().getGameBoard()[player.getPosition() + 1].getClass()) {
//                    if (c.getGuiController().getOwnerName(player.getPosition()) == c.getGuiController().getOwnerName(player.getPosition() + 1)) {
//                        setBothOwned(true);
//                        c.getGameBoard().getProperty(player.getPosition() + 1).setBothOwned(true);
//                    }
//                }
//            } else {
//                if (c.getGameBoard().getGameBoard()[player.getPosition()].getClass() == c.getGameBoard().getGameBoard()[player.getPosition() - 1].getClass()) {
//                    if (c.getGuiController().getOwnerName(player.getPosition()) == c.getGuiController().getOwnerName(player.getPosition() - 1)) {
//                        setBothOwned(true);
//                        c.getGameBoard().getProperty(player.getPosition() - 1).setBothOwned(true);
//                    }
//                }
//            }
            if(player.getPosition() != 0){
                if(c.getGameBoard().getGameBoard()[player.getPosition()].getClass() == c.getGameBoard().getGameBoard()[player.getPosition()-1].getClass()) {
                    if(c.getGuiController().getOwnerName(player.getPosition()) == c.getGuiController().getOwnerName(player.getPosition()-1)){
                        this.setBothOwned(true);
                        c.getGameBoard().getProperty(player.getPosition()-1).setBothOwned(true);
                    }
                }
            }
            if(player.getPosition() != 23) {
                if (c.getGameBoard().getGameBoard()[player.getPosition()].getClass() == c.getGameBoard().getGameBoard()[player.getPosition() + 1].getClass()) {
                    if (c.getGuiController().getOwnerName(player.getPosition()) == c.getGuiController().getOwnerName(player.getPosition()+1)) {
                        this.setBothOwned(true);
                        c.getGameBoard().getProperty(player.getPosition() + 1).setBothOwned(true);
                    }
                }
            }


        } else { // hvis er ejet
            if(!Objects.equals(c.getGuiController().getOwnerName(player.getPosition()), player.getName())) { // hvis spiller ikke selv ejer feltet
                if(bothOwned) { // hvis ejeren ejer begge felttyper
                    c.getGuiController().showMessage(c.getMsg().payDoubleRentMessage(c.getGuiController().getOwnerName(player.getPosition()), price * 2));
                    player.payDoubleRent(price,player,this);
                    c.getGuiController().payDoubleRent(price,player,this);
                } else { // hvis ejeren kun ejer den ene af felttyperne
                    c.getGuiController().showMessage(c.getMsg().payRentMessage(price,c.getGuiController().getOwnerName(player.getPosition())));
                    player.payRent(price,player,this);
                    c.getGuiController().payRent(price,player,this);
                }

            }else  // hvis spiller selv ejer feltet
                c.getGuiController().showMessage(c.getMsg().ownPropertyMessage());

        }
        player.setGetPropertyFree(false);
    }


    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }


    public void setBothOwned(boolean bothOwned) {
        this.bothOwned = bothOwned;
    }

}
