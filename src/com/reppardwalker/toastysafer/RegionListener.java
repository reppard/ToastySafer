package com.reppardwalker.toastysafer;

import com.mewin.WGRegionEvents.WGRegionEventsListener;
import com.mewin.WGRegionEvents.events.RegionEnterEvent;
import com.mewin.WGRegionEvents.events.RegionLeaveEvent;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created with IntelliJ IDEA.
 * User: rwalker8
 * Date: 3/18/14
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegionListener extends WGRegionEventsListener {
    private final toastySafer plugin;
    private List<String> safers = new ArrayList<String>();

    public RegionListener(toastySafer instance, WorldGuardPlugin wgInstance){
        super(instance, wgInstance);
        plugin = instance;
    }

    @EventHandler
    public void onRegionEnter(RegionEnterEvent e){
        String regionId = e.getRegion().getId();
        Pattern p = Pattern.compile(regionId + "*");
        Matcher m = p.matcher("safeline");

        if(m.matches()){
            Player player = e.getPlayer();
            addToSafers(player.getDisplayName());
            Timer countDown = new Timer(true);
            countDown.schedule(new SaferCheck(this, player), 5000);
            //int igniteTime = 2147483647;

            //for(int count = 0; count < igniteTime; count++){
            //    if(count == (igniteTime / 2)){
            //        player.sendMessage(ChatColor.DARK_RED + "Move or burn...");
            //   }

            //    if(count == igniteTime - 1){
            //        player.sendMessage(ChatColor.DARK_RED + "Told you so.");
            //       player.setFireTicks(250);
            //    }

            //    for(int countB = 0; countB < 2147483647; countB++){

            //    }
            //}
        }
    }

    public List<String> getSafers(){
        return safers;
    }

    public void addToSafers(String displayName){
        safers.remove(displayName);
    }

    @EventHandler
    public void onRegionLeave(RegionLeaveEvent e){
        Player player = e.getPlayer();
        if(getSafers().contains(player.getDisplayName())){
            safers.remove(player.getDisplayName());
        }
    }
}
