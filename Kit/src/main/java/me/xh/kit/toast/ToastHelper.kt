package me.xh.kit.toast

import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import me.xh.kit.app.KitConfig

private val handler = Handler(Looper.getMainLooper())

fun toast(msg: String) {
    toast(msg, Toast.LENGTH_SHORT)
}

fun toast(@StringRes stringId: Int) {
    toast(KitConfig.mContext.resources.getString(stringId), Toast.LENGTH_SHORT)
}

fun toastLong(msg: String) {
    toast(msg, Toast.LENGTH_LONG)
}

fun toastLong(@StringRes stringId: Int) {
    toast(KitConfig.mContext.resources.getString(stringId), Toast.LENGTH_LONG)
}

private fun toast(msg: String, duration: Int) {
    if (Looper.myLooper() != Looper.getMainLooper()) {
        handler.post { ToastCompat.makeText(KitConfig.mContext, msg, duration).show() }
    } else {
        ToastCompat.makeText(KitConfig.mContext, msg, duration).show()
    }
}

fun toast(view: View, gravity: Int = Gravity.CENTER, offsetX: Int = 0, offsetY: Int = 0) {
    toast(view, gravity, offsetX, offsetY, Toast.LENGTH_SHORT)
}

fun toastLong(view: View, gravity: Int = Gravity.CENTER, offsetX: Int = 0, offsetY: Int = 0) {
    toast(view, gravity, offsetX, offsetY, Toast.LENGTH_LONG)
}

private fun toast(
    view: View,
    gravity: Int,
    offsetX: Int,
    offsetY: Int,
    duration: Int
) {
    if (Looper.myLooper() != Looper.getMainLooper()) {
        handler.post {
            ToastCompat.custom(KitConfig.mContext, view, gravity, offsetX, offsetY, duration).show()
        }
    } else {
        ToastCompat.custom(KitConfig.mContext, view, gravity, offsetX, offsetY, duration).show()
    }
}
