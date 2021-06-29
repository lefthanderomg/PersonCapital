package andrey.murzin.com.personcapital.core.data.parser

import andrey.murzin.com.personcapital.core.utils.MoneyManager
import andrey.murzin.com.personcapital.oprationhistory.model.BrokerReport
import androidx.core.text.isDigitsOnly
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.InputStream
import javax.inject.Inject

/**
 * Parser for xlsl report from tinkoff broker
 */
class TinkoffBrokerReportXLSXParser @Inject constructor(
    private val priceManager: MoneyManager,
) : XLSXParser {

    override fun parse(stream: InputStream): List<BrokerReport> {
        val workbook = XSSFWorkbook(stream)
        val sheet: XSSFSheet = workbook.getSheetAt(0)

        val brokerReports = mutableListOf<BrokerReport>()
        val mapReference = mutableMapOf<String, Int>()

        fun Row.getCellValueByKey(key: String): String = getCellValue(mapReference[key])

        sheet.rowIterator().forEach { row ->
            val cell = row.getCellValue(0)
            if (cell == REPORT_TITLE_END) {
                return brokerReports
            }

            if (cell == KEY_REPORT_NUMBER && mapReference.isEmpty()) {
                row.cellIterator().forEach {
                    if (it?.stringCellValue.orEmpty().isNotEmpty()) {
                        mapReference[it.stringCellValue.replaceLineBreak()] = it.address.column
                    }
                }
            }

            if (cell.isNotEmpty() && cell.isDigitsOnly()) {
                brokerReports.add(
                    BrokerReport(
                        id = row.getCellValueByKey(KEY_REPORT_NUMBER),
                        date = row.getCellValueByKey(KEY_REPORT_DATE),
                        type = row.getCellValueByKey(KEY_REPORT_TYPE),
                        shortName = row.getCellValueByKey(KEY_REPORT_SHORT_NAME),
                        ticker = row.getCellValueByKey(KEY_REPORT_TICKER),
                        unitPrice = priceManager.getMoney(
                            price = row.getCellValueByKey(KEY_UNIT_PRICE),
                            currency = row.getCellValueByKey(KEY_UNIT_CURRENCY)
                        ),
                        count = row.getCellValueByKey(KEY_COUNT),
                        totalPrice = priceManager.getMoney(
                            price = row.getCellValueByKey(KEY_TOTAL_PRICE),
                            currency = row.getCellValueByKey(KEY_TOTAL_PRICE_CURRENCY)
                        ),
                        brokerCommissionPrice = priceManager.getMoney(
                            price = row.getCellValueByKey(KEY_BROKER_COMMISSIONS_PRICE),
                            currency = row.getCellValueByKey(KEY_BROKER_COMMISSIONS_CURRENCY)
                        ),
                        exchangeCommissionPrice = priceManager.getMoney(
                            price = row.getCellValueByKey(KEY_EXCHANGE_COMMISSIONS_PRICE),
                            currency = row.getCellValueByKey(KEY_EXCHANGE_COMMISSIONS_CURRENCY)
                        ),
                        clearingCenterCommissionPrice = priceManager.getMoney(
                            price = row.getCellValueByKey(KEY_CLEARING_CENTER_COMMISSIONS_PRICE),
                            currency = row.getCellValueByKey(KEY_CLEARING_CENTER_COMMISSIONS_CURRENCY)
                        ),
                    )
                )
            }
        }

        return brokerReports
    }

    private fun Row.getCellValue(index: Int?) = getCell(index ?: 0)?.stringCellValue.orEmpty()

    private fun String.replaceLineBreak(): String = replace("\n", "")

    companion object {
        private const val REPORT_TITLE_END =
            "1.2 Информация о неисполненных сделках на конец отчетного периода"

        private const val KEY_REPORT_NUMBER = "Номер сделки"
        private const val KEY_REPORT_DATE = "Дата заключения"
        private const val KEY_REPORT_TYPE = "Вид сделки"
        private const val KEY_REPORT_TICKER = "Код актива"
        private const val KEY_REPORT_SHORT_NAME = "Сокращенное наименование актива"
        private const val KEY_UNIT_PRICE = "Цена за единицу"
        private const val KEY_UNIT_CURRENCY = "Валюта цены"
        private const val KEY_COUNT = "Количество"
        private const val KEY_TOTAL_PRICE = "Сумма сделки"
        private const val KEY_TOTAL_PRICE_CURRENCY = "Валюта расчетов"
        private const val KEY_BROKER_COMMISSIONS_PRICE = "Комиссия брокера"
        private const val KEY_BROKER_COMMISSIONS_CURRENCY = "Валюта комиссии"
        private const val KEY_EXCHANGE_COMMISSIONS_PRICE = "Комиссия биржи"
        private const val KEY_EXCHANGE_COMMISSIONS_CURRENCY = "Валюта комиссии биржи"
        private const val KEY_CLEARING_CENTER_COMMISSIONS_PRICE = "Комиссия клир. центра"
        private const val KEY_CLEARING_CENTER_COMMISSIONS_CURRENCY = "Валюта комиссии биржи"
    }
}


