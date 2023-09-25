package com.season.winter.feature.main.viewmodel

import androidx.lifecycle.ViewModel
import com.season.winter.liquor.dummy.model.HomeItem
import com.season.winter.screen.fragment.navigationMain.home.domain.GetHomeScreenDataUseCase
import com.season.winter.user.di.Credentials
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val credentials: Credentials,
    private val homeScreenData: GetHomeScreenDataUseCase,
): ViewModel() {

    val userName = MutableStateFlow(credentials.userName)

    private val _onLogoutListener = MutableSharedFlow<Boolean>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val onLogoutListener: SharedFlow<Boolean>
        get() = _onLogoutListener.asSharedFlow()

    private val _onClickSearchListener = MutableSharedFlow<Boolean>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val onClickSearchListener: SharedFlow<Boolean>
        get() = _onClickSearchListener.asSharedFlow()


    private val _homeScreenDataFlow = MutableSharedFlow<List<HomeItem>>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val homeScreenDataFlow: SharedFlow<List<HomeItem>>
        get() = _homeScreenDataFlow.asSharedFlow()


    suspend fun getMainList() {
        _homeScreenDataFlow.tryEmit(
            homeScreenData.invoke()
        )
    }

    fun onClickLogout() {
        credentials.logout()
        _onLogoutListener.tryEmit(true)
    }

    fun onClickSearch() {
        _onClickSearchListener.tryEmit(true)
    }
}