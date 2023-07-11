package com.example.basicnavigationbase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class FlowStepFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        int flowStepNumber;

        //TODO STEP 5 - Get arguments from autogenerated clases.
        //flowStepNumber = getArguments().getInt("flowStepNumber");
        flowStepNumber = FlowStepFragmentArgs.fromBundle(getArguments()).getFlowStepNumber();
        //END STEP 5

        //TODO STEP 6  - Use type-safe arguments - remove previous line!
        int destLayout = R.id.flow_step_one_dest;
        switch (flowStepNumber) {
            case 1:
                destLayout = R.layout.flow_step_one_fragment;
                break;
            case 2:
                destLayout = R.layout.flow_step_two_fragment;
                break;
        }
        return inflater.inflate(destLayout, container, false);

       // return inflater.inflate(R.layout.flow_step_one_fragment, container, false);
        //END STEP 6

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getView().findViewById(R.id.next_button).setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.next_action));
    }
}
