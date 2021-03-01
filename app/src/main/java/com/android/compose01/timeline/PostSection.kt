package com.android.compose01.timeline

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.android.compose01.R
import com.android.compose01.ui.theme.softGray


@Composable
fun PostSection() {

    Column(modifier = Modifier.background(Color.White)) {


        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            val (image, text) = createRefs()



            Image(
                painter = painterResource(R.drawable.me),
                contentDescription = "",
                modifier = Modifier
                    .constrainAs(image) {
                        linkTo(parent.top, parent.bottom, 16.dp, 16.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                    }
                    .width(38.dp)
                    .clip(CircleShape)

            )


            Text(
                text = stringResource(R.string.whats_on_your_mind),
                color = Color.Gray,
                modifier = Modifier
                    .constrainAs(text) {
                        start.linkTo(image.end, margin = 16.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                        top.linkTo(image.top)
                        bottom.linkTo(image.bottom)
                        width = Dimension.fillToConstraints
                    }
                    .border(width = 1.dp, color = softGray, shape = CircleShape)
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                fontSize = 16.sp
            )


        }


        Divider(color = softGray, thickness = 1.dp)


        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

            val (live, photo, room) = createRefs()

            Surface(modifier = Modifier.constrainAs(live) {
                linkTo(parent.start, photo.start)
            }) {
                PostAction(
                    icon = R.drawable.ic_round_video_call_24,
                    tint = colorResource(R.color.color_FFE91E63),
                    action = R.string.live
                )
            }


            Surface(modifier = Modifier.constrainAs(photo) {
                linkTo(live.end, room.start)
            }) {
                PostAction(
                    icon = R.drawable.ic_baseline_image_24,
                    tint = colorResource(R.color.teal_700),
                    action = R.string.photo
                )
            }


            Surface(modifier = Modifier.constrainAs(room) {
                linkTo(photo.end, parent.end)
            }) {
                PostAction(
                    icon = R.drawable.ic_room,
                    tint = colorResource(R.color.purple_500),
                    action = R.string.room
                )
            }


        }


    }

}


@Composable
fun PostAction(
    icon: Int,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    action: Int,
    onClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .clickable { onClick.invoke() }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(20.dp)
        )

        Text(
            text = stringResource(id = action),
            modifier = Modifier.padding(start = 4.dp),
            fontSize = 12.sp
        )

    }

}
