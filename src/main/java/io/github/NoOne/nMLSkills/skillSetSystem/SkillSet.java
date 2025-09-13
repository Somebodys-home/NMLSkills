package io.github.NoOne.nMLSkills.skillSetSystem;

import io.github.NoOne.nMLSkills.skillSystem.Skills;

public class SkillSet {
    private Skills skills;

    public SkillSet(Skills skills) {
        this.skills = skills;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }
}
