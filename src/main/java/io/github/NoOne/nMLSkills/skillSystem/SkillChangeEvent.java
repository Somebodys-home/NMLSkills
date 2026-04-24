package io.github.NoOne.nMLSkills.skillSystem;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SkillChangeEvent extends Event {
    private static HandlerList handlers = new HandlerList();
    private Player player;
    private String skill;
    private double change;
    private int ticks;

    public SkillChangeEvent(@NotNull Player player, String skill, double change, int ticks) {
        this.player = player;
        this.skill = skill;
        this.change = change;
        this.ticks = ticks;
    }

    public SkillChangeEvent(@NotNull Player player, String skill, double change) {
        this.player = player;
        this.skill = skill;
        this.change = change;
        ticks = 0;
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

    public String getSkill() {
        return skill;
    }

    public double getChange() {
        return change;
    }

    public int getTicks() {
        return ticks;
    }
}