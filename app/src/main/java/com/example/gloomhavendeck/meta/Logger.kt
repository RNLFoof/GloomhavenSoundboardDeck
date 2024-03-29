package com.example.gloomhavendeck.meta

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.gloomhavendeck.Controllable
import com.example.gloomhavendeck.Controller
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
@RequiresApi(Build.VERSION_CODES.O)
class Logger(): Controllable() {

    init {
        Controller.logger = this
    }

    var logList = mutableListOf<String>()
    @Transient
    var logIndent = 0 // How many spaces to insert before a log, used to indicate that one action is part of another
    @Transient
    var logMuted = false // So you can make it shut up
    var logCount = 0 // How many logs have been made in general, used instead of index so old stuff can be removed
    var logsToHide = 0 // Used to go back and forth while undoing without like, making entire separate copies of the logs. MOVE THIS TO UNDOMANAGER SOMEHOW

    private val logCap = 100

    fun log(text: String) {
        if (!logMuted) {
            // Override any "future" logs
            while (logsToHide > 0 && logList.size > 0) {
                logsToHide -= 1
                logList.removeLast()
            }
            logsToHide = 0 // So that if there's more to hide than there is it still resets
            logList.add("----".repeat(logIndent) + text)
            while (logList.size > logCap) {
                logList.removeFirst()
            }
            logCount += 1

            Controller.activityConnector?.tvLog?.text = getShownLogs().joinToString(separator="\n")
        }
    }

    fun getShownLogs(): MutableList<String> {
        return logList.subList(0, Integer.max(0, logList.size - logsToHide))
    }
}