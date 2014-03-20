package com.reppardwalker.toastysafer;

import org.bukkit.entity.Player;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: rwalker8
 * Date: 3/20/14
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */

public class SaferCheck extends TimerTask {
    private Player player;
    private RegionListener regionLister;

    public SaferCheck(RegionListener regionListener, Player player) {
        this.regionLister = regionListener;
        this.player = player;
    }

    public void run(){
        if(regionLister.getSafers().contains(player.getDisplayName())){
            player.setFireTicks(250);
        }
    }
}
