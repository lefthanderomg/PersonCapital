package andrey.murzin.com.personcapital.core.data.parser

import andrey.murzin.com.personcapital.oprationhistory.model.BrokerReport
import java.io.InputStream

interface XLSXParser {
    fun parse(stream: InputStream): List<BrokerReport>
}