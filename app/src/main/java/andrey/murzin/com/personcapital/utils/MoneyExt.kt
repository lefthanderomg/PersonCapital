package andrey.murzin.com.personcapital.utils

import andrey.murzin.com.personcapital.domain.model.Money

fun Money.getText() =
    "${DecimalFormatter.DEFAULT_DECIMAL_FORMATTER.format(value)} ${currency.symbol}"