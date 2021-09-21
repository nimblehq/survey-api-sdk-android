package co.nimblehq.sample.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.nimblehq.sample.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)


        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            if (it.isSuccess) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Login FAIL!", Toast.LENGTH_LONG).show()
            }

        })

        binding.login.setOnClickListener {
            loginViewModel.login()
        }
    }
}
