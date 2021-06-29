package andrey.murzin.com.personcapital.core.data.repository

import android.content.res.Resources
import androidx.annotation.RawRes

class ResourceManager(
    private val resource: Resources
) {

    fun getRawStream(@RawRes id: Int) = resource.openRawResource(id)
}