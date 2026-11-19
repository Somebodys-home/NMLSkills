package io.github.NoOne.nMLSkills.skillSystem;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class SkillChangeEvent extends Event {
    private static HandlerList handlers = new HandlerList();
    private Player player;
    private Skill skill;
    private int change;
    private boolean expChange; // true/false if were changing the exp of the skill or the level
    private int ticks;

    public SkillChangeEvent(@NotNull Player player, Skill skill, boolean expChange, int change, int ticks) {
        this.player = player;
        this.skill = skill;
        this.change = change;
        this.expChange = expChange;
        this.ticks = ticks;
    }

    public SkillChangeEvent(@NotNull Player player, Skill skill, boolean expChange, int change) {
        this.player = player;
        this.skill = skill;
        this.expChange = expChange;
        this.change = change;
        ticks = 0;
    }

    @Override
    public @NonNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getPlayer() {
        return player;
    }

    public Skill getSkill() {
        return skill;
    }

    public boolean isExpChange() {
        return expChange;
    }

    public int getChange() {
        return change;
    }

    public int getTicks() {
        return ticks;
    }
}