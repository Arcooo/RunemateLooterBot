package com.testingsuite.bots.tutorial_bot;

import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;


/**
 * The main class that the script returns to after completing a LeafTask
 */
public class LooterBot extends TreeBot {
    @Override
    public TreeTask createRootTask(){
        return new RootBranch();
    }
}
