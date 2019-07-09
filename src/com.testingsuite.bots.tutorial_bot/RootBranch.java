package com.testingsuite.bots.tutorial_bot;
import com.runemate.game.api.hybrid.local.WorldOverview;
import com.runemate.game.api.hybrid.local.Worlds;
import com.runemate.game.api.hybrid.local.hud.interfaces.*;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.listeners.ChatboxListener;
import com.runemate.game.api.script.framework.listeners.events.MessageEvent;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

/**
 * Class validates if the current world is a pvpworld
 * if it is the treescript continues with PickupOrBank branch
 */
public class RootBranch extends BranchTask {

    private PickupORBank pickupOrBank = new PickupORBank();
    private IsPVPWorld pvptest = new IsPVPWorld();

    @Override
    public boolean validate() {
        ////get current world id number
        int world = Worlds.getCurrent();

        ////use id number to create interface worldOverview.java
        WorldOverview wo = Worlds.getOverview(world);

        //test if current world is pvp
        if(wo.isPVP()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public TreeTask successTask() {
        return pickupOrBank;
    }

    @Override
    public TreeTask failureTask() {
        return pvptest;
    }

//    public void p(Object o){
//        System.out.println(o);
//    }
}

