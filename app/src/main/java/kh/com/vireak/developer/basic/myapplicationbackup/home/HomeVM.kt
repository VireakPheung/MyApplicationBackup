//package kh.com.vireak.developer.basic.myapplicationbackup.home
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kh.com.vireak.developer.basic.myapplicationbackup.home.HomeRepository
//import kh.com.vireak.developer.basic.myapplicationbackup.model2.BaseUiState
//import kh.com.vireak.developer.basic.myapplicationbackup.model2.ComponentModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//
//class HomeVM(
//    private val homeRepository: HomeRepository = HomeRepository()
//) : ViewModel() {
//    private val _componentList = MutableStateFlow<BaseUiState<List<ComponentModel>>>(BaseUiState.Loading)
//    val componentList = _componentList.asStateFlow()
//
//
//    fun getComponentList(){
//        viewModelScope.launch {
//            _componentList.value = BaseUiState.Loading
//            try {
//                homeRepository.getComponentList().collect { data ->
//                    _componentList.value = BaseUiState.Success(data)
//                }
//            } catch (e: Exception){
//                _componentList.value = BaseUiState.Error(e.message ?: "Unknown error")
//            }
//        }
//    }
//
//    init {
//        getComponentList()
//    }
//
//
//}
