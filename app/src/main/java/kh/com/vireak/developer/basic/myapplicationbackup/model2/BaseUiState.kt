package kh.com.vireak.developer.basic.myapplicationbackup.model2

open class BaseUiState<out T> {
    data object None: BaseUiState<Nothing>()
    data object Loading: BaseUiState<Nothing>()
    data class Success<out T> (val data: T): BaseUiState<T>()
    data class Error(val message: String): BaseUiState<Nothing>()
    data class ErrorWithException(val exception: Exception): BaseUiState<Nothing>()
}

/**
 * 1.Base Ui State
 * 2.loading util singleTon
 * 3.use view model
 * 4.use loading content in screen
 * 5.loading ui content
 * */