package andrey.murzin.com.personcapital.data.parser

import andrey.murzin.com.personcapital.data.model.BrokerReportModel
import java.io.InputStream

interface XLSXParser {

    fun parse(stream: InputStream): List<BrokerReportModel>
}