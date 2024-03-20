package com.example.cvapp.sidemenu

import com.example.cvapp.R

class MenuUtil {
    companion object{
        const val HOME_FRAGMENT_CODE : Int = 0
        const val EDUCATION_FRAGMENT_CODE : Int = 1
        const val ACHIEVEMENT_FRAGMENT_CODE : Int = 2
        const val ORGANIZATION_FRAGMENT_CODE : Int = 3
        fun getMenuList() : List<MenuItem> {
            val list : MutableList<MenuItem> = mutableListOf()
            // Select first item
            list.add(MenuItem(R.drawable.ic_baseline_home_24, HOME_FRAGMENT_CODE,true))
            list.add(MenuItem(R.drawable.ic_baseline_education_24, EDUCATION_FRAGMENT_CODE,false))
            list.add(MenuItem(R.drawable.ic_baseline_achievement_24, ACHIEVEMENT_FRAGMENT_CODE,false))
            list.add(MenuItem(R.drawable.ic_baseline_organization_24, ORGANIZATION_FRAGMENT_CODE,false))

            return list;
        }
    }


}