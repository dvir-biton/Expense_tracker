package com.fylora.expensetracker.feature_expense.presentation.add_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fylora.expensetracker.R
import com.fylora.expensetracker.core.fontFamily
import com.fylora.expensetracker.feature_expense.presentation.add_screen.AddEvent
import com.fylora.expensetracker.feature_expense.presentation.add_screen.AddViewModel
import com.fylora.expensetracker.feature_expense.presentation.add_screen.TextFieldEvent
import com.fylora.expensetracker.feature_expense.presentation.ui.theme.Background
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(
    viewModel: AddViewModel,
    navController: NavController
) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                AddViewModel.UiEvent.SaveExpense -> {
                    navController.navigateUp()
                }
                is AddViewModel.UiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Background)
            ){
                IconButton(
                    onClick = {
                        viewModel.resetState()
                        navController.navigateUp()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Go back",
                        tint = Color.White
                    )
                }
            }
        },
        contentColor = Background,
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Background)
        ) {
            Text(
                text = "New ${viewModel.state.value.type?.screenTitle}",
                modifier = Modifier.align(CenterHorizontally),
                color = viewModel.state.value.type?.color ?: Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp,
                fontFamily = fontFamily
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "$${viewModel.state.value.amount}",
                modifier = Modifier.align(CenterHorizontally),
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 48.sp,
                fontFamily = fontFamily,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(18.dp))

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(30.dp, 30.dp))
                    .background(Color(0xFF292929))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(TopCenter),
                    verticalAlignment = Alignment.Top
                ){
                    InvisibleBorderTextField(
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                            .padding(bottom = 40.dp),
                        text = viewModel.state.value.textField.textValue,
                        hint = "Enter Title",
                        onValueChange = { text ->
                            viewModel.onEvent(AddEvent.TextFieldAction(TextFieldEvent.EnteredContent(text)))
                        },
                        onFocusChange = { focused ->
                            viewModel.onEvent(AddEvent.TextFieldAction(TextFieldEvent.ChangeTitleFocus(focused)))
                        },
                        isHintVisible = viewModel.state.value.textField.isHintVisible,
                        singleLine = true
                    )
                }

                Column(
                    modifier = Modifier
                        .align(BottomCenter)
                        .clip(RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp))
                        .background(Color(0xFF333333)),
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){

                    Row{
                        InvisibleBorderTextButton(
                            symbol = "7",
                            onClick = {
                                viewModel.onEvent(AddEvent.AddNumber("7"))
                            }
                        )
                        InvisibleBorderTextButton(
                            symbol = "8",
                            onClick = {
                                viewModel.onEvent(AddEvent.AddNumber("8"))
                            }
                        )
                        InvisibleBorderTextButton(
                            symbol = "9",
                            onClick = {
                                viewModel.onEvent(AddEvent.AddNumber("9"))
                            }
                        )
                    }
                    Row {
                        InvisibleBorderTextButton(
                            symbol = "4",
                            onClick = {
                                viewModel.onEvent(AddEvent.AddNumber("4"))
                            }
                        )
                        InvisibleBorderTextButton(
                            symbol = "5",
                            onClick = {
                                viewModel.onEvent(AddEvent.AddNumber("5"))
                            }
                        )
                        InvisibleBorderTextButton(
                            symbol = "6",
                            onClick = {
                                viewModel.onEvent(AddEvent.AddNumber("6"))
                            }
                        )
                    }
                    Row {
                        InvisibleBorderTextButton(
                            symbol = "1",
                            onClick = {
                                viewModel.onEvent(AddEvent.AddNumber("1"))
                            }
                        )
                        InvisibleBorderTextButton(
                            symbol = "2",
                            onClick = {
                                viewModel.onEvent(AddEvent.AddNumber("2"))
                            }
                        )
                        InvisibleBorderTextButton(
                            symbol = "3",
                            onClick = {
                                viewModel.onEvent(AddEvent.AddNumber("3"))
                            }
                        )
                    }
                    Row {
                        InvisibleBorderTextButton(
                            symbol = ".",
                            onClick = {
                                viewModel.onEvent(AddEvent.EnterDecimal)
                            }
                        )
                        InvisibleBorderTextButton(
                            symbol = "0",
                            onClick = {
                                viewModel.onEvent(AddEvent.AddNumber("0"))
                            }
                        )
                        InvisibleBorderTextButton(
                            symbol = "",
                            icon = painterResource(id = R.drawable.backspace),
                            onClick = {
                                viewModel.onEvent(AddEvent.Delete)
                            }
                        )
                    }

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 20.dp,
                                vertical = 10.dp
                            )
                            .padding(bottom = 20.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF21C161)),
                        onClick = {
                            viewModel.onEvent(AddEvent.Enter)
                        }
                    ) {
                        Text(
                            text = "Enter",
                            fontSize = 32.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                        )
                    }
                }
            }
        }
    }
}