package io.github.NoOne.nMLSkills.skillSystem;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SkillChangeEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final String stat;
    private final double change;

    public SkillChangeEvent(@NotNull Player player, String stat, double change) {
        this.player = player;
        this.stat = stat;
        this.change = change;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    } // deleting this breaks things, apparently

    public Player getPlayer() {
        return player;
    }

    public String getStat() {
        return stat;
    }

    public double getChange() {
        return change;
    }
}