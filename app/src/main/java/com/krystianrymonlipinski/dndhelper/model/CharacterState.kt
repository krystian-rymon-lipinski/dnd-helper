package com.krystianrymonlipinski.dndhelper.model

class CharacterState(
    val basicsState: CharacterBasicsState = CharacterBasicsState(
        hitPoints = 20,
        armorClass = 12,
        initiative = 3,
        speed = 12
    ),
    val abilityScoresState: CharacterAbilityScoresState = CharacterAbilityScoresState(
        strength = 16,
        dexterity = 14,
        constitution = 15,
        intelligence = 12,
        wisdom = 10,
        charisma = 8
    )
) {
}