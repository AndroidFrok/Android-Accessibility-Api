package cn.vove7.andro_accessibility_api.demo.actions

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import cn.vove7.andro_accessibility_api.demo.toast
import cn.vove7.auto.core.api.waitForApp
import cn.vove7.auto.core.api.withId
import kotlinx.coroutines.delay
import timber.log.Timber

class ToWechat : Action() {
    override val name: String
        get() = "等待 微信 打开 - 搜索页"

    override suspend fun run(act: ComponentActivity) {

//        ToastUtils.show("start chrome after 1s")
        delay(1000)
//.ui.LauncherUI
        val targetApp = "com.tencent.mm"
        act.startActivity(act.packageManager.getLaunchIntentForPackage(targetApp))

        if (waitForApp(targetApp, 5000).also {
                toast("wait " + if (it) "success" else "failed")
            }) {
//            var issss = withId("j5t").tryClick()
            var issss = withId("ij").tryClick()
            Timber.d("" + issss)
        }
    }
}