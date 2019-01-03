package com.observer;

import java.util.Observable;
import java.util.Observer;

public class AObserver implements Observer {


    public AObserver(ServerManager serverManager) {
        super();
        serverManager.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("AObserver receive:Data has changed to "+((ServerManager) o).getData());
    }
}
