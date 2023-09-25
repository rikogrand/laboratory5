package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.StateAdapter;
import com.example.myapplication.User;
import com.example.myapplication.databinding.FragmentFirstListBinding;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {
    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    public StateAdapter userAdapter;
    public static List<User> userList = new ArrayList<>();
    private FragmentFirstListBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUser();
        userListInit();
        ShowNewGameFragment();
    }

    private void userListInit() {
        if (userAdapter == null) {
            userAdapter = new StateAdapter(
                    getContext(),
                    R.layout.list_item,
                    userList);
        }
        binding.list.setAdapter(userAdapter);
        binding.list.setOnItemLongClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getContext(),
                    String.valueOf(i),
                    Toast.LENGTH_LONG).show();

        });

    }

    public void setUser() {
        if (!userList.isEmpty()) return;
        userList.add(new User("Dota 2", 2000, R.drawable.dota));
        userList.add(new User("CSGO", 2015, R.drawable.csgo));
        userList.add(new User("CS 2", 2025, R.drawable.cs));
        userList.add(new User("Valorant", 2020, R.drawable.valorant));
    }

    public void ShowNewGameFragment() {
        binding.addGame.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, new NewGameFragment(userAdapter), "new_game_fragment")
                    .addToBackStack("new_game_fragment")
                    .commit();
        });
    }
}
