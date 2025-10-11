package io.github.NoOne.nMLSkills.skillSystem.menus;

import io.github.NoOne.menuSystem.Menu;
import io.github.NoOne.menuSystem.MenuSystem;
import io.github.NoOne.menuSystem.PlayerMenuUtility;
import io.github.NoOne.nMLSkills.NMLSkills;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class AcrobaticsMenu extends Menu {
    private NMLSkills nmlSkills;
    private final Player player;
    private final int acrobaticsLevel;
    private final ItemStack maneuversBook;
    private final ItemStack backButton;
    private final ItemStack roll;
    private final ItemStack rollInformation;
    private final ItemStack rollInformation2;
    private final ItemStack longJump;
    private final ItemStack longJumpInformation;
    private final ItemStack railGrind;
    private final ItemStack railGrindInformation;
    private final ItemStack climb;
    private final ItemStack climbInformation;

    public AcrobaticsMenu(PlayerMenuUtility playerMenuUtility, NMLSkills nmlSkills) {
        super(playerMenuUtility);

        this.nmlSkills = nmlSkills;
        player = playerMenuUtility.getOwner();
        acrobaticsLevel = nmlSkills.getSkillSetManager().getSkillSet(player.getUniqueId()).getSkills().getAcrobaticsLevel();

        maneuversBook = new ItemStack(Material.BOOK);
            ItemMeta maneuversBookItemMeta = maneuversBook.getItemMeta();
            List<String> manueversLore = new ArrayList<>();
            maneuversBookItemMeta.setDisplayName("§f§nAcrobatics levels unlock maneuvers!");
            manueversLore.add("§7- Maneuvers are actions you can do to move around better");
            manueversLore.add("§7- Do a set of inputs quickly to do a maneuver");
            manueversLore.add("§7- Most maneuvers use §6energy ⚡");
            maneuversBookItemMeta.setLore(manueversLore);
            maneuversBook.setItemMeta(maneuversBookItemMeta);

        backButton = new ItemStack(Material.BARRIER);
            ItemMeta backButtonItemMeta = backButton.getItemMeta();
            backButtonItemMeta.setDisplayName("§4§l<- Go Back");
            backButton.setItemMeta(backButtonItemMeta);

        // rolling, level 1
        if (reachedAcrobaticsLevel(1)) {
            roll = new ItemStack(Material.WHITE_CONCRETE);
                ItemMeta rollItemMeta = roll.getItemMeta();
                List<String> rollLore = new ArrayList<>();
                rollItemMeta.setDisplayName("§f§lRoll (Shift + Shift)");
                rollLore.add("§7§oUnlocks at Lv. 1");
                rollLore.add("§7§o§nCost§r§7§o: §65⚡");
                rollItemMeta.setLore(rollLore);
                roll.setItemMeta(rollItemMeta);

            rollInformation = new ItemStack(Material.LIGHT_GRAY_CONCRETE);
                ItemMeta rollInformationItemMeta = rollInformation.getItemMeta();
                List<String> rollInformationLore = new ArrayList<>();
                rollInformationItemMeta.setDisplayName("§f§lOn the ground:");
                rollInformationLore.add("§7- Dash a little bit in the direction you're moving in");
                rollInformationLore.add("§7- Puts all abilities on cooldown for 1.5s");
                rollInformationItemMeta.setLore(rollInformationLore);
                rollInformation.setItemMeta(rollInformationItemMeta);

            rollInformation2 = new ItemStack(Material.LIGHT_GRAY_CONCRETE);
                ItemMeta rollInformation2ItemMeta = rollInformation2.getItemMeta();
                List<String> rollInformation2Lore = new ArrayList<>();
                rollInformation2ItemMeta.setDisplayName("§f§lIn the air:");
                rollInformation2Lore.add("§7- Brace yourself for when you fall");
                rollInformation2Lore.add("§7- If you were to take fall damage, halve it and roll instead");
                rollInformation2Lore.add("§7- Puts all abilities on cooldown for 1.5s");
                rollInformation2Lore.add("§7- Does not use energy");
                rollInformation2ItemMeta.setLore(rollInformation2Lore);
                rollInformation2.setItemMeta(rollInformation2ItemMeta);
        } else {
            roll = new ItemStack(Material.RED_CONCRETE);
                ItemMeta rollItemMeta = roll.getItemMeta();
                List<String> rollLore = new ArrayList<>();
                rollItemMeta.setDisplayName("§4§l§mRoll (Shift + Shift)");
                rollLore.add("§7§oUnlocks at Lv. 1");
                rollLore.add("§7§o§nCost§r§7§o: §65⚡");
                rollItemMeta.setLore(rollLore);
                roll.setItemMeta(rollItemMeta);

            rollInformation = new ItemStack(Material.LIGHT_GRAY_CONCRETE);
                ItemMeta rollInformationItemMeta = rollInformation.getItemMeta();
                rollInformationItemMeta.setDisplayName("§7You have not unlocked this maneuver yet!");
                rollInformation.setItemMeta(rollInformationItemMeta);

            rollInformation2 = new ItemStack(Material.LIGHT_GRAY_CONCRETE);
                ItemMeta rollInformation2ItemMeta = rollInformation2.getItemMeta();
                rollInformation2ItemMeta.setDisplayName("§7You have not unlocked this maneuver yet!");
                rollInformation2.setItemMeta(rollInformation2ItemMeta);
        }

        // long jump, level 10
        if (reachedAcrobaticsLevel(10)) {
            longJump = new ItemStack(Material.WHITE_CONCRETE);
                ItemMeta longJumpItemMeta = longJump.getItemMeta();
                List<String> longJumpLore = new ArrayList<>();
                longJumpItemMeta.setDisplayName("§f§lLong Jump (Run + Shift + Jump)");
                longJumpLore.add("§7§oUnlocks at Lv. 10");
                longJumpLore.add("§7§o§nCost§r§7§o: §610⚡");
                longJumpItemMeta.setLore(longJumpLore);
                longJump.setItemMeta(longJumpItemMeta);

            longJumpInformation = new ItemStack(Material.LIGHT_GRAY_CONCRETE);
                ItemMeta rollInformationItemMeta = longJumpInformation.getItemMeta();
                rollInformationItemMeta.setDisplayName("§7- It really do be a long jump.");
                longJumpInformation.setItemMeta(rollInformationItemMeta);
        } else {
            longJump = new ItemStack(Material.RED_CONCRETE);
                ItemMeta rollItemMeta = longJump.getItemMeta();
                List<String> rollLore = new ArrayList<>();
                rollItemMeta.setDisplayName("§4§l§mLong Jump (Run + Shift + Jump)");
                rollLore.add("§7§oUnlocks at Lv. 10");
                rollLore.add("§7§o§nCost§r§7§o: §610⚡");
                rollItemMeta.setLore(rollLore);
                longJump.setItemMeta(rollItemMeta);

            longJumpInformation = new ItemStack(Material.LIGHT_GRAY_CONCRETE);
                ItemMeta rollInformationItemMeta = longJumpInformation.getItemMeta();
                rollInformationItemMeta.setDisplayName("§7You have not unlocked this maneuver yet!");
                longJumpInformation.setItemMeta(rollInformationItemMeta);
        }

        // rail grind, level 20
        if (reachedAcrobaticsLevel(20)) {
            railGrind = new ItemStack(Material.WHITE_CONCRETE);
                ItemMeta rollItemMeta = railGrind.getItemMeta();
                List<String> rollLore = new ArrayList<>();
                rollItemMeta.setDisplayName("§f§lRail Grind (Land on a grindable block from a long jump)");
                rollLore.add("§7§oUnlocks at Lv. 20");
                rollItemMeta.setLore(rollLore);
                railGrind.setItemMeta(rollItemMeta);

            railGrindInformation = new ItemStack(Material.LIGHT_GRAY_CONCRETE);
                ItemMeta rollInformationItemMeta = railGrindInformation.getItemMeta();
                List<String> rollInformationLore = new ArrayList<>();
                rollInformationItemMeta.setDisplayName("§7- Grindable blocks are any fence or bars");
                rollInformationLore.add("§7- Move and turn on any other connecting grindable blocks automatically");
                rollInformationLore.add("§7- Shift to stop / jump to §nrail jump");
                rollInformationLore.add("§7- A rail jump has the same properties of a long jump");
                rollInformationItemMeta.setLore(rollInformationLore);
                railGrindInformation.setItemMeta(rollInformationItemMeta);
        } else {
            railGrind = new ItemStack(Material.RED_CONCRETE);
                ItemMeta rollItemMeta = railGrind.getItemMeta();
                List<String> rollLore = new ArrayList<>();
                rollItemMeta.setDisplayName("§4§l§mRail Grind (Land on a grindable block from a long jump)");
                rollLore.add("§7§oUnlocks at Lv. 20");
                rollItemMeta.setLore(rollLore);
                railGrind.setItemMeta(rollItemMeta);

            railGrindInformation = new ItemStack(Material.LIGHT_GRAY_CONCRETE);
                ItemMeta rollInformationItemMeta = railGrindInformation.getItemMeta();
                rollInformationItemMeta.setDisplayName("§7You have not unlocked this maneuver yet!");
                railGrindInformation.setItemMeta(rollInformationItemMeta);
        }

        // climbing, level 30
        if (reachedAcrobaticsLevel(30)) {
            climb = new ItemStack(Material.WHITE_CONCRETE);
                ItemMeta rollItemMeta = climb.getItemMeta();
                List<String> rollLore = new ArrayList<>();
                rollItemMeta.setDisplayName("§f§lWall Running (Long jump near a wall)");
                rollLore.add("§7§oUnlocks at Lv. 30");
                rollLore.add("§7§o§nCost§r§7§o: §620⚡§r§7§o/s");
                rollItemMeta.setLore(rollLore);
                climb.setItemMeta(rollItemMeta);

            climbInformation = new ItemStack(Material.LIGHT_GRAY_CONCRETE);
                ItemMeta climbInformationItemMeta = climbInformation.getItemMeta();
                List<String> rollInformationLore = new ArrayList<>();
                climbInformationItemMeta.setDisplayName("§7- A \"wall\" being a ≥2 blocks high surface");
                rollInformationLore.add("§7- Reach the lip of a wall to pull yourself up");
                rollInformationLore.add("§7- Land to stop / jump to §nwall jump");
                rollInformationLore.add("§7- A wall jump has the same properties of a long jump");
                climbInformationItemMeta.setLore(rollInformationLore);
                climbInformation.setItemMeta(climbInformationItemMeta);
        } else {
            climb = new ItemStack(Material.RED_CONCRETE);
                ItemMeta climbItemMeta = climb.getItemMeta();
                List<String> rollLore = new ArrayList<>();
                climbItemMeta.setDisplayName("§7- A \"wall\" being a ≥2 blocks high surface");
                rollLore.add("§7§oUnlocks at Lv. 30");
                climbItemMeta.setLore(rollLore);
                climb.setItemMeta(climbItemMeta);

            climbInformation = new ItemStack(Material.LIGHT_GRAY_CONCRETE);
                ItemMeta rollInformationItemMeta = climbInformation.getItemMeta();
                rollInformationItemMeta.setDisplayName("§7You have not unlocked this maneuver yet!");
                climbInformation.setItemMeta(rollInformationItemMeta);
        }
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
        inventory.setItem(25, climb);
        inventory.setItem(34, climbInformation);
        inventory.setItem(53, backButton);
    }

    private boolean reachedAcrobaticsLevel(int threshold) {
        return threshold <= acrobaticsLevel;
    }
}