package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.ui.theme.TestTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                var refresh by remember {
                    mutableStateOf(false)
                }
                var load by remember {
                    mutableStateOf(false)
                }
                var itemmub by remember {
                    mutableStateOf(20)
                }
                val scope = rememberCoroutineScope()
                SwipeRefresh(
                    refreshState = rememberSwipeRefreshState(isRefreshing = refresh),
                    onRefresh = {
                        refresh = true
                        scope.launch {
                            withContext(Dispatchers.IO) {
                                delay(3000)
                                itemmub=20
                                refresh = false

                            }
                        }

                    },
                    loadState = load,
                    onLoad = {
                        load = true
                        scope.launch {
                            withContext(Dispatchers.IO) {
                                delay(3000)
                                itemmub += 10
                                load = false
                            }
                        }
                    }) {
                    CardList(itemmub)

                }

            }
        }
    }
}

