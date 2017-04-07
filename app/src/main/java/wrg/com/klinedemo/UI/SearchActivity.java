package wrg.com.klinedemo.UI;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import butterknife.Bind;
import wrg.com.klinedemo.Base.BaseActivity;
import wrg.com.klinedemo.R;

/**
 * Created by 翁 on 2017/3/20.
 */

public class SearchActivity extends BaseActivity implements TextWatcher, View.OnClickListener {

    @Bind(R.id.stock_edit)
    EditText stock_edit;

    @Bind(R.id.search_listview)
    ListView listView;


    @Override
    protected int getContentId() {
        return R.layout.activity_search;
    }

    @Override
    protected void init() {
        super.init();

        stock_edit.addTextChangedListener(this);
        stock_edit.setOnClickListener(this);


    }

    @Override
    protected void loadDatas() {
        super.loadDatas();


    }

    @Override
    public boolean isOpenStatus() {
        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(SearchActivity.this,MainActivity.class));
    }
}
