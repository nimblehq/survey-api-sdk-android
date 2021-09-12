package co.nimblehq.sample.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.nimblehq.sample.databinding.ActivityLoginBinding
import co.nimblehq.sample.ui.surveylist.SurveyListActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)


        loginViewModel.loginResult.observe(this@LoginActivity, {
            if (it.success != null) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_LONG).show()
                val intent = Intent(this@LoginActivity, SurveyListActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Login FAIL!", Toast.LENGTH_LONG).show()
            }

        })

        binding.login.setOnClickListener {
            loginViewModel.login()
        }

    }

}

