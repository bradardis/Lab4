package edu.temple.lab4mobileappdevelopment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var  newArrayList: ArrayList<pics>
    lateinit var imageId : Array<Int>
    lateinit var desc : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        imageId = arrayOf(R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,  R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10,)

        desc = arrayOf("This photo was taken of a Buddhist temple in the residential area of Bangkok. In Thailand there was a temple every 5 blocks but this temple had very inteicate designes" +
                " and was larger than the others we saw ", "Here is another shot of the same temple, this highlights the gold designs covering the underside of the roof. I did not capture any pictures of the inside" +
                " because I didnt want to be inconsiderate of the monks but the inside was adorned with golden statues", "This is also in Thailand but out in the middle of nowhere, we drove for a few hours to see these two twin temples on the mountaintop",
            "This was taken in Belize, these are ancient Mayan temples that they used to perform human sacrifices in. Its amazing that the stone sculptures have survived to this day despite being so old"
            , "This was taken in Seoul South Korea, this was just a random temple in the middle of a roundabout in the busy city center. It was interesting because of the blend of city and tradition"
            , "This was taken atop a small mountain overlooking Railay Beach in Krabi Thailand. After climbing almost entirely vertical up the rocky cliffs atop the tiny mountain there is a basin that the monekys usually hang out in to avoid tourists.  "
            , "This is another shot of the basic atop the mountain, it was really cool because of how little people were up here, there were also little caverns around the lake in the basin which were a little scary"
            , "This is my grandfather at Pont Du Hoc, located in Normandy france. The Nazi's held this point overlooking the english channel stacking all of their artillery and mortars in preperation for D-day. The weapons of war are still there to this day."
            , "This is Thingvaller national park in Iceland, pictured are the north american and european tectonic plates. This is one of the only points in the world where you can see two tectonic plates touching each other."
            , "This was also taken in Iceland, honestly they need to rename to waterfall land because there was a waterfall every two feet!")

            newRecyclerView = findViewById(R.id.recyclerView)
            newRecyclerView.layoutManager = LinearLayoutManager(this)
            newRecyclerView.setHasFixedSize(true)

            newArrayList = arrayListOf<pics>()
            getUserData()


    }

    private fun getUserData() {
        for (i in imageId.indices){
            val pics = pics(imageId[i],desc[i])
            newArrayList.add(pics)
        }
        var adapter = recAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : recAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, MainActivity2::class.java)

                intent.putExtra("desc", newArrayList[position].desc)
                intent.putExtra("ImageId", newArrayList[position].image)
                startActivity(intent)
            }

        })
    }
}