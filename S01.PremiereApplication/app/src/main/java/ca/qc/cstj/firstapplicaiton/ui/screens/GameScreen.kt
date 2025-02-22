package ca.qc.cstj.firstapplicaiton.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.qc.cstj.firstapplicaiton.R
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit


@Composable
fun GameScreen(viewModel: GameScreenViewModel = viewModel() ){

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    if(uiState.status == GameStatus.WIN)
    KonfettiView(
        modifier = Modifier.fillMaxSize(),
        parties = listOf(
            Party(
                emitter = Emitter(duration = 5, TimeUnit.SECONDS).perSecond(30)
            )
        )

    )



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = uiState.userTry.toString(), fontSize = 32.sp)
            Column {
                Button(onClick = {
                    viewModel.increment()
                }) {
                    Text(text = "+", fontSize = 20.sp)
                }
                Button(onClick = {
                        viewModel.decrement()
                }) {
                    Text(text = "-", fontSize = 20.sp)
                }
            }
        }
        if(uiState.status == GameStatus.WIN) {
            Button(
                modifier = Modifier.fillMaxWidth(0.6f),
                onClick = {
                    viewModel.restart()
                }
            ) {
                Text(text = stringResource(R.string.new_game), fontSize = 28.sp)
            }
        } else{
            Button(
                modifier = Modifier.fillMaxWidth(0.5f),
                onClick = {
                    viewModel.validate()
                }
            ) {
                Text(text = stringResource(R.string.msg_try), fontSize = 32.sp)
            }
        }
        Text(text = when(uiState.status){
            GameStatus.NEW_GAME -> stringResource(R.string.good_luck)
            GameStatus.TOO_HIGH -> stringResource(R.string.too_high)
            GameStatus.TOO_LOW -> stringResource(R.string.too_low)
            GameStatus.WIN -> stringResource(R.string.you_win)
        }, fontSize = 32.sp)
    }
}