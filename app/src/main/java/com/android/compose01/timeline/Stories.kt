package com.android.compose01.timeline

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.android.compose01.R
import dev.chrisbanes.accompanist.coil.CoilImage


@Composable
fun Stories(stories: ArrayList<Story>) {


    Surface(color = Color.White, modifier = Modifier.padding(top = 8.dp)) {

        LazyRow(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {

            items(stories, itemContent = { story ->

                StoryCard(
                    story = Story(
                        userName = story.userName,
                        userProfile = story.userProfile,
                        imgUrl = story.imgUrl
                    )
                )

            })

        }

    }



}


@Composable
fun StoryCard(story: Story) {

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(130.dp)
            .height(190.dp)
            .padding(4.dp),
        backgroundColor = Color.Gray
    ) {


        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clickable { /* todo */ }
        ) {

            val (profileImg, storyImg, name) = createRefs()

            CoilImage(
                data = story.imgUrl,
                contentDescription = null,
                modifier = Modifier.constrainAs(storyImg) {
                    linkTo(parent.start, parent.end)
                    linkTo(parent.top, parent.bottom)
                },
                contentScale = ContentScale.Crop
            )

            Text(
                text = story.userName,
                fontSize = 13.sp,
                color = Color.White,
                modifier = Modifier
                    .constrainAs(name) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(8.dp),
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Red,
                    ),

                    )
            )



            Card(
                shape = CircleShape,
                modifier = Modifier
                    .constrainAs(profileImg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .padding(8.dp)
                    .width(40.dp)
                    .height(40.dp)
                    .border(
                        width = 2.dp,
                        color = colorResource(R.color.purple_500),
                        shape = CircleShape
                    )
                    .padding(4.dp)
            ) {


                Image(
                    painter = painterResource(story.userProfile),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                )

            }

        }


    }

}


data class Story(
    val userName: String,
    val userProfile: Int,
    val imgUrl: String,
)





