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
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class SkillsMenu extends Menu {
    private NMLSkills nmlSkills;
    private Player player;
    private Skills skills;
    private ItemStack you;
    private final ItemStack backButton;
    private ItemStack foragingSkillItem;
    private ItemStack miningSkillItem;
    private ItemStack fishingSkillItem;
    private ItemStack cultivatingSkillItem;
    private ItemStack craftingSkillItem;
    private ItemStack cookingSkillItem;
    private ItemStack acrobaticsSkillItem;
    private ItemStack stealthSkillItem;

    public SkillsMenu(PlayerMenuUtility playerMenuUtility, NMLSkills nmlSkills) {
        super(playerMenuUtility);

        this.nmlSkills = nmlSkills;
        player = playerMenuUtility.getOwner();
        skills = nmlSkills.getSkillSetManager().getSkillSet(player.getUniqueId()).getSkills();

        you = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta yourMeta = (SkullMeta) you.getItemMeta();
            yourMeta.setDisplayName("§b* It's You!");
            yourMeta.setOwningPlayer(player);
            you.setItemMeta(yourMeta);

        backButton = new ItemStack(Material.BARRIER);
            ItemMeta backButtonItemMeta = backButton.getItemMeta();
            backButtonItemMeta.setDisplayName("§4§lExit");
            backButton.setItemMeta(backButtonItemMeta);

        foragingSkillItem = new ItemStack(Material.DARK_OAK_SAPLING);
            ItemMeta foragingMeta = foragingSkillItem.getItemMeta();
            List<String> foragingLore = new ArrayList<>();
            foragingMeta.setDisplayName("§fLv. " + skills.getForagingLevel() + " §2§lForager");
            foragingLore.add("§7Click to learn more about foraging!");
            foragingLore.add("");
            foragingLore.add("§7§oReject modernity, return to caveman");
            foragingMeta.setLore(foragingLore);
            foragingSkillItem.setItemMeta(foragingMeta);

        miningSkillItem = new ItemStack(Material.DEEPSLATE_DIAMOND_ORE);
            ItemMeta miningMeta = miningSkillItem.getItemMeta();
            List<String> miningLore = new ArrayList<>();
            miningMeta.setDisplayName("§fLv. " + skills.getMiningLevel() + " §3§lMiner");
            miningLore.add("§7Click to learn more about mining!");
            miningLore.add("");
            miningLore.add("§7§oGet back in the mines little bro");
            miningMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            miningMeta.setLore(miningLore);
            miningSkillItem.setItemMeta(miningMeta);

        fishingSkillItem = new ItemStack(Material.FISHING_ROD);
            ItemMeta fishingMeta = fishingSkillItem.getItemMeta();
            List<String> fishingLore = new ArrayList<>();
            fishingMeta.setDisplayName("§fLv. " + skills.getFishingLevel() + " §b§lFisherman");
            fishingLore.add("§7Click to learn more about fishing!");
            fishingLore.add("");
            fishingLore.add("§7§oAh yes, the skill universal for escaping your wife");
            fishingLore.add("§7§owhile women escape you in real life");
            fishingMeta.setLore(fishingLore);
            fishingSkillItem.setItemMeta(fishingMeta);

        cultivatingSkillItem = new ItemStack(Material.WHEAT);
            ItemMeta cultivatingMeta = cultivatingSkillItem.getItemMeta();
            List<String> cultivatingLore = new ArrayList<>();
            cultivatingMeta.setDisplayName("§fLv. " + skills.getCultivatingLevel() + " §a§lFarmer");
            cultivatingLore.add("§7Click to learn more about cultivating!");
            cultivatingLore.add("");
            cultivatingLore.add("§7§oWhat's Roblox?");
            cultivatingMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            cultivatingMeta.setLore(cultivatingLore);
            cultivatingSkillItem.setItemMeta(cultivatingMeta);

        craftingSkillItem = new ItemStack(Material.CRAFTER);
            ItemMeta craftingMeta = craftingSkillItem.getItemMeta();
            List<String> craftingLore = new ArrayList<>();
            craftingMeta.setDisplayName("§fLv. " + skills.getCraftingLevel() + " §6§lCrafter");
            craftingLore.add("§7Click to learn more about crafting!");
            craftingLore.add("");
            craftingLore.add("§7§oMinecraft. That's it, that's the joke.");
            craftingMeta.setLore(craftingLore);
            craftingSkillItem.setItemMeta(craftingMeta);

        cookingSkillItem = new ItemStack(Material.FURNACE);
            ItemMeta cookingMeta = cookingSkillItem.getItemMeta();
            List<String> cookingLore = new ArrayList<>();
            cookingMeta.setDisplayName("§fLv. " + skills.getCraftingLevel() + " §9§lChef");
            cookingLore.add("§7Click to learn more about cooking!");
            cookingLore.add("");
            cookingLore.add("§7§oI SAID, LET. HIM. COOK.");
            cookingMeta.setLore(cookingLore);
            cookingSkillItem.setItemMeta(cookingMeta);

        acrobaticsSkillItem = new ItemStack(Material.FEATHER);
            ItemMeta acrobaticsMeta = acrobaticsSkillItem.getItemMeta();
            List<String> acrobaticsLore = new ArrayList<>();
            acrobaticsMeta.setDisplayName("§fLv. " + skills.getCraftingLevel() + " §7§lAcrobat");
            acrobaticsLore.add("§7Click to learn more about acrobatics!");
            acrobaticsLore.add("");
            acrobaticsLore.add("§7§oWell it's more like parkour but whatever.");
            acrobaticsMeta.setLore(acrobaticsLore);
            acrobaticsSkillItem.setItemMeta(acrobaticsMeta);

        stealthSkillItem = new ItemStack(Material.SCULK);
            ItemMeta stealthMeta = stealthSkillItem.getItemMeta();
            List<String> stealthLore = new ArrayList<>();
            stealthMeta.setDisplayName("§fLv. " + skills.getCraftingLevel() + " §8§lSkulker");
            stealthLore.add("§7Click to learn more about stealth!");
            stealthLore.add("");
            stealthLore.add("§7§o...It's hot sometimes.");
            stealthMeta.setLore(stealthLore);
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
        inventory.setItem(22, you);
        inventory.setItem(25, acrobaticsSkillItem);
        inventory.setItem(29, fishingSkillItem);
        inventory.setItem(33, cultivatingSkillItem);
        inventory.setItem(40, cookingSkillItem);
        inventory.setItem(44, backButton);
    }
}