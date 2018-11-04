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
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.content_home.*

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

        val movies = ArrayList<Movie>()

        movies.add(Movie("pelicula 1",23,"R",R.drawable.bg, "todos los dias 21:hrs"))
        movies.add(Movie("pelicula 2",12,"R",R.drawable.bg, "todos los dias 21:hrs"))
        movies.add(Movie("pelicula 3",14,"R",R.drawable.bg, "todos los dias 21:hrs"))
        movies.add(Movie("pelicula 4",41,"R",R.drawable.bg, "todos los dias 21:hrs"))
        movies.add(Movie("pelicula 5",65,"R",R.drawable.bg, "todos los dias 21:hrs"))

        val adapter = AdapterMovie(movies)
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
                var intent = Intent(applicationContext, Create::class.java)
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
