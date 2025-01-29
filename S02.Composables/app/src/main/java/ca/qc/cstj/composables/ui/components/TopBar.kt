package ca.qc.cstj.composables.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.qc.cstj.composables.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(name:String)
{
    TopAppBar(
        title = {
            Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ){
            Text( text = stringResource(R.string.good_morning, name))
            Text( text = stringResource(R.string.we_wish_you_a_good_day), style = MaterialTheme.typography.bodySmall)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
    )
}