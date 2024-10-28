
import com.github.comismoy.pruebatecnicawomandroid.data.core.ResultData
import com.github.comismoy.pruebatecnicawomandroid.domain.model.DogImageModel
import com.github.comismoy.pruebatecnicawomandroid.domain.usecase.DogBreedsImagesUseCase
import com.github.comismoy.pruebatecnicawomandroid.ui.details.DogBreedsImagesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.junit.Assert.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class DogBreedsImagesViewModelTest {
      private lateinit var viewModel: DogBreedsImagesViewModel
      private val dogBreedsImagesUseCase: DogBreedsImagesUseCase = mock()
      private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = DogBreedsImagesViewModel(dogBreedsImagesUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun `getDogBreedsImages should update dogBreedsImages with success result`() = runTest(testDispatcher) {
        //Given
        val breedName = "Husky"
        val expectedImages = DogImageModel(breedsImages = listOf("image1.jpg", "image2.jpg"))
        whenever(dogBreedsImagesUseCase(breedName)).thenReturn(ResultData.Success(expectedImages))

        //When
        viewModel.getDogBreedsImages(breedName)
        advanceUntilIdle()

        //Then
        val state = viewModel.dogBreedsImages.first()
        assertEquals(expectedImages, state.dogBreedsImagesList)
        assertEquals(expectedImages, state.dogBreedsImagesList)
        assertEquals(null, state.error)
    }

    @Test
    fun `getDogBreedsImages should error when breed name is blank`() = runTest(testDispatcher) {
        //when
        viewModel.getDogBreedsImages("")
        advanceUntilIdle()

        //Then
        val state = viewModel.dogBreedsImages.first()
        assertEquals(null, state.dogBreedsImagesList)
        assertEquals("Breed name is required", state.error)

    }
    @Test
    fun `getDogBreedsImages should update dogBreedsImages with error result`() = runTest(testDispatcher) {
        //Given
        val breedName = "Husky"
        val errorMessage = "Error fetching images"
        whenever(dogBreedsImagesUseCase(breedName)).thenReturn(ResultData.Error(Exception(errorMessage)))

        //When
        viewModel.getDogBreedsImages(breedName)
        advanceUntilIdle()

        //Then
        val state = viewModel.dogBreedsImages.first()
        assertEquals(null, state.dogBreedsImagesList)
    }

    }