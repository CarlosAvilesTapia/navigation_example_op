package com.example.basicnavigationbase;

import android.drm.DrmStore;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public class HomeFragment extends Fragment {

    private Fragment thisFragment=this;

    private NavController thisNavController;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        thisNavController = NavHostFragment.findNavController(thisFragment);

        //TODO STEP 2 - Set an OnClickListener, using Navigation.createNavigateOnClickListener()
        Button navigateButton = (Button) getView().findViewById(R.id.navigate_destination_button);
        //END STEP 2

        //TODO STEP 3 - Set NavOptions
        // Creación de objeto navigation builder y llamado a métodos de animaciones.
        NavOptions.Builder navOptionBuilder = new NavOptions.Builder();
        navOptionBuilder.setEnterAnim(R.anim.slide_in_right);
        navOptionBuilder.setExitAnim(R.anim.slide_out_left);
        navOptionBuilder.setPopExitAnim(R.anim.slide_out_right);
        navOptionBuilder.setPopEnterAnim(R.anim.slide_in_left);

        // Creación de objeto NavOptions.
        final NavOptions options = navOptionBuilder.build();

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(thisFragment).navigate(R.id.flow_step_one_dest,null,options);
            }
        });


        //END STEP 3

        //TODO STEP 4 - OnClickListener to navigate using an action
        //END STEP 4

        //TODO STEP 7 - Update the OnClickListener to navigate using an action and using  ...Direction clases for arguments
        //END STEP 7

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
    }
}
