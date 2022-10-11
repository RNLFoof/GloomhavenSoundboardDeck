package com.example.gloomhavendeck

import java.util.*
import kotlin.collections.HashMap


data class SoundBundle(var weights: LinkedHashMap<Any, Float>) {
    companion object{
        /* GENERATED BY nonsense/sounds/fix.py START */
        val PLUS1_GUITAR = SoundBundle(listOf(
            R.raw.plus1_guitar_guitar_impact1,
            R.raw.plus1_guitar_guitar_impact2,
        ))
        val PLUS1 = SoundBundle(
            LinkedHashMap(
                mapOf(
                    R.raw.plus1_bat_hit to 1f,
                    R.raw.plus1_hitsound to 1f,
                    R.raw.plus1_pan to 1f,
                    PLUS1_GUITAR to 0.5f,
        )))
        val PLUS2 = SoundBundle(listOf(
            R.raw.plus2_boom,
            R.raw.plus2_et_cagebreak,
            R.raw.plus2_explosion,
            R.raw.plus2_hamsterball_ball_break,
            R.raw.plus2_thwomp,
            R.raw.plus2_ttyd_jesus,
            R.raw.plus2_ttyd_layered_explosion,
        ))
        val MINUS1_GOO = SoundBundle(listOf(
            R.raw.minus1_goo_hamsterball_glue_stuck,
            R.raw.minus1_goo_lancersplat,
        ))
        val MINUS1 = SoundBundle(listOf(
            R.raw.minus1_et_playerdie,
            R.raw.minus1_fnf_death,
            MINUS1_GOO,
        ))
        val MINUS2 = SoundBundle(R.raw.minus2_mario_fall)
        val BLESS = SoundBundle(
            LinkedHashMap(
                mapOf(
                    R.raw.bless_cheer to 1f,
                    R.raw.bless_happy_birthday to 0.1f,
                    R.raw.bless_tada to 1f,
        )))
        val CURSE = SoundBundle(R.raw.curse_ttyd_ghost)
        val DEATH_AUDIES_XP = SoundBundle(listOf(
            R.raw.death_audies_xp_windows2kgoodbye,
            R.raw.death_audies_xp_xpgoodbye,
        ))
        val DEATH_AUDIES = SoundBundle(listOf(
            R.raw.death_audies_cartoonfall,
            R.raw.death_audies_foghorn,
            R.raw.death_audies_screamman,
            DEATH_AUDIES_XP,
        ))
        val DEATH_BEETHRO = SoundBundle(listOf(
            R.raw.death_beethro_beethrodie1,
            R.raw.death_beethro_beethrodie2,
        ))
        val DEATH_GRINDER = SoundBundle(listOf(
            R.raw.death_grinder_grinderhuman_01,
            R.raw.death_grinder_grinderhuman_02,
        ))
        val DEATH = SoundBundle(listOf(
            R.raw.death_americano,
            R.raw.death_die,
            R.raw.death_et_jetdie,
            R.raw.death_medic_mvm_class_is_dead03,
            R.raw.death_mvm_player_died,
            R.raw.death_poof,
            R.raw.death_ttyd_mario_fucking_dies,
            DEATH_AUDIES,
            DEATH_BEETHRO,
            DEATH_GRINDER,
        ))
        val DEFAULT_STONE = SoundBundle(listOf(
            R.raw.default_stone_stone1,
            R.raw.default_stone_stone2,
            R.raw.default_stone_stone3,
            R.raw.default_stone_stone4,
        ))
        val DEFAULT = SoundBundle(DEFAULT_STONE)
        val DISADVANTAGE = SoundBundle(R.raw.disadvantage_windows_xp_error)
        val DISCARD = SoundBundle(listOf(
            R.raw.discard_banana_slip,
            R.raw.discard_sneeze,
        ))
        val DRINK_LIQUID_AUDIES = SoundBundle(listOf(
            R.raw.drink_liquid_audies_drain,
            R.raw.drink_liquid_audies_pissmiss,
        ))
        val DRINK_LIQUID = SoundBundle(listOf(
            R.raw.drink_liquid_et_istolethis,
            R.raw.drink_liquid_splosh,
            DRINK_LIQUID_AUDIES,
        ))
        val DRINK = SoundBundle(
            LinkedHashMap(
                mapOf(
                    R.raw.drink_bottle_break to 0.1f,
                    R.raw.drink_drinking to 1f,
                    DRINK_LIQUID to 0.5f,
        )))
        val EXTRATARGET = SoundBundle(listOf(
            R.raw.extratarget_gun,
            R.raw.extratarget_hamsterball_catapult,
            R.raw.extratarget_sentry_spot_client,
        ))
        val JOHNSON = SoundBundle(R.raw.johnson_johnson)
        val JUMP_DEMOCHARGE = SoundBundle(listOf(
            R.raw.jump_democharge_demo_charge_windup1,
            R.raw.jump_democharge_demo_charge_windup2,
            R.raw.jump_democharge_demo_charge_windup3,
        ))
        val JUMP_TIMROCKETS = SoundBundle(listOf(
            R.raw.jump_timrockets_rocket_launch_also,
            R.raw.jump_timrockets_rocket_launch,
        ))
        val JUMP = SoundBundle(
            LinkedHashMap(
                mapOf(
                    R.raw.jump_bottlerocket to 1f,
                    R.raw.jump_et_balloondeflating to 0.05f,
                    R.raw.jump_et_flyingwhee to 0.05f,
                    R.raw.jump_et_missilefire to 1f,
                    R.raw.jump_et_springuse to 1f,
                    R.raw.jump_jack_in_the_box to 1f,
                    R.raw.jump_launch1 to 1f,
                    JUMP_DEMOCHARGE to 1f,
                    JUMP_TIMROCKETS to 1f,
        )))
        val MUDDLE = SoundBundle(R.raw.muddle_hamsterball_dizzy)
        val NULL = SoundBundle(
            LinkedHashMap(
                mapOf(
                    R.raw.null_buzzer to 1f,
                    R.raw.null_nope to 0.1f,
                    R.raw.null_your_team_lost to 0.05f,
        )))
        val PENDANTOFDARKPACTS = SoundBundle(R.raw.pendantofdarkpacts_loud_bird)
        val PIERCE = SoundBundle(R.raw.pierce_shield_break)
        val REFRESH = SoundBundle(listOf(
            R.raw.refresh_chest_open,
            R.raw.refresh_h553,
        ))
        val RINGOFBRUTALITY = SoundBundle(
            LinkedHashMap(
                mapOf(
                    R.raw.ringofbrutality_onemoretimesoft to 0.02f,
                    R.raw.ringofbrutality_one_more_time to 1f,
        )))
        val SHIELD_IRONDOOR = SoundBundle(listOf(
            R.raw.shield_irondoor_close1,
            R.raw.shield_irondoor_close2,
            R.raw.shield_irondoor_close3,
            R.raw.shield_irondoor_close4,
        ))
        val SHIELD_IRONGOLEM = SoundBundle(listOf(
            R.raw.shield_irongolem_hit1,
            R.raw.shield_irongolem_hit2,
            R.raw.shield_irongolem_hit3,
            R.raw.shield_irongolem_hit4,
        ))
        val SHIELD_MCSHIELD = SoundBundle(listOf(
            R.raw.shield_mcshield_block1,
            R.raw.shield_mcshield_block2,
            R.raw.shield_mcshield_block3,
            R.raw.shield_mcshield_block4,
            R.raw.shield_mcshield_block5,
        ))
        val SHIELD_WOODDOOR = SoundBundle(listOf(
            R.raw.shield_wooddoor_close,
            R.raw.shield_wooddoor_close2,
            R.raw.shield_wooddoor_close3,
            R.raw.shield_wooddoor_close4,
            R.raw.shield_wooddoor_close5,
            R.raw.shield_wooddoor_close6,
        ))
        val SHIELD = SoundBundle(
            LinkedHashMap(
                mapOf(
                    SHIELD_IRONDOOR to 1f,
                    SHIELD_IRONGOLEM to 1f,
                    SHIELD_MCSHIELD to 1f,
                    SHIELD_WOODDOOR to 0.1f,
        )))
        val SHUFFLE = SoundBundle(R.raw.shuffle_shuffle)
        val STRENGTHEN = SoundBundle(R.raw.strengthen_ringside)
        val STUN = SoundBundle(listOf(
            R.raw.stun_ttyd_dizzy_dial,
            R.raw.stun_ttyd_sleep,
            R.raw.stun_ttyd_timestop,
        ))
        val SUMMON = SoundBundle(listOf(
            R.raw.summon_knight_spawn,
            R.raw.summon_roar,
            R.raw.summon_sm64_painting,
        ))
        val UTILITYBELT = SoundBundle(R.raw.utilitybelt_metal_falling)
        val X2 = SoundBundle(
            LinkedHashMap(
                mapOf(
                    R.raw.x2_blast_zone to 1f,
                    R.raw.x2_bong to 0.1f,
        )))        /* GENERATED BY nonsense/sounds/fix.py END */
    }

    constructor(): this(LinkedHashMap())

    constructor(i: Iterable<Any>) : this() {
        i.forEach { weights[it] = 1f }
    }

    constructor(i: Any) : this(listOf(i)) {
    }

    fun getSound(): Any {
        if (weights.size == 0) {
            throw Exception("No freaking sounds in this bundle")
        }

        val totalWeight = weights.values.sum()
        var countdown = Math.random() * totalWeight
        var countup = 0
        while (true) {
            val currentSound = weights.keys.toList()[countup]
            val currentWeight = weights[currentSound]!!
            countdown -= currentWeight
            if (countdown <= 0) {
                try {
                    return (currentSound as SoundBundle).getSound()
                } catch(e : Exception) {
                    return currentSound
                }
            }
            countup++
        }
    }
}