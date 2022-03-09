package edu.temple.lab4mobileappdevelopment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main2.*
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val desc : TextView = findViewById(R.id.textView)
        val image : ImageView = findViewById(R.id.imageView)


        val bundle : Bundle?= intent.extras
        val description = bundle!!.getString("desc")
        val imageId = bundle.getInt("ImageId")

        desc.text = description
        image.setImageResource(imageId)

        btswitch.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }
}