package com.example.contatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvList)
    }
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        bindView()
        updateList()
    }

    // Roda o DrawerLayout(Menu)
    private fun initDrawer(){
        //Inicialização do DrawerLayout
        val drawerLayout = findViewById<View>(R.id.dlMenu) as DrawerLayout
        
        //Inicialização da Toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.tbMenu)
        setSupportActionBar(toolbar)

        //Vinculação de ambas à um toggle
        val toggle = ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun bindView() {
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList() {
        adapter.updateList(
            arrayListOf(
                Contact("Arthur", "(00)123456789", "img.png"),
                Contact("Ana", "(01)123456789", "img.png"),
                Contact("Pedro", "(02)123456789", "img.png"),
                Contact("Julia", "(03)123456789", "img.png")
            )
        )
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.iMenu1 ->{
                showToast("Configurações não disponíveis")
                true
            }
            R.id.iMenu2 ->{
                showToast("Sobre não disponível")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}