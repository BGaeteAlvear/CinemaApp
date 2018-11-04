package cl.landsys.macbookpro.cinemaapp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        RegistrarTxV.setOnClickListener { register() }
        btnIngresar.setOnClickListener { validate(edit_email.text.toString(), edit_password.text.toString()) }

    }

    fun register(){
        val intent = Intent(this.applicationContext,RegisterActivity::class.java )
        startActivity(intent)
        finish()
    }

    private fun login(email:String, password:String ){

        if(email.equals("duoc@duoc.cl") and password.equals("duoc")){
            Toast.makeText(getApplicationContext(), "Redireccionando....",
                Toast.LENGTH_LONG).show();
            var intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
            finish()

        }else{
            Toast.makeText(getApplicationContext(), "Credenciales Invalidas!",
                Toast.LENGTH_LONG).show();
        }

    }

    private fun validate(getEmail:String, getPassword:String){

        edit_email.error = null
        edit_password.error = null

        val emailStr = getEmail
        val passwordStr = getPassword

        var cancel = false
        var focusView: View? = null


        if (!TextUtils.isEmpty(passwordStr) && !isPasswordValid(passwordStr)) {
            Toast.makeText(getApplicationContext(), "Largo mínimo 3 Caracteres",
                Toast.LENGTH_LONG).show();
            focusView = edit_password
            cancel = true
        }

        //Validaciones Email
        if (TextUtils.isEmpty(emailStr)) {
            Toast.makeText(getApplicationContext(), "Email Requerido!",
                Toast.LENGTH_LONG).show();
            focusView = edit_email
            cancel = true
        } else if (!isEmailValid(emailStr)) {
            Toast.makeText(getApplicationContext(), "Formato Invalido necesita un @",
                Toast.LENGTH_LONG).show();
            focusView = edit_email
            cancel = true
        } else if (!isEmailValidDot(emailStr)){
            Toast.makeText(getApplicationContext(), "Formato Invalido necesita un .com .cl etc",
                Toast.LENGTH_LONG).show();
            focusView = edit_email
            cancel = true
        }

        if (cancel) {
            focusView?.requestFocus()
        } else {

            login(getEmail,getPassword)
        }

    }

    // Validaciones
    private fun isEmailValid(email: String): Boolean {
        return email.contains("@")
    }

    private fun isEmailValidDot(email: String): Boolean {
        return email.contains(".")
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length >= 4
    }





}
