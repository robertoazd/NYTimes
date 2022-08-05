package com.robertoazeredo.nytimes.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.robertoazeredo.nytimes.R
import com.robertoazeredo.nytimes.data.api.Result
import com.robertoazeredo.nytimes.data.model.Article
import com.robertoazeredo.nytimes.data.model.Multimedia
import com.robertoazeredo.nytimes.data.model.NewsResponse
import com.robertoazeredo.nytimes.data.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class NewsViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var articles: Observer<List<Article>?>

    @Mock
    private lateinit var errorMessage: Observer<Int>

    private lateinit var viewModel: NewsViewModel

    @ExperimentalCoroutinesApi
    @Test
    fun `when view model getNews get success then sets articles`() = runTest {
        // Arrange
        val newsResponse = NewsResponse(
            status = "200",
            numResults = "1",
            results = listOf(
                Article(
                    slugName="04ukraine-briefing-grain-ships",
                    section="World",
                    subsection="Europe",
                    title="Three more ships carrying grain have been cleared to depart from Ukraine.",
                    abstract="The ships are carrying a total of 58,041 metric tons of corn from Ukraine’s desperately needed stores.",
                    url="https://www.nytimes.com/2022/08/04/world/europe/ukraine-grain-ships.html",
                    byline="BY FARNAZ FASSIHI AND SOPHIE DOWNES",
                    thumbnailStandard="https://static01.nyt.com/images/2022/08/04/multimedia/04ukraine-briefing-grain-ships/04ukraine-briefing-grain-ships-thumbStandard.jpg",
                    source="New York Times",
                    updateDate="2022-08-04T20:15:59-04:00",
                    publishedDate="2022-08-04T19:30:16-04:00",
                    materialTypeFacet="News",
                    multimedia= listOf(
                        Multimedia(
                            url="https://static01.nyt.com/images/2022/08/04/multimedia/04ukraine-briefing-grain-ships/04ukraine-briefing-grain-ships-mediumThreeByTwo440.jpg",
                            format="mediumThreeByTwo440",
                            height=293,
                            width=440,
                            type="image",
                            subtype="photo",
                            caption="The Navi-Star waiting to depart with its cargo of grain at the Port of Odesa in Ukraine last week.",
                            copyright="David Goldman/Associated Press"
                        )
                    )
                )
            )
        )
        val resultSuccess = MockNewsRepository(Result.Success(newsResponse))
        viewModel = NewsViewModel(resultSuccess)
        viewModel.articles.observeForever(articles)

        // Act
        val section = "World"
        viewModel.getNews(section)

        // Assert
        advanceUntilIdle()
        verify(articles).onChanged(newsResponse.results)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `when view model getNews get error then sets errorMessage`() = runTest {
        // Arrange
        val message = R.string.error_no_data
        val resultError = MockNewsRepository(Result.Error(message))
        viewModel = NewsViewModel(resultError)
        viewModel.errorMessage.observeForever(errorMessage)

        // Act
        val section = "World"
        viewModel.getNews(section)

        // Assert
        advanceUntilIdle()
        verify(errorMessage).onChanged(message)
    }
}

class MockNewsRepository(private val result: Result<NewsResponse>) : NewsRepository {
    override suspend fun getNews(section: String): Result<NewsResponse> {
        return result
    }
}

@ExperimentalCoroutinesApi
class MainCoroutineRule(private val dispatcher: TestDispatcher = StandardTestDispatcher()) : TestWatcher() {

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}