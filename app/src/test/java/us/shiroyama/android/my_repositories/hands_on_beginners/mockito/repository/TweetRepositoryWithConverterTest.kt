package us.shiroyama.android.my_repositories.hands_on_beginners.mockito.repository

import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*
import us.shiroyama.android.my_repositories.hands_on_beginners.mockito.converter.TweetConverter
import us.shiroyama.android.my_repositories.hands_on_beginners.mockito.entity.Tweet
import us.shiroyama.android.my_repositories.hands_on_beginners.mockito.repository.LocalTweetDataSource.MockTweetDataSource

/**
 * Local Unit Test for [TweetRepositoryWithConverter]
 *
 * @author Fumihiko Shiroyama
 */
class TweetRepositoryWithConverterTest {
    private lateinit var converter: TweetConverter
    private lateinit var repository: TweetRepositoryWithConverter
    /**
     * [Mockito.spy] を使ってテストスパイを作ってみよう。
     * テストスパイは [Mockito.verify] を使うことで、メソッド呼び出し等のインタラクションを検証することができる。
     */
    @Before
    @Throws(Exception::class)
    fun setUp() {
        converter = spy(TweetConverter())
        repository = TweetRepositoryWithConverter(MockTweetDataSource(), converter)
    }

    /**
     * [TweetRepositoryWithConverter.getTimeline] は内部で [TweetConverter] を呼ばないはずだ。
     * せっかくなので「インタラクションがない」ことを検証してみよう。
     *
     *
     * ヒント: [Mockito.verify] に `never()` を渡すことでインタラクションがないことを検証できる。
     */
    @Test
    fun timeline() {
        Assertions.assertThat(repository.timeline).hasSize(3)
        verify(converter, never()).convert(ArgumentMatchers.any(Tweet::class.java))
        verify(converter, never()).convertList(ArgumentMatchers.anyList())
    }

    /**
     * [TweetRepositoryWithConverter.getTimelineBody] では内部で [TweetConverter] とのインタラクションがあるはずだ。
     *
     *
     * ヒント: `verify(object, times(1))` のようにするとインタラクションがあったこととその回数も検証することができる。
     */
    @Test
    fun timelineBody() {
        Assertions.assertThat(repository.timelineBody).containsExactly("foo", "bar", "baz")
        verify(converter, never()).convert(ArgumentMatchers.any(Tweet::class.java))
        verify(converter, times(1)).convertList(ArgumentMatchers.anyList())
    }
}