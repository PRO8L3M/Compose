package com.example.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.common.base.Event
import com.example.common.navigation.NavigationEvent
import com.example.domain.models.Joke
import com.example.domain.models.Value
import com.example.home.events.SyncJokes
import com.example.home.state.HomeState

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (Event) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        when (state) {
            is HomeState.NotApplicable -> Unit
            is HomeState.Success -> {
                Content(
                    modifier = Modifier.fillMaxSize(),
                    state = state,
                    onEvent = onEvent,
                )
            }
        }
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    state: HomeState.Success,
    onEvent: (Event) -> Unit,
) {
    Box(modifier = modifier) {
        when (state.jokes) {
            is Value.NoData -> {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .align(Alignment.BottomCenter),
                    onClick = { onEvent(SyncJokes) }
                ) {
                    Text(text = "Fetch jokes")
                }
            }
            is Value.Data -> {
                LazyColumn(
                    modifier = Modifier.matchParentSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(16.dp),
                ) {
                    items(state.jokes.data) { joke ->
                        JokeCard(
                            joke = joke,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun JokeCard(
    modifier: Modifier = Modifier,
    joke: Joke,
) {
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Text(
            text = joke.question,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Gray,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp),
        )
        Text(
            text = joke.punchline,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Green,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp),
        )
    }
}
