package com.project.sfmd_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Articles : AppCompatActivity(), Article_Adapter.OnItemClickListener {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Article_Data>
    private lateinit var art: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutParams = WindowManager.LayoutParams().apply {
            flags = WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        }
        window.attributes = layoutParams


        setContentView(R.layout.activity_articles)

        val back= findViewById<Button>(R.id.back)
        back.setOnClickListener {
            val intent = Intent(this@Articles, Home::class.java)
            startActivity(intent)
        }

        newRecyclerView= findViewById(R.id.recycler)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        art = arrayOf(
            "Unlocking the Power of Mindfulness: How Meditation Can Improve Mental Well-being",
            "The Surprising Benefits of a Plant-Based Diet for Heart Health",
            "Understanding the Link Between Exercise and Mental Health: Science Explains",
            "Breaking the Stigma: Exploring the Truth About Depression and Seeking Help",
            "From Stress to Serenity: Effective Strategies for Managing Anxiety in Daily Life"
        )

        newArrayList = arrayListOf<Article_Data>()
        getUserData()


    }

    private fun getUserData(){
        for(i in art.indices){
            val docs = Article_Data(art[i])
            newArrayList.add(docs)
        }
        newRecyclerView.adapter =Article_Adapter(newArrayList, this)
    }
    override fun onItemClick(position: Int) {

        val intent = Intent(this, Articles::class.java)
        startActivity(intent)
    }

}