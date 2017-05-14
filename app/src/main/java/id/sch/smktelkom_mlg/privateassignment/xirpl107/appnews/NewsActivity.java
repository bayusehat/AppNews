package id.sch.smktelkom_mlg.privateassignment.xirpl107.appnews;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static java.lang.Boolean.TRUE;

public class NewsActivity extends AppCompatActivity {
    private static final String URL_DATA = "https://api.nytimes.com/svc/news/v3/content/all/all.json?api-key=a2da39a7d3fb4d9d848849fc44d1a71c";
    public ImageView imageViewDetailNews;
    public String url;
    public String urlGambar;
    LikeItem likeItem;
    boolean ipress;
    private TextView textViewHeadNews;
    private TextView textViewDescNews;
    private TextView textViewReviewNews;
    private Integer npostkey = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        npostkey = getIntent().getExtras().getInt("Anu");
        loadRecyclerViewData();

        textViewHeadNews = (TextView) findViewById(R.id.textViewHeadNews);
        textViewDescNews = (TextView) findViewById(R.id.textViewDescNews);
        textViewReviewNews = (TextView) findViewById(R.id.textViewReviewNews);
        imageViewDetailNews = (ImageView) findViewById(R.id.imageViewDetailNews);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ipress == TRUE) {
                    doSave();
                    Snackbar.make(view, "Liked", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {

                }

            }
        });
    }

    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("results");
                            JSONObject o = array.getJSONObject(npostkey);

                            setTitle(" ");

                            textViewHeadNews.setText(o.getString("title"));
                            textViewDescNews.setText(o.getString("byline"));
                            textViewReviewNews.setText(o.getString("abstract"));
                            url = o.getString("url");
                            urlGambar = o.getString("thumbnail_standard");

                            Glide
                                    .with(NewsActivity.this)
                                    .load(o.getString("thumbnail_standard"))
                                    .into(imageViewDetailNews);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


    private void doSave() {
        String judul = textViewHeadNews.getText().toString();
        String deskripsi = textViewDescNews.getText().toString();
        String urlgambar = urlGambar;
        likeItem = new LikeItem(judul, deskripsi, urlgambar);
        likeItem.save();
    }

}
