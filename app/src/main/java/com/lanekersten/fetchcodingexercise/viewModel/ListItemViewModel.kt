package com.lanekersten.fetchcodingexercise.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lanekersten.fetchcodingexercise.model.ListItem
import com.lanekersten.fetchcodingexercise.network.ApiClient
import kotlinx.coroutines.launch

class ListItemViewModel : ViewModel() {

    private val fetchService = ApiClient.fetchService

    private val _listItemData = MutableLiveData<Map<Int, List<ListItem>>>()
    val listItemData: LiveData<Map<Int, List<ListItem>>> get() = _listItemData

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        _isLoading.postValue(true)
        viewModelScope.launch {
            // Get list items and then filter/sort the result
            val filteredListItems = fetchService.getListItems().body()?.filter {
                listItem -> !listItem.name.isNullOrBlank()
            }?.sortedWith(
                compareBy({ it.listId }, { it.id })
            )?.groupBy { it.listId }

            // Post result to live data
            filteredListItems?.let {
                _listItemData.postValue(it)
            }
            _isLoading.postValue(false)
        }
    }

}