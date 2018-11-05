package cl.landsys.macbookpro.cinemaapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.content_home.*
import kotlinx.android.synthetic.main.activity_create.*

val listMovies = ListMovies()

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        // recycler view
        val recyclerView:RecyclerView=findViewById(R.id.reciclerview)
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayout.VERTICAL,false) as RecyclerView.LayoutManager?

        listMovies.apply {

            addMovie(Movie("pelicula 1",50,"+18",R.drawable.descarga, "todos los dias 21:00 hrs"))
            addMovie(Movie("pelicula 2",230,"+14",R.drawable.descarga, "todos los dias 15:00 hrs"))
            addMovie(Movie("pelicula 3",68,"TE",R.drawable.descarga, "todos los dias 18:00 hrs"))

        }

        val adapter = AdapterMovie(listMovies)
        reciclerview.adapter=adapter
    }



    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_calification -> {

            }
            R.id.nav_list -> {
                var intent = Intent(applicationContext, this::class.java)
                startActivity(intent)
                finish()
            }
            R.id.nav_new -> {
                var intent = Intent(applicationContext, CreateActivity::class.java)
                startActivity(intent)
                finish()

            }
            R.id.nav_edit -> {

            }
            R.id.nave_delete -> {

            }
            R.id.nav_my -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}


class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        btnGuardar.setOnClickListener { newMovie() }
        btnCancelar.setOnClickListener { back() }
    }

    fun newMovie(){
        val title:String
        val horario:String
        val classification = classification()
        val minutos:String = txtDuracion.text.toString()



        if (validate(txtPelicula.text.toString())){
            title = txtPelicula.text.toString()

            if (validate(txtHorario.text.toString())){
                horario =txtPelicula.text.toString()

                if(validate(minutos)){
                    val min:Int = minutos.toInt()

                    listMovies.addMovie(Movie(title,min,classification,R.drawable.descarga,horario))
                    Toast.makeText(getApplicationContext(), "Pelicula Agregada Correctamente",
                        Toast.LENGTH_SHORT).show();

                    back()

                }else{
                    Toast.makeText(getApplicationContext(), "Minutos de la Pelicula es Requerido!",
                        Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(getApplicationContext(), "Horario de Pelicula es Requerido!",
                    Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(getApplicationContext(), "Titulo de Pelicula es Requerido!",
                Toast.LENGTH_SHORT).show();

        }

    }

    fun validate(value:String):Boolean{
        if(value.isNotEmpty()){
            return true
        }
        return false
    }

    fun classification():String{
        if (rbTE.isChecked()){
            return "TE"
        }else if(rb14.isChecked()){
            return "+14"
        }else if(rb18.isChecked()){
            return "+18"
        }else if(rb14.isChecked()){
            return "+21"
        }else{
            return "SIN CLASIFICACIÓN"
        }
    }

    fun back(){
        var intent = Intent(applicationContext, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}
