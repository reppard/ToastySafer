ToastySafer v0.0.2
===========

Minecraft Server plugin to burn the safers!

Requirements
============

Your CraftBukkit server must be running [WorldGuard](http://dev.bukkit.org/bukkit-plugins/worldguard/).
I have tested against 5.8 but it should work on 5.9 as well.

Usage
=====

Once the plugin has been installed and your server is up and running, you need to create a region for each safeline you want to be ToastySafer activated.
To do this select a start and end block with your WorldGuard `//wand`.  You may choose to do something like `//expand 3 u` to increase the hight of the region.
Next you do `/region define <safeline name>`. 

For now, your safeline name must follow this convention: "safeline" + one optional alpha-numeric character.

So "safeline", "safeline1" and "safelinea" should all be valid safeline names.

TODO:
=====
Create config to provide customizable setFireTicks and Time to Ignite as well as the ablity to flag any region with any name as a safe zone.
