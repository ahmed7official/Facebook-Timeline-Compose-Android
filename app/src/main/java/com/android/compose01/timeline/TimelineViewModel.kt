package com.android.compose01.timeline

import androidx.lifecycle.ViewModel
import com.android.compose01.R

class TimelineViewModel : ViewModel() {

    
    fun getStories() = arrayListOf<Story>().apply {

        add(
            Story(
                userName = "Ahmed M Abdalla",
                userProfile = R.drawable.me,
                imgUrl = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg"
            )
        )

        add(
            Story(
                userName = "Messi",
                userProfile = R.drawable.me,
                imgUrl = "https://upload.wikimedia.org/wikipedia/commons/d/d9/Lionel_Messi_20180626_%28cropped%29.jpg"
            )
        )

        add(
            Story(
                userName = "Elon Musk",
                userProfile = R.drawable.elon_musk,
                imgUrl = "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg"
            )
        )

        add(
            Story(
                userName = "Cristiano Ronaldo",
                userProfile = R.drawable.me,
                imgUrl = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg"
            )
        )

        add(
            Story(
                userName = "Yasser Ali",
                userProfile = R.drawable.me,
                imgUrl = "https://pbs.twimg.com/profile_images/1251163079301386240/FgDdw5tG.jpg"
            )
        )

        add(
            Story(
                userName = "Elon Musk",
                userProfile = R.drawable.elon_musk,
                imgUrl = "https://pbs.twimg.com/profile_images/1251163079301386240/FgDdw5tG.jpg"
            )
        )
        
    }
    

    fun getPosts(): List<SinglePost> {

        return arrayListOf<SinglePost>().apply {

            add(
                SinglePost(
                    authorName = "Ahmed M. Abdalla",
                    authorPhoto = R.drawable.me,
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, ",/*photo = R.drawable.wallpaper,*/
                )
            )

            add(
                SinglePost(
                    authorName = "Ossama Elzero",
                    authorPhoto = R.drawable.elzero,
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                    photo = R.drawable.elon_musk,
                )
            )

            add(
                SinglePost(
                    authorName = "Ahmed M. Abdalla",
                    authorPhoto = R.drawable.me,
                    text = "Hello World, This is first jetpack compose project",/*photo = R.drawable.wallpaper,*/
                )
            )

            add(
                SinglePost(
                    authorName = "Ahmed M. Abdalla",
                    authorPhoto = R.drawable.me,
                    text = "Hello World, This is first jetpack compose project",
                    photo = R.drawable.wallpaper,
                )
            )

        }

    }

}