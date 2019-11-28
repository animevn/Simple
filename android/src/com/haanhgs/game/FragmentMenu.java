package com.haanhgs.game;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentMenu extends Fragment {

    private Button buttonNew;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        buttonNew = view.findViewById(R.id.button_new);
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager() != null){
                    Fragment fragment = getFragmentManager().findFragmentByTag("test");
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    if (fragment == null){
                        Test gameView = new Test();
                        ft.add(R.id.flMain, gameView, "test");
                        ft.addToBackStack("test");
                        ft.commit();
                    }else {
                        ft.attach(fragment);
                    }
                }
            }
        });
        return view;
    }

}
