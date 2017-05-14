package id.sch.smktelkom_mlg.privateassignment.xirpl107.appnews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static id.sch.smktelkom_mlg.privateassignment.xirpl107.appnews.R.id.recyclerViewfav;


/**
 * A simple {@link Fragment} subclass.
 */
public class LikeFragment extends Fragment {
    ArrayList<LikeItem> fList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public LikeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_like, container, false);


        recyclerView = (RecyclerView) view.findViewById(recyclerViewfav);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fList = new ArrayList<>();

        adapter = new LikeAdapter(fList, getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);

        fList.addAll(LikeItem.listAll(LikeItem.class));
        adapter.notifyDataSetChanged();

        return view;
    }

}
