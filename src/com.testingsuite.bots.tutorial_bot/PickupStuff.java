package com.testingsuite.bots.tutorial_bot;

import com.runemate.game.api.hybrid.entities.GroundItem;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.hybrid.net.GrandExchange;
import com.runemate.game.api.hybrid.queries.results.LocatableEntityQueryResults;
import com.runemate.game.api.hybrid.region.GroundItems;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * Created by alecc on 1/3/2019.
 */
public class PickupStuff extends LeafTask {

    private boolean isUnderAttack(){
        return Players.newQuery().targeting(Players.getLocal()).results() != null;
    }
    @Override
    /*
        1. move to area
        2. search ground items
        3. pick up stuff
     */

    public void execute() {
        //pkArea
        Area pkArea = new Area.Rectangular(new Coordinate(3232, 3223, 0), new Coordinate(3237, 3215, 0));

        /*
            1. Get Coordinate of my player
            2. Create search area
            3. Search that area for all items (Sorted by closest)


         */


        //Get Current Player Position
        Coordinate myPlayerPosition = Players.getLocal().getPosition();
        //PRINT position
        p("Position: " + myPlayerPosition.getX() + ", " + myPlayerPosition.getY());

        //Create Search Area
        Area.Circular searchArea = new Area.Circular(myPlayerPosition, 7);

        //Get all items sorted within searchArea
        LocatableEntityQueryResults<GroundItem> allGroundItems = GroundItems.getLoadedWithin(searchArea).sortByDistance();

        //objects within Area
        p("Number of Objects within Area: "+ allGroundItems.size());



        //if ground items found is 0, go to pk area
        if(allGroundItems.size()==0){
            RegionPath toPkArea = RegionPath.buildTo(pkArea.getRandomCoordinate());
            if(toPkArea != null){
                toPkArea.step();
            }
            p("delay 5 secs");
            Execution.delay(5000);
        }



        GroundItem gi = allGroundItems.first();
        boolean b = (gi == null);

        p("gi null: " + b);

        if(gi != null){
            //turn if items not visible
            if(!gi.isVisible()){
                Camera.turnTo(gi);
            }

            //take item
            try {
                gi.interact("Take", gi.getDefinition().getName());
            } catch (NullPointerException e) {
                throw new NullPointerException("Exception thrown");
            }
        }

    }
    public void p(Object o){
        System.out.println(o);
    }

}



