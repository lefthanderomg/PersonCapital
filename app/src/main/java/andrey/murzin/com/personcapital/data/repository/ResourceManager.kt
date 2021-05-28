package andrey.murzin.com.personcapital.data.repository

import android.content.res.Resources
import androidx.annotation.IdRes
import androidx.annotation.RawRes

class ResourceManager(
    private val resource: Resources
) {

    fun getRawStream(@RawRes id: Int) = resource.openRawResource(id)
}