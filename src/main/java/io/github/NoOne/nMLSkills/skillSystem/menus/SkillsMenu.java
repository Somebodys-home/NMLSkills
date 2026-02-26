package io.github.NoOne.nMLSkills.skillSystem.menus;

import io.github.NoOne.menuSystem.Menu;
import io.github.NoOne.menuSystem.PlayerMenuUtility;
import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.skillSystem.Skills;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SkillsMenu extends Menu {
    private final NMLSkills nmlSkills;
    private final Player player;
    private final ItemStack backButton;
    private final ItemStack combatSkillItem;
    private final ItemStack foragingSkillItem;
    private final ItemStack miningSkillItem;
    private final ItemStack fishingSkillItem;
    private final ItemStack farmingSkillItem;
    private final ItemStack craftingSkillItem;
    private final ItemStack cookingSkillItem;
    private final ItemStack acrobaticsSkillItem;
    private final ItemStack stealthSkillItem;

    public SkillsMenu(PlayerMenuUtility playerMenuUtility, NMLSkills nmlSkills) {
        super(playerMenuUtility);

        this.nmlSkills = nmlSkills;
        player = playerMenuUtility.getOwner();
        Skills skills = nmlSkills.getSkillSetManager().getSkillSet(player.getUniqueId()).getSkills();

        backButton = new ItemStack(Material.BARRIER);
        ItemMeta backButtonItemMeta = backButton.getItemMeta();
        backButtonItemMeta.setDisplayName("§c§lExit");
        backButton.setItemMeta(backButtonItemMeta);

        combatSkillItem = new ItemStack(Material.IRON_SWORD);
        ItemMeta combatMeta = combatSkillItem.getItemMeta();
        combatMeta.setDisplayName("§fLv. " + skills.getCombatLevel() + " §4§lWarrior");
        combatMeta.setLore(List.of(
                "§7Click to learn more about combat!",
                "",
                "§8§oFIGHT TO LIVE, LIVE TO FIGHT!"
        ));
        combatMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        combatSkillItem.setItemMeta(combatMeta);

        foragingSkillItem = new ItemStack(Material.DARK_OAK_SAPLING);
        ItemMeta foragingMeta = foragingSkillItem.getItemMeta();
        foragingMeta.setDisplayName("§fLv. " + skills.getForagingLevel() + " §2§lForager");
        foragingMeta.setLore(List.of(
                "§7Click to learn more about foraging!",
                "",
                "§8§oAll natural, baby!"
        ));
        foragingSkillItem.setItemMeta(foragingMeta);

        miningSkillItem = new ItemStack(Material.DEEPSLATE_DIAMOND_ORE);
        ItemMeta miningMeta = miningSkillItem.getItemMeta();
        miningMeta.setDisplayName("§fLv. " + skills.getMiningLevel() + " §3§lMiner");
        miningMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        miningMeta.setLore(List.of(
                "§7Click to learn more about mining!",
                "",
                "§8§oGet back in the mines little bro"
        ));
        miningSkillItem.setItemMeta(miningMeta);

        fishingSkillItem = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingMeta = fishingSkillItem.getItemMeta();
        fishingMeta.setDisplayName("§fLv. " + skills.getFishingLevel() + " §b§lFisherman");
        fishingMeta.setLore(List.of(
                "§7Click to learn more about fishing!",
                "",
                "§8§oYou too can become a bass pro!"
        ));
        fishingSkillItem.setItemMeta(fishingMeta);

        farmingSkillItem = new ItemStack(Material.WHEAT);
        ItemMeta farmingMeta = farmingSkillItem.getItemMeta();
        farmingMeta.setDisplayName("§fLv. " + skills.getFarmingLevel() + " §a§lFarmer");
        farmingMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        farmingMeta.setLore(List.of(
                "§7Click to learn more about farming!",
                "",
                "§8§oIt ain't much, but it's honest work."
        ));
        farmingSkillItem.setItemMeta(farmingMeta);

        craftingSkillItem = new ItemStack(Material.CRAFTER);
        ItemMeta craftingMeta = craftingSkillItem.getItemMeta();
        craftingMeta.setDisplayName("§fLv. " + skills.getCraftingLevel() + " §6§lCrafter");
        craftingMeta.setLore(List.of(
                "§7Click to learn more about crafting!",
                "",
                "§8§oMinecraft. That's it, that's the joke."
        ));
        craftingSkillItem.setItemMeta(craftingMeta);

        cookingSkillItem = new ItemStack(Material.FURNACE);
        ItemMeta cookingMeta = cookingSkillItem.getItemMeta();
        cookingMeta.setDisplayName("§fLv. " + skills.getCraftingLevel() + " §9§lChef");
        cookingMeta.setLore(List.of(
                "§7Click to learn more about cooking!",
                "",
                "§8§oLET HIM COOK"
        ));
        cookingSkillItem.setItemMeta(cookingMeta);

        acrobaticsSkillItem = new ItemStack(Material.FEATHER);
        ItemMeta acrobaticsMeta = acrobaticsSkillItem.getItemMeta();
        acrobaticsMeta.setDisplayName("§fLv. " + skills.getAcrobaticsLevel() + " §7§lAcrobat");
        acrobaticsMeta.setLore(List.of(
                "§7Click to learn more about acrobatics!",
                "",
                "§8§oWell it's more like parkour but whatever."
        ));
        acrobaticsSkillItem.setItemMeta(acrobaticsMeta);

        stealthSkillItem = new ItemStack(Material.SCULK);
        ItemMeta stealthMeta = stealthSkillItem.getItemMeta();
        stealthMeta.setDisplayName("§fLv. " + skills.getStealthLevel() + " §8§lSkulker");
        stealthMeta.setLore(List.of(
                "§7Click to learn more about stealth!",
                "",
                "§8§oWho likes being around people anyways?"
        ));
        stealthSkillItem.setItemMeta(stealthMeta);
    }

    @Override
    public String getMenuName() {
        return "Your Skill Set";
    }

    @Override
    public int getSlots() {
        return 9 * 5;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        event.setCancelled(true);

        switch (event.getSlot()) {
            case 25 -> new AcrobaticsMenu(playerMenuUtility, nmlSkills).open();
            case 44 -> player.closeInventory();
        }
    }

    @Override
    public void handlePlayerMenu(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    @Override
    public void setMenuItems() {
        inventory.setItem(4, craftingSkillItem);
        inventory.setItem(11, foragingSkillItem);
        inventory.setItem(15, miningSkillItem);
        inventory.setItem(19, stealthSkillItem);
        inventory.setItem(22, combatSkillItem);
        inventory.setItem(25, acrobaticsSkillItem);
        inventory.setItem(29, fishingSkillItem);
        inventory.setItem(33, farmingSkillItem);
        inventory.setItem(40, cookingSkillItem);
        inventory.setItem(44, backButton);
    }
}