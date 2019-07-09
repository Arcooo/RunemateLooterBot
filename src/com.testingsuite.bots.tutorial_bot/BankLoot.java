package com.testingsuite.bots.tutorial_bot;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * Created by alecc on 9/3/2018.
 */
public class BankLoot extends LeafTask {

    @Override
    public void execute() {
        p("Open Bank");

        Bank.open();

        if (Bank.open()) {
            p("Bank opened.");
        }

        p("Deposit Inventory");
        Bank.depositInventory();

        //close bank
        p("close bank");
        Bank.close();

        //walk back to area
        //TODO: find area coordinates to loot from
        Area lumbridgeBank = new Area.Rectangular(new Coordinate(3221, 3216, 0), new Coordinate(3222, 3218, 0));
    }

    public void p(Object o){
        System.out.println(o);
    }
}
