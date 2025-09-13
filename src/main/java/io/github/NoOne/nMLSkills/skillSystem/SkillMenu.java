package io.github.NoOne.nMLSkills.skillSystem;

import io.github.NoOne.menuSystem.Menu;
import io.github.NoOne.menuSystem.PlayerMenuUtility;
import io.github.NoOne.nMLSkills.NMLSkills;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SkillMenu extends Menu {
    private Player player;
    private Skills skills;
    private ItemStack offenseStats;
    private ItemStack defenseStats;
    private ItemStack gatheringStats;

    public SkillMenu(PlayerMenuUtility playerMenuUtility, NMLSkills nmlSkills) {
        super(playerMenuUtility);

        player = playerMenuUtility.getOwner();
        skills = nmlSkills.getSkillSetManager().getSkillSet(player.getUniqueId()).getSkills();
    }

    @Override
    public String getMenuName() {
        return "Your Stats:";
    }

    @Override
    public int getSlots() {
        return 9 * 6;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    @Override
    public void handlePlayerMenu(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    @Override
    public void setMenuItems() {
    }
}