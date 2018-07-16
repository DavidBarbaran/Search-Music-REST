package davidbarbaran.searchmusicrest.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.OnEditorAction
import com.bumptech.glide.Glide
import davidbarbaran.searchmusicrest.R
import davidbarbaran.searchmusicrest.controller.ViewController
import davidbarbaran.searchmusicrest.model.SongYoutube
import davidbarbaran.searchmusicrest.presenter.SearchPresenter

class SearchActivity : AppCompatActivity(), ViewController.ViewSearch {

    @BindView(R.id.search_edit)
    lateinit var searchEdit: EditText

    @BindView(R.id.thumbnail_image)
    lateinit var thumbnailImage: ImageView

    @BindView(R.id.title_text)
    lateinit var titleText: TextView

    private lateinit var searchPresenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        ButterKnife.bind(this)
        searchPresenter = SearchPresenter(this)

    }

    override fun listSong(list: MutableList<SongYoutube>) {
        var song = list[0]
        Glide.with(this).load(song.thumbnail).into(thumbnailImage)
        titleText.text = song.title

    }

    @OnEditorAction(R.id.search_edit)
    fun actionSearch(actionId: Int):Boolean{
        if(actionId == EditorInfo.IME_ACTION_SEARCH){
            searchPresenter.searchSong(searchEdit.text.toString())
            return true
        }
        return false
    }

    @OnClick(R.id.back_btn)
    fun actionBack(){
        onBackPressed()
    }

    @OnClick(R.id.clean_btn)
    fun actionClean(){
        searchEdit.text.clear()
    }
}