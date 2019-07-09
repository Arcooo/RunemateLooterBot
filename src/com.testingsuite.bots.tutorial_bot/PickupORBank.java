package com.testingsuite.bots.tutorial_bot;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

/**
 * Created by alecc on 1/12/2019.
 */
public class PickupORBank extends BranchTask {
    @Override
    public boolean validate() {
        //print current number of empty inventory slots
        p("Empty Inventory Slots: " + Inventory.getEmptySlots());

        //
        if (Inventory.getEmptySlots()>12){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public TreeTask successTask() {
        return new PickupStuff();
    }

    @Override
    public TreeTask failureTask() {
        return new WalktoBankOROpenBank();
    }

    public void p(Object o){
        System.out.println(o);
    }
}

