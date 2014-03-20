package com.reppardwalker.toastysafer;

import com.mewin.WGRegionEvents.WGRegionEventsPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

/**
 * Created with IntelliJ IDEA.
 * User: rwalker8
 * Date: 3/18/14
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */
public final class toastySafer extends WGRegionEventsPlugin {
    private final WorldGuardPlugin wgInstance = WorldGuardPlugin.inst();
    private final RegionListener listener = new RegionListener(this, wgInstance);

    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
