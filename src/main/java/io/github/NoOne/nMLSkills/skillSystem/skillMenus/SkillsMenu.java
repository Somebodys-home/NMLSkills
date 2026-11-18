package io.github.NoOne.nMLSkills.skillSystem.skillMenus;

import io.github.NoOne.menuSystem.Menu;
import io.github.NoOne.nMLItems.ItemCreator;
import io.github.NoOne.nMLSkills.NMLSkills;
import io.github.NoOne.nMLSkills.skillSystem.Skill;
import io.github.NoOne.nMLSkills.skillSystem.Skills;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class SkillsMenu extends Menu {
    private NMLSkills nmlSkills;
    private Skills skills;

    public SkillsMenu(Player player, NMLSkills nmlSkills) {
        super(player);

        this.nmlSkills = nmlSkills;
        skills = nmlSkills.getSaveSkillsManager().getSkills(player.getUniqueId());
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
            case 25 -> new AcrobaticsMenu(player, nmlSkills).open();
            case 33 -> new FarmingMenu(player, nmlSkills).open();
            case 44 -> player.closeInventory();
        }
    }

    @Override
    public void handlePlayerMenu(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    @Override
    public void setMenuItems() {
        double combatPercent = skills.calculateExpPercent(Skill.COMBAT) * 100.0;
        double foragingPercent = skills.calculateExpPercent(Skill.FORAGING) * 100.0;
        double miningPercent = skills.calculateExpPercent(Skill.MINING) * 100.0;
        double fishingPercent = skills.calculateExpPercent(Skill.FISHING) * 100.0;
        double farmingPercent = skills.calculateExpPercent(Skill.FARMING) * 100.0;
        double craftingPercent = skills.calculateExpPercent(Skill.CRAFTING) * 100.0;
        double cookingPercent = skills.calculateExpPercent(Skill.COOKING) * 100.0;
        double acrobaticsPercent = skills.calculateExpPercent(Skill.ACROBATICS) * 100.0;
        double stealthPercent = skills.calculateExpPercent(Skill.STEALTH) * 100.0;

        ItemStack combatSkillItem = ItemCreator.createItem(
                Material.IRON_SWORD,
                "§fLv. " + skills.getSkillLevel(Skill.COMBAT) + " §4§l" + Skill.COMBAT.toTitle(),
                List.of(
                        "§8" + skills.getSkillExp(Skill.COMBAT) + " / " + skills.calculateExpToLvlUpSkill(Skill.COMBAT) + " exp (" + combatPercent + "%)",
                        "",
                        "§fClick to learn about combat!",
                        "",
                        "§8§oFIGHT TO LIVE, LIVE TO FIGHT!"
                )
        );
        combatSkillItem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        ItemStack foragingSkillItem = ItemCreator.createItem(
                Material.DARK_OAK_SAPLING,
                "§fLv. " + skills.getSkillLevel(Skill.FORAGING) + " §2§l" + Skill.FORAGING.toTitle(),
                List.of(
                        "§8" + skills.getSkillExp(Skill.FORAGING) + " / " + skills.calculateExpToLvlUpSkill(Skill.FORAGING) + " exp (" + foragingPercent + "%)",
                        "",
                        "§fClick to learn about foraging!",
                        "",
                        "§8§oAll natural, baby!"
                )
        );

        ItemStack miningSkillItem = ItemCreator.createItem(
                Material.DEEPSLATE_DIAMOND_ORE,
                "§fLv. " + skills.getSkillLevel(Skill.MINING) + " §3§l" + Skill.MINING.toTitle(),
                List.of(
                        "§8" + skills.getSkillExp(Skill.MINING) + " / " + skills.calculateExpToLvlUpSkill(Skill.MINING) + " exp (" + miningPercent + "%)",
                        "",
                        "§fClick to learn about mining!",
                        "",
                        "§8§oGet back in the mines little bro"
                )
        );

        ItemStack fishingSkillItem = ItemCreator.createItem(
                Material.FISHING_ROD,
                "§fLv. " + skills.getSkillLevel(Skill.FISHING) + " §b§l" + Skill.FISHING.toTitle(),
                List.of(
                        "§8" + skills.getSkillExp(Skill.FISHING) + " / " + skills.calculateExpToLvlUpSkill(Skill.FISHING) + " exp (" + fishingPercent + "%)",
                        "",
                        "§fClick to learn about fishing!",
                        "",
                        "§8§oYou too can become a bass pro!"
                )
        );

        ItemStack farmingSkillItem = ItemCreator.createItem(
                Material.WHEAT,
                "§fLv. " + skills.getSkillLevel(Skill.FARMING) + " §a§l" + Skill.FARMING.toTitle(),
                List.of(
                        "§8" + skills.getSkillExp(Skill.FARMING) + " / " + skills.calculateExpToLvlUpSkill(Skill.FARMING) + " exp (" + farmingPercent + "%)",
                        "",
                        "§fClick to learn about farming!",
                        "",
                        "§8§oIt ain't much, but it's honest work."
                )
        );

        ItemStack craftingSkillItem = ItemCreator.createItem(
                Material.CRAFTER,
                "§fLv. " + skills.getSkillLevel(Skill.CRAFTING) + " §6§l" + Skill.CRAFTING.toTitle(),
                List.of(
                        "§8" + skills.getSkillExp(Skill.CRAFTING) + " / " + skills.calculateExpToLvlUpSkill(Skill.CRAFTING) + " exp (" + craftingPercent + "%)",
                        "",
                        "§fClick to learn about crafting!",
                        "",
                        "§8§oMinecraft. That's it. That's the joke."
                )
        );

        ItemStack cookingSkillItem = ItemCreator.createItem(
                Material.FURNACE,
                "§fLv. " + skills.getSkillLevel(Skill.COOKING) + " §9§l" + Skill.COOKING.toTitle(),
                List.of(
                        "§8" + skills.getSkillExp(Skill.COOKING) + " / " + skills.calculateExpToLvlUpSkill(Skill.COOKING) + " exp (" + cookingPercent + "%)",
                        "",
                        "§fClick to learn about cooking!",
                        "",
                        "§8§oLET HIM COOK"
                )
        );

        ItemStack acrobaticsSkillItem = ItemCreator.createItem(
                Material.FEATHER,
                "§fLv. " + skills.getSkillLevel(Skill.ACROBATICS) + " §7§l" + Skill.ACROBATICS.toTitle(),
                List.of(
                        "§8" + skills.getSkillExp(Skill.ACROBATICS) + " / " + skills.calculateExpToLvlUpSkill(Skill.ACROBATICS) + " exp (" + acrobaticsPercent + "%)",
                        "",
                        "§fClick to learn about acrobatics!",
                        "",
                        "§8§oWell it's more like parkour but whatever."
                )
        );

        ItemStack stealthSkillItem = ItemCreator.createItem(
                Material.SCULK,
                "§fLv. " + skills.getSkillLevel(Skill.STEALTH) + " §8§l" + Skill.STEALTH.toTitle(),
                List.of(
                        "§8" + skills.getSkillExp(Skill.STEALTH) + " / " + skills.calculateExpToLvlUpSkill(Skill.STEALTH) + " exp (" + stealthPercent + "%)",
                        "",
                        "§fClick to learn about stealth!",
                        "",
                        "§8§oWho likes being around people anyways?"
                )
        );

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