package com.testingsuite.bots.tutorial_bot;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class BankBranch extends BranchTask {

    private WithdrawBranch withdrawBranch = new WithdrawBranch();
    private Deposit depositLeaf = new Deposit();

    @Override
    public TreeTask successTask() {
        return withdrawBranch;
    }

    @Override
    public TreeTask failureTask() {
        return depositLeaf;
    }

    @Override
    public boolean validate() {
        return Inventory.isEmpty() || Inventory.containsOnly("Bone");
    }
}