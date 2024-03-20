package com.example.cvapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvapp.education.EducationFragment
import com.example.cvapp.home.HomeFragment
import com.example.cvapp.sidemenu.Callback
import com.example.cvapp.sidemenu.MenuAdapter
import com.example.cvapp.sidemenu.MenuItem
import com.example.cvapp.sidemenu.MenuUtil

class MainActivity : AppCompatActivity(), Callback {
    lateinit var menuRv : RecyclerView //bugs here
    lateinit var adapter : MenuAdapter
    var selectedMenuPos : Int = 0
    var menuItems : List<MenuItem> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // Set side menu

        setupSideMenu()
        setHomeFragment()

        //setEducationFragment()

    }

    private fun setupSideMenu(){
        // get menu list item will get data from a static data
        menuRv = this.findViewById(R.id.rv_side_menu)
        println(R.id.rv_side_menu)
        println(menuRv)
        menuItems = MenuUtil.getMenuList()
        adapter = MenuAdapter(menuItems, this)
        menuRv.layoutManager = LinearLayoutManager(this)
        menuRv.adapter = adapter
    }
    fun setEducationFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container, EducationFragment()).commit()
    }

    private fun setHomeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
    }

    override fun onSideMenuItemClick(i: Int) {
        when(menuItems[i].code){
            MenuUtil.HOME_FRAGMENT_CODE -> setHomeFragment()
            MenuUtil.EDUCATION_FRAGMENT_CODE -> setEducationFragment()
//            MenuUtil.ACHIEVEMENT_FRAGMENT_CODE -> setAchievementFragment()
//            MenuUtil.ORGANIZATION_FRAGMENT_CODE -> setOrganizationFragment()
            else -> setHomeFragment()
        }

        // Highlight selected item
        menuItems[selectedMenuPos].isSelected = false
        menuItems[i].isSelected = true
        selectedMenuPos = i
        adapter.notifyDataSetChanged()
    }
}