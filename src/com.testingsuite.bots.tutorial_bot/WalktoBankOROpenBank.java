package com.testingsuite.bots.tutorial_bot;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

/**
 * Created by alecc on 1/12/2019.
 */
public class WalktoBankOROpenBank extends BranchTask{
    @Override
    public boolean validate() {
        //if close enough to lum bank open it deposit close
        Area lumbridgeBank = new Area.Rectangular(new Coordinate(3221, 3216, 0), new Coordinate(3222, 3218, 0));

        //get my characters (players) position
        int x = Players.getLocal().getPosition().getX();
        int y = Players.getLocal().getPosition().getY();

        p(x+ ", " + y);

        if (x>=3221 && x<= 3222 && y >=3216 && y<= 3218){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public TreeTask successTask() {
        return new BankLoot();
    }

    @Override
    public TreeTask failureTask() {
        return new WalkToLumBank();
    }

    public void p(Object o){
        System.out.println(o);
    }

}
