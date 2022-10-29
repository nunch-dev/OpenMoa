package pe.aioo.openmoa

import android.content.Context
import android.content.Intent
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.core.content.res.ResourcesCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlin.math.*

class KeyTouchListener(
    context: Context,
    private val key: String,
) : OnTouchListener {

    private val broadcastManager = LocalBroadcastManager.getInstance(context)
    private val backgrounds = listOf(
        ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.key_background_pressed,
            context.theme,
        ),
        ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.key_background,
            context.theme,
        ),
    )

    private var startX: Float = 0f
    private var startY: Float = 0f
    private val moeumList = arrayListOf<String>()

    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                view.background = backgrounds[0]
                startX = motionEvent.x
                startY = motionEvent.y
                moeumList.clear()
            }
            MotionEvent.ACTION_MOVE -> {
                val currentX = motionEvent.x
                val currentY = motionEvent.y
                val distance = sqrt(
                    (currentX - startX).pow(2) + (currentY - startY).pow(2)
                )
                if (distance > 50f) {
                    val degree = (atan2(currentY - startY, currentX - startX) * 180f) / PI
                    startX = currentX
                    startY = currentY
                    if (abs(degree) < 22.5f) {
                        moeumList.add("ㅏ")
                    } else if (abs(degree) < 67.5f) {
                        moeumList.add(if (degree > 0) "ㅡ" else "ㅣ")
                    } else if (abs(degree) < 112.5f) {
                        moeumList.add(if (degree > 0) "ㅜ" else "ㅗ")
                    } else if (abs(degree) < 157.5f) {
                        moeumList.add(if (degree > 0) "ㅡ" else "ㅣ")
                    } else {
                        moeumList.add("ㅓ")
                    }
                }
            }
            MotionEvent.ACTION_UP -> {
                sendKey(key)
                var moeum: String? = null
                for (nextMoeum in moeumList) {
                    moeum = when (moeum) {
                        "ㅏ" -> when (nextMoeum) {
                            "ㅓ" -> "ㅐ"
                            else -> moeum
                        }
                        "ㅐ" -> when (nextMoeum) {
                            "ㅏ" -> "ㅑ"
                            else -> moeum
                        }
                        "ㅑ" -> when (nextMoeum) {
                            "ㅓ" -> "ㅒ"
                            else -> moeum
                        }
                        "ㅓ" -> when (nextMoeum) {
                            "ㅏ" -> "ㅔ"
                            else -> moeum
                        }
                        "ㅔ" -> when (nextMoeum) {
                            "ㅓ" -> "ㅕ"
                            else -> moeum
                        }
                        "ㅕ" -> when (nextMoeum) {
                            "ㅏ" -> "ㅖ"
                            else -> moeum
                        }
                        "ㅗ" -> when (nextMoeum) {
                            "ㅏ" -> "ㅘ"
                            "ㅜ" -> "ㅚ"
                            else -> moeum
                        }
                        "ㅘ" -> when (nextMoeum) {
                            "ㅓ" -> "ㅙ"
                            else -> moeum
                        }
                        "ㅚ" -> when (nextMoeum) {
                            "ㅗ" -> "ㅛ"
                            else -> moeum
                        }
                        "ㅜ" -> when (nextMoeum) {
                            "ㅓ" -> "ㅝ"
                            "ㅗ" -> "ㅟ"
                            else -> moeum
                        }
                        "ㅝ" -> when (nextMoeum) {
                            "ㅏ" -> "ㅞ"
                            else -> moeum
                        }
                        "ㅟ" -> when (nextMoeum) {
                            "ㅜ" -> "ㅠ"
                            else -> moeum
                        }
                        "ㅡ" -> when (nextMoeum) {
                            "ㅣ" -> "ㅢ"
                            else -> "ㅡ"
                        }
                        "ㅣ" -> "ㅣ"
                        null -> nextMoeum
                        else -> moeum
                    }
                }
                moeum?.let { sendKey(it) }
                view.background = backgrounds[1]
                view.performClick()
            }
        }
        return true;
    }

    private fun sendKey(key: String) {
        broadcastManager.sendBroadcast(
            Intent(OpenMoaIME.INTENT_ACTION).apply {
                putExtra(OpenMoaIME.EXTRA_NAME, key)
            }
        )
    }

}