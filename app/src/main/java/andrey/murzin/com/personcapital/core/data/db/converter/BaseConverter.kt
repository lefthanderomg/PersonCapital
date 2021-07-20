package andrey.murzin.com.personcapital.core.data.db.converter

interface BaseConverter<FROM, TO> {

    fun from(from: FROM): TO

    fun to(to: TO): FROM
}