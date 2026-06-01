package io.github.NoOne.nMLSkills.skillSystem.skillMenus;

import io.github.NoOne.menuSystem.Menu;
import io.github.NoOne.menuSystem.MenuSystem;
import io.github.NoOne.menuSystem.PlayerMenuUtility;
import io.github.NoOne.nMLItems.ItemCreator;
import io.github.NoOne.nMLSkills.NMLSkills;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class AcrobaticsMenu extends Menu {
    private NMLSkills nmlSkills;
    private Player player;
    private ItemStack maneuversBook;
    private ItemStack roll;
    private ItemStack rollInformation;
    private ItemStack rollInformation2;
    private ItemStack longJump;
    private ItemStack longJumpInformation;
    private ItemStack railGrind;
    private ItemStack railGrindInformation;
    private ItemStack wallRun;
    private ItemStack wallRunInformation;

    public AcrobaticsMenu(PlayerMenuUtility playerMenuUtility, NMLSkills nmlSkills) {
        super(playerMenuUtility);

        this.nmlSkills = nmlSkills;
        player = playerMenuUtility.getOwner();
        int acrobaticsLevel = nmlSkills.getSkillSetManager().getSkillSet(player.getUniqueId()).getSkills().getAcrobaticsLevel();
        maneuversBook = ItemCreator.createItem(
                Material.BOOK,
                "§f§nAcrobatics levels unlock maneuvers!",
                List.of(
                        "§7- Maneuvers are actions to move around faster",
                        "§7- Maneuvers use §6energy ⚡"
                )
        );

        setRollItems();
        setLongJumpItems(acrobaticsLevel);
        setRailGrindItems(acrobaticsLevel);
        setWallRunItems(acrobaticsLevel);
    }

    @Override
    public String getMenuName() {
        return "Acrobatics";
    }

    @Override
    public int getSlots() {
        return 9 * 6;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        event.setCancelled(true);

        switch (event.getSlot()) {
            case 53 -> new SkillsMenu(MenuSystem.getPlayerMenuUtility(player), nmlSkills).open();
        }
    }

    @Override
    public void handlePlayerMenu(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    @Override
    public void setMenuItems() {
        inventory.setItem(4, maneuversBook);
        inventory.setItem(19, roll);
        inventory.setItem(28, rollInformation);
        inventory.setItem(37, rollInformation2);
        inventory.setItem(21, longJump);
        inventory.setItem(30, longJumpInformation);
        inventory.setItem(23, railGrind);
        inventory.setItem(32, railGrindInformation);
        inventory.setItem(25, wallRun);
        inventory.setItem(34, wallRunInformation);
        inventory.setItem(53, ItemCreator.createBackoutButton());
    }

    private void setRollItems() {
        roll = ItemCreator.createItem(
                Material.WHITE_CONCRETE,
                "§f§lRoll",
                List.of(
                        "§8§oAcrobatics Lv. 1 §r§a✔",
                        "",
                        "§7§o§nCost§r§7§o: §65⚡",
                        "§7§o§nInput§r§7§o: Shift (x2)"
                )
        );

        rollInformation = ItemCreator.createItem(
                Material.LIGHT_GRAY_CONCRETE,
                "§f§lOn the ground:",
                List.of(
                        "§7- Roll in the direction you're moving in",
                        "§7- Puts all abilities on cooldown for 1.5s"
                )
        );

        rollInformation2 = ItemCreator.createItem(
                Material.LIGHT_GRAY_CONCRETE,
                "§f§lIn the air:",
                List.of(
                        "§7- Brace yourself for when you fall",
                        "§7- If you were to take fall damage, halve it and roll",
                        "§7- Puts all abilities on cooldown for 1.5s",
                        "§7- Does not use energy"
                )
        );
    }

    private void setLongJumpItems(int acrobaticsLevel) {
        if (acrobaticsLevel >= 10) {
            longJump = ItemCreator.createItem(
                    Material.WHITE_CONCRETE,
                    "§f§lLong Jump",
                    List.of(
                            "§8§oAcrobatics Lv. 10 §r§a✔",
                            "",
                            "§7§o§nCost§r§7§o: §615⚡",
                            "§7§o§nInput§r§7§o: Run + Shift + Jump"
                    )
            );

            longJumpInformation = ItemCreator.createItem(
                    Material.LIGHT_GRAY_CONCRETE,
                    "§7- Ok so imagine a jump but more like...that way.",
                    List.of(
                            "§7- Distance scales to your §fspeed ✦"
                    )
            );
        } else {
            longJump = ItemCreator.createItem(
                    Material.WHITE_CONCRETE,
                    "§4§l§kLong Jump",
                    List.of(
                            "§8§oAcrobatics Lv. 10 §r§c✖"
                    )
            );

            longJumpInformation = ItemCreator.createItem(
                    Material.LIGHT_GRAY_CONCRETE,
                    "§c§oYou have not learned this maneuver yet!",
                    List.of()
            );
        }
    }

    private void setRailGrindItems(int acrobaticsLevel) {
        if (acrobaticsLevel >= 20) {
            railGrind = ItemCreator.createItem(
                    Material.WHITE_CONCRETE,
                    "§f§lRail Grind",
                    List.of(
                            "§8§oAcrobatics Lv. 20 §r§a✔",
                            "",
                            "§7§o§nInput§r§7§o: Long Jump"
                    )
            );

            railGrindInformation = ItemCreator.createItem(
                    Material.LIGHT_GRAY_CONCRETE,
                    "§f§lLand on a rail after a long jump",
                    List.of(
                            "§7- \"Rail\" = any fence or bar",
                            "§7- Grind on connecting rails",
                            "§7- Shift to stop / jump to §nrail jump",
                            "§7- A rail jump counts as a long jump"
                    )
            );
        } else {
            railGrind = ItemCreator.createItem(
                    Material.RED_CONCRETE,
                    "§4§l§kRail Grind",
                    List.of(
                            "§8§oAcrobatics Lv. 20 §r§c✖"
                    )
            );

            railGrindInformation = ItemCreator.createItem(
                    Material.RED_CONCRETE,
                    "§c§oYou have not learned this maneuver yet!",
                    List.of()
            );
        }
    }

    private void setWallRunItems(int acrobaticsLevel) {
        if (acrobaticsLevel >= 30) {
            wallRun = ItemCreator.createItem(
                    Material.WHITE_CONCRETE,
                    "§f§lWall Run",
                    List.of(
                            "§8§oAcrobatics Lv. 30 §r§a✔",
                            "",
                            "§7§o§nCost§r§7§o: §65⚡§r§7§o/s",
                            "§7§o§nInput§r§7§o: Long Jump"
                    )
            );

            wallRunInformation = ItemCreator.createItem(
                    Material.LIGHT_GRAY_CONCRETE,
                    "§f§lTouch a wall after a long jump",
                    List.of(
                            "§7- \"Wall\" = ≥2 blocks high surface",
                            "§7- Run along the wall at the speed you hit it at",
                            "§7- Reach the lip of the wall to pull yourself up",
                            "§7- Shift to stop / jump to §nwall jump",
                            "§7- A wall jump counts as a long jump"
                    )
            );
        } else {
            wallRun = ItemCreator.createItem(
                    Material.RED_CONCRETE,
                    "§4§l§kWall Run",
                    List.of(
                            "§8§oAcrobatics Lv. 30 §r§c✖"
                    )
            );

            wallRunInformation = ItemCreator.createItem(
                    Material.RED_CONCRETE,
                    "§c§oYou have not learned this maneuver yet!",
                    List.of()
            );
        }
    }
}