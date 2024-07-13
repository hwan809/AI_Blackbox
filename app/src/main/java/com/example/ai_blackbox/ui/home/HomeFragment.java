package com.example.ai_blackbox.ui.home;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ai_blackbox.R;
import com.example.ai_blackbox.accident_view.ListViewAdapter;
import com.example.ai_blackbox.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ListView listView;
    private TextView text1, text2;
    private Button listButton;
    private ListViewAdapter adapter;

    private VideoView accidentVideoView;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView = (ListView) root.findViewById(R.id.accident_view);
        text1 = (TextView) root.findViewById(R.id.accident_value_text);
        text2 = (TextView) root.findViewById(R.id.location_text);
        listButton = (Button) root.findViewById(R.id.listview_item_button);

        adapter = new ListViewAdapter();
        listView.setAdapter(adapter);

        adapter.add_item("70 : 30", R.drawable.img_3, "부산광역시 금정구\n대한민국\n2024/07/05");
        adapter.add_item("20 : 80", R.drawable.img, "부산광역시 해운대구\n대한민국\n2024/05/08");

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}