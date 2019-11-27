package us.shiroyama.android.my_repositories.hands_on_beginners.mockito.converter

import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import us.shiroyama.android.my_repositories.hands_on_beginners.mockito.entity.Tweet

/**
 * Local Unit Test for [TweetConverter]
 *
 * @author Fumihiko Shiroyama
 */
class TweetConverterTest {
    private lateinit var converter: TweetConverter
    @Before
    @Throws(Exception::class)
    fun setUp() {
        converter = TweetConverter()
    }

    /**
     * [Tweet] を [String] に正しく変換できることを検証するテストケースを書こう。
     */
    @Test
    @Throws(Exception::class)
    fun convert() {
        val tweetBody = converter.convert(Tweet.bodyOf("tweet"))
        Assertions.assertThat(tweetBody).isEqualTo("tweet")
    }

    /**
     * [Tweet.body] が空の場合に変換結果が空文字列であることを検証するテストケースを書こう。
     */
    @Test
    @Throws(Exception::class)
    fun convert_inputEmpty_returnsEmpty() {
        val tweetBody = converter.convert(Tweet.bodyOf(""))
        Assertions.assertThat(tweetBody).isEmpty()
    }

    /**
     * {@link List<Tweet>} を {@link List<String>} に正しく変換できることを検証するテストケースを書こう。
     *
     *
     * ヒント: `isNotEmpty` や `hasSize` や `containsExactly` などのList用のアサーションを利用してみよう。
     */
    @Test
    @Throws(Exception::class)
    fun convertList() {
        val bodies = converter.convertList(
                listOf(
                        Tweet.bodyOf("test0"),
                        Tweet.bodyOf("test1"),
                        Tweet.bodyOf("test2"),
                        Tweet.bodyOf("test3")
                )
        )
        Assertions.assertThat(bodies).apply {
            isNotEmpty()
            hasSize(4)
            containsExactly("test0", "test1", "test2", "test3")
        }
    }

    /**
     * {@link List<Tweet>} が空リストの場合 {@link List<String>} も空リストになることを検証しよう。
     */
    @Test
    @Throws(Exception::class)
    fun convertList_inputEmptyList_returnsEmptyList() {
        val bodies = converter.convertList(listOf())

        Assertions.assertThat(bodies).isEmpty()
    }
}