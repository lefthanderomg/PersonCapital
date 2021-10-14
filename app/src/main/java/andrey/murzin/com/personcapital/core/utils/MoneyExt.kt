package andrey.murzin.com.personcapital.core.utils

import andrey.murzin.com.personcapital.feature.oprationhistory.model.Money

fun Money.getText() =
    "${DecimalFormatter.DEFAULT_DECIMAL_FORMATTER.format(value)} ${currency.symbol}"