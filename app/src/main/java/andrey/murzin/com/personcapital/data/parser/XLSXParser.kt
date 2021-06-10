package andrey.murzin.com.personcapital.data.parser

import andrey.murzin.com.personcapital.domain.model.BrokerReport
import java.io.InputStream

interface XLSXParser {
    fun parse(stream: InputStream): List<BrokerReport>
}