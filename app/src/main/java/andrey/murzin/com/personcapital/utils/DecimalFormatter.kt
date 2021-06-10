package andrey.murzin.com.personcapital.utils

import java.text.DecimalFormat
import java.util.*

object DecimalFormatter {

    private const val DEFAULT_GROUP_SEPARATOR = ' '

    val DEFAULT_DECIMAL_FORMATTER: DecimalFormat =
        (DecimalFormat.getInstance(Locale.getDefault()) as DecimalFormat).apply {
            isGroupingUsed = true
            decimalFormatSymbols.groupingSeparator = DecimalFormatter.DEFAULT_GROUP_SEPARATOR
        }
}

