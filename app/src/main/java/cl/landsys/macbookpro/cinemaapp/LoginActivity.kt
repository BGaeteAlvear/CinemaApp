package cl.landsys.macbookpro.cinemaapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        RegistrarTxV.setOnClickListener { registrar() }

    }

    fun registrar(){
        val intent = Intent(this.applicationContext,RegisterActivity::class.java )
        startActivity(intent)
        finish()
    }
}
