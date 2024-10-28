package com.github.comismoy.pruebatecnicawomandroid.ui.home
import com.github.comismoy.pruebatecnicawomandroid.data.core.DispatcherProvider
import com.github.comismoy.pruebatecnicawomandroid.data.core.NetworkHelper
import com.github.comismoy.pruebatecnicawomandroid.data.core.ResultData
import com.github.comismoy.pruebatecnicawomandroid.domain.model.DogBreedsModel
import com.github.comismoy.pruebatecnicawomandroid.domain.usecase.DogBreedsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class DogBreedsViewModelTest {
    private lateinit var viewModel: DogBreedsViewModel
    private val getDogBreedsUseCase: DogBreedsUseCase = mock()
    private val networkHelper: NetworkHelper = mock()
    private val testDispatcher = UnconfinedTestDispatcher()


    private val testDispatcherProvider = object : DispatcherProvider {
        override val io = testDispatcher
        override val main = testDispatcher
        override val default = testDispatcher
    }

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = DogBreedsViewModel(getDogBreedsUseCase, testDispatcherProvider,networkHelper)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getDogBreeds should update dogBreeds with success result`() = runTest(testDispatcher){
        // Given
        whenever(networkHelper.isConnected()).thenReturn(true)
        val expectedBreeds = DogBreedsModel(breedsList = listOf("Husky", "Beagle"))
        whenever(getDogBreedsUseCase()).thenReturn(ResultData.Success(expectedBreeds))

        // When
        viewModel.getDogBreeds()
        advanceUntilIdle()

        // Then
        val state = viewModel.dogBreeds.first()
        assertEquals(expectedBreeds, state.breedsList)
        assertTrue("La lista de raza no debería estar vacía",state.error == null)
        assertEquals(null, state.error)
        assertFalse(state.isLoading)

    }


    @Test
    fun `getDogBreeds should update dogBreeds with success result when internet is available`() = runTest(testDispatcher) {
        // Given
        whenever(networkHelper.isConnected()).thenReturn(true)

        //When
        val expectedBreeds = DogBreedsModel(breedsList = listOf("Husky", "Beagle"))
        whenever(getDogBreedsUseCase()).thenReturn(ResultData.Success(expectedBreeds))

        viewModel.getDogBreeds()
        advanceUntilIdle()

        // Then
        val state = viewModel.dogBreeds.first()
        assertEquals(expectedBreeds, state.breedsList)
        assertEquals(null, state.error)
    }

}