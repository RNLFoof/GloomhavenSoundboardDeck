package com.example.gloomhavendeck

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@RequiresApi(Build.VERSION_CODES.O)
@Serializable
class Pipis(): Controllable() {
    init {
        Controller.pipis = this
    }

    companion object {
        fun generateNerflessCounterparts(enemies: List<Enemy>, scenarioLevel: Int): HashMap<String, Enemy> {
            if (enemies.map { e -> e.name }.toSet().size < enemies.size) {
                throw DuplicateEnemyNameException()
            }

            return HashMap(enemies.associateBy(
                keySelector = {e -> e.name},
                valueTransform  = {e -> e.deepCopy()}
            ))
        }
    }

    fun generateNerflessCounterparts(enemies: List<Enemy>): HashMap<String, Enemy> {
        return generateNerflessCounterparts(enemies, Controller.player?.scenarioLevel ?: 7)
    }
}

class DuplicateEnemyNameException: Exception() {}