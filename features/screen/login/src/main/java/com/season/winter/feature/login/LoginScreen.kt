package com.season.winter.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.season.winter.compose.button.CBButton
import com.season.winter.compose.image.CBImage
import com.season.winter.compose.input.CBTextField
import com.season.winter.compose.spacing.CBColumnWeight
import com.season.winter.compose.spacing.CBSpacerHeight
import com.season.winter.compose.text.CBText
import com.season.winter.compose.theme.ComposeCatchBottleTheme
import com.season.winter.designsystem.graphic.CBGraphic
import com.season.winter.designsystem.size.CBSize
import com.season.winter.designsystem.spacing.CBSpacing
import com.season.winter.designsystem.typography.CBTypography

@Composable
fun LoginActivityScreen(
    viewModel: LoginViewModel = viewModel()
) {
    LoginActivityScreen(
        onClickLogin = { userName ->
            viewModel.login(userName)
        }
    )
}

@Composable
internal fun LoginActivityScreen(
    onClickLogin: (userName: String) -> Unit = { }
) {

    var userName = ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(CBSpacing.M.dp)
    ) {
        CBSpacerHeight(CBSpacing.Xxxl)
        CBImage(
            painter = CBGraphic.LogoIcon.painter,
            size = CBSize.X4l,
            modifier = Modifier
                .rotate(45f)
        )
        CBSpacerHeight(CBSpacing.L)
        CBText(
            style = CBTypography.HeadM,
            text = "Good to see you"
        )
        CBText(
            style = CBTypography.BodyM,
            text = "Discovering exquisite bottle with"
        )
        CBImage(
            modifier = Modifier.align(Alignment.End),
            painter = CBGraphic.LogoText.painter,
            width = CBSize.X4l.dp,
            height = CBSize.X2l.dp
        )
        CBSpacerHeight(CBSpacing.L)
        CBTextField(
            placeholderValue = "input your name"
        ) {
            userName = it
        }
        CBColumnWeight()
        CBButton("Login",) {
            if (userName.isNotEmpty())
                onClickLogin(userName)
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@ExperimentalComposeUiApi
@Composable
internal fun PreviewLoginScreen() {
    ComposeCatchBottleTheme {
        LoginActivityScreen(
            onClickLogin = {

            }
        )
    }
}