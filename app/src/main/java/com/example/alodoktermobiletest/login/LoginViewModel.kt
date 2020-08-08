package com.example.alodoktermobiletest.login

import android.content.Context
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.example.alodoktermobiletest.BR
import com.example.alodoktermobiletest.data.preference.Preferences
import com.example.alodoktermobiletest.R
import com.example.alodoktermobiletest.data.model.User
import java.io.Serializable

class LoginViewModel(private val context: Context) : BaseObservable(), Serializable {

    val user = User()
    var isLoggedIn = MutableLiveData<Boolean>()

    @Bindable
    private var toastMessage: String? = null

    fun getToastMessage(): String? {
        return toastMessage
    }

    private fun setToastMessage(toastMessage: String) {
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }

    @Bindable
    fun getUserEmail() = user.email

    fun setUserEmail(value: String) {
        if (user.email != value) {
            user.email = value
            notifyPropertyChanged(BR.userEmail)
        }
    }

    @Bindable
    fun getUserPassword() = user.password

    fun setUserPassword(value: String) {
        if (user.password != value) {
            user.password = value
            notifyPropertyChanged(BR.userPassword)
        }
    }

    fun loginClicked() {
        if (isInputValid()) {
            setToastMessage(context.getString(R.string.login_success))
            Preferences().setLoggedInStatus(context)
            isLoggedIn.value = true
        } else {
            setToastMessage(context.getString(R.string.login_failed))
        }
    }

    private fun isInputValid(): Boolean {
        return !getUserEmail().isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && !getUserPassword().isNullOrEmpty()
    }

    companion object {
        @BindingAdapter("toastMessage")
        @JvmStatic
        fun runToast(view: View, message: String?) {
            if (message != null) Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
        }
    }
}