//package Model;
//
//import Model.Fields.*;
//import gui_fields.*;
//
//import java.awt.*;
//
//public class FieldFactory {
//
//    private Field[] gameBoard;
//
//    public Field[] createGUIBoard() {
//        gameBoard = new Field[]{
//                new Start("Start", "You recieve $2 when you land on or pass Start", 2),
//                new Properties("Burgerbaren", "$1", " Burgerbaren ", "$1"),
//                new Properties("Pizzahuset", "$1", "Pizzaria ", "$1"),
//                new Chance(),
//                new Properties("Slikbutikken", "$1", "Slikbutikken ", "$1", ),
//                new Properties("Iskiosken", "$1", "Iskiosken ", "$1", ),
//                new VisitJail(),
//                new Properties("Museet", "$2", " Museet", "$1", ),
//                new Properties("Biblioteket", "$2", "Bibloteket ", "$1", ),
//                new Chance(),
//                new Properties("Skaterparken", "$2", " Skaterparken", "$2", ),
//                new Properties("Swimmingpoolen", "$2", "Swimmingpoolen ", "$2", ),
//                new Parking(),
//                new Properties("Spillehallen", "$3", "Spillehallen ", "$3", ),
//                new Properties("Biografen", "$3", "Biografen ", "$3", ),
//                new Chance(),
//                new Properties("Legetøjsbutikken", "$3", "Legetøjsbutikken ", "$3", ),
//                new Properties("Dyrehandlen", "$3", "Dyrehandlen ", "$3", ),
//                new Jail(),
//                new Properties("Bowlinghallen", "$4", "Bowlinghallen", "$4", ),
//                new Properties("Zoologisk Have", "$4", "Zoologisk Have ", "$4", ),
//                new Chance(),
//                new Properties("Vandlandet", "$4", "Vandlandet ", "$4"),
//                new Properties("Strandpromenaden", "$4", "Strandpromenaden ", "$4")
//        };
//        return gameBoard;
//    }
//}
