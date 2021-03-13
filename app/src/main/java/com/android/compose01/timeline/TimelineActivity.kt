package com.android.compose01.timeline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.android.compose01.timeline.ui.theme.Compose01Theme
import com.android.compose01.ui.theme.softGray

class TimelineActivity : ComponentActivity() {

    private lateinit var viewModel: TimelineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(TimelineViewModel::class.java)

        setContent {
            Compose01Theme(darkTheme = false) {
                TimelineScreen(viewModel)
            }
        }
    }

}//TimelineActivity

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Compose01Theme {
        TimelineScreen(TimelineViewModel())
    }
}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

@Composable
fun TimelineScreen(viewModel: TimelineViewModel) {


    Surface(
        color = softGray, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Column {

            Header()

            LazyColumn {


                item {
                    Column {
                        PostSection()
                        Stories(viewModel.getStories())
                        Spacer(modifier = Modifier.padding(4.dp))
                    }
                }

                items(viewModel.getPosts()) { item: SinglePost -> Post(singlePost = item) }

            }


        }


    }

}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
