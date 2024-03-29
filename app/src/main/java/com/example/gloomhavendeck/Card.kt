package com.example.gloomhavendeck

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.serialization.Serializable

@Serializable
data class Card(
    var value: Int = 0,
    var multiplier: Boolean = false,
    var nullOrCurse: Boolean = false, // TODO replace with curse, bless, null, and properties for lose and cancelsDamage
    var flippy: Boolean = false,
    var spinny: Boolean = false,
    var lose: Boolean = false,

    var stun: Boolean = false,
    var muddle: Boolean = false,
    var invisible: Boolean = false,
    var refresh: Boolean = false,
    var pierce: Int = 0,
    var extraTarget: Boolean = false,
    val healAlly: Int = 0,
    val shieldSelf: Int = 0,
    val element: Element? = null,
    val regenerate: Boolean = false,
    val poison: Boolean = false,
    val curses: Boolean = false,
) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun effect(Controller: Controller, doingDisadvantage: Boolean = false, displayBenefitsAsRemoved: Boolean = false): Effect {

        // Named
        val effectToAdd : Effect = if ("null" in toString())
            Effect(sound=SoundBundle.NULL, card=R.drawable.card_null)
        else if ("curse" in toString())
            Effect(sound=SoundBundle.CURSE, card=R.drawable.card_curse)
        else if ("bless" in toString())
            Effect(sound=SoundBundle.BLESS, card=R.drawable.card_bless)


        // Effects
        else if (pierce > 0)
            Effect(sound=SoundBundle.PIERCE, card=R.drawable.card_pierce)
        else if ("+3" in toString() && muddle)
            Effect(sound=SoundBundle.MUDDLE, card=R.drawable.card_plus3muddle)
        else if (muddle)
            Effect(sound=SoundBundle.MUDDLE, card=R.drawable.card_muddle)
        else if (stun)
            Effect(sound=SoundBundle.STUN, card=R.drawable.card_stun)
        else if (invisible)
            Effect(sound=SoundBundle.DEFAULT, card=R.drawable.card_invisible)
        else if (extraTarget)
            Effect(sound=SoundBundle.EXTRATARGET, card=R.drawable.card_extra_target)
        else if (refresh)
            Effect(sound=SoundBundle.REFRESH, card=R.drawable.card_refresh)
        else if (healAlly > 0)
            Effect(sound=SoundBundle.HEAL, card=R.drawable.card_plus1healally)
        else if (shieldSelf > 0)
            Effect(sound=SoundBundle.SHIELD, card=R.drawable.card_plus3shield)
        else if (element == Element.DARK)
            Effect(sound=SoundBundle.DARK, card=R.drawable.card_plus2dark)
        else if (regenerate)
            Effect(sound=SoundBundle.REGENERATE, card=R.drawable.card_plus2regenerate)
        else if (poison)
            Effect(sound=SoundBundle.POISON, card=R.drawable.card_poison)
        else if (curses)
            Effect(sound=SoundBundle.CURSEADDED, card=R.drawable.card_plus2curse)

        // Numbers
        else if ("-2" in toString())
            Effect(sound=SoundBundle.MINUS2, card=R.drawable.card_minus2)
        else if (flippy && "-1" in toString())
            Effect(sound=SoundBundle.MINUS1, card=R.drawable.card_minus1_flippy)
        else if ("-1" in toString())
            Effect(sound=SoundBundle.MINUS1, card=R.drawable.card_minus1)
        else if ("+0" in toString())
            Effect(sound=SoundBundle.DEFAULT, card=R.drawable.card_plus0)
        else if (flippy && "+1" in toString())
            Effect(sound=SoundBundle.PLUS1, card=R.drawable.card_plus1_flippy)
        else if ("+1" in toString())
            Effect(sound=SoundBundle.PLUS1, card=R.drawable.card_plus1)
        else if ("+2" in toString())
            Effect(sound=SoundBundle.PLUS2, card=R.drawable.card_plus2)
        else if ("x2" in toString())
            Effect(sound=SoundBundle.X2, card=R.drawable.card_x2)
        else
            Effect(sound=SoundBundle.ITEMUNUSABLE, card=R.drawable.card_what)
        // Replace sound if it's in disadvantage
        if (flippy && doingDisadvantage) {
            effectToAdd.sound = SoundBundle.DISADVANTAGE
        }

        if (displayBenefitsAsRemoved && hasSpecialBenefits()) {
            effectToAdd.cardForeground = R.drawable.card_nerf_fg
            effectToAdd.sound = SoundBundle.DISADVANTAGE
        }

        return effectToAdd
    }

    fun withoutSpecialBenefits(): Card {
        //TODO find a way to mark the properties directly
        return Card(value=value, multiplier=multiplier, lose=lose, flippy = flippy, nullOrCurse=nullOrCurse, spinny = spinny)
    }

    fun hasSpecialBenefits(): Boolean {
        return this != withoutSpecialBenefits()
    }

    override fun toString(): String {
        Card(healAlly = 2) + Card(healAlly = 2)
        // Named stuff
        if (lose && value == 2) {
            return " [bless] "
        }
        if (lose && value == 0) {
            return " [curse] "
        }
        if (value == 0 && nullOrCurse) {
            return " [null] "
        }

        var ret = ""
        ret += " ["

        if (stun) {ret += Status.STUN.icon}
        if (muddle) {ret += Status.MUDDLE.icon}
        if (refresh){ret += "\uD83D\uDC5C"}
        if (extraTarget) {ret += "\uD83C\uDFAF"}
        if (pierce > 0) {ret += "$pierce➺"}
        if (ret == " [" || value != 0 || multiplier) {
            ret += (if (multiplier) "x" else if (value >= 0) "+" else "") +
            value.toString()
        }

        if (flippy) {
            ret += "⤳"
        } else if (spinny) {
            ret += "⟳"
        }

        ret += "] "
        return ret
    }

    // Operators and such
    fun toInt(): Int {
        if (nullOrCurse) {
            return -99
        }
        return value * 2 + (
            if (pierce > 0 || stun || muddle || extraTarget || refresh) 1 else 0
        )
    }

    operator fun plus(increment: Card): Card {
        val retCard = this.copy()
        retCard.flippy = false // Since all the cards combine, this becomes irrelevant

        // The few properties that still apply if this is a null/curse
        retCard.spinny = retCard.spinny || increment.spinny
        retCard.nullOrCurse = retCard.nullOrCurse || increment.nullOrCurse

        // If it's a null/curse, end here, nothing else matters
        if (retCard.nullOrCurse) {
            retCard.value = 0
            return retCard
        }

        // and the rest of it
        if (increment.multiplier)
            retCard.value *= increment.value
        else
            retCard.value += increment.value
        retCard.pierce += increment.pierce
        retCard.stun = retCard.stun || increment.stun
        retCard.muddle = retCard.muddle || increment.muddle
        retCard.extraTarget = retCard.extraTarget || increment.extraTarget
        retCard.refresh = retCard.refresh || increment.refresh
        retCard.lose = retCard.lose || increment.lose // I'm not actually sure this needs to be here?

        return retCard
    }

    operator fun compareTo(comparison: Card): Int {
        return toInt() - comparison.toInt()
    }
}

fun List<Card>.sum(): Card {
    if (this.size == 1) {
        return this[0]
    }
    var retCard = this[0]
    for (card in this.subList(1, this.size)) {
        retCard += card
    }
    return retCard
}