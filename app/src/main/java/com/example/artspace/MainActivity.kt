package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
                }
            }
        }
    }

@Composable
fun ArtSpaceApp(){

    var artSpace by remember {
        mutableStateOf(1)
    }

  Column(
      modifier = Modifier
          .fillMaxSize()
          .padding(horizontal = 15.dp)
          .verticalScroll(rememberScrollState()),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
  ) {
      when ( artSpace){
          1 ->{
              ArtWorkContent(
                  drawableResourceId = R.drawable.image_1,
                  contentDescriptionResourceId = R.string.img_1_content_desc,
                  textLabelResourceId = R.string.img_1_text_desc ,
                  originQouteId = R.string.img_1_author,
                  creditLabelResourceId = R.string.img_1_credit_desc ,
                  onPrevClick = { artSpace = 6 },
                  onNextClick = { artSpace = 2}
              )
          }

          2 ->{
              ArtWorkContent(
                  drawableResourceId = R.drawable.image_2,
                  contentDescriptionResourceId = R.string.img_2_content_desc,
                  textLabelResourceId = R.string.img_2_text_desc ,
                  originQouteId = R.string.img_2_author,
                  creditLabelResourceId = R.string.img_2_credit_desc ,
                  onPrevClick = { artSpace = 1 },
                  onNextClick = { artSpace = 3}
              )
          }
          3 ->{
              ArtWorkContent(
                  drawableResourceId = R.drawable.image_3,
                  contentDescriptionResourceId = R.string.img_3_content_desc,
                  textLabelResourceId = R.string.img_3_text_desc ,
                  originQouteId = R.string.img_3_author,
                  creditLabelResourceId = R.string.img_3_credit_desc ,
                  onPrevClick = { artSpace = 2 },
                  onNextClick = { artSpace = 4}
              )
          }

          4 ->{
              ArtWorkContent(
                  drawableResourceId = R.drawable.image_4,
                  contentDescriptionResourceId = R.string.img_4_content_desc,
                  textLabelResourceId = R.string.img_4_text_desc ,
                  originQouteId = R.string.img_4_author,
                  creditLabelResourceId = R.string.img_4_credit_desc ,
                  onPrevClick = { artSpace = 3 },
                  onNextClick = { artSpace = 5}
              )
          }

          5 ->{
              ArtWorkContent(
                  drawableResourceId = R.drawable.image_5,
                  contentDescriptionResourceId = R.string.img_5_content_desc,
                  textLabelResourceId = R.string.img_5_text_desc ,
                  originQouteId = R.string.img_5_author,
                  creditLabelResourceId = R.string.img_5_credit_desc ,
                  onPrevClick = { artSpace = 4 },
                  onNextClick = { artSpace = 6}
              )
          }

          6 ->{
              ArtWorkContent(
                  drawableResourceId = R.drawable.image_6,
                  contentDescriptionResourceId = R.string.img_6_content_desc,
                  textLabelResourceId = R.string.img_6_text_desc ,
                  originQouteId = R.string.img_6_author,
                  creditLabelResourceId = R.string.img_6_credit_desc ,
                  onPrevClick = { artSpace = 5 },
                  onNextClick = { artSpace = 1}
              )
          }


      }

  }

}

@Composable
fun ArtWorkContent(
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    textLabelResourceId: Int,
    originQouteId: Int,
    creditLabelResourceId: Int,
    onPrevClick: () -> Unit,
    onNextClick: () -> Unit
){
    ArtworkWall(
        modifier = Modifier
            .size(width = 500.dp, height = 500.dp)
            .padding(top = 100.dp),
        drawableResourceId = drawableResourceId,
        contentDescriptionResourceId = contentDescriptionResourceId,
        creditLabelResourceId = creditLabelResourceId)

    Spacer(modifier = Modifier.height(50.dp))

    ArtworkDescriptor(
        textLabelResourceId = textLabelResourceId,
        originQouteId = originQouteId)


    Spacer(modifier = Modifier.height(10.dp))

    DisplayController(
        prevBtnTextResourceId = R.string.prev_btn,
        nxtBtnTextResourceId = R.string.nxt_btn ,
        onPrevClick = onPrevClick,
        onNextClick = onNextClick
    )
}

@Composable
fun ArtworkWall(

    modifier: Modifier = Modifier,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    creditLabelResourceId: Int

){

        ElevatedCard(
            colors = CardDefaults.cardColors(
                Color.White),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 15.dp)

        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(all = 30.dp),

                painter = painterResource(drawableResourceId),
                contentDescription = stringResource(contentDescriptionResourceId)
            )
            Text(text = stringResource(creditLabelResourceId ),
                fontSize = 10.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 5.dp, bottom = 2.dp)
            )
        }


}

@Composable
fun ArtworkDescriptor(
    textLabelResourceId: Int,
    originQouteId: Int,
    modifier: Modifier = Modifier
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),

    ) {
        Column(
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        ) {
            Text(text = stringResource(textLabelResourceId),
                fontSize = 15.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Text(text = stringResource(originQouteId),
                fontSize = 15.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

        }


    }
}

@Composable
fun DisplayController(
    prevBtnTextResourceId: Int,
    nxtBtnTextResourceId: Int,
    onPrevClick: () -> Unit,
    onNextClick: () -> Unit,


){
    Row(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth(),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly


    ) {
        Button(
            modifier = Modifier
                .weight(0.1f),
            onClick = onPrevClick)
        {
            Text(text = stringResource(prevBtnTextResourceId))
        }

        Spacer(modifier = Modifier.weight(0.1f))

        Button(
            modifier = Modifier
                .weight(0.1f),
            onClick = onNextClick)
        {
            Text(text = stringResource(nxtBtnTextResourceId) )

        }
       }

}

@Preview(showSystemUi = true)
@Composable
fun ArtSpaceAppPreview(){
    ArtSpaceApp()
}