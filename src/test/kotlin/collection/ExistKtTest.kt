package collection

import org.junit.Test
import com.google.common.truth.Truth.assertThat

class ExistKtTest {
    private val supportedList = listOf("ja", "en", "fr")

    @Test
    fun 第1言語がサポート対象の場合() {
        val targetList = listOf("ja", "en")
        val actual = find(supportedList, targetList)
        assertThat(actual).isEqualTo("ja")
    }
    @Test
    fun 第2言語がサポート対象の場合() {
        val targetList = listOf("ti", "ja")
        val actual = find(supportedList, targetList)
        assertThat(actual).isEqualTo("ja")
    }

    @Test
    fun どれもサポート対象ではない場合() {
        val targetList = listOf("ti", "de")
        val actual = find(supportedList, targetList)
        assertThat(actual).isEmpty()
    }
    @Test
    fun `第2,3言語がサポート対象の場合`() {
        val targetList = listOf("ti", "en", "ja")
        val actual = find(supportedList, targetList)
        assertThat(actual).isEqualTo("en")
    }

}