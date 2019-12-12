package us.shiroyama.android.my_repositories.hands_on_beginners.async

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import us.shiroyama.android.my_repositories.hands_on_beginners.async.Fetcher.StringFetcher
import java.util.concurrent.CountDownLatch


/**
 * Local Unit Test for [AsyncFetcher]
 *
 * @author Fumihiko Shiroyama
 */
class AsyncFetcherTest {
    private lateinit var fetcher: Fetcher<String>
    private lateinit var asyncFetcher: AsyncFetcher<String>
    private lateinit var latch: CountDownLatch
    /**
     * 非同期処理が別スレッドで実行されている間にテストケースを抜けてしまうと、そのテストケースは意図せず「成功」とみなされてしまう。
     * 非同期処理が完了してコールバックをもらうまでスレッドを待機させる処理を書いてみよう。
     *
     *
     * ヒント: [CountDownLatch] を使うことで簡単に待ち合わせができる。
     */
    @Before
    @Throws(Exception::class)
    fun setUp() {
        fetcher = Mockito.spy(StringFetcher())
        asyncFetcher = AsyncFetcher(fetcher)
        latch = CountDownLatch(1)
    }

    /**
     * 非同期処理が成功で終わる場合を検証してみよう。
     *
     *
     * ヒント: [CountDownLatch.await] で待たせた処理は [CountDownLatch.countDown] の結果がゼロになることで再開することができる。
     * メモ : [CountDownLatch.countDown]を呼んだ回数だけCountDownLatchのcountが減っていく。
     */
    @Test
    @Throws(Exception::class)
    fun fetch_success() {
        asyncFetcher.fetch(
                { result: String? ->
                    assertThat(result).isEqualTo("OK")
                    log("async: ok")
                    latch.countDown()
                }
        ) { e: java.lang.Exception? -> log("async: ng") }
        latch.await()
        log("fetch_success:end")
    }

    /**
     * 非同期処理が失敗で終わる場合を検証してみよう。
     * [CountDownLatch] を使う部分は成功パターンと同じだが、[Fetcher.fetch] が失敗になるように工夫が必用だ。
     *
     *
     * ヒント: [Mockito.doThrow] を使うと戻り値がvoidのメソッドの結果を変えることができる。
     */
    @Test
    @Throws(Exception::class)
    fun fetch_failure() {
        Mockito.doThrow(RuntimeException("NG")).`when`(fetcher).fetch()
        asyncFetcher.fetch({ log("async: ok") }) {
            assertThat(it.message).isEqualTo("NG")
            log("async: ng")
            latch.countDown()
        }
        latch.await()
        log("fetch_failure: end")
    }

    private fun log(msg: String) {
        println(msg)
    }
}