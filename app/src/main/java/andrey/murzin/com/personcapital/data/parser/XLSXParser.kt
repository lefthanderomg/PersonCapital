package andrey.murzin.com.personcapital.data.parser

import java.io.InputStream

interface XLSXParser<out T> {

    fun parse(stream: InputStream): T
}