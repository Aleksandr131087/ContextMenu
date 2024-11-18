package com.example.contextmenu

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
      private lateinit var textET: EditText
    private lateinit var button_input: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textET = findViewById(R.id.textET)
        registerForContextMenu(textET)

button_input = findViewById(R.id.Button_input)

        button_input.setOnClickListener {
            val randomNumber = Random.nextInt(1, 51)
            textET.setText(randomNumber.toString())
        }

        }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
       menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_change_color -> {
             changeColor()
                Toast.makeText(this, "поменяли цвет", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_EXIT -> {
                          finish()
            }
            else -> {
                return super.onContextItemSelected(item)
            }
        }
        return true
    }
private fun changeColor() {
    val randomNumber = textET.text.toString()
    when (randomNumber) {
        1.toString() -> {
            textET.setBackgroundColor(Color.parseColor("#FFA500"))
        }
        2.toString() -> {
            textET.setBackgroundColor(Color.YELLOW)
        }
        3.toString() -> {
            textET.setBackgroundColor(Color.GREEN)
        }
        4.toString() -> {
            textET.setBackgroundColor(Color.BLUE)
        }
        5.toString() -> {
            textET.setBackgroundColor(Color.RED)
        }
        in (1..10).toString() -> {
            textET.setBackgroundColor(Color.RED)
        }
        in (11..20).toString() -> {
            textET.setBackgroundColor(Color.parseColor("#FFA500"))
        }
        in (21..30).toString() -> {
            textET.setBackgroundColor(Color.YELLOW)
        }
        in (31..40).toString() -> {
            textET.setBackgroundColor(Color.GREEN)
        }
        in (41..50).toString() -> {
            textET.setBackgroundColor(Color.BLUE)
        }

    }


}}


