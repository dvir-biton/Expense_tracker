package com.fylora.expensetracker.feature_expense.presentation.add_screen

import androidx.compose.runtime.mutableStateOf
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fylora.expensetracker.feature_expense.domain.model.Expense
import com.fylora.expensetracker.feature_expense.domain.model.InvalidExpenseException
import com.fylora.expensetracker.feature_expense.domain.use_cases.UseCases
import com.fylora.expensetracker.feature_expense.presentation.util.TransactionTypes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel(){

    private val _state = mutableStateOf(AddState())
    val state = _state

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun setTransactionTypeFromString(transactionType: String){
        lateinit var type: TransactionTypes

        when (transactionType) {
            "Payment", "Expense" -> {
                type = TransactionTypes.Payment(
                    title = "",
                    amount = ""
                )
            }
            "Income", "Received" -> {
                type = TransactionTypes.Received(
                    title = "",
                    amount = ""
                )
            }
            else -> {
                type = TransactionTypes.Payment(
                    title = "",
                    amount = ""
                )
            }
        }

        _state.value = state.value.copy(
            type = type
        )
    }

    fun resetState(){
        _state.value = AddState()
    }

    fun onEvent(event: AddEvent){
        when(event){
            is AddEvent.AddNumber -> {
                val regex = "\\d+\\.\\d{4,}"

                if(!_state.value.amount.matches(Regex(regex))
                    && state.value.amount.length < 12){
                    _state.value = state.value.copy(
                        amount = state.value.amount + event.number
                    )
                }
            }
            AddEvent.Delete -> {
                if(state.value.amount.isNotBlank()){
                    _state.value = state.value.copy(
                        amount = state.value.amount.dropLast(1)
                    )
                }
            }
            AddEvent.Enter -> {
                viewModelScope.launch {
                    try {
                        useCases.upsertExpenseUseCase(
                            expense = Expense(
                                title = state.value.textField.textValue,
                                amount = when(state.value.type) {
                                    is TransactionTypes.Received -> {
                                        if((state.value.amount.isDigitsOnly()
                                                    || state.value.amount.contains("."))
                                                    && state.value.amount.isNotBlank()){
                                            state.value.amount.toDouble()
                                        } else {
                                            0.0
                                        }
                                    }
                                    is TransactionTypes.Payment -> {
                                        if((state.value.amount.isDigitsOnly()
                                                    || state.value.amount.contains("."))
                                                    && state.value.amount.isNotBlank()){
                                            state.value.amount.toDouble() * -1
                                        } else {
                                            0.0
                                        }
                                    }
                                    null -> return@launch
                                },
                            )
                        )
                        resetState()
                        _eventFlow.emit(UiEvent.SaveExpense)
                    } catch (e: InvalidExpenseException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(e.message ?: "Unable to save expense")
                        )
                    }

                }
            }
            AddEvent.EnterDecimal -> {
                if(state.value.amount.isNotBlank() && !state.value.amount.contains(".")){
                    _state.value = state.value.copy(
                        amount = state.value.amount + "."
                    )
                }
            }
            is AddEvent.TextFieldAction -> {
                when(event.textFieldEvent){
                    is TextFieldEvent.ChangeTitleFocus -> {
                        _state.value = state.value.copy(
                            textField = state.value.textField.copy(
                                isHintVisible = !event.textFieldEvent.focusState.isFocused && state.value.textField.textValue.isBlank()
                            )
                        )
                    }
                    is TextFieldEvent.EnteredContent -> {
                        _state.value = state.value.copy(
                            textField = state.value.textField.copy(
                                textValue = event.textFieldEvent.content
                            )
                        )
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
        object SaveExpense: UiEvent()
    }
}