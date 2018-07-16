package davidbarbaran.searchmusicrest.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick
import davidbarbaran.searchmusicrest.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.search_card_view)
    fun actionSearchCardView(){
        startActivity(Intent(this, SearchActivity::class.java))
    }
}
