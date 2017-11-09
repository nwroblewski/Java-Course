package main;

import java.util.LinkedList;

public class ActionsParser {
    public static Action[] parser(String[] tablica) {
        int i=0;
        LinkedList<Action> lista = new LinkedList();
        for (String c : tablica) {
            switch (c) {
                case "d-": {
                    lista.add(Action.DAY_EARLIER);
                    i++;
                }
                    break;
                case "d+":{
                    lista.add(Action.DAY_LATER);
                    i++;
                }
                    break;
                case "t-":{
                    lista.add(Action.TIME_EARLIER);
                    i++;
                }
                    break;
                case "t+":{
                    lista.add(Action.TIME_LATER);
                    i++;
                }
                    break;
            }
        }
        Action [] akcje = new Action[i];
        int j=0;
        for(Action action:lista){
            akcje[j]=action;
            j++;
        }
        return akcje;
    }
}
