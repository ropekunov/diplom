package com.roman.masterim_buket

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {


    private lateinit var bottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userNameList:List<String> = listOf("Ёлки КРАСИВЫЕ","Венки НОВОГОДНИЕ","Композиции","Наборы","И ещё","МНОГО","ВСЕГО","ЗАХОДИ","НАЛЕТАЙ","доставка по всей России",";-)")

        val userRecyclerView: RecyclerView = findViewById(R.id.happy_new_price)
        userRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        userRecyclerView.adapter=UserAdapter(userNameList)

        bottomMenu = findViewById(R.id.bottom_menu)

        bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu -> {
                    val menuFragment = MenuFragment()
                    replaceFragment(menuFragment)
                }
                R.id.about -> {
                    val aboutFragment = AboutFragment()
                    replaceFragment(aboutFragment)
                }
                R.id.browser_ya -> {

                    val link = Uri.parse("https://masterim-buket.ru")
                    val intent = Intent(Intent.ACTION_VIEW, link)

                    startActivity(intent)


                }
            }
            true
        }

        bottomMenu.selectedItemId = savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.menu
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomMenu.selectedItemId)
        super.onSaveInstanceState(outState)
    }
}