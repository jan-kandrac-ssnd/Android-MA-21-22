package ssnd.mobile.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ssnd.mobile.net.NetworkData

fun <T> Fragment.collect(
    request: (Flow<NetworkData<T>>),
    collector: (NetworkData<T>) -> Unit
) {
    lifecycleScope.launch {
        request.collect {
            collector(it)
        }
    }
}