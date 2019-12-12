package us.shiroyama.android.my_repositories.hands_on_beginners.mockito.repository

import org.junit.Before
import org.junit.Test

/**
 * Local Unit Test for [TweetRepository]
 *
 * @author Fumihiko Shiroyama
 */
class TweetRepositoryTest {
    private val tweetRepository: TweetRepository? = null
    /**
     * [TweetRepository] は [LocalTweetDataSource] に依存している。
     * テストのやり方は色々あるが、ここでは [Mockito.mock] を利用してみよう。
     *
     *
     * ヒント: [Mockito.when] と `thenReturn()` を組み合わせると、メソッドのスタブを作ることができる。
     */
    @Before
    @Throws(Exception::class)
    fun setUp() {
    }

    /**
     * スタブで定義した返り値を検証するテストケースを書いてみよう。
     * Listの検証で学んだアサーションをここでも有効活用しよう。
     */
    @get:Throws(Exception::class)
    @get:Test
    val timeline: Unit
        get() {
        }
}