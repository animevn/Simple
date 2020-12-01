package com.haanhgs.game;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;

public class TestOpenAlert extends AndroidFragmentApplication {

    private MyGame myGame;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        myGame = new MyGame();
        myGame.setListener(() -> {
            if (getFragmentManager() != null){
                AlertOneButton button = new AlertOneButton();
                button.setContent("test");
                button.setTitle("test");
                button.setListener(() -> myGame.setRunning(true));
                button.show(getFragmentManager(), "");
            }
        });
        return initializeForView(myGame);
    }
}
