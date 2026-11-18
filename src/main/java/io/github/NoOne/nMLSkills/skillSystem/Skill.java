package io.github.NoOne.nMLSkills.skillSystem;

import java.util.List;

public enum Skill {
    // regular skills
    COMBAT,
    FORAGING,
    MINING,
    FISHING,
    FARMING,
    CRAFTING,
    COOKING,
    ACROBATICS,
    STEALTH,

    // expertise skills
    SOLDIER,
    MARAUDER,
    ASSASSIN,
    CAVALIER,
    MARTIAL_ARTIST,
    SHIELD_HERO,
    MARKSMAN,
    SORCERER,
    PRIMORDIAL,
    HALLOWED,
    ANNULLED;

    @Override
    public String toString() {
        return switch (this) {
            case COMBAT -> "combat";
            case FORAGING -> "foraging";
            case MINING -> "mining";
            case FISHING -> "fishing";
            case FARMING -> "farming";
            case CRAFTING -> "crafting";
            case COOKING -> "cooking";
            case ACROBATICS -> "acrobatics";
            case STEALTH -> "stealth";
            case SOLDIER -> "soldier";
            case MARAUDER -> "marauder";
            case ASSASSIN -> "assassin";
            case CAVALIER -> "cavalier";
            case MARTIAL_ARTIST -> "martialArtist";
            case SHIELD_HERO -> "shieldHero";
            case MARKSMAN -> "marksman";
            case SORCERER -> "sorcerer";
            case PRIMORDIAL -> "primordial";
            case HALLOWED -> "hallowed";
            case ANNULLED -> "annulled";
        };
    }

    // mainly for the skill bars and menu
    public String toTitle() {
        return switch (this) {
            case COMBAT -> "Fighter";
            case FORAGING -> "Forager";
            case MINING -> "Miner";
            case FISHING -> "Fisherman";
            case FARMING -> "Farmer";
            case CRAFTING -> "Craftsman";
            case COOKING -> "Chef";
            case ACROBATICS -> "Acrobat";
            case STEALTH -> "Skulker";
            case SOLDIER -> "Soldier";
            case MARAUDER -> "Marauder";
            case ASSASSIN -> "Assassin";
            case CAVALIER -> "Cavalier";
            case MARTIAL_ARTIST -> "Martial Artist";
            case SHIELD_HERO -> "Shield Hero";
            case MARKSMAN -> "Marksman";
            case SORCERER -> "Sorcerer";
            case PRIMORDIAL -> "Primordial";
            case HALLOWED -> "Hallowed";
            case ANNULLED -> "Annulled";
        };
    }

    public static Skill fromString(String skill) {
        return switch (skill.toLowerCase()) {
            case "combat" -> COMBAT;
            case "foraging" -> FORAGING;
            case "mining" -> MINING;
            case "fishing" -> FISHING;
            case "farming" -> FARMING;
            case "crafting" -> CRAFTING;
            case "cooking" -> COOKING;
            case "acrobatics" -> ACROBATICS;
            case "stealth" -> STEALTH;
            case "soldier" -> SOLDIER;
            case "marauder" -> MARAUDER;
            case "assassin" -> ASSASSIN;
            case "cavalier" -> CAVALIER;
            case "martialartist" -> MARTIAL_ARTIST;
            case "shieldhero" -> SHIELD_HERO;
            case "marksman" -> MARKSMAN;
            case "sorcerer" -> SORCERER;
            case "primordial" -> PRIMORDIAL;
            case "hallowed" -> HALLOWED;
            case "annulled" -> ANNULLED;
            default -> null;
        };
    }

    public static List<Skill> getExpertiseSkills() {
        return List.of(SOLDIER, MARAUDER, ASSASSIN, CAVALIER, MARTIAL_ARTIST, SHIELD_HERO, MARKSMAN, SORCERER, PRIMORDIAL, HALLOWED, ANNULLED);
    }
}
