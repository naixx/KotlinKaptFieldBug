package com.example.astra.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import org.androidannotations.annotations.EActivity
import org.androidannotations.annotations.Extra
import org.androidannotations.annotations.InstanceState
import org.androidannotations.annotations.ViewById

@EActivity
public open class ItemDetailActivity : AppCompatActivity() {
    @field:ViewById lateinit var fab: FloatingActionButton

    @field:Extra lateinit var working: String
    @field:InstanceState lateinit var notWorking: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        val toolbar = findViewById(R.id.detail_toolbar) as Toolbar
        setSupportActionBar(toolbar)

        fab.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        })

        // Show the Up button in the action bar.
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val arguments = Bundle()
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, intent.getStringExtra(ItemDetailFragment.ARG_ITEM_ID))
            val fragment = ItemDetailFragment()
            fragment.arguments = arguments
            supportFragmentManager.beginTransaction().add(R.id.item_detail_container, fragment).commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {

            NavUtils.navigateUpTo(this, Intent(this, ItemListActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
