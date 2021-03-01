/*
 * Written by Lê Trần Ngọc Thành (瑛太 / Ngọc Thành / kineita) <thanhletranngoc@yahoo.co.jp>, [1/3/2021 - Present]
 */

package jp.kineita.fragmentnavigation.common

@Deprecated("Use addFragment with BundleBuilder")
class Arg<K, V>(val key: K?, val value: V?) {

    override fun toString(): String {
        return String.format("Arg{%s %s}", key.toString(), value.toString())
    }

    companion object {
        fun <A, B> create(a: A?, b: B?): Arg<A?, B?> {
            return Arg(a, b)
        }
    }
}