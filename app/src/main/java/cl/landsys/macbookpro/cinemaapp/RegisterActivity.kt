package cl.landsys.macbookpro.cinemaapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        textVolver.setOnClickListener { volver() }
    }

    private fun volver(){
        var intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }
}
