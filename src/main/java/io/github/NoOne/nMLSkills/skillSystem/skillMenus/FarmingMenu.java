package io.github.NoOne.nMLSkills.skillSystem.skillMenus;

import io.github.NoOne.menuSystem.Menu;
import io.github.NoOne.nMLItems.ItemCreator;
import io.github.NoOne.nMLSkills.NMLSkills;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

public class FarmingMenu extends Menu {
    private NMLSkills nmlSkills;

    public FarmingMenu(Player player, NMLSkills nmlSkills) {
        super(player);
        this.nmlSkills = nmlSkills;
    }

    @Override
    public String getMenuName() {
        return "§aFarming";
    }

    @Override
    public int getSlots() {
        return 9 * 3;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        switch (event.getSlot()) {
            case 13 -> player.performCommand("cropcodex");
            case 26 -> new SkillsMenu(player, nmlSkills).open();
        }
    }

    @Override
    public void handlePlayerMenu(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    @Override
    public void setMenuItems() {
        inventory.setItem(13, ItemCreator.createItem(
                Material.WRITABLE_BOOK,
                "§a§nThe Crop Codex:",
                List.of(
                        "§7§oThe dictionary for all crops",
                        "§7§oCan also use §n/cropcodex"
                )
        ));
        inventory.setItem(26, ItemCreator.createBackoutButton());
    }
}
