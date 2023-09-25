package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Game;
import com.example.myapplication.R;
import com.example.myapplication.GameAdapter;
import com.example.myapplication.databinding.FragmentFirstListBinding;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {
    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    public GameAdapter gameAdapter;
    public static List<Game> gameList = new ArrayList<>();
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
        setGame();
        gameListInit();
        ShowNewGameFragment();
    }

    private void gameListInit() {
        if (gameAdapter == null) {
            gameAdapter = new GameAdapter(
                    getContext(),
                    R.layout.list_item,
                    gameList);
        }
        binding.list.setAdapter(gameAdapter);
        binding.list.setOnItemLongClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getContext(),
                    String.valueOf(i),
                    Toast.LENGTH_LONG).show();
                gameAdapter.remove(gameAdapter.getItem(i));
            return true;
        });

    }

    public void setGame() {
        if (!gameList.isEmpty()) return;
        gameList.add(new Game("Dota 2", 2000, R.drawable.dota));
        gameList.add(new Game("CSGO", 2015, R.drawable.csgo));
        gameList.add(new Game("CS 2", 2025, R.drawable.cs));
        gameList.add(new Game("Valorant", 2020, R.drawable.valorant));
    }

    public void ShowNewGameFragment() {
        binding.addGame.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, new NewGameFragment(gameAdapter), "new_game_fragment")
                    .addToBackStack("new_game_fragment")
                    .commit();
        });
    }
}
