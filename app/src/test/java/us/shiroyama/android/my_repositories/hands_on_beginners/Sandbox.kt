package us.shiroyama.android.my_repositories.hands_on_beginners

import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test

/**
 * Sandbox for Unit Test
 *
 * @author Fumihiko Shiroyama
 */
class Sandbox {
    @Before
    @Throws(Exception::class)
    fun setUp() {
    }

    /**
     * 数字のアサーションに挑戦してみましょう！
     *
     *
     * 1) 1 + 1 = 2
     * 2) 123 > 100
     *
     *
     * これらを検証するようなテストケースを自由に書いてみてください。
     *
     *
     * ヒント: `Assertions#assertThat( テスト対象 ).isEqualTo( 期待値 )` のように書きます。
     * ヒント: `isGreaterThan` や `isLessThan` など、数字に関する様々なアサーションを試してみましょう。
     */
    @Test
    @Throws(Exception::class)
    fun simple_assertion_for_numbers() {
        Assertions.assertThat(1 + 1).isEqualTo(2)
        Assertions.assertThat(100).isGreaterThan(99)
        Assertions.assertThat(100).isLessThan(101)
    }

    /**
     * 文字列のアサーションに挑戦してみましょう！
     *
     *
     * 1) "Alice" は "Bob" ではない
     * 2) "Alice" は "Al" から始まる
     * 3) "Alice" は大文字小文字を区別しなければ "alice" と同じ
     *
     *
     * これらを検証するようなテストケースを自由に書いてみてください。
     *
     *
     * ヒント: `isNotEmpty` や `startsWith` など、文字列に関する様々なアサーションを試してみましょう。
     */
    @Test
    @Throws(Exception::class)
    fun simple_assertion_for_strings() {
        Assertions.assertThat("Alice").isNotEqualTo("Bob")
        Assertions.assertThat("Alice").startsWith("Al")
        Assertions.assertThat("Alice").isEqualToIgnoringCase("alice")
    }
}