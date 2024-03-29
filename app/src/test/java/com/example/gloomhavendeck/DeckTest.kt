package com.example.gloomhavendeck


import com.example.gloomhavendeck.Enemy.Companion.createMany
import com.example.gloomhavendeck.Enemy.Companion.interestingPipisTeams
import com.example.gloomhavendeck.meta.Saver
import org.junit.Assert
import org.junit.Test
import org.junit.Before

internal class DeckTest {
    lateinit var deck: Deck

    @Test
    fun drawRow() {
        deck.drawPile = mutableListOf(Card(value=2, stun = true))
        var combinedCard = deck.drawRow().sum()
        Assert.assertEquals(2, combinedCard.value)
        Assert.assertTrue(combinedCard.stun)


        deck.drawPile = mutableListOf(Card(value=2, stun = true))
        combinedCard = deck.drawRow(withoutSpecialBenefits = true).sum()
        Assert.assertEquals(2, combinedCard.value)
        Assert.assertFalse(combinedCard.stun)
    }

    @Test
    fun Pipis() {
        val player = Player(26)
        fun pipisTheseEnemies(enemies: List<Enemy>) {
            if (enemies.size == 0) {
                return
            }
            val originalState = enemies.toString()
            for ((i, enemy) in enemies.withIndex()) {
                if (i % 4 == 0) {
                    enemy.targeted = true
                } else {
                    enemy.extraTarget = true
                }
            }
            deck.pipis(player, enemies)
            Assert.assertNotEquals(originalState, enemies.toString())
        }

        for (enemyGen in arrayOf(
            "aes sco:1 2 3 n4 5 6",
            "aes ash: 1 2 3",
            "aes ash: 1 2 3 4 5 6 7",
            "aes ash: 1 2 3 4 n5 6 7 8\n" +
                    "val tra: 1 2 3 4 n5 6 7 8"
        )) {
            val enemies = createMany(enemyGen, 7).toMutableList()
            pipisTheseEnemies(enemies)
        }

        for (team in interestingPipisTeams().toMutableList()) {
            pipisTheseEnemies(team)
        }
    }

    @Before
    fun setUp() {
        Controller.fullyStock()
        deck = Controller.deck!!
        deck.addBaseDeckThreeSpears()
    }
}