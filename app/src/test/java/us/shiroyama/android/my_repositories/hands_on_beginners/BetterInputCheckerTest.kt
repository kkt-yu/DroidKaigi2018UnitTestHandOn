package us.shiroyama.android.my_repositories.hands_on_beginners

import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Local Unit Test for [BetterInputChecker]
 *
 * @author Fumihiko Shiroyama
 */
/**
 * Androidフレームワークのコードを使ったクラスのテストに挑戦してみましょう。
 *
 *
 * ヒント: [Robolectric] を使うとAndroidフレームワークのコードをLocal Unit Testで模すことができます。
 * ヒント: クラスを`@RunWith(RobolectricTestRunner.class)`アノテーションで修飾すると [Robolectric] を使うことができます。
 */
@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class BetterInputCheckerTest {
    private lateinit var inputChecker: BetterInputChecker
    @Before
    @Throws(Exception::class)
    fun setUp() {
        inputChecker = BetterInputChecker()
    }

    /**
     * 正しい入力で`true`を受け取るテストケースを書いてみよう。
     *
     *
     * 例: `String input = "srym";`
     */
    @Test
    fun isValid() {
        val input = "srym"
        val actual = inputChecker.isValid(input)
        Assertions.assertThat(actual).isTrue()
    }

    /**
     * 不正な入力（記号や半角スペースが含まれた文字列）で`false`を受け取るテストケースを書いてみよう。
     *
     *
     * 例: `String input = "abc$";`
     */
    @Test
    fun isValid_inputIllegalCharacters_resultsFalse() {
        val input = "abc$"
        val actual = inputChecker.isValid(input)
        Assertions.assertThat(actual).isFalse()
    }

    /**
     * 不正な入力（規定文字数より少ない文字列）で`false`を受け取るテストケースを書いてみよう。
     *
     *
     * 例: `String input = "abc";`
     */
    @Test
    fun isValid_inputLessThan4_resultsFalse() {
        val input = "abc"
        val actual = inputChecker.isValid(input)
        Assertions.assertThat(actual).isFalse()
    }

    /**
     * 不正な入力（空文字列）で`IllegalArgumentException`が上がることを確認するテストケースを書いてみよう。
     *
     *
     * 例: `String input = null;`
     *
     *
     * ヒント: `@Test(expected = 例外.class)`
     */
    @Test(expected = IllegalArgumentException::class)
    fun isValid_inputBlank_resultsIllegalArgumentException() {
        val input = ""
        inputChecker.isValid(input)
    }

    /**
     * 不正な入力（null）で`IllegalArgumentException`が上がることを確認するテストケースを書いてみよう。
     *
     *
     * 例: `String input = null;`
     *
     *
     * ヒント: `@Test(expected = 例外.class)`
     */
    @Test(expected = java.lang.IllegalArgumentException::class)
    fun isValid_inputNull_resultsIllegalArgumentException() {
        val input: String? = null
//        inputChecker.isValid(input)
    }
}