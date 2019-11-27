package com.haanhgs.game;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;

public class Test extends AndroidFragmentApplication {

    private MyGame myGame;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        myGame = new MyGame();
        myGame.setListener(new MyGame.OpenAlert() {
            @Override
            public void openAlert() {
                if (getFragmentManager() != null){
                    AlertOneButton button = new AlertOneButton();
                    button.setContent("test");
                    button.setTitle("test");
                    button.setListener(new AlertOneButton.OnButtonAlertClick() {
                        @Override
                        public void onOkButtonClick() {
                            myGame.setRunning(true);
                        }
                    });
                    button.show(getFragmentManager(), "");
                }
            }
        });
        return initializeForView(myGame);
    }
}
