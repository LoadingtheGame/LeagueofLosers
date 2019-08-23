package com.example.wineryfactory.View

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.wineryfactory.Model.SectionsPagerAdapter
import com.example.wineryfactory.R
import com.github.clans.fab.FloatingActionMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionMenu = findViewById(R.id.fab)
        fab.isIconAnimated = false
        fab.setClosedOnTouchOutside(true)
        var index = 0

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(i: Int) {
                index = i
                if (i == 0) {
                    fab.menuIconView.setImageResource(R.drawable.ic_trophy)
                    fab.visibility = View.VISIBLE
                    menu_adicionar.labelText = "Adicionar Campeonato"
                } else if (i == 1) {
                    fab.visibility = View.INVISIBLE
                } else if (i == 2) {
                    fab.menuIconView.setImageResource(R.drawable.ic_team)
                    fab.visibility = View.VISIBLE
                    menu_adicionar.labelText = "Adicionar Time"
                } else if (i == 3) {
                    fab.menuIconView.setImageResource(R.drawable.ic_player)
                    fab.visibility = View.VISIBLE
                    menu_adicionar.labelText = "Adicionar Player"
                }
            }


        })

        menu_adicionar.setOnClickListener {
            when (index) {
                0 -> {
                    fab.close(true)
                    startActivity(Intent(applicationContext, Cadastrar_Campeonato::class.java))
                }
                2 -> {
                    fab.close(true)
                    startActivity(Intent(applicationContext, Cadastrar_Time::class.java))
                }
                3 -> {
                    fab.close(true)
                    startActivity(Intent(applicationContext, Cadastrar_Jogador::class.java))
                }
            }
        }

    }

    override fun onBackPressed() {
        if (view_pager.currentItem != 0) {
            view_pager.currentItem = 0
        } else {
            finish()
        }
    }
}