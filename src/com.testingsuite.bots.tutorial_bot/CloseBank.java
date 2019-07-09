package com.testingsuite.bots.tutorial_bot;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class CloseBank extends LeafTask {

    @Override
    public void execute() {
        if (Bank.close()) {
            System.out.println("Bank closed");
        }
    }
}
