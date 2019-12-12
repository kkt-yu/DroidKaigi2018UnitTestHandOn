package us.shiroyama.android.my_repositories.hands_on_beginners

import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test

/**
 * Local Unit Test for [InputChecker]
 *
 * @author Fumihiko Shiroyama
 */
class InputCheckerTest {
    private var inputChecker: InputChecker? = null
    /**
     * ここに [InputChecker] の初期化処理を書いて各テストケースで共用しよう。
     */
    @Before
    @Throws(Exception::class)
    fun setUp() {
        inputChecker = InputChecker()
    }

    /**
     * 正しい入力で`true`を受け取るテストケースを書いてみよう。
     *
     *
     * 例: `String input = "srym";`
     */
    @get:Throws(Exception::class)
    @get:Test
    val isValid: Unit
        get() {
            val input = "srym"
            Assertions.assertThat(inputChecker!!.isValid(input)).isTrue()
        }

    /**
     * 不正な入力（空文字列）で`false`を受け取るテストケースを書いてみよう。
     *
     *
     * 例: `String input = "";`
     */
    @get:Throws(Exception::class)
    @get:Test
    val isValid_inputBlank_resultsFalse: Unit
        get() {
            val input = ""
            Assertions.assertThat(inputChecker!!.isValid(input)).isFalse()
        }

    /**
     * 不正な入力（記号や半角スペースが含まれた文字列）で`false`を受け取るテストケースを書いてみよう。
     *
     *
     * 例: `String input = "abc$";`
     */
    @get:Throws(Exception::class)
    @get:Test
    val isValid_inputIllegalCharacters_resultsFalse: Unit
        get() {
            val input = "abc$"
            Assertions.assertThat(inputChecker!!.isValid(input)).isFalse()
        }

    /**
     * 不正な入力（規定文字数より少ない文字列）で`false`を受け取るテストケースを書いてみよう。
     *
     *
     * 例: `String input = "abc";`
     */
    @get:Throws(Exception::class)
    @get:Test
    val isValid_inputLessThan4_resultsFalse: Unit
        get() {
            val input = "abc"
            Assertions.assertThat(inputChecker!!.isValid(input)).isFalse()
        }

    /**
     * 不正な入力（null）で`NullPointerException`が上がることを確認するテストケースを書いてみよう。
     *
     *
     * 例: `String input = null;`
     *
     *
     * ヒント: `@Test(expected = 例外.class)`
     */
    @get:Throws(Exception::class)
    @get:Test(expected = NullPointerException::class)
    val isValid_inputNull_resultsNPE: Unit
        get() {
            val input: String? = null
            inputChecker!!.isValid(input!!)
        }
}