package com.testingsuite.bots.tutorial_bot;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.hybrid.queries.results.SpriteItemQueryResults;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * Created by alecc on 1/2/2019.
 */
public class DropTest extends LeafTask {

    @Override
    public void execute() {
        for (SpriteItem i : Inventory.getItems("Jug")) {
            i.interact("Drop");
        }




//        SpriteItemQueryResults invItems = Inventory.getItems();



    }








    public void p(Object o){
        System.out.println(o);
    }
}
