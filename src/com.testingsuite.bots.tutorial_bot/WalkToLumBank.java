package com.testingsuite.bots.tutorial_bot;
import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.local.WorldOverview;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Landmark;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.hybrid.location.navigation.web.Web;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.region.Players;

import com.runemate.game.api.script.framework.tree.LeafTask;



/**
 * Created by alecc on 10/8/2018.
 */
public class WalkToLumBank extends LeafTask {
    //coordinates for lumbridge bank
    private Area lumbridgeBank = new Area.Rectangular(new Coordinate(3221, 3216, 0), new Coordinate(3222, 3218, 0));
//    private Area rockArea = new Area.Rectangular(new Coordinate(3105, 3505, 0), new Coordinate(3094, 3495, 0));

    @Override
    public void execute() {
        //get coordinates
        int x = Players.getLocal().getPosition().getX();
        int y = Players.getLocal().getPosition().getY();
        //print coordinates
        System.out.println("Coordinates of bot are: " + x +", " + y);

        //create path from location? to a point in lumbridge area.
        RegionPath toLumBank = RegionPath.buildTo(lumbridgeBank.getRandomCoordinate());

        //move to lumbridge
        if(toLumBank != null){
            toLumBank.step();
        }
    }
}
