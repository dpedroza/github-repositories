package com.dmap.githubrepositories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var repositoryRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        val adapter = RepositoryAdapter()

        repositoryRecyclerView = findViewById<RecyclerView>(R.id.recycler_view_repositories).apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }
    }
}