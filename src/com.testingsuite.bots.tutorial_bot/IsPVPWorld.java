package com.testingsuite.bots.tutorial_bot;

import com.runemate.game.api.hybrid.local.WorldOverview;
import com.runemate.game.api.hybrid.local.Worlds;
import com.runemate.game.api.hybrid.local.hud.interfaces.ChatDialog;
import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceWindows;
import com.runemate.game.api.hybrid.local.hud.interfaces.WorldHop;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 *
 */
public class IsPVPWorld extends LeafTask{
    //the pvp worlds switch around monthly and can only be world 371 or 417 freeplayer
    private final int PVP317 = 371;
    private final int PVP471 = 417;

    @Override
    public void execute() {
        //create overviews for the pvp worlds
        WorldOverview wo317 = Worlds.getOverview(PVP317);
        WorldOverview wo471 = Worlds.getOverview(PVP471);

        //go to a pvp world
        if(wo317.isPVP()){
            switchToPvpWorld(PVP317);
        }else if (wo471.isPVP()){
            switchToPvpWorld(PVP471);
        }else{
            System.out.println("Cannot find a pvp world");
        }
    }

    public void switchToPvpWorld(int world){
        //hop to pvp world
        WorldHop.hopTo(world);

        //get past warning dialogue of pvp world
        //creat list of dialogue options
        java.util.List<ChatDialog.Option> list = ChatDialog.getOptions();

        //basically make sure list is not null
        if (list.size() > 0){
            //option 2 to accept world
            list.get(1).select();
        }


        Execution.delay(5000);

        //switch back to inventory
        InterfaceWindows.getInventory().open();

        //for loop to view dialogue options
//        for (ChatDialog.Option opt : list) {
//            System.out.println(opt);
//        }

    }
}

