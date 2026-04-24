package io.github.NoOne.nMLSkills.skillSystem.skillMenus;

import io.github.NoOne.menuSystem.Menu;
import io.github.NoOne.menuSystem.PlayerMenuUtility;
import io.github.NoOne.nMLItems.ItemCreator;
import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.skillSystem.Skills;
import io.github.NoOne.nMLSkills.skillSystem.skillMenus.farming.FarmingMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class SkillsMenu extends Menu {
    private NMLSkills nmlSkills;
    private Player player;
    private ItemStack combatSkillItem;
    private ItemStack foragingSkillItem;
    private ItemStack miningSkillItem;
    private ItemStack fishingSkillItem;
    private ItemStack farmingSkillItem;
    private ItemStack craftingSkillItem;
    private ItemStack cookingSkillItem;
    private ItemStack acrobaticsSkillItem;
    private ItemStack stealthSkillItem;

    public SkillsMenu(PlayerMenuUtility playerMenuUtility, NMLSkills nmlSkills) {
        super(playerMenuUtility);

        this.nmlSkills = nmlSkills;
        player = playerMenuUtility.getOwner();
        Skills skills = nmlSkills.getSkillSetManager().getSkillSet(player.getUniqueId()).getSkills();

        double combatPercent = skills.getCombatExp() / skills.getExp2LvlUpCombat() * 100.0;
        combatSkillItem = ItemCreator.createItem(
                Material.IRON_SWORD,
                "§fLv. " + skills.getCombatLevel() + " §4§lWarrior",
                List.of(
                        "§8" + skills.getCombatExp() + " / " + skills.getExp2LvlUpCombat() + " exp (" + combatPercent + "%)",
                        "",
                        "§fClick to learn about combat!",
                        "",
                        "§8§oFIGHT TO LIVE, LIVE TO FIGHT!"
                )
        );
        combatSkillItem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        double foragingPercent = skills.getForagingExp() / skills.getExp2LvlUpForaging() * 100.0;
        foragingSkillItem = ItemCreator.createItem(
                Material.DARK_OAK_SAPLING,
                "§fLv. " + skills.getForagingLevel() + " §2§lForager",
                List.of(
                        "§8" + skills.getForagingExp() + " / " + skills.getExp2LvlUpForaging() + " exp (" + foragingPercent + "%)",
                        "",
                        "§fClick to learn about foraging!",
                        "",
                        "§8§oAll natural, baby!"
                )
        );

        double miningPercent = skills.getMiningExp() / skills.getExp2LvlUpMining() * 100.0;
        miningSkillItem = ItemCreator.createItem(
                Material.DEEPSLATE_DIAMOND_ORE,
                "§fLv. " + skills.getMiningLevel() + " §3§lMiner",
                List.of(
                        "§8" + skills.getMiningExp() + " / " + skills.getExp2LvlUpMining() + " exp (" + miningPercent + "%)",
                        "",
                        "§fClick to learn about mining!",
                        "",
                        "§8§oGet back in the mines little bro"
                )
        );

        double fishingPercent = skills.getFishingExp() / skills.getExp2LvlUpFishing() * 100.0;
        fishingSkillItem = ItemCreator.createItem(
                Material.FISHING_ROD,
                "§fLv. " + skills.getFishingLevel() + " §b§lFisherman",
                List.of(
                        "§8" + skills.getFishingExp() + " / " + skills.getExp2LvlUpFishing() + " exp (" + fishingPercent + "%)",
                        "",
                        "§fClick to learn about fishing!",
                        "",
                        "§8§oYou too can become a bass pro!"
                )
        );

        double farmingPercent = skills.getFarmingExp() / skills.getExp2LvlUpFarming() * 100.0;
        farmingSkillItem = ItemCreator.createItem(
                Material.WHEAT,
                "§fLv. " + skills.getFarmingLevel() + " §a§lFarmer",
                List.of(
                        "§8" + skills.getFarmingExp() + " / " + skills.getExp2LvlUpFarming() + " exp (" + farmingPercent + "%)",
                        "",
                        "§fClick to learn about farming!",
                        "",
                        "§8§oIt ain't much, but it's honest work."
                )
        );

        double craftingPercent = skills.getCraftingExp() / skills.getExp2LvlUpCrafting() * 100.0;
        craftingSkillItem = ItemCreator.createItem(
                Material.CRAFTER,
                "§fLv. " + skills.getCraftingLevel() + " §6§lCrafter",
                List.of(
                        "§8" + skills.getCraftingExp() + " / " + skills.getExp2LvlUpCrafting() + " exp (" + craftingPercent + "%)",
                        "",
                        "§fClick to learn about crafting!",
                        "",
                        "§8§oMinecraft. That's it. That's the joke."
                )
        );

        double cookingPercent = skills.getCookingExp() / skills.getExp2LvlUpCooking() * 100.0;
        cookingSkillItem = ItemCreator.createItem(
                Material.FURNACE,
                "§fLv. " + skills.getCookingLevel() + " §9§lChef",
                List.of(
                        "§8" + skills.getCookingExp() + " / " + skills.getExp2LvlUpCooking() + " exp (" + cookingPercent + "%)",
                        "",
                        "§fClick to learn about cooking!",
                        "",
                        "§8§oLET HIM COOK"
                )
        );

        double acrobaticsPercent = skills.getAcrobaticsExp() / skills.getExp2LvlUpAcrobatics() * 100.0;
        acrobaticsSkillItem = ItemCreator.createItem(
                Material.FEATHER,
                "§fLv. " + skills.getAcrobaticsLevel() + " §7§lAcrobat",
                List.of(
                        "§8" + skills.getAcrobaticsExp() + " / " + skills.getExp2LvlUpAcrobatics() + " exp (" + acrobaticsPercent + "%)",
                        "",
                        "§fClick to learn about acrobatics!",
                        "",
                        "§8§oWell it's like parkour but whatever."
                )
        );

        double stealthPercent = skills.getStealthExp() / skills.getExp2LvlUpStealth() * 100.0;
        stealthSkillItem = ItemCreator.createItem(
                Material.SCULK,
                "§fLv. " + skills.getStealthLevel() + " §8§lSkulker",
                List.of(
                        "§8" + skills.getStealthExp() + " / " + skills.getExp2LvlUpStealth() + " exp (" + stealthPercent + "%)",
                        "",
                        "§fClick to learn about stealth!",
                        "",
                        "§8§oWho likes being around people anyways?"
                )
        );
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
            case 33 -> new FarmingMenu(playerMenuUtility, nmlSkills).open();
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
        inventory.setItem(44, ItemCreator.createBackoutButton());
    }
}